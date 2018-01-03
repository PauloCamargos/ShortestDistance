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

    public GraphNode head;
    public GraphNode tale;
    public int nodesAmount;
    public AdjacencyList priorityList = new AdjacencyList();
    public AdjacencyList route = new AdjacencyList();

    /**
     * Constructor Graph(GraphNode head, GraphNode tale)
     *
     * @param head
     * @param tale
     */
    public Graph(GraphNode head, GraphNode tale) {
        this.head = head;
        this.tale = tale;
        this.nodesAmount = 0;
        //this.priorityList = null;
    }

    /**
     * Constructor Graph()
     */
    public Graph() {
        this.head = null;
        this.tale = null;
        this.nodesAmount = 0;
        //this.priorityList = null;
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

    public void insertEnd(City city) {
        GraphNode new_node = new GraphNode(city);
        if (head == null) {
            head = new_node;
            tale = new_node;
            System.out.println(city.getName() + " na cabeça inserida com sucesso");
        } else {
            tale.setNext(new_node);
            new_node.setPrevious(tale);
            tale = tale.getNext();
            System.out.println(city.getName() + " inserida com sucesso");
        }

        setNodesAmount(getNodesAmount() + 1);
        getPriorityList().insertEnd(city, 0);
    }

    /**
     * Locate and returs a Graph node based on the given data
     *
     * @param city
     * @return foundNode
     */
    public GraphNode findNode(City city) {
        GraphNode temp = getHead();
        while (temp != null) {
            if (temp.getCity() == city) {
                return temp;
            } else {
                temp = temp.getNext();
            }
        }
        return temp;
    }

    /**
     *
     * @param city_1
     * @param city_2
     * @param weight
     */
    public void insertEdge(City city_1, City city_2, double weight) {
        GraphNode node_1 = findNode(city_1);
        GraphNode node_2 = findNode(city_2);
        if (node_1 == null || node_2 == null) {
            System.out.println("Coudn't find that city. Try again.");
        } else {

            (node_1.getAdjacencyList()).insertEnd(city_2, weight);
            (node_2.getAdjacencyList()).insertEnd(city_1, weight);
            System.out.println("Aresta criada com sucesso!");
        }
    }

    /**
     *
     * @param origin
     * @param destiny
     */
    public void calculateDijkstra(City origin, City destiny) {
        //            Criar a lista de prioridade;
        //            Configurar origem S como distancia 0;
        //            Configurar outros nós V como distacia infinita;
        //            Inserir todos os nós em uma lista de prioridade P;
        //            Ordenar lista
        //            |Para cada no V de P não-visitado //Começando em Origem (primeiro nó):
        //            |   |Para cada nó vizinho U de V
        //            |   |     |Se distancia no grafo de P(V, U) + distancia acumulada P(S, V) menor que P(S, U)
        //            |   |     |    Configure a distância de P(S, V) = distancia acumulada P(S, U) + distancia P(V, U)
        //            |   |     |    Configure o noh anterior de U = V
        //            |   |     Marque nó V como visitado
        //            |   |     Ordene a lista

        route.resetList();
        route.head = null;

        AdjacencyNode aux;//= new AdjacencyNode(); //Auxiliary node to run the adj list
        AdjacencyNode aux_PL;// = new AdjacencyNode(); //Aux for priority list
        AdjacencyNode new_origin_PL;// = new AdjacencyNode(); //Aux for priority list
        City newOrigin = origin;
        int i = 1;

        //Considering that origin or destiny aren't null
        priorityList.findNode(origin).setAccumulatedWeight(0);
        priorityList.sortList();

        double destiny_weight = priorityList.findNode(destiny).getAccumulatedWeight();
        boolean allNodesVisited = priorityList.findNode(newOrigin).getWasVisited();

        while (destiny_weight == Double.POSITIVE_INFINITY || !allNodesVisited) {
            priorityList.sortList();

            aux = findNode(newOrigin).getAdjacencyList().getHead();
            new_origin_PL = priorityList.findNode(newOrigin);

            while (aux != null) {
                aux_PL = priorityList.findNode(aux.getCity());

                if (aux_PL.getAccumulatedWeight() > new_origin_PL.getAccumulatedWeight() + aux.getWeight() && !aux_PL.getWasVisited()) {
                    aux_PL.setAccumulatedWeight(new_origin_PL.getAccumulatedWeight() + aux.getWeight());
                    aux_PL.setPreviousCity(priorityList.findNode(newOrigin).getCity());
                }
                aux = aux.getNext();
                priorityList.sortList();
            }
            priorityList.sortList();
            priorityList.findNode(newOrigin).setWasVisited(true);
            i++;
            if (i > this.getNodesAmount()) {
                break;
            }
            newOrigin = priorityList.findNode(newOrigin).getNext().getCity();
        }
    }

    /**
     *
     */
    public String printCities() {
        String cities = "";
        GraphNode temporary;
        temporary = this.getHead();
        while (temporary != null) {
            cities += temporary.getCity().getName() + "\n";
            System.out.println(temporary.getCity().getName());
            temporary = temporary.getNext();
        }
        return cities;
    }

    /**
     *
     * @param origin
     * @param destiny
     * @return
     */
    public AdjacencyList shortestDistance(City origin, City destiny) {
        if (origin == null || destiny == null) {
            System.out.println("Couldn't find that node. Try again!");
        } else {
            calculateDijkstra(origin, destiny);
            route = createRoute(destiny);
            route.printRoute();
            priorityList.resetList();
            priorityList.printCities();
        }
        return route;
    }

    public AdjacencyList createRoute(City destiny) {

        AdjacencyNode temporary = priorityList.findNode(destiny); // Catch the destiny node in the PL
        route.insertBeginning(temporary.getCity(), temporary.getAccumulatedWeight());
        // Insert that node in the route list
        System.out.println("Inserindo na rota " + temporary.getCity().getName() + " (" + temporary.getAccumulatedWeight() + ")Km");

        while (temporary.accumulatedWeight != 0) { //While the origin city hasn't been found
            temporary = priorityList.findNode(temporary.getPreviousCity()); // Temporary receives the previous city
            System.out.println("Inserindo na rota " + temporary.getCity().getName() + " (" + temporary.getAccumulatedWeight() + ")Km");
            route.insertBeginning(temporary.getCity(), temporary.getAccumulatedWeight());
        }
        return route;
    }

    public City findCityByName(String city_name) {
        City city = null;
        GraphNode temp = head;
        if (temp == null) {
            System.out.println("Coudnt find");
            return null;
        } else {
            while (temp != null) {
                if ((temp.getCity().getName()).equals(city_name)) {
                    city = temp.getCity();
                    break;
                } else {
                    temp = temp.getNext();
                }
            }
            return city;
        }

    }
} //End of class
