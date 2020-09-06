package Fruit;

public class Fruit {
    private boolean seedless;
    private boolean seasonal;
    private float price;
    public static void main(String[] args) {
        boolean myseed,myseason;
        float mycost;
        myseed = false;
        myseason = true;
        mycost = 25.86F;
        Fruit MyFruit = new Fruit();
        MyFruit.setPrioperties(myseed, myseason, mycost);
        MyFruit.printProperties();
    }
    public void setPrioperties(boolean myseed, boolean myseason, float mycost) {
        seedless = myseed;
        seasonal = myseason;
        price = mycost;
    }
    public void printProperties() {
        if(seedless) {
            System.out.println("Fruit is seedless");
        } else {
            System.out.println("Fruit is seedes");
        }

        if(seasonal) {
            System.out.println("Fruit is seasonal");
        } else {
            System.out.println("Fruit is not seasonal");
        }

        System.out.println("Price is" + price);
    }
}
