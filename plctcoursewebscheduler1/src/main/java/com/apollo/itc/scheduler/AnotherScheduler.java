package com.apollo.itc.scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.apollo.itc.config.BaseConfig;
import com.apollo.itc.config.SolrConfig;

@Configuration
@EnableScheduling
@Import({BaseConfig.class})
public class AnotherScheduler {
	
	@Autowired
	private SolrConfig solrConfig;
	
	@Scheduled(cron = "${cron.expression}")
	public void myCron() {
		System.out.println("I am the different scheduler, I run through annotations ....");
		
		System.out.println("URL :::"+solrConfig.getSolrDeltaImportUrl());
	}

}
