import java.util.Scanner;
import java.util.Random;

public class MonopolyDemo {
    public static void main(String[] args) {
        int turn = 0;
        Random j = new Random();
        Scanner sc = new Scanner(System.in);
        System.out.println("Please write the names of the 2 players");

        String a = sc.next();
        String b = sc.next();
        Player player1 = new Player (0, 2000, a);
        Player player2 = new Player (0, 2000, b);

        GameBoard monopoly = new GameBoard();
        
        while (sc.hasNext()) {
            System.out.println(monopoly.getResult());
            System.out.println();
            System.out.println();

            System.out.println(player1.toString());
            System.out.println(player2.toString());
            System.out.println();
            System.out.println();

            char input = sc.next().charAt(0);
            if (input == 'm') {
                if (turn % 2 == 0) {
                    int dice1 = j.nextInt(11) + 2;
                    player1.changeIndex(dice1);

                    System.out.println(player1.getNickName() + " threw a dice of " + dice1);

                    if (((monopoly.getSquare(player1.getIndex())).getClass().getName()).equals("Buyable")) {
                        System.out.println(player1.getNickName() + " stepped on a property at location " + player1.getIndex());
                        if ((monopoly.getBuyable(player1.getIndex())).getOwnerName() == null) {
                            System.out.println("The property is for sale, price: " + monopoly.getBuyable(player1.getIndex()).getWorth() + " for purchasing, please input 'b' otherwise input 'p'");
                            char buyOrPass = sc.next().charAt(0);
                            if (buyOrPass == 'b') {
                                (monopoly.getBuyable(player1.getIndex())).buy(player1.getMoney(), player1.getNickName());
                                if ((monopoly.getBuyable(player1.getIndex()).getOwnerName()) != null &&
                                 (monopoly.getBuyable(player1.getIndex()).getOwnerName()).equals(player1.getNickName()))
                                    player1.reduceMoney(monopoly.getBuyable(player1.getIndex()).getWorth());
                            System.out.println();
                            System.out.println(player1.toString());
                            System.out.println(player2.toString());
                            }
                            else if (buyOrPass == 'p') {
                            }
                        }
                        else if (!(monopoly.getBuyable(player1.getIndex())).getOwnerName().equals(player1.getNickName())) {
                            System.out.println(player1.getNickName() + " pays the other player's rent $ " + (monopoly.getBuyable(player1.getIndex())).getRent());
                            player1.reduceMoney((monopoly.getBuyable(player1.getIndex())).getRent());
                            player2.addMoney((monopoly.getBuyable(player1.getIndex())).getRent());
                            if (player1.getMoney() < 0) {
                                System.out.println(player1.getNickName() + " lost the game as he/she has no money left");
                                System.out.println("The WINNER is " + player2.getNickName() + ". The monopoly of the city is in his/her hands");
                                System.exit(0);
                            }
                        System.out.println();
                        System.out.println(player1.toString());
                        System.out.println(player2.toString());
                        }
                    }
                    else {
                        player1.reduceMoney((monopoly.getCheckpoint(player1.getIndex()).getCharge()));
                        player1.addMoney((monopoly.getCheckpoint(player1.getIndex()).getPrize()));
                        if (player1.getMoney() < 0) {
                            System.out.println(player1.getNickName() + " lost the game as he/she has no money left");
                            System.out.println("The WINNER is " + player2.getNickName() + ". The monopoly of the city is in his/her hands");
                            System.exit(0);
                        }
                    System.out.println();
                    System.out.println(player1.toString());
                    System.out.println(player2.toString());
                    }
                    ++turn;
                }
                else {
                    int dice2 = j.nextInt(11) + 2;
                    player2.changeIndex(dice2);
    
                    System.out.println(player2.getNickName() + " threw a dice of " + dice2);
    
                    if (((monopoly.getSquare(player2.getIndex())).getClass().getName()).equals("Buyable")) {
                        System.out.println(player2.getNickName() + " stepped on a property at location " + player2.getIndex());
                        if ((monopoly.getBuyable(player2.getIndex())).getOwnerName() == null) {
                            System.out.println("The property is for sale, price: " + monopoly.getBuyable(player2.getIndex()).getWorth() + " for purchasing, please input 'b' otherwise input 'p'");
                            char buyOrPass = sc.next().charAt(0);
                            if (buyOrPass == 'b') {
                                (monopoly.getBuyable(player2.getIndex())).buy(player2.getMoney(), player2.getNickName());
                                if ((monopoly.getBuyable(player2.getIndex()).getOwnerName()) != null &&
                                (monopoly.getBuyable(player2.getIndex()).getOwnerName()).equals(player2.getNickName()))
                                    player2.reduceMoney(monopoly.getBuyable(player2.getIndex()).getWorth());
                            System.out.println();
                            System.out.println(player1.toString());
                            System.out.println(player2.toString());
                            }
                            else if (buyOrPass == 'p') {
                            }
                        }
                        else if (!(monopoly.getBuyable(player2.getIndex())).getOwnerName().equals(player2.getNickName())) {
                            System.out.println(player2.getNickName() + " pays the other player's rent $ " + (monopoly.getBuyable(player2.getIndex())).getRent());
                            player2.reduceMoney((monopoly.getBuyable(player2.getIndex())).getRent());
                            player1.addMoney((monopoly.getBuyable(player2.getIndex())).getRent());
                            if (player2.getMoney() < 0) {
                                System.out.println(player2.getNickName() + " lost the game as he/she has no money left");
                                System.out.println("The WINNER is " + player1.getNickName() + ". The monopoly of the city is in his/her hands");
                                System.exit(0);
                            }
                        System.out.println();
                        System.out.println(player1.toString());
                        System.out.println(player2.toString());
                        }
                    }
                    else {
                        player2.reduceMoney((monopoly.getCheckpoint(player2.getIndex()).getCharge()));
                        player2.addMoney((monopoly.getCheckpoint(player2.getIndex()).getPrize()));
                        if (player2.getMoney() < 0) {
                            System.out.println(player2.getNickName() + " lost the game as he/she has no money left");
                            System.out.println("The WINNER is " + player1.getNickName() + ". The monopoly of the city is in his/her hands");
                            System.exit(0);
                        }
                    System.out.println();
                    System.out.println(player1.toString());
                    System.out.println(player2.toString());
                    }
                    ++turn;
                }
            }

            else if (input == 'u') {
                if (turn % 2 == 1) {
                    int tempIndex1 = sc.nextInt();
                    int tempUpgradeLevel1 = (monopoly.getBuyable(tempIndex1)).getUpgradeLevel();
                    (monopoly.getBuyable(tempIndex1)).upgrade(player1.getMoney(), player1.getNickName());
                    if ((monopoly.getBuyable(tempIndex1)).getUpgradeLevel() == tempUpgradeLevel1 + 1) {
                        player1.reduceMoney(monopoly.getBuyable(tempIndex1).getUpgradePrice());
                    }
                System.out.println();
                System.out.println(player1.toString());
                System.out.println(player2.toString());
                }
                else {
                    int tempIndex2 = sc.nextInt();
                    int tempUpgradeLevel2 = (monopoly.getBuyable(tempIndex2)).getUpgradeLevel();
                    (monopoly.getBuyable(tempIndex2)).upgrade(player2.getMoney(), player2.getNickName());
                    if ((monopoly.getBuyable(tempIndex2)).getUpgradeLevel() == tempUpgradeLevel2 + 1) {
                        player2.reduceMoney(monopoly.getBuyable(tempIndex2).getUpgradePrice());
                    }
                System.out.println();
                System.out.println(player1.toString());
                System.out.println(player2.toString());
                }
            }
        }
    }
}