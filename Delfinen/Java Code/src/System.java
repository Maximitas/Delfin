// Importing the CashierUI, LoginUI, and Chairman class
import UI.ChooseDisciplineUI;
import UI.CashierUI;
import UI.LoginUI;
import membersClasses.Chairman;


public class System
{
    public static void main(String[] args)
    {
        // Setting the user login integer equal to the LoginUI.startMenu method
        int loginUser = LoginUI.startMenu();
        switch (loginUser)
        {
            // 1. Break
            case 1:
                ChooseDisciplineUI.chooseSwimmingDiscipline();
                break;
            // 2. Calling the cashierMenu method
            case 2:
                CashierUI.cashierMenu();
                break;

            // 3. Calling the chairmanMenu method
            case 3:
                Chairman.chairmanMenu();
                break;
        }
    }
}
