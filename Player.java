public class Player {
    private String nickName;
    private int money;
    private int index;

    public Player () {
        index = 1000;
        nickName = "noName";
        money = 10000;
    }

    public Player (int x, int startCash, String playerName) {
        index = x;
        money = startCash;
        nickName = playerName;
    }

    // accessors

    public String getNickName () {
        return this.nickName;
    }

    public int getMoney () {
        return this.money;
    }

    public int getIndex () {
        return this.index;
    }

    // mutators

    public void addMoney (int k) {
        money = money + k;
    }

    public void reduceMoney (int k) {
        money = money - k;
    }

    public void changeIndex (int k) {
        index = (index + k) % 34;
    }

    public String toString() {
        return "Player: " + nickName + ", Cash: " + money + ", Location: " + index;
    }
}