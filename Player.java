public class Player {
    private String nickName;
    private int money;
    private int location;
    private int numberOfHouses;

    public Player () {
        location = 1000;
        nickName = "noName";
        money = 10000;
        numberOfHouses = 10000;
    }

    public Player (int x, int startCash, String playerName) {
        location = x;
        money = startCash;
        nickName = playerName;
        numberOfHouses = 0;
    }

    // accessors

    public int getNumberOfHouses () {
        return numberOfHouses;
    }

    public String getNickName () {
        return this.nickName;
    }

    public int getMoney () {
        return this.money;
    }

    public int getLocation () {
        return this.location;
    }

    // mutators
    public void addNumberOfHouses () {
        ++numberOfHouses;
    }
    public void addMoney (int k) {
        money = money + k;
    }

    public void reduceMoney (int k) {
        money = money - k;
    }

    public void changeLocation (int k) {
        location = (location + k) % 32;
    }

    public String toString() {
        return "Player: " + nickName + ", Cash: " + money + ", Location: " + location;
    }
}