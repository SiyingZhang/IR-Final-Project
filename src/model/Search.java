/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Zhirun Tian
 */

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;

public class Search {

	public static void main(String[] args) {

		List<Document> docList = new ArrayList<Document>();
		SearchBase searchBase = new SearchBase();
		docList = searchBase.SearchIndex("visa");
		
		for (Document doc :docList) {
			
			System.out.println("============ title ============");
			System.out.println(doc.get("title"));
			
			System.out.println("============ abstract ============");
			System.out.println(doc.get("abstract"));
			
			System.out.println("============ content ============");
			System.out.println(doc.get("content"));

		}
	}
}