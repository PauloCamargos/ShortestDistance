/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 *
 * @author pauloc
 */
public class NoLista extends NoGrafo{

    private double weight;
    private double accumulatedWeight;
    private boolean wasVisited;
    private DataCity lastCity;
    
    public NoLista(
            double weight, double accumulatedWeight, boolean wasVisited, 
            DataCity lastCity, NoGrafo proximo, NoGrafo anterior, 
            DataCity cidade) {
        super(proximo, anterior, cidade);
        this.weight = weight;
        this.accumulatedWeight = accumulatedWeight;
        this.wasVisited = wasVisited;
        this.lastCity = lastCity;
    }

    public NoLista(double weight, double accumulatedWeight, boolean wasVisited,
            DataCity lastCity, DataCity cidade) {
        super(cidade);
        this.weight = weight;
        this.accumulatedWeight = accumulatedWeight;
        this.wasVisited = wasVisited;
        this.lastCity = lastCity;
    }

    public NoLista(double weight, double accumulatedWeight, boolean wasVisited,
            DataCity lastCity) {
        this.weight = weight;
        this.accumulatedWeight = accumulatedWeight;
        this.wasVisited = wasVisited;
        this.lastCity = lastCity;
    }
    
    
    
    
}
