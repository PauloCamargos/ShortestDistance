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
public class Graph {

    private GraphNode head;
    private GraphNode tale;
    private int nodesAmount;
    private AdjacencyList priorityList;

    /**
     *  Constructor Graph(GraphNode head, GraphNode tale) 
     * 
     * @param head
     * @param tale
     */
    public Graph(GraphNode head, GraphNode tale) {
        this.head = head;
        this.tale = tale;
        this.nodesAmount = 0;
        this.priorityList = null;
    }

    /**
     * Constructor Graph()
     */
    public Graph() {
        this.head = null;
        this.tale = null;
        this.nodesAmount = 0;
        this.priorityList = null;
    }    
    
    /**
     * Returns the 'head' parameter
     * 
     * @return
     */
    public GraphNode getHead() {
        return head;
    }

    /**
     *
     * @param head
     */
    public void setHead(GraphNode head) {
        this.head = head;
    }

    /**
     *
     * @return
     */
    public GraphNode getTale() {
        return tale;
    }

    /**
     *
     * @param tale
     */
    public void setTale(GraphNode tale) {
        this.tale = tale;
    }

    /**
     *
     * @return
     */
    public int getNodesAmount() {
        return nodesAmount;
    }

    /**
     *
     * @param nodesAmount
     */
    public void setNodesAmount(int nodesAmount) {
        this.nodesAmount = nodesAmount;
    }

    /**
     *
     * @return
     */
    public AdjacencyList getPriorityList() {
        return priorityList;
    }

    /**
     *
     * @param priorityList
     */
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
    
    /**
     * Locate and returs a Graph node based on the given data
     * 
     * @param data
     * @return foundNode
     */
    public GraphNode findNode(City data){
       
        return null;
    }
    
    /**
     *
     * @param node_1
     * @param node_2
     * @param weight
     */
    public void insertEdge(City node_1, City node_2, double weight){
        
    }
    
    /**
     *
     * @param origin
     * @param destiny
     */
    public void calculateDijkstra(City origin, City destiny){
        
    }
    
    /**
     *
     */
    public void printList(){
        
    }
    
    /**
     *
     * @param origin
     * @param destiny
     */
    public void shortestDistance(City origin, City destiny){
        if (origin == null || destiny == null) {
            System.out.println("Couldn't find that node. Try again!");
        } else {
            calculateDijkstra(origin, destiny);
            
           // AdjacencyNode temp = priorityList.findNode(City destiny);
        }
    }

} //End of class
