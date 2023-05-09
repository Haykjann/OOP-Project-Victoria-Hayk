import java.util.Random;

public class Chance extends Square {

    public Chance () {
        super("Chance");
    }

    private Random j = new Random();

    public void drawCard (Player x, Player l) {
        int k = j.nextInt(4);
        if (k == 0) {
            System.out.println("The card says 'You have been elected chairman of the city, pay the other player $50'");
            x.reduceMoney(50);
            l.addMoney(50);
        }
        else if (k == 1) {
            System.out.println("The card says 'Make general repairs on all your property, pay $25 for every house'");
            x.reduceMoney(x.getNumberOfHouses() * 25);
        }
        else if (k == 2) {
            System.out.println("The card says 'Bank pays you dividend of $50'");
            x.addMoney(50);
        }
        else {
            System.out.println("The card says 'Your building and loan matures, collect $150'");
            x.addMoney(150);
        }
    }
}