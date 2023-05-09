public class Checkpoint extends Square {

    public Checkpoint () {
        super();
        charge = 0;
        prize = 0;
    }

    public Checkpoint (String x, int money, int money1) {
        super(x);
        this.charge = money;
        this.prize = money1;
    }

    private final int charge;
    private final int prize;

    public final int getCharge () {
        return this.charge;
    }

    public final int getPrize () {
        return this.prize;
    }
}
