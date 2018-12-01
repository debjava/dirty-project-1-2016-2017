package com.ddlab.rnd;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.Term;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.SimpleFSDirectory;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

public class ZipCodeIndexer1 {

    private static AtomicLong idCounter = new AtomicLong();

    public static String getID() {
        return String.valueOf(idCounter.getAndIncrement());
    }

    public static IndexWriter getIndexWriter(File dataDir) {
    	
        StandardAnalyzer analyzer = new StandardAnalyzer();
        Directory dir = null;
        try {
            dir = new SimpleFSDirectory(dataDir.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        IndexWriterConfig config = new IndexWriterConfig(analyzer);

        IndexWriter w = null;
        try {
            w = new IndexWriter(dir, config);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return w;
    }

    private static void updateDoc(IndexWriter w, String id, String zipCode, String courseId) throws IOException {

        Term term = new Term("id", id);

        Document doc = new Document();

        doc.add(new StringField("id", id, Field.Store.YES));
        doc.add(new StringField("zipCode", zipCode, Field.Store.YES));
        doc.add(new StringField("courseName", courseId, Field.Store.YES));
        //For full text search
        String fullSearchableText = id + " " + zipCode + " " + courseId;
        doc.add(new TextField("content", fullSearchableText, Field.Store.NO));

        w.updateDocument(term, doc);

    }

    public static void main(String[] args) throws Exception {

        File dataDir = new File("E:/dirty-project-2017/lucene63idea1/local/data/");
        IndexWriter indexWriter = getIndexWriter(dataDir);

        long startTime = System.nanoTime();

        //Zip Code
        for (int i = 0; i < 5; i++) {

            String zipCode = String.format("%05d", i);

            for (int j = 0; j < 10; j++) {

                String courseCode = "Course" + String.format("%03d", j);
                String id = getID();
                System.out.println(zipCode + "<---->" + courseCode);
                updateDoc(indexWriter, id, zipCode, courseCode);
            }
        }

        try {
            indexWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        long endTime = System.nanoTime();

        long duration = endTime - startTime;

        long minutes = TimeUnit.MINUTES.convert(duration, TimeUnit.NANOSECONDS);
        System.out.println("Total time taken :::" + minutes + " minutes");

    }

}
