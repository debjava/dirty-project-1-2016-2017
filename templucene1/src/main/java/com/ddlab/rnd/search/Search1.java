package com.ddlab.rnd.search;

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

import java.io.File;

/**
 * Created by PIKU on 2/19/2017.
 */
public class Search1 {
    private static File indexDirPath = new File("local/data");

    public static void main(String[] args) throws Exception {
//        File dataDir = new File("local/data/");
        Directory dir = FSDirectory.open(indexDirPath.toPath());
        DirectoryReader ireader = DirectoryReader.open(dir);
        IndexSearcher isearcher = new IndexSearcher(ireader);

        Analyzer analyzer = new StandardAnalyzer();
        // Parse a simple query that searches for "text":
//        QueryParser parser = new QueryParser("zipCode", analyzer);
        QueryParser parser = new QueryParser("content", analyzer);
//	    Query query = parser.parse("ZIP00002");

//	    Query query = parser.parse("*:*");

//        Query query = parser.parse("ZIP00002");
        Query query = parser.parse("COURSE002");
        System.out.println(query.toString());

        ScoreDoc[] hits = isearcher.search(query, 1000).scoreDocs;
        System.out.println("Total Hits :::"+hits.length);
        for (int i = 0; i < hits.length; i++) {
            Document hitDoc = isearcher.doc(hits[i].doc);
            System.out.println(hitDoc.get("id")+"\t"+hitDoc.get("zipCode")+"\t"+hitDoc.get("courseCode"));
        }
        ireader.close();
        dir.close();
    }
}
