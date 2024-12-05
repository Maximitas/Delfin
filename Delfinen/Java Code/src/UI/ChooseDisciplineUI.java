package UI;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

// Importing FileReader and TrainingGroup classes
import FileWorkers.FileReaderClass;
import TrainingGroup.*;



public class ChooseDisciplineUI
{



    // Choose swimming discipline
    public static void chooseSwimmingDiscipline()
    {
        Scanner scanner = new Scanner(System.in);
        boolean whileKey;
        ArrayList<SwimmingMoves> swimmingTimes;
        do {
            try{                        //Try catch statement made by Nicolas with change sin logic when needed.
            whileKey = true;
            // Enter number of swimmers
            System.out.println("Enter number of swimmers");
            int numberOfSwimmers = scanner.nextInt();

            // Choose discipline
            System.out.println("Choose swimming discipline. \nPress 1 for crawl. \nPress 2 for back crawl. \nPress 3 for breast swimming. \nPress 4 for butterfly times");


            // Number to choose discipline
            int chooseSwimmingDiscipline = scanner.nextInt();

            // Setting member name, member e-mail and member swimming time equal to their corresponding methods
            String memberName = returnMemberName();
            scanner.nextLine();
            String returnEmail = returnMemberEmail();

                System.out.println(memberName + " " + returnEmail);
            // Setting the file path per default to an empty string (it's value is being set to the swimming discipline's corresponding CSV file)
            String filePath = "";

            // Discipline choices
            switch (chooseSwimmingDiscipline) {
                // 1. Crawl
                case 1:
                    filePath = "Resources/crawltimes.csv";
                    System.out.println("Enter crawl times and names:\n");
                    swimmingTimes = Crawl.registerCrawlTimes(numberOfSwimmers);
                    FileReaderClass.addSwimmerToCsvFile(memberName, returnEmail, swimmingTimes, filePath);
                    whileKey = false;
                    break;


                // 2. Back Crawl
                case 2:
                    filePath = "Resources/backcrawltimes.csv";
                    System.out.println("Enter back crawl times");
                    swimmingTimes = BackCrawl.registerBackCrawlTimes(numberOfSwimmers);
                    FileReaderClass.addSwimmerToCsvFile(memberName, returnEmail, swimmingTimes, filePath);
                    whileKey = false;
                    break;


                // 3. Breast Swimming
                case 3:
                    filePath = "Resources/breastswimmingtimes.csv";
                    System.out.println("Enter breast swimming times");
                    swimmingTimes = BreastSwimming.registerBreastSwimmingTimes(numberOfSwimmers);
                    FileReaderClass.addSwimmerToCsvFile(memberName, returnEmail, swimmingTimes, filePath);
                    whileKey = false;
                    break;


                // 4. Butterlfy
                case 4:
                    filePath = "Resources/butterflytimes.csv";
                    System.out.println("Enter butterfly times");
                    swimmingTimes = Butterfly.registerButterflyTimes(numberOfSwimmers);
                    FileReaderClass.addSwimmerToCsvFile(memberName, returnEmail, swimmingTimes, filePath);
                    whileKey = false;
                    break;
                }
            }catch(InputMismatchException e){
                System.out.println("Invalid Input");
                whileKey = true;
                scanner.nextLine();
            }
        }while(whileKey);
    }


    // Return swimmer name
    public static String returnMemberName()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter Trainers name");
        String name = sc.nextLine();
        return name;
    }

    // Return member e-mail
    public static String returnMemberEmail()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter Trainers email");
        String email = sc.nextLine();
        return email;
    }
}


