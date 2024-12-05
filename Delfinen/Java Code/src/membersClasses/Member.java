// Written by Victor
package membersClasses;

import java.util.ArrayList;

// Creating Member class
public class Member
{
    // Creating a list for the members
    private static ArrayList<Member> membersList = new ArrayList<>();

    // Instantiating name
    private String name;

    // Instantiating age
    private int age;

    // Instantiating e-mail
    private String email;

    // Instantiating MembersType
    private MembersType membersType;

    // Instantiating hasPaid boolean
    private boolean hasPaid;

    // Instantiating isPassive boolean
    private boolean isPassive;

    // Instantiating isPartOfStaff boolean
    private boolean isPartOfStaff = false;


    //
    public Member(String name, int age, String email, boolean hasPaid, boolean isPassive, boolean isPartOfStaff)
    {
        this.name = name;
        this.age = age;
        this.email = email;
        this.hasPaid = hasPaid;
        this.isPartOfStaff = false;
        this.isPassive = false;
        this.membersType = getMemberShipType();
    }

    // Checking name conditions
    public static void nameConditions(String nameOne)
    {
        // Illegal characters
        String[] notAllowedCharsInName = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "0"};

        // Looping over the illegal characters
        for (int i = 0; i < notAllowedCharsInName.length - 1; ++i)
        {
            // If the name contains at least one of the illegal characters, then print out the error message
            if (nameOne.contains(notAllowedCharsInName[i]))
            {
                System.out.println("Invalid character in name. Names can only contain letters from the alphabet.");
            }
        }

    }

    // Creating getter for memberShipType
    public MembersType getMemberShipType()
    {
        MembersType currentMember = new MembersType(this.age, this.isPassive);
        return currentMember;
    }

    // Creating getter for name
    public String getName()
    {
        return name;
    }

    // Creating getter for age
    public int getAge()
    {
        return age;
    }

    // Creating getter for e-mail
    public String getEmail()
    {
        return email;
    }

    // Method for checking payment
    public boolean isHasPaid()
    {
        return hasPaid;
    }

    // Method for checking passivity
    public boolean isPassive()
    {
        return isPassive;
    }

    // Is part of staff
    public boolean isPartOfStaff()
    {
        return isPartOfStaff;
    }

    // Override the toString method
    @Override
    public String toString()
    {
        return "Member{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", " + membersType +          //Nicolas
                ", hasPaid=" + hasPaid +
                ", isPassive=" + isPassive +
                ", isPartOfStaff=" + isPartOfStaff +
                "}";
    }
}
