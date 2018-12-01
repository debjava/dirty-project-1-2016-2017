package com.ddlab.rnd.search;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.Term;
import org.apache.lucene.search.*;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

import java.io.File;

/**
 * Created by PIKU on 2/19/2017.
 */
public class MultiFieldSearch {
    private static File indexDirPath = new File("local/data");

    public static void main(String[] args) throws Exception {
//        File dataDir = new File("local/data/");
        Directory dir = FSDirectory.open(indexDirPath.toPath());
        DirectoryReader ireader = DirectoryReader.open(dir);
        IndexSearcher isearcher = new IndexSearcher(ireader);
        Analyzer analyzer = new StandardAnalyzer();

//        String queryText = "ZIP00002";
//        String[] fields = new String[]{"zipCode","courseCode"};
//        MultiFieldQueryParser mp = new MultiFieldQueryParser(fields,analyzer);
//        Query query = mp.parse(queryText);

//        TermQuery t1 = new TermQuery( new Term("zipCode","ZIP00002"));
//        TermQuery t2 = new TermQuery( new Term("courseCode","COURSE003"));

        String queryStr = "COURSE003";
        TermQuery t1 = new TermQuery( new Term("zipCode",queryStr));
        TermQuery t2 = new TermQuery( new Term("courseCode",queryStr));

        BooleanClause bc1 = new BooleanClause(t1, BooleanClause.Occur.SHOULD);
        BooleanClause bc2 = new BooleanClause(t2, BooleanClause.Occur.SHOULD);

        Query query = new BooleanQuery.Builder().add(bc1).add(bc2).build();

//        StandardQueryParser stdQueryParser = new StandardQueryParser();
//        Query query = stdQueryParser.parse("ZIP00002", "zipCode");


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
