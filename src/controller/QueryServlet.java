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
import javax.servlet.http.HttpSession;

import model.Card;
import model.Combination;

import org.apache.lucene.document.Document;

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
    		bonus = 1;
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
    	System.out.println("Query is: " + queryContent);
    	
    	request.setAttribute("query_text", queryText);	//pass query on result page
    	
        Card cardinfo = new Card("",  network,  issuer,  bonus,  difficulty, "/a fake path");
        
        //Initiate combination
        Combination combination = new Combination(cardinfo, queryContent);
        
        //Get the recommendation card
        Card DreamCard = combination.ReturnCard();

        //Pass card info into result jsp
        request.setAttribute("bank_name", DreamCard.getIssuer());
        request.setAttribute("card_name", DreamCard.getNetwork());
        request.setAttribute("bonus", DreamCard.getBouns());
        
        request.setAttribute("path", DreamCard.getPath());
        
        System.out.println("card info:" + DreamCard.getIssuer() + DreamCard.getNetwork());
        
        //Retrieve doc list
        List<Document> documentList = new ArrayList<Document>();
        documentList = combination.retrieveDocList(10);
        
        HashMap<String, String> linkContent = new HashMap<>(); // link->content
        
        for(Document doc : documentList){
        	
        	System.out.println("content--\tname:\t" + doc.get("link") + "\tcontent:\t" + doc.get("content"));  
            
        	linkContent.put(doc.get("link"), doc.get("content"));            
        }
        
        //pass link->content into result jsp page
        HttpSession session = request.getSession();
        session.setAttribute("result", linkContent);

        //request.setAttribute("result", linkContent);
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
	
//	public Card GetDreamCard(Card card) {
//
//        int test = 5;
//        Card returnCard = new Card();
//        CardDao carddao = new CardDao();
//        List<Card> cardList = carddao.GetCardListFromDB();
//        List<Double> scoreList = new ArrayList<Double>();
//        List<Double> scoreListSorted = new ArrayList<Double>();
////        Map<Integer, Double> mapScore = new HashMap<Integer, Double>();
////        Map<Integer, Double> mapScoreSorted = new HashMap<Integer, Double>();
//        for (Card tempCard : cardList) {
//            double score = 0;
//            //weigth of bonus
//            double bonusWeight = 0.5;
//            //weight of difficulty
//            double difficultyWeight = 0.5;
//
//            if ((card.getIssuer() == tempCard.getIssuer()) && (card.getNetwork() == tempCard.getNetwork())) {
//                score = bonusWeight * abs(card.getBouns() - tempCard.getBouns()) + difficultyWeight * abs(card.getDifficulty() - tempCard.getDifficulty());
//                //mapScore.put(cardList.indexOf(tempCard), score);
//                scoreList.add(score);
//            } else {
//                scoreList.add(0.01);
//            }
//
////            scoreListSorted = scoreList;
////           Collections.sort(scoreListSorted);
//            
//
//        }
//        double maxScore = Collections.max(scoreList);
//        int i = scoreList.indexOf(maxScore);
//
//        returnCard = cardList.get(i);
//       
//        //returnCard = 
//        return returnCard;
//    }
//	

}
