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
public class Main {

    public static void main(String[] args) {
        AlgoritmicTaskOne one = new AlgoritmicTaskOne(10, 2);
        one.getReplacement();
        System.out.println(one);
        
        AlgoritmicTaskTwo two = new AlgoritmicTaskTwo(3, 4);
        two.getPerimeter();
        System.out.println(two);
        
        AlgoritmicTaskThree three = new AlgoritmicTaskThree(1, 2, 3);
        three.getEndS();
        System.out.println(three);
        
        AlgoritmicTaskFour four = new AlgoritmicTaskFour(8, 2);
        four.getG();
        System.out.println(four);
        

    }
    
}
