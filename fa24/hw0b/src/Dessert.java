public class Dessert {
    public static int numDesserts = 0;
    private int flavor;
    private int price;

    public Dessert(int flavor, int price) {
        this.flavor = flavor;
        this.price = price;
        numDesserts += 1;
    }

    public void printDessert() {
        System.out.print(flavor + " " + price + " " + numDesserts);
    }

    public static void main(String[] args) {
        System.out.println("I love dessert!");
    }
}
