/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Zhirun Tian
 */
public class PreProcessDoc {

    FileInputStream fis = null;
    BufferedReader reader = null;
    String line;
    String docLink;
    String docTitle;
    String docAbstract;
    

    public PreProcessDoc() throws FileNotFoundException {
        fis = new FileInputStream(Path.DataDir);
        reader = new BufferedReader(new InputStreamReader(fis));
    }

    public WebDocument nextDocument() throws IOException {
        line = reader.readLine();
        while (line != null) {

            if (line.equals("<DOC>")) {
                line = reader.readLine();
                //get the doc number
                docLink = line.substring(7, (line.length() - 8));
                line = reader.readLine();
                docTitle = line.substring(8, (line.length() - 9));
                line = reader.readLine();
                docAbstract = line.substring(11, (line.length() - 12));
                

            } else {
                //if(line.equals("<p>") ){
                String result = "";
                StringBuilder stringBuilder = new StringBuilder();
                //String temp = reader.readLine();
                //System.out.println("+++++++++"+ temp);
//                int count = 0;
//
//                String tempString = reader.readLine();
////                if (tempString.equals(null)) {
////                    continue;
////                }
//                
//                line = reader.readLine();
//                if (line == null) {
//                    break;
                    
                while (!(line.contains("</DOC>"))) {
                    stringBuilder.append(line);

                    line = reader.readLine();
                    if (line == null) {
                        break;
                    }
//                    count++;
                    //System.out.println("count "+ count+"+++++++++"+ temp);
                }
                //combine the lines to a string
                result = stringBuilder.toString();
                //return the map
//                Map<String, Object> rstPair = new HashMap<String, Object>();
//                rstPair.put(subs, result.toCharArray());
                docTitle = docTitle.substring(2,docTitle.length()-2);
                docLink = docLink.substring(2,docLink.length()-2);
                docAbstract = docAbstract.substring(2,docAbstract.length()-2);
                
                WebDocument doc = new WebDocument(docTitle, docLink, result, docAbstract);
                return doc;

            }

            if (line == null) {
                break;
            }
            line = reader.readLine();
        }

        reader.close();
        fis.close();

        return null;
    }

}
