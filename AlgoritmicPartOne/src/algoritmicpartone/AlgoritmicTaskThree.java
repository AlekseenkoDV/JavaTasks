package algoritmicpartone;

/**
 *
 * @author Полина
 */
public class AlgoritmicTaskThree 
{
    private int a;
    private int b;
    private int c;

    public AlgoritmicTaskThree(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
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
    public int getC() {
        return c;
    }
    public void setC(int c) {
        this.c = c;
    }
    
    private int getS()
    {
        return this.a + this.b;
    }
    
    public int getEndS()
    {
        return getS() + c;
    }

    @Override
    public String toString() {
        return "Задача №3: {" + getEndS() + '}';
    }
    
    
}
