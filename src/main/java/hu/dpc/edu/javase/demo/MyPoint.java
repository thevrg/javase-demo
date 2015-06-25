package hu.dpc.edu.javase.demo;

/**
 *
 * @author IQJB
 */
public class MyPoint {
    private int x;
    private int y;

    public MyPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    

    @Override
    public int hashCode() {
        System.out.println("hashCode");
        int hash = 5;
        hash = 47 * hash + this.x;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        System.out.println("equals");
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final MyPoint other = (MyPoint) obj;
        if (this.x != other.x) {
            return false;
        }
        return true;
    }


    @Override
    public String toString() {
        return "MyPoint{" + "x=" + x + ", y=" + y + '}';
    }

    public int compareTo(Object o) {
        System.out.println("compareTo");
        MyPoint other = (MyPoint) o;
        return x - other.x;
    }

}
