package org.apollo.edu.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({BaseConfig.class})
public class SolrConfig {
	
	@Value( "${solr.FullImport.Url}" )
	private String solrFullImportUrl;
	
	@Value( "${solr.DeltaImport.Url}" )
	private String solrDeltaImportUrl;
	
	public String getSolrFullImportUrl() {
		return solrFullImportUrl;
	}
	public void setSolrFullImportUrl(String solrFullImportUrl) {
		this.solrFullImportUrl = solrFullImportUrl;
	}
	public String getSolrDeltaImportUrl() {
		return solrDeltaImportUrl;
	}
	public void setSolrDeltaImportUrl(String solrDeltaImportUrl) {
		this.solrDeltaImportUrl = solrDeltaImportUrl;
	}

}
