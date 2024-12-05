package membersClasses;

import java.util.InputMismatchException;
import java.util.Scanner;

import FileWorkers.FileReaderClass;


public class Chairman extends Cashier {
    // Instantiating a new scanner object
    static Scanner scanner = new Scanner(System.in);

    // Creating a constructor for the Chairman
    public Chairman(String name, int age, String email, boolean hasPaid, boolean isPartOfStaff, boolean isPassive) {
        super(name, age, email, hasPaid, isPartOfStaff, isPassive);
    }

    //Made by Lasse
    public static void chairmanMenu() {
        boolean whileKey = true;

        // Do everything in the do block
        do {
            try {                   //Try catch statement made by Nicolas with change sin logic when needed.
                // Calling the printChairmanMenu method
                printChairmanMenu();

                // Lets user make an option by pressing a number
                System.out.println("Please write a number for the option you would like to choose");
                int menuChoice = scanner.nextInt();
                scanner.nextLine();

                // Defining user choices
                switch (menuChoice) {

                    // 1. Access the remove member method
                    case 1:
                        removeMember(scanner);
                        System.out.println("Press any key to continue");
                        scanner.nextLine();

                        break;

                    // 2. Input new members
                    case 2:
                        inputNewMembers(scanner);
                        break;

                    // 3. Search in CSV file
                    case 3:
                        String filePath = "Resources/MembersList.csv";
                        System.out.println("Please write what you want to search after");
                        String searchTerm = scanner.nextLine();
                        FileReaderClass.searchData(searchTerm, filePath);
                        System.out.println("Press any key to continue");
                        scanner.nextLine();

                        break;

                    // 4. Edit member file
                    case 4:
                        editMemberFile(scanner);
                        break;

                    case 5:
                        viewContigent();
                        System.out.println("Press any key to continue");
                        scanner.nextLine();
                        break;

                    // 6. View prompt
                    case 6:
                        viewPrompts(scanner);
                        break;

                    // 7. Watch Lasse's brain melt down slowly ...
                    case 7:
                        whileKey = false;
                        break;
                }
            }catch(InputMismatchException e){
                System.out.println("Invalid input");
                whileKey = true;
                scanner.nextLine();
            }

        }

        // While whileKey is true
        while (whileKey);
    }

    //Made by Lasse
    // Edit member file method
    public static void editMemberFile(Scanner scanner) {
        // Setting up the file path
        String filePath = "Resources/MembersList.csv";

        // User inputs data it wishes to edit
        System.out.println("Please type the e-mail for the member you want to edit in");
        String searchTerm = scanner.nextLine();

        // User must enter category number in order to edit the wished category
        System.out.println("Please type the number for which category you would like to edit in");

        // Call the printPositionMenu method
        printPositionMenu();

        // Let user input a number
        int position = scanner.nextInt();
        scanner.nextLine();

        // User inputs new data
        System.out.println("Please type the new data");
        String newData = scanner.nextLine();

        // Adding file variables to the FileReaderClass method
        FileReaderClass.editLine(searchTerm, newData, filePath, position);
    }

    //Made by Lasse
    // Print chairman menu
    public static void printChairmanMenu() {
        // Creating options
        String[] ChairmanMenu = {"Remove member", "Add member", "Search data", "Edit data", "View contigent", "View prompts", "Exit program"};

        // Setting up numbers used for picking an option
        int[] ChairmanMenuNumbers = {1, 2, 3, 4, 5, 6, 7};

        // Setting each number equal to the options in the String array
        for (int i = 0; i < ChairmanMenuNumbers.length; i++) {
            System.out.println(ChairmanMenuNumbers[i] + " " + ChairmanMenu[i]);
        }
    }

    //Made by Lasse
    public static void viewPrompts(Scanner scanner) {
        String filePath = "Resources/MembersToBeRemoved.csv";
        int position = 4;      //Dette er positionen for e-mail i arrayen i MembersList.csv
        boolean memberChecker = FileReaderClass.printAll(filePath);

        removeMemberPrompt(memberChecker, filePath, position);
    }

    public static void removeMemberPrompt(boolean memberChecker, String filePath, int position){
        if (memberChecker) {
            boolean checkForData = false;
            do {
                System.out.println("\nPlease type the email of the member you want to remove");
                String removeUser = scanner.nextLine();
                checkForData = FileReaderClass.removeLine(removeUser, filePath, position);
            } while (!checkForData);
        } else {
            System.out.println("There are no members to remove\nPress any key to continue");
            scanner.nextLine();
        }
    }

    //Made by Lasse
    public static void printPositionMenu() {
        String[] ChairmanMenu = {"Name", "Age", "Has member paid", "E-mail", "Is member staff", "Is member passive member"};
        int[] ChairmanMenuNumbers = {1, 2, 3, 4, 5, 6};
        for (int i = 0; i < ChairmanMenuNumbers.length; i++) {
            System.out.println(ChairmanMenuNumbers[i] + " " + ChairmanMenu[i]);
        }
    }

    //Made by Lasse
    public static void removeMember(Scanner scanner){
        String filePath = "Resources/MembersList.csv";
        int position = 4;                                   //Dette er positionen i csv filen jeg vil søge efter. Vi går efter email da det er unik for hver member
                                                            //og email ligger på position 4
        boolean checkForData = false;
        do {
            System.out.println("Please write the email of the member you would like to delete");
            String removeUser = scanner.nextLine();
            checkForData = FileReaderClass.removeLine(removeUser, filePath, position);
        } while (!checkForData);
    }

    //Made by Lasse
    public static void inputNewMembers(Scanner scanner){
        String filePath = "Resources/MembersList.csv";
        System.out.println("Please type in the new members name");
        String memberName = scanner.nextLine();
        System.out.println("Please type in new members age");
        int memberAge = scanner.nextInt();
        scanner.nextLine();
        boolean hasPaid = hasMemberPaid(scanner);  //Hvis den er false har de ikke betalt, hvis den er true har de betalt
        String getEmail = getMemberEmail(scanner);
        boolean isPassive = isMemberPassive(scanner);
        boolean isPartOfStaff = isMemberPartOfStaff(scanner);

        FileReaderClass.addLineToCsvFile(memberName, memberAge, hasPaid, getEmail, isPassive, isPartOfStaff, filePath);
    }

    //Made by Lasse
    public static String getMemberEmail(Scanner scanner){
        System.out.println("Please type in member e-mail");
        String email = scanner.nextLine();
        return email;
    }

    //Made by Lasse
    public static boolean isMemberPartOfStaff(Scanner scanner) {
        boolean isPartOfStaff = false;
        String memberAnswer = "";
        do{
            System.out.println("Is member part of staff? 'y' for yes, 'n' for no");
            memberAnswer = scanner.nextLine();
            if(memberAnswer.equalsIgnoreCase("y") || memberAnswer.equalsIgnoreCase("n")) {
                isPartOfStaff = checkMemberPay(memberAnswer, isPartOfStaff);
            } else {

            }
        } while (!memberAnswer.equalsIgnoreCase("y") && !memberAnswer.equalsIgnoreCase("n"));
        return isPartOfStaff;
    }

    //Made by Lasse
    public static boolean isMemberPassive(Scanner scanner) {
        boolean isPassive = false;
        String memberAnswer = "";
        do {
            System.out.println("Is it a passive member? 'y' for yes, 'n' for no");
            memberAnswer = scanner.nextLine();
            if (memberAnswer.equalsIgnoreCase("y") || memberAnswer.equalsIgnoreCase("n")) {
                isPassive = checkMemberPay(memberAnswer, isPassive);
            } else {

            }
        } while (!memberAnswer.equalsIgnoreCase("y") && !memberAnswer.equalsIgnoreCase("n"));
        return isPassive;
    }

    //Made by Lasse
    public static boolean hasMemberPaid(Scanner scanner) {
        boolean hasPaid = false;

        String memberAnswer = "";

        // Checking if member has paid or not
        do {
            System.out.println("Has new member paid? 'y' for yes, 'n' for no");
            memberAnswer = scanner.nextLine();
            if (memberAnswer.equalsIgnoreCase("y") || memberAnswer.equalsIgnoreCase("n")) {
                hasPaid = checkMemberPay(memberAnswer, hasPaid);
            }

        } while (!memberAnswer.equalsIgnoreCase("y") && !memberAnswer.equalsIgnoreCase("n"));
        return hasPaid;
    }

    //Made by Lasse
    public static boolean checkMemberPay(String memberAnswer, boolean hasPaid) {
        // Checking member answer to the payment question
        if (memberAnswer.equals("y")) {
            hasPaid = true;
        }
        else {
            hasPaid = false;
        }
        return hasPaid;
    }

}