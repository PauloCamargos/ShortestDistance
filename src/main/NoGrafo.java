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
public class NoGrafo {

    private NoGrafo next;
    private NoGrafo previous;
    private DataCity city;

    public NoGrafo(NoGrafo proximo, NoGrafo anterior, DataCity cidade) {
        this.next = proximo;
        this.previous = anterior;
        this.city = cidade;
    }
    
    public NoGrafo(DataCity cidade) {
        this.next = null;
        this.previous = null;
        this.city = cidade;
    }
    
    public NoGrafo() {
        this.next = null;
        this.previous = null;
        this.city = null;
    }

    public NoGrafo getNext() {
        return next;
    }

    public void setNext(NoGrafo next) {
        this.next = next;
    }

    public NoGrafo getPrevious() {
        return previous;
    }

    public void setPrevious(NoGrafo previous) {
        this.previous = previous;
    }

    public DataCity getCity() {
        return city;
    }

    public void setCity(DataCity city) {
        this.city = city;
    }
}
