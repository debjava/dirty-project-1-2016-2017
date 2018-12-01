package com.ddlab.rnd.search;

import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.queryparser.flexible.standard.StandardQueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

import java.io.File;

/**
 * Created by PIKU on 2/19/2017.
 * Based on Field Name
 */
public class WorkingSearch1 {

    private static File indexDirPath = new File("local/data");

    public static void main(String[] args) throws Exception {
        Directory dir = FSDirectory.open(indexDirPath.toPath());
        DirectoryReader ireader = DirectoryReader.open(dir);
        IndexSearcher isearcher = new IndexSearcher(ireader);

        StandardQueryParser qpHelper = new StandardQueryParser();
//        Query query = qpHelper.parse("ZIP00002", "zipCode");
        Query query = qpHelper.parse("COURSE002", "courseCode");
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
