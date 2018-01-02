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
public class AdjacencyNode {

    private AdjacencyNode previous;
    private AdjacencyNode next;
    private City city;
    private double weight;
    private double accumulatedWeight;
    private boolean wasVisited;
    private City previousCity;

    public AdjacencyNode() {
        this.previous = null;
        this.next = null;
        this.weight = 0;
        this.city = null;
        this.accumulatedWeight = Double.POSITIVE_INFINITY;
        this.wasVisited = false;
        this.previousCity = null;
    }

    public AdjacencyNode(AdjacencyNode previous, AdjacencyNode next, double weight, double accumulatedWeight, boolean wasVisited, City lastCity) {
        this.previous = previous;
        this.next = next;
        this.weight = 0;
        this.city = null;
        this.accumulatedWeight = Double.POSITIVE_INFINITY;
        this.wasVisited = false;
        this.previousCity = null;
    }

    public AdjacencyNode getPrevious() {
        return previous;
    }

    public void setPrevious(AdjacencyNode previous) {
        this.previous = previous;
    }

    public AdjacencyNode getNext() {
        return next;
    }

    public void setNext(AdjacencyNode next) {
        this.next = next;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getAccumulatedWeight() {
        return accumulatedWeight;
    }

    public void setAccumulatedWeight(double accumulatedWeight) {
        this.accumulatedWeight = accumulatedWeight;
    }

    public boolean isWasVisited() {
        return wasVisited;
    }

    public void setWasVisited(boolean wasVisited) {
        this.wasVisited = wasVisited;
    }

    public City getPreviousCity() {
        return previousCity;
    }

    public void setPreviousCity(City previousCity) {
        this.previousCity = previousCity;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

}
