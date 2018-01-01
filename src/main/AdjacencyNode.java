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
public class AdjacencyNode extends GraphNode{

    private double weight;
    private double accumulatedWeight;
    private boolean wasVisited;
    private City lastCity;
    
    public AdjacencyNode(
            double weight, double accumulatedWeight, boolean wasVisited, 
            City lastCity, GraphNode proximo, GraphNode anterior, 
            City cidade) {
        super(proximo, anterior, cidade);
        this.weight = weight;
        this.accumulatedWeight = accumulatedWeight;
        this.wasVisited = wasVisited;
        this.lastCity = lastCity;
    }

    public AdjacencyNode(double weight, double accumulatedWeight, boolean wasVisited,
            City lastCity, City cidade) {
        super(cidade);
        this.weight = weight;
        this.accumulatedWeight = accumulatedWeight;
        this.wasVisited = wasVisited;
        this.lastCity = lastCity;
    }

    public AdjacencyNode(double weight, double accumulatedWeight, boolean wasVisited,
            City lastCity) {
        this.weight = weight;
        this.accumulatedWeight = accumulatedWeight;
        this.wasVisited = wasVisited;
        this.lastCity = lastCity;
    }
    
    
    
    
}
