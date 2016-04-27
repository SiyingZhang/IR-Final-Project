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
	Map<Integer, WebDocument> map;
      
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
    	String queryContent = query +" "+ creditScore +" "+ monthSpend +" "+ network +" "+ issuer;
    	System.out.println("Query is: " + queryText);
    	
    	request.setAttribute("query", queryText);	//entire query
    	
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
        
    	//List<WebDocument> searchResult = search.getSearchResult();
    	
    	List<HashMap<String, String>> result = new ArrayList<>();
    	
    	int count = 0;
    	for(WebDocument document : searchResult) {
    		map.put(count++, document);
    		
    		HashMap<String, String> map = new HashMap<>();
    		map.put("link", document.getDocLink());
    		map.put("content", document.getDocContent());
    		
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
