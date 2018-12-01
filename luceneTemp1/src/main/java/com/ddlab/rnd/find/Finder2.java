package com.ddlab.rnd.find;

import java.io.File;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

public class Finder2 {

	public static void main(String[] args) throws Exception {
		
		File dataDir = new File("local/data/");
		Directory dir = FSDirectory.open(dataDir.toPath());
		DirectoryReader ireader = DirectoryReader.open(dir);
	    IndexSearcher isearcher = new IndexSearcher(ireader);
	    
	    Analyzer analyzer = new StandardAnalyzer();
	 // Parse a simple query that searches for "text":
	    QueryParser parser = new QueryParser("zipCode", analyzer);
//	    Query query = parser.parse("ZIP00002");
	    
//	    Query query = parser.parse("*:*");
	    
	    Query query = parser.parse("ZIP00002");
	    System.out.println(query.toString());
	    
	    ScoreDoc[] hits = isearcher.search(query, 1000).scoreDocs;
	    System.out.println("Total Hits :::"+hits.length);
	    for (int i = 0; i < hits.length; i++) {
	        Document hitDoc = isearcher.doc(hits[i].doc);
//	        assertEquals("This is the text to be indexed.", hitDoc.get("fieldname"));
	        
	        System.out.println(hitDoc.get("id")+"\t"+hitDoc.get("zipCode")+"\t"+hitDoc.get("courseCode"));
	        
	      }
	    
	    
	      ireader.close();
	      dir.close();

	}

}
