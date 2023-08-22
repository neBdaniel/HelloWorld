import java.io.*; 
import java.util.Scanner;

public class bmi {

    public static void main(String args[]) throws IOException { 
    Scanner s = new Scanner(System.in); 

    // asks the user for his/her height in centimeters
    System.out.print("Enter your height in centimeters: "); 

    // asks the user for his/her weight in kilograms
    float height = s.nextFloat();      
    System.out.print("Enter your weight in kilograms: "); 

    // calculates the user input and then prints the bmi
    float weight = s.nextFloat();
    float bmi = weight / (height * height) * 10000; 
    System.out.println("Your body mass index is " + bmi + ".");

    }
}