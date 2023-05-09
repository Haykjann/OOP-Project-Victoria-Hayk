public class Property extends Square {

    public Property () {
        super();
        worth = 1000;
    }

    public Property (String x, int worth) {
        super(x);
        this.worth = worth;
    }

    private String ownerName;
    private int worth;
    private int upgradeLevel = 0;
    // no variable for rent as it is equal to the 10% of the price of the property
    // no variable for house upgrade as it is equal to the 40% of the price of the property

    public final int getUpgradeLevel () {
        return this.upgradeLevel;
    }

    public final int getWorth () {
        return this.worth;
    }

    public final String getOwnerName() {
        return ownerName;
    }

    public final int getRent () {
        return worth / 10;
    }

    public final int buy (int money, String playerName) {
        if (money < worth) {
            System.out.println(playerName + " does not have enough money to buy this property");
            return 0;
        }
        else if (this.ownerName == null) {
            System.out.println(playerName + " bought the place.");
            this.ownerName = playerName;
            return this.worth;
        }        
        else {
            System.out.println("The property is already owned by " + playerName);
            return 0;
        }

    }

    public final void upgrade (int money, String playerName) {
        if (this.ownerName == null)
            System.out.println("This property is not owned");
        else if (!this.ownerName.equals(playerName))
            System.out.println("This property is not owned by " + playerName);
        else if (money < worth * 2 / 5) // 2 / 5 stands for 40 / 100 meaning 40%
            System.out.println(playerName + " does not have enough money to upgrade this property");
        else if (getUpgradeLevel() == 4)
            System.out.println("This property is already at its max level");
        else {
            upgradeLevel++;
            worth = worth * 6 / 5;
        }
    }

    public final int getUpgradePrice () {
        return worth * 2 / 5;
    }

}