package com.ddlab.rnd;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.Term;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.*;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.SimpleFSDirectory;
import org.apache.lucene.util.QueryBuilder;

import java.io.File;

/**
 * Created by PIKU on 2/19/2017.
 */
public class Search1 {

    private static File dataDir = new File("E:/idea-workspace-2017/lucene63idea1/local/data/");

    public static IndexSearcher getIndexSearcher() throws Exception {
        Directory dir = new SimpleFSDirectory(dataDir.toPath());
        IndexReader reader = DirectoryReader.open(dir);
        IndexSearcher searcher = new IndexSearcher(reader);

        return searcher;
    }

    public static void searchZipCode( String queryStr) throws Exception {

        StandardAnalyzer analyzer = new StandardAnalyzer();
        QueryParser parser = new QueryParser("zipCode", analyzer);
        Query q = parser.parse(queryStr);

        int hitsPerPage = 10;
        IndexSearcher searcher = getIndexSearcher();
        TopDocs docs = searcher.search(q, hitsPerPage);
        System.out.println("Total :::" + docs.totalHits);
        ScoreDoc[] hits = docs.scoreDocs;
        System.out.println("Found " + hits.length + " hits.");
        for (int i = 0; i < hits.length; ++i) {
            int docId = hits[i].doc;
            Document d = searcher.doc(docId);
            System.out.println((i + 1) + ". " + "---" + d.get("id") + " " + d.get("zipCode") + "\t" + d.get("CourseName"));
        }
    }

    public static void searchCourseCode( String queryStr) throws Exception {

        Term term = new Term("CourseName", queryStr);
        Query q = new TermQuery(term);

        int hitsPerPage = 10;
        IndexSearcher searcher = getIndexSearcher();
        TopDocs docs = searcher.search(q, hitsPerPage);
        System.out.println("Total :::" + docs.totalHits);
        ScoreDoc[] hits = docs.scoreDocs;
        System.out.println("Found " + hits.length + " hits.");
        for (int i = 0; i < hits.length; ++i) {
            int docId = hits[i].doc;
            Document d = searcher.doc(docId);
            System.out.println((i + 1) + ". " + "---" + d.get("id") + " " + d.get("zipCode") + "\t" + d.get("CourseName"));
        }
    }

    public static TopDocs performSearch(String queryString, int n) throws Exception {

        IndexSearcher searcher = getIndexSearcher();
        QueryParser parser = new QueryParser("content", new StandardAnalyzer());
        Query query = parser.parse(queryString);
        return searcher.search(query, n);
    }


    public static void searchAnything(String queryStr , int hitsPerPage ) throws Exception {
        IndexSearcher searcher = getIndexSearcher();
        TopDocs docs = performSearch(queryStr,hitsPerPage);
        System.out.println("Total :::" + docs.totalHits);
        ScoreDoc[] hits = docs.scoreDocs;
        System.out.println("Found " + hits.length + " hits.");
        for (int i = 0; i < hits.length; ++i) {
            int docId = hits[i].doc;
            Document d = searcher.doc(docId);
            System.out.println((i + 1) + ". " + "---" + d.get("id") + " " + d.get("zipCode") + "\t" + d.get("CourseName"));
        }
    }

    public static void main(String[] args) throws Exception {
//        String zipQueryStr = "00044";
//        searchZipCode(zipQueryStr);

//        String courseQueryStr = "Course-00012";
//        searchCourseCode(courseQueryStr);

//        String queryStr = "00012";//Zip Code
//        String queryStr = "Course-00012";//Course
//        searchAnything(queryStr,10);

        //General search
//        String queryStr = "Course-00012";
        String queryStr = "00012";
        IndexSearcher searcher = getIndexSearcher();
//        QueryParser parser = new QueryParser("content", new StandardAnalyzer());
//        Query query = parser.parse(queryStr);

        StandardAnalyzer analyzer = new StandardAnalyzer();
        QueryBuilder builder = new QueryBuilder(analyzer);
//        query = builder.createBooleanQuery("zipCode",queryStr);

        Query query = builder.createPhraseQuery("zipCode","\""+queryStr+"\"");

        System.out.println(query.toString());

        TopDocs docs = performSearch(queryStr,10);
        System.out.println("Total :::" + docs.totalHits);
        ScoreDoc[] hits = docs.scoreDocs;
        System.out.println("Found " + hits.length + " hits.");
        for (int i = 0; i < hits.length; ++i) {
            int docId = hits[i].doc;
            Document d = searcher.doc(docId);
            System.out.println((i + 1) + ". " + "---" + d.get("id") + " " + d.get("zipCode") + "\t" + d.get("CourseName"));
        }



    }
}
