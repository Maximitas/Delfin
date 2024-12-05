package membersClasses;

public class MembersType
{
    // Setting up price variables for different member types
    private static int juniorMember = 1000;
    private static int seniorMember = 1600;

    // Calculating the pensioner member price based on the senior member price (it's 3/4 of the senior member price)
    private static int pensionerMember = (int) Math.round(seniorMember * .75);
    private static int passiveMember = 500;
    private int yearlySubscriptionPrice;

    //
    private String memberType;

    // MembersType - setting the member price based on each member's type
    public MembersType(int age, boolean isPassive)
    {
        if (age < 18 && !isPassive)
        {
            yearlySubscriptionPrice = juniorMember;
            memberType = "juniorMember";
        }

        // Else if member is +18 and under 60 not passive
        else if (age >= 18 && age < 60 && !isPassive)
        {
            yearlySubscriptionPrice = seniorMember;
            memberType = "seniorMember";
        }
        // Else if member is over 60 and not passive
        else if (age > 60 && !isPassive)
        {
            yearlySubscriptionPrice = pensionerMember;
            memberType = "pensionerMember";
        }
        // Else is passive
        else
        {
            yearlySubscriptionPrice = 500;
            memberType = "passiveMember";
        }
    }

    // Yearly subscription price
    public int getYearlySubscriptionPrice()
    {
        return yearlySubscriptionPrice;
    }


    // Overriding
    @Override
    public String toString()
    {
        return "MembersType{" +
                "yearlySubscriptionPrice=" + yearlySubscriptionPrice +
                ", memberType='" + memberType + '\'' +
                '}';
    }
}
