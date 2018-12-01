package com.ddlab.rnd.find;

import java.io.File;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.queryparser.classic.MultiFieldQueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.SimpleFSDirectory;

public class Finder1 {
	
	private static File dataDir = new File("local/data/");
	
	public static IndexSearcher getIndexSearcher() throws Exception {
		Directory dir = new SimpleFSDirectory(dataDir.toPath());
		IndexReader reader = DirectoryReader.open(dir);
		IndexSearcher searcher = new IndexSearcher(reader);

		return searcher;
	}

	public static void main(String[] args) throws Exception {
		
		String qText = "COURSE002";
//		String qText = "ZIP00003";
//		String qText = "*:*";
//		String qText = "ZIP00003";
//		String[] fields = new String[] {"zipCode", "courseCode"};
		String[] fields = new String[] {"content"};
		Analyzer analyzer = new StandardAnalyzer();
		MultiFieldQueryParser queryParser = new MultiFieldQueryParser(fields, analyzer);
		
		Query q = queryParser.parse(qText);
		System.out.println(q.toString());

		IndexSearcher searcher = getIndexSearcher();
		TopDocs docs = searcher.search(q, 10);
		System.out.println("Total :::" + docs.totalHits);
		ScoreDoc[] hits = docs.scoreDocs;
		System.out.println("Found " + hits.length + " hits.");
		for (int i = 0; i < hits.length; ++i) {
			int docId = hits[i].doc;
			Document d = searcher.doc(docId);
			System.out.println(
					(i + 1) + ". " + "---" + d.get("id") + " " + d.get("zipCode") + "\t" + d.get("courseCode"));
		}

	}

}
