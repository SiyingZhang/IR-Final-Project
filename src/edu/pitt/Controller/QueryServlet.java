package edu.pitt.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CardRecommendation
 */
@WebServlet("/CardRecommendation")
public class QueryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
    	String query;
    	String creditScore;
    	String monthSpend;
    	String network;
    	String issuer;
    	
    	if(request.getParameter("query_text") == null) {
    		query = "";
    	} else {
			query = request.getParameter("query_text");
		}
    	
    	if(request.getParameter("credit_score") == null) {
    		creditScore = "";
    	} else {
    		creditScore = request.getParameter("credit_score");
		}
    	
    	if(request.getParameter("monthly_spend") == null) {
    		monthSpend="";
    	} else {
    		monthSpend = request.getParameter("monthly_spend");
		}
    	
    	if(request.getParameter("network") == null) {
    		network = "";
    	} else {
    		network = request.getParameter("network");
		}
    	
    	if(request.getParameter("issuer") == null) {
    		issuer = "";
    	} else {
    		issuer = request.getParameter("issuer");
		}

    	//Get the entire query content
    	String queryContent = query + creditScore + monthSpend + network + issuer;
    	
    	//Get the card information  
    	
    	
    	//Transfer data into result page.
    	getServletContext().getRequestDispatcher("/result.jsp").forward(request, response);
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
