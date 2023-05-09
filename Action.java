import java.util.Random;

public class Action {
    private Random j = new Random();
    private int dice;

    public final void Move (Player x, GameBoard y) {
        dice = j.nextInt(11) + 2;
        x.changeLocation(dice);

        System.out.println(x.getNickName() + " threw a dice of " + dice);
    }

    public final void Buy (Player x, GameBoard z) {
        (z.getProperty(x.getLocation())).buy(x.getMoney(), x.getNickName());
        if ((z.getProperty(x.getLocation()).getOwnerName()) != null && (z.getProperty(x.getLocation()).getOwnerName()).equals(x.getNickName()))
            x.reduceMoney(z.getProperty(x.getLocation()).getWorth());
    }

    public final void payRent (Player x, Player y, GameBoard z) {
        System.out.println(x.getNickName() + " pays the other player's rent $ " + (z.getProperty(x.getLocation())).getRent());
        x.reduceMoney((z.getProperty(x.getLocation())).getRent());
        y.addMoney((z.getProperty(x.getLocation())).getRent());
        checkForWinner (x, y);
    }

    public final void atCheckpoint (Player x, Player y, GameBoard z) {
        x.reduceMoney((z.getCheckpoint(x.getLocation()).getCharge()));
        x.addMoney((z.getCheckpoint(x.getLocation()).getPrize()));
        checkForWinner(x, y);
    }

    public final void atChance (Player x, Player y, GameBoard z) {
        (z.getChance(x.getLocation())).drawCard(x, y);
        getPlayersStatus(x, y);
    }

    public final void upgrade (Player x, GameBoard z, int location) {
        int tempUpgradeLevel = (z.getProperty(location)).getUpgradeLevel();
        (z.getProperty(location)).upgrade(x.getMoney(), x.getNickName());
        if ((z.getProperty(location)).getUpgradeLevel() == tempUpgradeLevel + 1) {
            x.reduceMoney(z.getProperty(location).getUpgradePrice());
            x.addNumberOfHouses();
        }
    }

    public final void getPlayersStatus (Player x, Player y) {
        System.out.println();
        System.out.println(x.toString());
        System.out.println(y.toString());
    }
    public final void checkForWinner (Player x, Player y) {
        if (x.getMoney() < 0) {
            getPlayersStatus (x, y);
            System.out.println(x.getNickName() + " lost the game as he/she has no money left");
            System.out.println("The WINNER is " + y.getNickName() + ". The monopoly of the city is in his/her hands");
            System.exit(0);
        }
    }

}
