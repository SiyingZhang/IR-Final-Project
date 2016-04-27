package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Card;
import model.Combination;
import model.WebDocument;

import org.apache.lucene.document.Document;
import org.json.JSONArray;

/**
 * Servlet implementation class CardRecommendation
 */
@WebServlet("/CardRecommendation")
public class QueryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Map<Integer, Document> map;
      
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryServlet() {
        super();
        // TODO Auto-generated constructor stub
        map = new HashMap<>();
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
    	//Get data from JSP
    	String query;
    	String creditScore;
    	int difficulty;
    	String monthSpend;
    	int bonus;
    	String network;
    	String issuer;
    	String queryText = "";
    	
    	if(request.getParameter("query_text") == null) {
    		query = "";
    	} else {
			query = request.getParameter("query_text");
			queryText = queryText + "Search Text: " + query;
		}
    	
    	if(request.getParameter("credit_score") == null) {
    		difficulty = 8;
    	} else {
    		creditScore = request.getParameter("credit_score");
    		difficulty = Integer.parseInt(creditScore);

    		queryText = queryText + " | Credit Score: " + creditScore;
		}
    	
    	if(request.getParameter("monthly_spend") == null) {
    		bonus=1;
    	} else {
    		monthSpend = request.getParameter("monthly_spend");
    		bonus = Integer.parseInt(monthSpend); 
    		queryText = queryText + " | Monthly Spend: " + monthSpend;
		}
    	
    	if(request.getParameter("network") == null) {
    		network = "AE";
    	} else {
    		network = request.getParameter("network");
    		queryText = queryText + " | Network: " + network;
		}
    	
    	if(request.getParameter("issuer") == null) {
    		issuer = "AE";
    	} else {
    		issuer = request.getParameter("issuer");
    		queryText = queryText + " | Issuer: " + issuer;
		}

    	//Get the entire query content, add space between each two
    	String queryContent = query +" "+ difficulty +" "+ bonus +" "+ network +" "+ issuer;
    	System.out.println("Query is: " + queryText);
    	
    	request.setAttribute("query_text", queryText);	//pass query on result page
    	
    	Combination combination = new Combination();
        Card cardinfo = new Card("",  network,  issuer,  bonus,  difficulty, "/a fake path");
       
        combination.ReturnAll(cardinfo, queryContent, 10);
        Card DreamCard = combination.getCard();
        
        //Pass card info into result jsp
        request.setAttribute("bank_name", DreamCard.getIssuer());
        request.setAttribute("card_name", DreamCard.getNetwork());
        request.setAttribute("bonus", DreamCard.getBouns());
        
        request.setAttribute("path", DreamCard.getPath());
        
        System.out.println("card info:" + DreamCard.getIssuer() + DreamCard.getName());
        
        List<Document> docList = combination.getDocList();
        List<HashMap<String, String>> result = new ArrayList<>();
        int count = 0;
        
        for(Document doc :docList){
        	map.put(count++, doc);
        	
        	HashMap<String, String> map = new HashMap<>();
        	map.put("link", doc.get("link"));
        	map.put("content", doc.get("content"));
            System.out.println("content--\tname:\t" + doc.get("link") + "\tcontent:\t" + doc.get("content"));  
            
            result.add(map);
            
        }
    	
    	JSONArray json = new JSONArray(result);
    	request.setAttribute("result", json.toString());
    	//Transfer data into result page.
    	getServletContext().getRequestDispatcher("/result.jsp").forward(request, response);
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			processRequest(request, response);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			processRequest(request, response);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
