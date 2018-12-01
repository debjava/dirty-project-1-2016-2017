package com.itc.apti.services.impl;

import org.springframework.beans.factory.annotation.Value;
import com.itc.apti.entity.UrlBean;
import com.itc.apti.services.IDownloader;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandProperties;

/**
 * The Class FailSafeDownloader is a fail-safe downloader to download the
 * contents from the remote service or url.
 * 
 * @author Debadatta Mishra
 */
public class FailSafeDownloader extends HystrixCommand<String> {

	/** The contents. */
	private String contents; // It is of no use, it should be here

	/** The downloader. */
	private IDownloader<String, UrlBean> downloader;

	/** The url bean. */
	private UrlBean urlBean;

	/**
	 * Instantiates a new fail safe downloader.
	 *
	 * @param contents
	 *            the contents
	 */
	public FailSafeDownloader(@Value("default") String contents) {
		super(HystrixCommand.Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("DownloadGroup"))
				.andCommandPropertiesDefaults(HystrixCommandProperties.Setter().withCircuitBreakerEnabled(true)
						.withExecutionTimeoutInMilliseconds(60000)// 60 seconds
		// .withCircuitBreakerRequestVolumeThreshold(2)

		));
		this.contents = contents;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.netflix.hystrix.HystrixCommand#run()
	 */
	@Override
	protected String run() throws Exception {
		String xmlContents = downloader.download(urlBean);
		if (!xmlContents.toLowerCase().startsWith("<status>"))
			throw new RuntimeException("Improper downloaded contents");
		return xmlContents;
	}

	/**
	 * Sets the.
	 *
	 * @param downloader
	 *            the downloader
	 * @param urlBean
	 *            the url bean
	 */
	public void set(IDownloader<String, UrlBean> downloader, UrlBean urlBean) {
		this.downloader = downloader;
		this.urlBean = urlBean;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.netflix.hystrix.HystrixCommand#getFallback()
	 */
	@Override
	protected String getFallback() {
		String errorXMLContents = "<status><groups><group name=" + "\"" + "Server Properties" + "\""
				+ "><properties><host.canonical.name>ERROR</host.canonical.name><host.ip>ERROR</host.ip><host.name>ERROR</host.name></properties></group> </groups> </status>";
		return errorXMLContents;
	}

}
