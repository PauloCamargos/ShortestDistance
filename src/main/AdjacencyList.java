/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 * Class representing a adjacency list of the graph.
 *
 * @author pauloc
 */
public class AdjacencyList{

    private AdjacencyNode head;
    private AdjacencyNode tale;
    private int nodesAmount;

    public AdjacencyList() {
    }

    public AdjacencyList(AdjacencyNode head, AdjacencyNode tale, int nodesAmount) {
        this.head = head;
        this.tale = tale;
        this.nodesAmount = nodesAmount;
    }
    
    //todo: implement case city wasn't found.
    public AdjacencyNode findNode(City city) {
        AdjacencyNode temp = getHead();
        while (temp != null) {
            if (temp.getCity() == city) {
                return temp;
            } else {
                temp = temp.getNext();
            }
        }
        return temp;
    }

    public AdjacencyNode getHead() {
        return head;
    }

    public void setHead(AdjacencyNode head) {
        this.head = head;
    }

    public AdjacencyNode getTale() {
        return tale;
    }

    public void setTale(AdjacencyNode tale) {
        this.tale = tale;
    }

    public int getNodesAmount() {
        return nodesAmount;
    }

    public void setNodesAmount(int nodesAmount) {
        this.nodesAmount = nodesAmount;
    }

}
