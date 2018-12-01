package com.ddlab.rnd;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.SimpleFSDirectory;

import java.io.File;

public class Search3 {

    private static File dataDir = new File("E:/dirty-project-2017/lucene63idea1/local/data/");

    public static IndexSearcher getIndexSearcher() throws Exception {
        Directory dir = new SimpleFSDirectory(dataDir.toPath());
        IndexReader reader = DirectoryReader.open(dir);
        IndexSearcher searcher = new IndexSearcher(reader);

        return searcher;
    }

    public static void main(String[] args) throws Exception {
        StandardAnalyzer analyzer = new StandardAnalyzer();

//        String queryStr = "00003";//For zip code only
//        Query q = new QueryParser("zipCode", analyzer).parse(queryStr);
        
        String queryStr = "Course005";//For course code only
        Query q = new QueryParser("courseName", analyzer).parse(queryStr);
        
        System.out.println(q.toString());

        IndexSearcher searcher = getIndexSearcher();
        TopDocs docs = searcher.search(q, 10);
        System.out.println("Total :::" + docs.totalHits);
        ScoreDoc[] hits = docs.scoreDocs;
        System.out.println("Found " + hits.length + " hits.");
        for (int i = 0; i < hits.length; ++i) {
            int docId = hits[i].doc;
            Document d = searcher.doc(docId);
            System.out.println((i + 1) + ". " + "---" + d.get("id") + " " + d.get("zipCode") + "\t" + d.get("courseName"));
        }
    }
}
