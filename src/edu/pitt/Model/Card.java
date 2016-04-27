/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pitt.Model;

/**
 *
 * @author Zhirun Tian
 */

public class Card {
    private String Name;
    private String Network;
    private String Issuer;
    private double bonus;
    private double difficulty;
    private String path;

    public Card(String Name, String Network, String Issuer, double bonus, double difficulty, String path) {
        this.Name = Name;
        this.Network = Network;
        this.Issuer = Issuer;
        this.bonus = bonus;
        this.difficulty = difficulty;
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getNetwork() {
        return Network;
    }

    public void setNetwork(String Network) {
        this.Network = Network;
    }

    public String getIssuer() {
        return Issuer;
    }

    public void setIssuer(String Issuer) {
        this.Issuer = Issuer;
    }

    public double getBonus() {
        return this.bonus;
    }

    public void setBouns(double bonus) {
        this.bonus = bonus;
    }

    public double getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(double difficulty) {
        this.difficulty = difficulty;
    }
    
}
