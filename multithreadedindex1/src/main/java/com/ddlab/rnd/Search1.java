package com.ddlab.rnd;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TotalHitCountCollector;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

import java.io.File;

/**
 * Created by PIKU on 2/19/2017.
 */
public class Search1 {
    private static String rootDir = "E:/dirty-project-idea-2017/multithreadedindex1";
    private static File indexDirPath = new File(rootDir+"/"+"local/data");

    public static void main(String[] args) throws Exception {
//        File dataDir = new File("local/data/");
        Directory dir = FSDirectory.open(indexDirPath.toPath());
        DirectoryReader ireader = DirectoryReader.open(dir);
        IndexSearcher isearcher = new IndexSearcher(ireader);

        Analyzer analyzer = new StandardAnalyzer();
        QueryParser parser = new QueryParser("content", analyzer);
//	    Query query = parser.parse("ZIP00001");
        Query query = parser.parse("*:*");
        System.out.println(query.toString());

        //A way to get all total counts
        TotalHitCountCollector collector = new TotalHitCountCollector();
        isearcher.search(query, collector);
        ScoreDoc[] hits = isearcher.search(query, Math.max(1, collector.getTotalHits())).scoreDocs;
        System.out.println("Total Hits :::"+hits.length);
        //To display all
        for (int i = 0; i < hits.length; i++) {
            Document hitDoc = isearcher.doc(hits[i].doc);
            System.out.println(i+".) "+hitDoc.get("id")+"\t"+hitDoc.get("zipCode")+"\t"+hitDoc.get("courseCode"));
        }

        ireader.close();
        dir.close();
    }
}
