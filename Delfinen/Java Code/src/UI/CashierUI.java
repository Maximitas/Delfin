// Written by Tobias

package UI;

import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

// Importing methods from the Cashier class
import static membersClasses.Cashier.promptChairmanToRemoveMember;
import static membersClasses.Cashier.viewContigent;

public class CashierUI
{
    private static Scanner scanner = new Scanner(System.in);
    // Cashier menu UI
    public static void cashierMenu()
    {

        // Number to choose menu point
        int menuChoice = 0;
        boolean whileKey;
        // Do everything in the do block
        do {
            try {                       //Try catch statement made by Nicolas with change sin logic when needed.
                whileKey = true;
                // Instantiating new scanner object



                System.out.println("Please choose an option");
                System.out.println("1.      View Contingent");
                System.out.println("2.      Prompt Chairman to remove a member");
                System.out.println("3.      Quit");
                menuChoice = scanner.nextInt();
                scanner.nextLine();

                // Selecting menu choice
                switch (menuChoice) {
                    // 1. View contingent
                    case 1:
                        viewContigent();
                        whileKey = false;
                        break;

                    // 2. Prompt chairman to remove member
                    case 2:
                        promptChairmanToRemoveMember();
                        whileKey = false;
                        System.out.println("Chairman has been prompted!");
                        break;

                    // 3. Quit (with message)
                    case 3:
                        whileKey = true;
                        System.out.println("Goodbye");
                }

            }catch(InputMismatchException e){
                System.out.println("Invalid input");
                whileKey = true;
                scanner.nextLine();
            }
        }
        // As long as the user hasn't pressed 3
        while (!whileKey);
    }
}
