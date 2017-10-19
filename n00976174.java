// Michael Moser
// UNF ID: n00976174
// Ken Martin COP 3503

import java.util.Scanner;

public class n00976174 {
   public static void main(String[] args){
      
      Scanner input = new Scanner(System.in);
      
      // Prompts user to enter value in distance variable as a double
      System.out.print("Enter the driving distance: ");
      double distance = input.nextDouble();
      
      // Prompts user to enter value for miles variable as a double
      System.out.print("Enter miles per gallon of car: ");
      double mpg = input.nextDouble();
      
      // Prompts user to enter value for a price of a gallon as a double
      System.out.print("Enter price per gallon: ");
      double gallonPrice = input.nextDouble();
      
      // Process of using inputs to calculate the total trip cost
      double tripCost = (distance / mpg) * gallonPrice;
      
      // Displays the "tripCost" variable to user and displays value with 2 decimals spaces
      System.out.println("The cost of driving:$" + String.format("%.2f", tripCost));
      }
   }