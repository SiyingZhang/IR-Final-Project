/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.List;
import model.*;
import org.apache.lucene.document.Document;

/**
 *
 * @author Zhirun Tian
 */
public class Demo {
    public static void main(String[] args) {  
        Combination combination = new Combination();
        Card cardinfo = new Card("Citi Prestige",  "Master",  "Citi",  6,  5,  "/a fake path");
        String origQuery = "prestige";
        combination.ReturnAll(cardinfo, origQuery, 10);
        Card DreamCard = combination.getCard();
        System.out.println("card info:" + DreamCard.getIssuer() + DreamCard.getName());
        List<Document> docList = combination.getDocList();
        
        for(Document doc :docList){
            System.out.println("content--\tname:\t" + doc.get("link") + "\tcontent:\t" + doc.get("content"));  
        }
        
        
//        for (int i = 0; i <doc.size(); i++) {  
//                    
//                    System.out.println("the No.   " + (i + 1) + "has content--\tname:\t" + doc.get("link") + "\tcontent:\t" + doc.get("content"));  
//                }
        
        
       
    }
}
