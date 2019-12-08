/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmicpartone;

import static java.lang.Math.sqrt;

/**
 *
 * @author Полина
 */
public class AlgoritmicTaskTwo {
    private int a;
    private int b;
    private int y;

    public AlgoritmicTaskTwo(int a, int b) {
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
    
    public int getY()
    {
        y = (int) (sqrt((a * a) + (b * b)));
        return y;
    }
    
    public int getPerimeter()
    {
        int perimeter = getY() + a + b;
        return perimeter;
    }

    @Override
    public String toString() {
        return "Задача №2: опеределение периметра прямоугольного треугольника {" + getPerimeter() + '}';
    }
    
    
}
