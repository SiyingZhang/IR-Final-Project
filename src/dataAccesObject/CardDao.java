/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataAccesObject;

import java.util.List;

import java.util.*;

import model.Card;

import dbConnect.DbConnection;
import static java.lang.Math.abs;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Zhirun Tian
 */
public class CardDao {

    private Connection connection;
    Statement st = null;
    ResultSet rs = null;

    String sql = "";
    int autoKey = 0;

    public CardDao() {
        //connect to database and select the record
        connection = DbConnection.getConnection();
    }

    public List<Card> GetCardListFromDB() {
        List<Card> cardList = new ArrayList<Card>();
        try {
            //prepare and execute search query
            sql = "SELECT * FROM cards.bankcard";
            PreparedStatement ps = connection.prepareStatement(sql);
            //ps.setString(1, nonceval);
            rs = ps.executeQuery();

            

            while (rs.next()) {
                //System.out.println(rs.getString("name"));
                Card card = new Card();
                card.setName(rs.getString("name"));
                card.setIssuer(rs.getString("issuer"));
                card.setNetwork(rs.getString("network"));

                card.setBouns(rs.getInt("bonus"));
                card.setDifficulty(rs.getInt("difficulty"));
                card.setPath(rs.getString("path"));

                cardList.add(card);
            }
            
      

            rs.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cardList;
    }

    public Card GetDreamCard(Card card) {

//        int test = 5;
        Card returnCard = new Card();
        List<Card> cardList = GetCardListFromDB();
        List<Double> scoreList = new ArrayList<Double>();
        List<Double> scoreListSorted = new ArrayList<Double>();
//        Map<Integer, Double> mapScore = new HashMap<Integer, Double>();
//        Map<Integer, Double> mapScoreSorted = new HashMap<Integer, Double>();
        for (Card tempCard : cardList) {
            double score = 0;
            //weigth of bonus
            double bonusWeight = 0.5;
            //weight of difficulty
            double difficultyWeight = 0.5;

            
            Boolean i = card.getIssuer().equalsIgnoreCase(tempCard.getIssuer());
            Boolean j = card.getNetwork().equalsIgnoreCase(tempCard.getNetwork());
            
            if (card.getIssuer().equalsIgnoreCase(tempCard.getIssuer()) && card.getNetwork().equalsIgnoreCase(tempCard.getNetwork())) {
                score = bonusWeight * abs(card.getBouns() - tempCard.getBouns()) + difficultyWeight * abs(card.getDifficulty() - tempCard.getDifficulty());
                //mapScore.put(cardList.indexOf(tempCard), score);
                scoreList.add(score);
            } else {
                scoreList.add(0.01);
            }
        }
//            scoreListSorted = scoreList;
//           Collections.sort(scoreListSorted);
        double maxScore = Collections.max(scoreList);
        int i = scoreList.indexOf(maxScore);

        returnCard = cardList.get(i);

        return returnCard;
    }
}
