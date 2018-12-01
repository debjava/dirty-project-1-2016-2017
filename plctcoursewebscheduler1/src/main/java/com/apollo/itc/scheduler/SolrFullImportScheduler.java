package com.apollo.itc.scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.apollo.itc.config.SolrConfig;
import com.apollo.itc.service.CoreScheduler;

public class SolrFullImportScheduler implements CoreScheduler {

	protected static Logger logger = LoggerFactory.getLogger(SolrFullImportScheduler.class);
	
	@Autowired
	private SolrConfig solrConfig;
	
	public void schedule() {
		String threadName = Thread.currentThread().getName();
		logger.debug("   " + threadName + " cron service performing important stuff..");
		System.out.println("************* RUNNING *****************");
		
		System.out.println("URL :::"+solrConfig.getSolrDeltaImportUrl());
	}
}
