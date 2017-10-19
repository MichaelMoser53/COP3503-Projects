// Michael Moser
// UNF ID: n00976174
// Ken Martin COP 3503
// Assignment 2

import java.util.Scanner;

public class n00976174 {
   public static void main(String[] args){
      
      Scanner input = new Scanner(System.in);
      
      // Prompts user to enter a number used as the denominator in calculation and assigns to "num1" variable.
      System.out.print("Enter a odd-positive number for sum of series and calculating PI: ");
      int num1 = input.nextInt();
      
      // Declare sum variable as a double. For loop used to calculate sum of series stopping with the fraction from the user input.
      double sum = 0;
      for (double i = 1; i <= num1; i += 2){
      sum += i/(i+2);
      }
      // Prints the sum of the series using 12 decimal places.
      System.out.println("\nThe sum of fractions is: " + String.format("%.12f", sum));
      
      // Declares "PIsum" and "NUMchange" variable use in the loop.
      double PIsum = 0;
      int NUMchange = 1;
      
      // For loop used to calculate approximate value of pi.
      for (double i = 1; i <= (num1 *2); i += 2){
       PIsum += NUMchange * (4.0 / i);
       NUMchange = -NUMchange;
      
      }
      // Prints the approximate value of pi based on user input.
      System.out.println("The value of PI is: " + String.format("%.12f", PIsum));
      
      }
   }