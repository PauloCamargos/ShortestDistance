/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 * Class representing a Graph.
 * 
 *  
 * @author pauloc
 */
public class Graph {

    private GraphNode head;
    private GraphNode tale;
    private int nodesAmount;
    private AdjacencyList priorityList;

    public Graph(GraphNode head, GraphNode tale) {
        this.head = head;
        this.tale = tale;
        this.nodesAmount = 0;
        this.priorityList = null;
    }

    public GraphNode getHead() {
        return head;
    }

    public void setHead(GraphNode head) {
        this.head = head;
    }

    public GraphNode getTale() {
        return tale;
    }

    public void setTale(GraphNode tale) {
        this.tale = tale;
    }

    public int getNodesAmount() {
        return nodesAmount;
    }

    public void setNodesAmount(int nodesAmount) {
        this.nodesAmount = nodesAmount;
    }

    public AdjacencyList getPriorityList() {
        return priorityList;
    }

    public void setPriorityList(AdjacencyList priorityList) {
        this.priorityList = priorityList;
    }

    /**
     * Insert a node at the beginning of the graph.
     *
     * @param data node's data
     */
    public void insertBeginning(City data) {

        GraphNode newNode = new GraphNode(data);

        if (head == null) {
            head = newNode;
            head = newNode;
        } else {
            newNode.setNext(head);
            head.setPrevious(newNode);
            head = newNode;
        }
        nodesAmount++;
    } // End of insertBeginning.
   
} //End of class
