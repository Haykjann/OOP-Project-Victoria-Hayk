public class GameBoard {

    private Square[] squares;
    private StringBuilder result;

    public GameBoard () {
        squares = new Square[32];
        squares[0] = new Checkpoint(0, 0, 200);
        squares[1] = new Buyable(1, 100);
        squares[2] = new Buyable(2, 100);
        squares[3] = new Buyable(3, 100);
        squares[4] = new Buyable(4, 200);
        squares[5] = new Buyable(5, 150);
        squares[6] = new Buyable(6, 150);
        squares[7] = new Buyable(7, 150);
        squares[8] = new Checkpoint(8, 50, 0);
        squares[9] = new Buyable(9, 200);
        squares[10] = new Buyable(10, 200);
        squares[11] = new Buyable(11, 200);
        squares[12] = new Buyable(12, 300);
        squares[13] = new Buyable(13, 250);
        squares[14] = new Buyable(14, 250);
        squares[15] = new Buyable(15, 250);
        squares[16] = new Checkpoint(16, 0, 100);
        squares[17] = new Buyable(17, 300);
        squares[18] = new Buyable(18, 300);
        squares[19] = new Buyable(19, 300);
        squares[20] = new Buyable(20, 400);
        squares[21] = new Buyable(21, 350);
        squares[22] = new Buyable(22, 350);
        squares[23] = new Buyable(23, 350);
        squares[24] = new Checkpoint(24, 50, 0);
        squares[25] = new Buyable(25, 400);
        squares[26] = new Buyable(26, 400);
        squares[27] = new Buyable(27, 400);
        squares[28] = new Buyable(28, 600);
        squares[29] = new Buyable(29, 500);
        squares[30] = new Buyable(30, 500);
        squares[31] = new Buyable(31, 500);

        result = new StringBuilder();
        for (int i = 16; i < 25; ++i) {
            if ((squares[i].getClass().getName()).equals("Buyable"))
                result.append("| $ ");
            else if ((squares[i].getClass().getName()).equals("Checkpoint"))
                result.append("| ~ ");
        }

        result.append("|");
        result.append("\n");

        for (int i = 15, j = 25; i > 8 && j < 31; --i, ++j) {
            if ((squares[i].getClass().getName()).equals("Buyable"))
                result.append("| $ |");
            else if ((squares[i].getClass().getName()).equals("Checkpoint"))
                result.append("| ~ |");
            result.append("                           ");
            if ((squares[j].getClass().getName()).equals("Buyable")) {
                result.append("| $ |");
                result.append("\n");
            }
            else if ((squares[j].getClass().getName()).equals("Checkpoint")) {
                result.append("| ~ |");
                result.append("\n");
            }
        }

        for (int i = 8; i > -1; --i) {
            if ((squares[i].getClass().getName()).equals("Buyable"))
                result.append("| $ ");
            else if ((squares[i].getClass().getName()).equals("Checkpoint"))
                result.append("| ~ ");
        }
        result.append("|");

    }

    public Square getSquare (int index) {
        return squares[index];
    }

    public Buyable getBuyable (int index) {
        return (Buyable) squares[index];
    }

    public Checkpoint getCheckpoint (int index) {
        return (Checkpoint) squares[index];
    }

    public StringBuilder getResult () {
        return result;
    }
}