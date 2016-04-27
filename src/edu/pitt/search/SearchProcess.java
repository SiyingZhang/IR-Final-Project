package edu.pitt.search;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Zhirun Tian
 */

import java.io.File;  
  

import java.io.IOException;
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

import edu.pitt.bean.WebDocument;
import Classes.Path;
    
public class SearchProcess { 
	
	private Directory directory;
	private DirectoryReader dReader;
	private IndexSearcher searcher;
	private Analyzer analyzer;
	private String queryText;
	
	
	//Constructor
	public SearchProcess(String s) throws IOException {

        //path of indexing  
        directory = FSDirectory.open(new File(Path.IndexDir));  
        //read index  
        dReader = DirectoryReader.open(directory);  
        //create indexing search object  
        searcher = new IndexSearcher(dReader);  
        //the model should be same between indexing and searching
        analyzer = new StandardAnalyzer(Version.LUCENE_43); 
        this.queryText = s;
		
	}
	
	/*
    public static void main(String[] args) {  
        HashMap<String, String> testHashMap = new HashMap<>();
        try {
			Search searchModel = new Search("chase");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        testHashMap = getSearchResult();
    }
    */
    
	//Store search results into HashMap
    public List<WebDocument> getSearchResult() {
    	
    	List<WebDocument> resultDocuments = new ArrayList<WebDocument>();
    	
    	//link & content parts
    	//HashMap<String, String> map;  //“link” -> link & "content" -> content
    	
    	try {
        	QueryParser parse = new QueryParser(Version.LUCENE_43, "content", analyzer);  
            Query query = parse.parse(queryText); 

            //searching the index and get top 10 answer
            TopDocs topDocs = searcher.search(query, 10);  
            if (topDocs != null) {  
                System.out.println("the total result is  " +  topDocs.totalHits );  
                
                //Get result List ;
                for (int i = 0; i < topDocs.scoreDocs.length; i++) {    	
                    Document doc = searcher.doc(topDocs.scoreDocs[i].doc);
                    System.out.println("the No.   " + (i + 1) + "has content--\tname:\t" + doc.get("link") + "\tcontent:\t" + doc.get("content"));  

                    WebDocument document = new WebDocument((i+1), doc.get("link"), doc.get("content"));
                   
                    resultDocuments.add(document);
                }  
            }  
            //close the resouruce  
            dReader.close();  
            directory.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
    	return resultDocuments;
    }
}  