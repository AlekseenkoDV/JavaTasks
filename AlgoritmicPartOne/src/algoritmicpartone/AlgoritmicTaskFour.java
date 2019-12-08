package algoritmicpartone;

import static java.lang.Math.sqrt;

/**
 *
 * @author Полина
 */
public class AlgoritmicTaskFour 
{
    private int a;
    private int b;

    public AlgoritmicTaskFour(int a, int b) {
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
    
    public int getG()
    {
        return (int)sqrt(this.a * this.b);
    }

    @Override
    public String toString() {
        return "Задача №4: {" +  getG() + '}';
    }
    
    
}
