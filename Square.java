public abstract class Square {
    private final int index;

    public Square () {
        index = 1000;
    }

    public Square (int x) {
        index = x;
    }

    public final int getIndex () {
        return index;
    }

}
