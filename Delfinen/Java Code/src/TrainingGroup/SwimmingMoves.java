package TrainingGroup;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class SwimmingMoves implements Comparable<SwimmingMoves> {
    // Instantiating a new scanner
    static Scanner scanner = new Scanner(System.in);

    // Variables for swimmer name and time
    private String swimmerName;
    private double swimmerTime;


    // Method for back crawl time registration
    public static ArrayList<SwimmingMoves> registerTimes(int numberOfSwimmers)
    {

        // ArrayList to add the objects to
        ArrayList<SwimmingMoves> times = new ArrayList<>();

        // Minimum number of swimmers has to be 5
        // Otherwise the team is too small to be created
        while (numberOfSwimmers < 5)
        {
            System.out.println("Number of swimmers must be at least 5");
            numberOfSwimmers = scanner.nextInt();
        }


        // Dynamically updating the swimmer number each time a swimmer is being added
        int swimmerNumber = 1;
        for (int i = 0; i < numberOfSwimmers; i++)
        {

            // Add swimmer time
            System.out.println("Enter swimmer " + swimmerNumber + "'s time");
            double swimmerTime = scanner.nextDouble();

            scanner.nextLine();

            // Add swimmer name
            System.out.println("Enter swimmer " + swimmerNumber + "'s name");
            String swimmerName = scanner.nextLine();


            // Pass the name and time in as parameters to the object
            SwimmingMoves swimmingTime = new SwimmingMoves(swimmerName, swimmerTime);

            // Then add the object as element to the array list for each loop iteration
            times.add(swimmingTime);

            // Update swimmer number
            swimmerNumber++;


            System.out.println('\n');
        }

        // Sorting the array list, placing the name's with the corresponding times in correct order in the correct order
        // once the times have been sorted longer down
        Collections.sort(times);


        // Get names and times
        System.out.println("Top 5 times:");

        for (int i = 0; i < 5; i++)
        {

            System.out.println(times.get(i).getSwimmerName());
            System.out.println(times.get(i).getSwimmerTime());

            System.out.println();
        }

        // Return times
        return times;
    }

    // Creating a constructor for crawl

    public SwimmingMoves(String swimmerName, double swimmerTime)
    {
        this.swimmerName = swimmerName;
        this.swimmerTime = swimmerTime;
    }

    // Sorting the times using the compareTo interface
    public int compareTo(SwimmingMoves swimmingMoves)
    {
        if (swimmerTime < swimmingMoves.swimmerTime)
        {
            return -1;
        }
        else
        {
            return 1;
        }
    }

    // Swimmer name getter
    public String getSwimmerName()
    {
        return swimmerName;
    }

    // Swimmer name setter
    public void setSwimmerName(String swimmerName)
    {
        this.swimmerName = swimmerName;
    }

    // Swimmer time getter
    public double getSwimmerTime()
    {
        return swimmerTime;
    }

    // Swimmer time setter
    public void setSwimmerTime(double swimmerTime)
    {
        this.swimmerTime = swimmerTime;
    }

    // Overriding the toString method
    @Override
    public String toString()
    {
        return "SwimmingMoves{" +
                "swimmerName='" + swimmerName + '\'' +
                ", swimmerTime=" + swimmerTime +
                '}';
    }
}
