/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import dataAccesObject.CardDao;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;
/**
 *
 * @author Zhirun Tian
 */
public class Combination {
    private Card card;
    //path of indexing  
    private Directory directory;  
    //read index  
    private DirectoryReader dReader;  
    //create indexing search object  
    private IndexSearcher searcher;  
    //the model should be same between indexing and searching
    private Analyzer analyzer;
    private String queryString;
    private Query query;
    private QueryParser parser;
    
    
    //Constructor
    public Combination(Card c, String s) throws IOException, ParseException{
        this.card = c;
        directory = FSDirectory.open(new File(Path.IndexDir));
        dReader = DirectoryReader.open(directory); 
        searcher = new IndexSearcher(dReader);
        analyzer = new StandardAnalyzer(Version.LUCENE_43); 
        parser = new QueryParser(Version.LUCENE_43, "content", analyzer);
        
        queryString = s;
        query = parser.parse(this.queryString);
    }
    
    //input the cardinfo
    //the query to search
    //the number they want
    public Card ReturnCard() {
    	
    	CardDao cardDao = new CardDao();
    	Card dreamCard = cardDao.GetDreamCard(card);
    	return dreamCard;
    	
    }
    
    //Return topN document
    public List<Document> retrieveDocList(int topN) {
    	
    	//Store all retrieved documents
    	List<Document> docList = new ArrayList<>();
    	
    	try {
    		TopDocs topDocs = searcher.search(query, topN);  
            if (topDocs != null) {  
                System.out.println("the total result is  " +  topDocs.totalHits );  
                //print out the result  
                for (int i = 0; i < topDocs.scoreDocs.length; i++) {  
                    Document doc = searcher.doc(topDocs.scoreDocs[i].doc);  
                    docList.add(doc);
                 	System.out.println("the No.   " + (i + 1) + "has content--\tname:\t" + doc.get("link") + "\tcontent:\t" + doc.get("content"));        
                        
                }  
            }  
            //close the resouruce  
            dReader.close();  
            directory.close();  
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
    	return docList;
    }
    
}
