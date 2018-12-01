package com.itc.apti.services.impl;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Component;

import com.itc.apti.entity.UrlBean;
import com.itc.apti.services.IDownloader;

/**
 * The Class HttpDownloaderImpl is used to download the contents in XML format.
 * 
 * @author Debadatta Mishra
 */
@Component("httpDownloderImpl")
public class HttpDownloaderImpl implements IDownloader<String, UrlBean> {

	/**
	 * Gets the contents.
	 *
	 * @param url
	 *            the url
	 * @param contentType
	 *            the content type
	 * @return the contents
	 */
	private String getContents(String url, String contentType) {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(url);
		httpGet.addHeader(HttpHeaders.ACCEPT, contentType);
		CloseableHttpResponse response1 = null;
		try {
			response1 = httpclient.execute(httpGet);

		} catch (IOException e) {
			e.printStackTrace();
		}
		HttpEntity entity1 = response1.getEntity();
		String actualResponse = null;
		try {
			actualResponse = EntityUtils.toString(entity1);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return actualResponse;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.itc.apti.services.IDownloader#download(java.lang.Object)
	 */
	@Override
	public String download(UrlBean urlBean) {
		return getContents(urlBean.getUrl(), urlBean.getContentType());
	}

}
