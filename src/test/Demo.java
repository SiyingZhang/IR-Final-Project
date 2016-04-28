/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.io.IOException;
import java.util.List;

import model.*;

import org.apache.lucene.document.Document;
import org.apache.lucene.queryparser.classic.ParseException;

/**
 *
 * @author Zhirun Tian
 */
public class Demo {
    public static void main(String[] args) throws IOException, ParseException {  
        
        Card cardinfo = new Card("Citi Prestige",  "Master",  "Citi",  6,  5,  "/a fake path");
        String origQuery = "prestige";
        
        Combination combination = new Combination(cardinfo, origQuery);
        
        Card newCard = combination.ReturnCard();       
        System.out.println("card info:" + newCard.getIssuer() + newCard.getName());
        
        List<Document> docList = combination.retrieveDocList(10);
        
        for(Document doc :docList){
            System.out.println("content--\tname:\t" + doc.get("link") + "\tcontent:\t" + doc.get("content"));  
        }    
       
    }
}
