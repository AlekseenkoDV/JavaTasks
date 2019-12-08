/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmicpartone;

/**
 *
 * @author Полина
 */
public class AlgoritmicTaskOne {
    private int a;
    private int b;
    private int c;

    public AlgoritmicTaskOne(int a, int b) {
        this.a = a;
        this.b = b;
    }
    public int getA() {
        return a;
    }
    public void setA(int a) {
        this.a = a;
    }
    public int getB() {
        return b;
    }
    public void setB(int b) {
        this.b = b;
    } 
    
    public void getReplacement() {
        c = a;
        a = b;
        b = c;
    }

    @Override
    public String toString() {
        return "Задача №1 {" + "a=" + a + ", b=" + b + '}';
    }
    
    
    
}
