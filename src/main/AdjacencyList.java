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
public class AdjacencyList {

    public AdjacencyNode head;
    public AdjacencyNode tale;
    public int nodesAmount;

    public AdjacencyList() {
        this.head = null;
        this.tale = null;
        this.nodesAmount = 0;
    }

    public AdjacencyList(AdjacencyNode head, AdjacencyNode tale) {
        this.head = head;
        this.tale = tale;
        this.nodesAmount = 0;
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

    /**
     *
     * @param city
     * @param weight
     */
    public void insertEnd(City city, double weight) {
        setNodesAmount(getNodesAmount() + 1);
        AdjacencyNode new_node = new AdjacencyNode(city, weight);
        //new_node.setWeight(weight);
        if (this.head == null) {
            this.head = new_node;
            this.tale = new_node;
        } else {
            this.tale.setNext(new_node);
            new_node.setPrevious(this.tale);
            this.tale = this.tale.getNext();
        }
    }

    void printCities() {
        AdjacencyNode temporary;
        temporary = this.getHead();
        while (temporary != null) {
            System.out.println(temporary.getCity().getName() + "(" + temporary.getAccumulatedWeight() + ")");
            temporary = temporary.getNext();
        }
    }

    void resetList() {
        AdjacencyNode temporary = this.getHead();
        while (temporary != null) {
            temporary.setAccumulatedWeight(Double.POSITIVE_INFINITY);
            temporary.setPreviousCity(null);
            temporary.setWasVisited(false);
            temporary = temporary.getNext();
        }
    }

    void sortList() {
        AdjacencyNode temp = this.head;  // Variavel temporario do loop de fora
        AdjacencyNode temp_2 = this.head; // Variavel temporario do loop de dentro
        City aux_data;
        Double aux_distDijkstra;
        City aux_caminhoDijkstra;
        boolean naoEstaOrdenada = true;
        boolean flag = true;

        while (naoEstaOrdenada) {
            while (temp_2 != null && flag && naoEstaOrdenada) {
                aux_data = temp_2.getCity();
                aux_distDijkstra = temp_2.getAccumulatedWeight();
                aux_caminhoDijkstra = temp_2.getPreviousCity();

                if (temp_2 == null || temp_2.getNext() == null) {
                    naoEstaOrdenada = false;
                    flag = false;
                    break;
                }

                if (temp_2.getNext().getAccumulatedWeight() < temp_2.getAccumulatedWeight()) {

                    //Troca os nós de lugar
                    temp_2.setCity(temp_2.getNext().getCity());
                    temp_2.setAccumulatedWeight(temp_2.getNext().getAccumulatedWeight());
                    temp_2.setPreviousCity(temp_2.getNext().getPreviousCity());

                    temp_2.getNext().setCity(aux_data);
                    temp_2.getNext().setAccumulatedWeight(aux_distDijkstra);
                    temp_2.getNext().setPreviousCity(aux_caminhoDijkstra);
                    temp_2 = this.head;
                } else {
                    temp_2 = temp_2.getNext();
                }
                //Verfica se a lista está ordenada
                while (temp.getNext() != null) {
                    if (temp.getNext().getAccumulatedWeight() < temp.getAccumulatedWeight()) {
                        naoEstaOrdenada = true;
                        break;
                    } else {
                        naoEstaOrdenada = false;
                        temp = temp.getNext();
                    }
                }
                temp = this.head;;
            }
        }
    }

    void insertEnd(City city) {
        setNodesAmount(getNodesAmount() + 1);
        AdjacencyNode new_node = new AdjacencyNode(city);
        //new_node.setWeight(weight);
        if (this.head == null) {
            this.head = new_node;
            this.tale = new_node;
        } else {
            this.tale.setNext(new_node);
            new_node.setPrevious(this.tale);
            this.tale = this.tale.getNext();
        }
    }

    void insertBeginning(City city, double accumulatedWeight) {
        AdjacencyNode newNode = new AdjacencyNode(city, accumulatedWeight);
        newNode.setAccumulatedWeight(accumulatedWeight);
        if (head == null) {
            head = newNode;
            tale = newNode;
        } else {
            newNode.setNext(head);
            head.setPrevious(newNode);
            head = newNode;
        }
        nodesAmount++;
    } // End of insertBeginning.

    public String printRoute() {
        AdjacencyNode temp = this.head;
        //System.out.println(temp2.getCity().getName());
        String route_message = "With " + this.tale.getAccumulatedWeight() + " Km, the "
                + "shortest route is: \n";
        //System.out.println("With " + this.tale.getAccumulatedWeight() + " Km, the "
          //      + "shortest route is: ");

        while (temp != null) {
            if (temp.getNext() != null) {
                route_message += temp.getCity().getName() + " ("
                        + temp.getAccumulatedWeight() + " Km)" + " -> ";
                //System.out.print(temp.getCity().getName() + " ("
                  //      + temp.getAccumulatedWeight() + " Km)" + " -> ");
            } else {
                route_message += temp.getCity().getName() + " ("
                        + temp.getAccumulatedWeight() + " Km) ";
                //System.out.print(temp.getCity().getName() + " ("
                  //      + temp.getAccumulatedWeight() + " Km) ");
            }
            temp = temp.getNext();
        }
        //System.out.println(route_message);
        return route_message;
    }
}
