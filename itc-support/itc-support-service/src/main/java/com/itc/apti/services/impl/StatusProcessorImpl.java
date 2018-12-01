package com.itc.apti.services.impl;

import java.io.IOException;
import java.io.StringReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.itc.apti.entity.EStatus;
import com.itc.apti.entity.IStatus;
import com.itc.apti.entity.UrlBean;
import com.itc.apti.services.IDownloader;
import com.itc.apti.services.IProcessor;
import com.itc.apti.services.XmlHandler;

/**
 * The Class StatusProcessorImpl is responsible for processing the business
 * logic for XML contents downloaded from the remote service or url.
 * 
 * @author Debadatta Mishra
 */
@Component("statusProcessorImpl")
public class StatusProcessorImpl implements IProcessor<String, IStatus> {

	/** The handler. */
	@Autowired
	@Qualifier("statusHandler")
	private XmlHandler<IStatus> handler;

	/** The downloader. */
	@Autowired
	@Qualifier("httpDownloderImpl")
	private IDownloader<String, UrlBean> downloader;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.itc.apti.services.IProcessor#get(java.lang.Object)
	 */
	@Override
	public IStatus get(String url) {
		FailSafeDownloader failSafeDownloader = new FailSafeDownloader("");
		UrlBean urlBean = new UrlBean(url, "application/xml");
		failSafeDownloader.set(downloader, urlBean);

		String xmlContents = failSafeDownloader.execute();
		InputSource inputSrc = new InputSource(new StringReader(xmlContents));
		SAXParserFactory spf = SAXParserFactory.newInstance();
		try {
			SAXParser sp = spf.newSAXParser();
			sp.parse(inputSrc, handler);
		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}

		IStatus status = handler.get();
		status.setServiceName(getServiceName(url));
		setStatus(status);
		return status;
	}

	/**
	 * Sets the status.
	 *
	 * @param status
	 *            the new status
	 */
	private void setStatus(IStatus status) {
		String actualStatus = status.getHostIp() != null && status.getHostIp().equalsIgnoreCase("ERROR")
				? EStatus.FAIL.name() : EStatus.SUCCESS.name();
		status.setStatus(actualStatus);
	}

	/**
	 * Gets the service name.
	 *
	 * @param urlString
	 *            the url string
	 * @return the service name
	 */
	public static String getServiceName(String urlString) {
		String serviceName = "";
		String urlMainPattern = "(api/.*/\\d)";
		Pattern pattern = Pattern.compile(urlMainPattern);
		Matcher matcher = pattern.matcher(urlString);
		if (matcher.find())
			serviceName = matcher.group();
		pattern = Pattern.compile("[^api](\\b.*\\b)[^\\d]");
		matcher = pattern.matcher(serviceName);
		serviceName = matcher.find() ? matcher.group().replaceAll("/", "") : "";
		return serviceName;
	}

}
