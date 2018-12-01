package com.ddlab.rnd.es;

import java.net.InetAddress;
import java.util.Iterator;
import java.util.Map;

import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHitField;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

public class TestES1 {

	public static void main(String[] args) throws Exception {
		TransportClient client = new PreBuiltTransportClient(Settings.EMPTY)
		        .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("localhost"), 9300));
		
		SearchResponse response = client.prepareSearch("films")
				.get();
		
		SearchHits hits = response.getHits();
		Iterator itr = hits.iterator();
		while( itr.hasNext() ) {
			SearchHit hit = (SearchHit) itr.next();
			Map<String, Object> searchFieldsMap = hit.getSource();
			System.out.println(searchFieldsMap);
		}
		
		
				
				
		// on shutdown
		client.close();
	}

}
