package edu.pitt.Controller;

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

import edu.pitt.bean.WebDocument;
import edu.pitt.search.SearchProcess;

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
    	String monthSpend;
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
    		creditScore = "";
    	} else {
    		creditScore = request.getParameter("credit_score");
    		queryText = queryText + " | Credit Score: " + creditScore;
		}
    	
    	if(request.getParameter("monthly_spend") == null) {
    		monthSpend="";
    	} else {
    		monthSpend = request.getParameter("monthly_spend");
    		queryText = queryText + " | Monthly Spend: " + monthSpend;
		}
    	
    	if(request.getParameter("network") == null) {
    		network = "";
    	} else {
    		network = request.getParameter("network");
    		queryText = queryText + " | Network: " + network;
		}
    	
    	if(request.getParameter("issuer") == null) {
    		issuer = "";
    	} else {
    		issuer = request.getParameter("issuer");
    		queryText = queryText + " | Issuer: " + monthSpend;
		}

    	//Get the entire query content, add space between each two
    	String queryContent = query +" "+ creditScore +" "+ monthSpend +" "+ network +" "+ issuer;
    	System.out.println("Query is: " + queryText);
    	
    	request.setAttribute("query", queryText);	//entire query
    	
    	SearchProcess search = new SearchProcess(queryContent);
    	List<WebDocument> searchResult = search.getSearchResult();
    	
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
