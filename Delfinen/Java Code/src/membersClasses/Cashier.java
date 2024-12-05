package membersClasses;

import java.io.*;
import java.util.Scanner;

// Cashier inherits from Trainer
public class Cashier extends Trainer
{
    // Setting up a constructor for the cashier
    public Cashier(String name, int age, String email, boolean hasPaid, boolean isPartOfStaff, boolean isPassive)
    {
        super(name, age, email, hasPaid, isPartOfStaff, isPassive);
    }

    // Written by Tobias
    public static void viewContigent()
    {
        // Creating a new FileWriter object
        File membersList = new File("Resources/MembersList.csv");

        // Setting the total contingent to 0 by default
        int totalContigent = 0;
        try
        {
            // Making a scanner for reading through the database
            Scanner DatabaseReader = new Scanner(membersList);

            // Checking if there's a next line in the file
            while (DatabaseReader.hasNextLine())
            {

                String data = DatabaseReader.nextLine();

                // Split the Strings in the String[] array by ';'
                String[] stringsInArray = data.split(";");

                // Splitting the String up in different variables for later use
                String name = stringsInArray[0];

                int age = Integer.parseInt(stringsInArray[1]);

                Boolean hasPaid = Boolean.parseBoolean(stringsInArray[2]);

                String email = stringsInArray[3];

                boolean isPassive = Boolean.parseBoolean(stringsInArray[4]);

                boolean isPartOfStaff = Boolean.parseBoolean(stringsInArray[5]);

                // Using age and hasPaid to calculate the amount the user has to pay
                MembersType membersType = new MembersType(age, isPassive);

                // Set the continget to the yearly subscription price
                int contigent = membersType.getYearlySubscriptionPrice();

                // Adding contingent to the total contingent
                totalContigent += contigent;
            }

            // Printing out the total contingent in kroner
            System.out.println("Here is the total contigent");
            System.out.println(totalContigent + " kr per år\n");
        }

        // Catching potential errors in runtime
        catch (FileNotFoundException e)
        {
            System.out.println("file could not be found");
            e.printStackTrace();
        }
    }

    // Written by Tobias
    // Prompt chairman to remove member
    public static void promptChairmanToRemoveMember()
    {
        // Creating a new FileWriter object
        File membersToBeRemovedList = new File("Resources/MembersToBeRemoved.csv");
        File membersList = new File("Resources/MembersList.csv");

        // Wrapping the FileWriter in a try/catch block
        try
        {
            // Instantiating a new FileWriter object
            FileWriter fileWriter = new FileWriter(membersToBeRemovedList, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            Scanner DatabaseReader = new Scanner(membersList);

            // Running as long as the file has a next line
            while (DatabaseReader.hasNextLine())
            {

                String data = DatabaseReader.nextLine();
                String[] stringsInArray = data.split(";");

                // Split the Strings in the String[] array by ';'
                String name = stringsInArray[0];
                int age = Integer.parseInt(stringsInArray[1]);
                boolean hasPaid = Boolean.parseBoolean(stringsInArray[2]);
                String email = stringsInArray[3];

                // Dette if statement skriver til MembersToBeRemoved.csv, hvis en kunde ikke har betalt
                if (!hasPaid)
                {
                    String abc = name + ";" + age + ";" + email;
                    bufferedWriter.write(abc);
                    bufferedWriter.newLine();
                }
            }
            bufferedWriter.close();


        }

        // Catching potential errors caught in runtime
        catch (FileNotFoundException e)
        {
            System.out.println("file could not be found");
            e.printStackTrace();
        }
        catch (IOException e)
        {
            System.out.println("there was an error");
            e.printStackTrace();
        }
    }

}
