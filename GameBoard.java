public class GameBoard {

    private Square[] squares;
    private StringBuilder result;

    public GameBoard () {
        squares = new Square[32];
        squares[0] = new Checkpoint("GO", 0, 200);
        squares[1] = new Property("Vegetables", 100);
        squares[2] = new Property("Gardening", 100);
        squares[3] = new Property("Animal husbandry", 100);
        squares[4] = new Chance();
        squares[5] = new Property("Pharmacy", 150);
        squares[6] = new Property("Shop", 150);
        squares[7] = new Property("Market", 150);
        squares[8] = new Checkpoint("Charity", 50, 0);
        squares[9] = new Property("Telecommunications", 200);
        squares[10] = new Property("Post", 200);
        squares[11] = new Property("Press", 200);
        squares[12] = new Chance();
        squares[13] = new Property("Pawnshop", 250);
        squares[14] = new Property("Stock market", 250);
        squares[15] = new Property("Bank", 250);
        squares[16] = new Checkpoint("Prize", 0, 100);
        squares[17] = new Property("Leather and shoes", 300);
        squares[18] = new Property("Furniture", 300);
        squares[19] = new Property("Textile", 300);
        squares[20] = new Chance();
        squares[21] = new Property("Bus", 350);
        squares[22] = new Property("Passenger car", 350);
        squares[23] = new Property("Truck", 350);
        squares[24] = new Checkpoint("Jail", 50, 0);
        squares[25] = new Property("Electricity", 400);
        squares[26] = new Property("Gas", 400);
        squares[27] = new Property("Water", 400);
        squares[28] = new Chance();
        squares[29] = new Property("Meat", 500);
        squares[30] = new Property("Dairy", 500);
        squares[31] = new Property("Candy", 500);

        result = new StringBuilder();
        for (int i = 16; i < 25; ++i) {
            if ((squares[i].getClass().getName()).equals("Property"))
                result.append("| $ ");
            else if ((squares[i].getClass().getName()).equals("Checkpoint"))
                result.append("| ~ ");
            else
                result.append("| C ");
        }

        result.append("|");
        result.append("\n");

        for (int i = 15, j = 25; i > 8 && j < 32; --i, ++j) {
            if ((squares[i].getClass().getName()).equals("Property"))
                result.append("| $ |");
            else if ((squares[i].getClass().getName()).equals("Checkpoint"))
                result.append("| ~ |");
            else 
                result.append("| C |");
            result.append("                           ");
            if ((squares[j].getClass().getName()).equals("Property")) {
                result.append("| $ |");
                result.append("\n");
            }
            else if ((squares[j].getClass().getName()).equals("Checkpoint")) {
                result.append("| ~ |");
                result.append("\n");
            }
            else {
                result.append("| C |");
                result.append("\n");
            }
        }

        for (int i = 8; i > -1; --i) {
            if ((squares[i].getClass().getName()).equals("Property"))
                result.append("| $ ");
            else if ((squares[i].getClass().getName()).equals("Checkpoint"))
                result.append("| ~ ");
            else
                result.append("| C ");
        }
        result.append("|");

    }

    public Square getSquare (int location) {
        return squares[location];
    }

    public Property getProperty (int location) {
        return (Property) squares[location];
    }

    public Checkpoint getCheckpoint (int location) {
        return (Checkpoint) squares[location];
    }

    public Chance getChance (int location) {
        return (Chance) squares[location];
    }

    public StringBuilder getResult () {
        return result;
    }
}