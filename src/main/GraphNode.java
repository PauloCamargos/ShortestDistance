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
public class GraphNode {

    private GraphNode next;
    private GraphNode previous;
    private City city;

    public GraphNode(GraphNode proximo, GraphNode anterior, City cidade) {
        this.next = proximo;
        this.previous = anterior;
        this.city = cidade;
    }
    
    public GraphNode(City cidade) {
        this.next = null;
        this.previous = null;
        this.city = cidade;
    }
    
    public GraphNode() {
        this.next = null;
        this.previous = null;
        this.city = null;
    }

    public GraphNode getNext() {
        return next;
    }

    public void setNext(GraphNode next) {
        this.next = next;
    }

    public GraphNode getPrevious() {
        return previous;
    }

    public void setPrevious(GraphNode previous) {
        this.previous = previous;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}
