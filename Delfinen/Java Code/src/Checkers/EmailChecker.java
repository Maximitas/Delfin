package Checkers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.util.Scanner;

public class EmailChecker
{
    public static void main(String[] args)
    {
        System.out.println("Enter your e-mail address");
        Scanner scanner = new Scanner(System.in);
        String email = scanner.nextLine();

        System.out.println(isEmailValid(email));
    }


    public static boolean isEmailValid(String emailInput)
    {
        String emailRegex = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
        Pattern emailPattern = Pattern.compile(emailRegex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = emailPattern.matcher(emailInput);
        return matcher.find();
    }
}
