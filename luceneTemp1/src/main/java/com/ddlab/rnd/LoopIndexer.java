package com.ddlab.rnd;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicLong;

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

public class LoopIndexer {
	
	private static AtomicLong idCounter = new AtomicLong();

    public static String getID() {
        return String.valueOf(idCounter.getAndIncrement());
    }

    public static IndexWriter getIndexWriter(File dataDir) {
    	
        StandardAnalyzer analyzer = new StandardAnalyzer();
        Directory dir = null;
        try {
//            dir = new SimpleFSDirectory(dataDir.toPath());
        	dir = FSDirectory.open(dataDir.toPath());
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

    private static void updateDoc(IndexWriter indexWriter, String id, String zipCode, String courseCode) throws IOException {

        Document doc = new Document();

        
        
        doc.add(new StringField("id", id, Field.Store.YES));
        doc.add(new StringField("zipCode", zipCode, Field.Store.YES));
        doc.add(new StringField("courseCode", courseCode, Field.Store.YES));
        //For full text search
        String fullSearchableText = id + " " + zipCode + " " + courseCode;
        doc.add(new TextField("content", fullSearchableText, Field.Store.NO));

        Term term = new Term("id", id);
        indexWriter.updateDocument(term, doc);
        

    }

	public static void main(String[] args) throws Exception {
		File dataDir = new File("local/data/");
        IndexWriter indexWriter = getIndexWriter(dataDir);
        
        for (int i = 0; i < 5; i++) {

            String zipCode = "ZIP"+String.format("%05d", i);
            String courseCode = "COURSE" + String.format("%03d", i);
            System.out.println(zipCode + "<---->" + courseCode);
            String id = getID();
            updateDoc(indexWriter, id, zipCode, courseCode);
            
        }
        indexWriter.close();
        System.out.println("Indexing completed successfully ...");
	}

}
