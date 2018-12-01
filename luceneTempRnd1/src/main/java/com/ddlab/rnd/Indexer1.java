package com.ddlab.rnd;

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
import java.util.concurrent.TimeUnit;
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

	public static void addOrUpdateDocument(IndexWriter indexWriter, String id, String zipCode, String courseCode)
			throws Exception {

		Document doc = new Document();
		doc.add(new StringField("id", id, Field.Store.YES));
		doc.add(new StringField("zipCode", zipCode, Field.Store.YES));
		doc.add(new StringField("courseCode", courseCode, Field.Store.YES));
		// For full text search
		String fullSearchableText = id + " " + zipCode + " " + courseCode;
		doc.add(new TextField("content", fullSearchableText, Field.Store.NO));
		if (indexWriter.getConfig().getOpenMode() == IndexWriterConfig.OpenMode.CREATE) {
			indexWriter.addDocument(doc);
		} else {
			indexWriter.updateDocument(new Term("id", id), doc);
		}
	}

	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	public static IndexWriter getIndexWriter() throws Exception {

		Directory indexDir = FSDirectory.open(indexDirPath.toPath());
		Analyzer analyzer = new StandardAnalyzer();
		IndexWriterConfig iwc = new IndexWriterConfig(analyzer);
		iwc.setOpenMode(IndexWriterConfig.OpenMode.CREATE_OR_APPEND);
		IndexWriter writer = new IndexWriter(indexDir, iwc);

		return writer;
	}

	public static void storeDocs(IndexWriter writer) throws Exception {

		for (int i = 0; i < 45000; i++) {
			String zipCode = "ZIP" + String.format("%05d", i);

			for (int j = 0; j < 5001; j++) {
				String courseCode = "COURSE" + String.format("%05d", j);
				String id = getID();
				System.out.println(id + "-" + zipCode + "<---->" + courseCode);
				addOrUpdateDocument(writer, id, zipCode, courseCode);
			}
		}
	}

	public static void main(String[] args) throws Exception {
		long startTime = System.nanoTime();
		IndexWriter writer = getIndexWriter();
		storeDocs(writer);

		writer.close();
		System.out.println("Indexing completed successfully ...");
		long endTime = System.nanoTime();
		long duration = endTime - startTime;
		long minutes = TimeUnit.MINUTES.convert(duration, TimeUnit.NANOSECONDS);
		long seconds = TimeUnit.SECONDS.convert(duration, TimeUnit.NANOSECONDS);
		System.out.println("Total time taken :::"+minutes+" minutes" +" OR "+seconds+" seconds");

	}
}
