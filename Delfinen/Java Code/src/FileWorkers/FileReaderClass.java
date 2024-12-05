package FileWorkers;
import TrainingGroup.SwimmingMoves;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.PrintWriter;

public class FileReaderClass {
    //Made by Lasse
    public static void addLineToCsvFile(String memberName, int memberAge, boolean hasPaid, String getEmail,boolean isPassive, boolean isPartOfStaff, String filePath){

            try {
                FileWriter writer = new FileWriter(filePath, true);

                writer.append(memberName + ";" + memberAge + ";" + hasPaid + ";" + getEmail + ";" + isPassive + ";" + isPartOfStaff);
                writer.append("\n");

                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
    }

    //Made by Lasse
    public static void addSwimmerToCsvFile(String memberName, String memberEmail, ArrayList<SwimmingMoves> listOfTimes, String filePath){

            try {
                FileWriter writer = new FileWriter(filePath, true);

                writer.append(memberName + ";" + memberEmail + ";" + listOfTimes);
                writer.append("\n");

                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
        }
    }

    //Made by Lasse
    public static boolean removeLine(String searchTerm, String filePath, int position){
        //Når man kalder denne metode til at fjerne en linje i en csv fil, skal man give den positionen på tingen man vil søge efter det er 'position'
        //man skal give filens 'filePath' og hvad man skal søge efter for at finde den korrekte linje at slette.
        int positionOfTerm = position - 1;
        String tempFile = "temp.txt";
        File oldFile = new File(filePath);
        File newFile = new File(tempFile);
        String currentLine;
        String data[];
        boolean checkForData = false;

        try{
            FileWriter fw = new FileWriter(tempFile,true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            FileReader fr = new FileReader(filePath);
            BufferedReader br = new BufferedReader(fr);

            while((currentLine = br.readLine()) != null){                                 //currentLine bliver sat lig med den næste linje så længe den eksistere. Hvis næste linje ikke eksistere stopper while loopet.
                data = currentLine.split(";");                                      //Her bliver den første linje i filen lagt i en array som splitter dem op i ';'.
                if(!(data[positionOfTerm].equalsIgnoreCase(searchTerm))){                 //Her tjekker den om det du gerne vil havde fjernet er lig med den data der er gemt i data
                    pw.println(currentLine);                                              //Hvis de ikke er lig med hinanden så gemmer vi den i den nye fil
                }else{
                    checkForData = true;
                }
            }

            if (checkForData){
                System.out.println("File has been deleted\n");
            }else {
                System.out.println("File not found\n");
            }
            pw.flush();
            pw.close();
            fr.close();
            br.close();
            bw.close();
            fw.close();

            oldFile.delete();
            File temp = new File(filePath);
            newFile.renameTo(temp);

        }catch(Exception e){
            System.out.println("Error\n");
        }
        return checkForData;
    }

    //Made by Lasse
    public static boolean printAll(String filePath){
        int counter = 0;
        boolean memberChecker = true;
                try{
                    File memberFile = new File(filePath);
                    Scanner scanner = new Scanner(memberFile);
                    while(scanner.hasNextLine()){
                        String fileMembers = scanner.nextLine();
                        String[] fileMembersArray = fileMembers.split(";");
                        System.out.println("Name: " + fileMembersArray[0] + "  \t\tAge: " + fileMembersArray[1] + "\t\tHas member paid: " + fileMembersArray[2] + "\t\tE-mail: " + fileMembersArray[3] + "\t\t Is member passive: " + fileMembersArray[4] + "\t\tIs member part of staff: " + fileMembersArray[5]);
                        counter++;
                    }
                    scanner.close();
                    if(counter == 0){
                        memberChecker = false;
                    }
                }catch(FileNotFoundException e){
                    System.out.println("Could not find file\n");
                }
                return memberChecker;
            }

    //Made by Lasse
    public static void searchData(String searchTerm, String filePath){
        boolean found = false;
        String name = "";
        String age = "";
        String hasPaid = "";
        String email = "";
        String isPassive = "";
        String isPartOfStaff = "";
        try {
            FileReader writer = new FileReader(filePath);
            Scanner scanner = new Scanner((Readable) writer);
            scanner.useDelimiter("[;\n]");               //This line is to make java know that files are separated by ';' and after each new line '\n'

            while(scanner.hasNext() && !found )
            {
                name = scanner.next();
                age = scanner.next();
                hasPaid = scanner.next();
                email = scanner.next();
                isPassive = scanner.next();
                isPartOfStaff = scanner.next();

                if(name.equals(searchTerm) || age.equals(searchTerm) || hasPaid.equals(searchTerm) || email.equals(searchTerm) || isPassive.equals(searchTerm) || isPartOfStaff.equals(searchTerm)){
                    System.out.println("Name: " + name + "  \t\tAge: " + age + "\t\tHas member paid: " + hasPaid + "\t\tE-mail: " + email + "\t\t Is member passive: " + isPassive + "\t\tIs member part of staff: " + isPartOfStaff);
                }
            }
            writer.close();
            scanner.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    //Made by Lasse
    public static void editLine(String searchTerm, String newData, String filePath, int position){
        //Når man kalder denne metode til er fjerne i linje i en csv fil, skal man give den positionen på tingen man vil søge efter det er 'position'
        //man skal give filens 'filePath' og hvad man skal søge efter for at finde den korrekte linje at slette.

        int positionOfTerm = 3;                     //Dette er positionen for e-mail.
        position = position - 1;
        String tempFile = "temporary.txt";
        File oldFile = new File(filePath);
        File newFile = new File(tempFile);
        String currentLine;
        String data[];
        boolean checkForData = false;

        try{
            FileWriter fw = new FileWriter(tempFile,true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            FileReader fr = new FileReader(filePath);
            BufferedReader br = new BufferedReader(fr);

            while((currentLine = br.readLine()) != null){                                 //currentLine bliver sat lig med den næste linje så længe den eksistere. Hvis næste linje ikke eksistere stopper while loopet.
                data = currentLine.split(";");                                      //Her bliver den første linje i filen lagt i en array som splitter dem op i ','.
                if(!(data[positionOfTerm].equalsIgnoreCase(searchTerm))){                 //Her tjekker den om det du gerne vil havde fjernet er lig med den data der er gemt i data
                    pw.println(currentLine);                                              //Hvis de ikke er lig med hinanden så gemmer vi den i den nye fil
                }else{

                    data[position] = newData;
                    pw.println(data[0] + ";" + data[1] + ";" + data[2] + ";" + data[3] + ";" + data[4] + ";" + data[5]);
                    checkForData = true;
                }
            }
            if (checkForData){
                System.out.println("File has been edited\n");
            }else {
                System.out.println("File not found\n");
            }

            pw.flush();
            pw.close();
            fr.close();
            br.close();
            bw.close();
            fw.close();

            oldFile.delete();
            File temp = new File(filePath);
            newFile.renameTo(temp);

        }catch(Exception e){
            System.out.println("Error\n");
        }
    }

}

