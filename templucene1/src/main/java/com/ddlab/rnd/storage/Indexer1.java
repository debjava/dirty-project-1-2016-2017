package com.ddlab.rnd.storage;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.Term;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

import java.io.File;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by PIKU on 2/19/2017.
 */
public class Indexer1 {
    private static File indexDirPath = new File("local/data");

    private static AtomicLong idCounter = new AtomicLong();

    public static String getID() {
        return String.valueOf(idCounter.getAndIncrement());
    }

    public static void addOrUpdateDocument(IndexWriter indexWriter, String id, String zipCode, String
            courseCode) throws Exception {

        Document doc = new Document();
        doc.add(new StringField("id", id, Field.Store.YES));
        doc.add(new StringField("zipCode", zipCode, Field.Store.YES));
        doc.add(new StringField("courseCode", courseCode, Field.Store.YES));
        //For full text search
        String fullSearchableText = id + " " + zipCode + " " + courseCode;
        doc.add(new TextField("content", fullSearchableText, Field.Store.NO));
        if (indexWriter.getConfig().getOpenMode() == IndexWriterConfig.OpenMode.CREATE) {
            indexWriter.addDocument(doc);
        }
        else {
            indexWriter.updateDocument(new Term("id", id), doc);
        }
    }

    public static void main(String[] args) throws Exception {
        Directory indexDir = FSDirectory.open(indexDirPath.toPath());
        Analyzer analyzer = new StandardAnalyzer();
        IndexWriterConfig iwc = new IndexWriterConfig(analyzer);
        iwc.setOpenMode(IndexWriterConfig.OpenMode.CREATE_OR_APPEND);
        IndexWriter writer = new IndexWriter(indexDir, iwc);

        for (int i = 0; i < 5; i++) {
            String zipCode = "ZIP"+String.format("%05d", i);
            String courseCode = "COURSE" + String.format("%03d", i);
            System.out.println(zipCode + "<---->" + courseCode);
            String id = getID();
            addOrUpdateDocument(writer, id, zipCode, courseCode);
        }
        writer.close();
        System.out.println("Indexing completed successfully ...");

    }
}
