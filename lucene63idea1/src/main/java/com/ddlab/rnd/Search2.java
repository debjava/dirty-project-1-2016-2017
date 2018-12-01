package com.ddlab.rnd;

import java.io.File;
import java.io.IOException;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.Term;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.SimpleFSDirectory;

public class Search2 {

    public static void main(String[] args) throws ParseException, IOException {

//		String queryString = "lucene";
//        String queryString = "\"" + "Course-00001" + "\"";
//        queryString = "CourseName: Course-00001";
//        String queryString = "Course-00001";
        String queryString = "12345";

//		String queryString = "CourseName: "+"\""+"Course-12345"+"\"";
//		String queryString = "zipCode: 12345";
        StandardAnalyzer analyzer = new StandardAnalyzer();

//		Query q = new QueryParser("title", analyzer).parse(queryString);
//		Query q = new QueryParser("SomeCourseName", analyzer).parse(queryString);
//        Term term = new Term("CourseName", "Course-00001");
        
        Term term = new Term("zipCode", "12345");
        
        Query q = new TermQuery(term);

        File dataDir = new File("E:/idea-workspace-2017/lucene63idea1/local/data/");
        Directory dir = new SimpleFSDirectory(dataDir.toPath());

        int hitsPerPage = 10;
        IndexReader reader = DirectoryReader.open(dir);
        IndexSearcher searcher = new IndexSearcher(reader);
        TopDocs docs = searcher.search(q, hitsPerPage);
        System.out.println("Total :::" + docs.totalHits);
        ScoreDoc[] hits = docs.scoreDocs;

        System.out.println("Found " + hits.length + " hits.");
        for (int i = 0; i < hits.length; ++i) {
            int docId = hits[i].doc;
            Document d = searcher.doc(docId);
//		    System.out.println((i + 1) + ". " +"---"+d.get("id")+" "+ d.get("isbn") + "\t" + d.get("title"));

            System.out.println((i + 1) + ". " + "---" + d.get("id") + " " + d.get("zipCode") + "\t" + d.get("CourseName"));
        }

    }

}
