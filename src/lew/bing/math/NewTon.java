package lew.bing.math;

/**
 * Created by Y on 2016/10/5.
 */
public class NewTon {
    
    private final double extre;

    public NewTon(double extre) {
        this.extre = extre;
    }

    public double sqrt(double number,double first) {
        while (Math.abs(first * first - number) > extre) {
            first = first / 2 + number / (2 * first);
        }
        return first;
    }


    public static void main(String[] args) {

        System.out.println(new NewTon(1E-10).sqrt(5,2));
        
    }
    
}
