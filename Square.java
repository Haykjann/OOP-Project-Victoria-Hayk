public abstract class Square {
    private String title;

    public Square () {
        title = "noName";
    }

    public Square (String x) {
        title = x;
    }

    public final String getTitle () {
        return title;
    }

}
