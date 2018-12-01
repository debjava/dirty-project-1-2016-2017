package com.ddlab.rnd.find;

import java.io.File;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.Term;
import org.apache.lucene.queryparser.classic.MultiFieldQueryParser;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.SimpleFSDirectory;

public class Finder1 {
	
	private static File dataDir = new File("E:/dirty-project-2017/lucene63idea1/local/data/");

	public static IndexSearcher getIndexSearcher() throws Exception {
		Directory dir = new SimpleFSDirectory(dataDir.toPath());
		IndexReader reader = DirectoryReader.open(dir);
		IndexSearcher searcher = new IndexSearcher(reader);

		return searcher;
	}

	public static void main(String[] args) throws Exception {
		
//		String qText = "Course005";
		String qText = "00003";
		
//		Query query1 = new TermQuery(new Term("zipCode", qText));
//		Query query2 = new TermQuery(new Term("courseName", qText));
		
//		BooleanQuery booleanQuery = new BooleanQuery(false,0,null);
//		booleanQuery.add(query1, BooleanClause.Occur.SHOULD);
//		booleanQuery.add(query2, BooleanClause.Occur.SHOULD);
		
		Analyzer analyzer = new StandardAnalyzer();
		MultiFieldQueryParser queryParser = new MultiFieldQueryParser(
		                                        new String[] {"zipCode", "courseName"},
		                                        analyzer);
		
		
		Query q = queryParser.parse(qText);
		
		
		
		

//		StandardAnalyzer analyzer = new StandardAnalyzer();

//		String queryStr = "Course005";// For course code only

//		Term term = new Term("courseName", queryStr);
//		Query q = new TermQuery(term);
		
		
//		Term term = new Term("zipCode", "00003");
//		Query q = new TermQuery(term);
		

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
					(i + 1) + ". " + "---" + d.get("id") + " " + d.get("zipCode") + "\t" + d.get("courseName"));
		}
	}

}
