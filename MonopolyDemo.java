import java.util.Scanner;

public class MonopolyDemo {
    public static void main(String[] args) {
        int turn = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Please write the names of the 2 players");

        String a = sc.next();
        String b = sc.next();
        Player player1 = new Player (0, 2000, a);
        Player player2 = new Player (0, 2000, b);

        GameBoard monopoly = new GameBoard();
        Action action = new Action();

        System.out.println("Please input any key to continue");
        
        while (sc.hasNext()) {
            System.out.println(monopoly.getResult());
            System.out.println();
            action.getPlayersStatus(player1, player2);
            System.out.println();
            System.out.println();

            char input = sc.next().charAt(0);
            if (input == 'm') {
                if (turn % 2 == 0) {
                    action.Move(player1, monopoly);

                    if (((monopoly.getSquare(player1.getLocation())).getClass().getName()).equals("Property")) {
                        System.out.println(player1.getNickName() + " stepped on a property at location " + player1.getLocation());
                        if ((monopoly.getProperty(player1.getLocation())).getOwnerName() == null) {
                            System.out.println("The property is for sale, price: " + monopoly.getProperty(player1.getLocation()).getWorth() + " for purchasing, please input 'b' otherwise input any other key");
                            char buyOrPass = sc.next().charAt(0);
                            if (buyOrPass == 'b') {
                                action.Buy(player1, monopoly);
                                action.getPlayersStatus(player1, player2);
                            }
                        }
                        else if (!(monopoly.getProperty(player1.getLocation())).getOwnerName().equals(player1.getNickName())) {
                            action.payRent(player1, player2, monopoly);
                            action.getPlayersStatus(player1, player2);
                        }
                    }
                    else if (((monopoly.getSquare(player1.getLocation())).getClass().getName()).equals("Checkpoint")) {
                        action.atCheckpoint(player1, player2, monopoly);
                        action.getPlayersStatus(player1, player2);
                    }
                    else {
                        action.atChance(player1, player2, monopoly);
                    }
                    ++turn;
                }
                else {
                    action.Move(player2, monopoly);
    
                    if (((monopoly.getSquare(player2.getLocation())).getClass().getName()).equals("Property")) {
                        System.out.println(player2.getNickName() + " stepped on a property at location " + player2.getLocation());
                        if ((monopoly.getProperty(player2.getLocation())).getOwnerName() == null) {
                            System.out.println("The property is for sale, price: " + monopoly.getProperty(player2.getLocation()).getWorth() + " for purchasing, please input 'b' otherwise input any other key");
                            char buyOrPass = sc.next().charAt(0);
                            if (buyOrPass == 'b') {
                                action.Buy(player2, monopoly);
                                action.getPlayersStatus(player1, player2);
                            }
                        }
                        else if (!(monopoly.getProperty(player2.getLocation())).getOwnerName().equals(player2.getNickName())) {
                            action.payRent(player2, player1, monopoly);
                            action.getPlayersStatus(player1, player2);
                        }
                    }
                    else if (((monopoly.getSquare(player2.getLocation())).getClass().getName()).equals("Checkpoint")) {
                        action.atCheckpoint(player2, player1, monopoly);
                        action.getPlayersStatus(player1, player2);
                    }
                    else {
                        action.atChance(player2, player1, monopoly);
                    }
                    ++turn;
                }
            }

            else if (input == 'u') {
                if (turn % 2 == 1) {
                    action.upgrade(player1, monopoly, sc.nextInt());
                    action.getPlayersStatus(player1, player2);
                }
                else {
                    action.upgrade(player2, monopoly, sc.nextInt());
                    action.getPlayersStatus(player1, player2);
                }
            }
        }
    }
}