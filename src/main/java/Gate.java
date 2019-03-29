import java.util.ArrayList;
import java.util.Scanner;

public class Gate {

   static private  int userBall = 0;
   static private  int computerBall=0;

    public static void main (String [] args){

        Deck deck = new Deck();

        ArrayList <Card> resultsUser = new ArrayList<>(8);
        ArrayList <Card> resultsCopmputer = new ArrayList<>(8);



        for (int i=0; i<2; i++){
            userBall = deck.issuanceCard(userBall, resultsUser);
        }

        if (userBall > 21)  System.out.println("User Overflow ! " + userBall);

        System.out.println( "Total " + userBall);
        System.out.println("One more ? [press < y + Enter> or < n + Enter> ]");

        Scanner scaner = new Scanner(System.in);
        String  antwort = scaner.next();

        while (true) {

            if (antwort.matches("y") ||
                antwort.matches("n")){

                if (antwort.equalsIgnoreCase("y")) {

                    userBall = deck.issuanceCard(userBall, resultsUser);
                    System.out.println("Total " + userBall);

                    if (userBall > 21) {
                        System.out.println("User Overflow ! " + userBall);
                        break;
                    }

                    System.out.println("One more ? [press < y + Enter> or < n + Enter> ]");

                    antwort = scaner.next();
                }
                if (antwort.equalsIgnoreCase("n")) {

                    System.out.println("=====Computer cards=====");

                    for (int i = 0; i < 2; i++) {
                        computerBall = deck.issuanceCard(computerBall, resultsCopmputer);
                    }

                    while (true) {
                        if (computerBall > 21) {
                            System.out.println("Computer Overflow ! " + computerBall);
                            break;
                        }
                        if (computerBall < 15) {
                            computerBall = deck.issuanceCard(computerBall, resultsCopmputer);
                        } else break;
                    }
                    break;
                }
            }

            else {
                System.out.println("press < y + Enter> or < n + Enter>");
                     antwort = "";
                     antwort = scaner.next();
            }
        }
        System.out.println("=======RESULT=======");
        if (userBall > 21) System.out.println("Computer winn !");
        else if (computerBall > 21) System.out.println("User winn !");
        else if (computerBall > userBall) System.out.println("Computer winn !");
        else if (userBall > computerBall) System.out.println("User winn !");
        else System.out.println("Balance !");

        System.out.println("---------------------------------------");

        System.out.println("Users Cards");
        resultsUser.forEach(System.out::println);
        System.out.println("Total "+ userBall);
        System.out.println();
        System.out.println("Computer Cards");
        resultsCopmputer.forEach(System.out::println);
        System.out.println("Total "+ computerBall);

        scaner.close();
    }

}


