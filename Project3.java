// Assignment 3

import java.util.*;

public class Project3 {

   public static void main(String[] args){
      
      // Create array m1 and m2
      int[][] m1 = new int[3][3];
      int[][] m2 = new int[3][3];
      Strict run = new Strict();
   
      Scanner input = new Scanner(System.in);
      boolean m1Full = true;
      
      // Asks for user prompt and assigns input into the arrays through for loops
      System.out.print("Enter 18 numbers: ");
      for (int i = 0; i<m1.length; i++){
      for (int j = 0; j<m1[i].length;j++)
         m1[i][j] = input.nextInt();
         }
         
         if(m1Full==true){
         for (int x = 0; x<m2.length; x++){
         for (int y = 0; y<m2[x].length;y++)
            m2[x][y] = input.nextInt();
            }
         }
         System.out.println("");
         
         // "if,else" statement calls the equals method to determine if the array values are identical
         if (run.equals(m1, m2)) {
            System.out.println("The two arrays are strictly identical.");
        } else {
            System.out.println("The two arrays are not strictly identical");
        }
            System.out.println("");
   
      // Calls the howmany method
      System.out.println("Number of identical elements in m1 and m2: " +run.howmany(m1, m2));
      System.out.println("");
      
      // Calls the diagonal method
      System.out.println("Number of identical elements diagonally in m1 and m2: " +run.diagonal(m1, m2));
      System.out.println("");
      
      // Calls the average method
      System.out.println("The average of both arrays is: " +String.format("%.2f", run.average(m1, m2)));
      System.out.println("");
      
      // Calls the display method
      System.out.println("Here are the odd values of both arrays:");
      System.out.println("");
      run.display(m1, m2);
      System.out.println("");
      
      // Calls the silly method
      System.out.println("The values in the array are 1 < numbers <= 10: " +run.silly(m1, m2));
      System.out.println("");
      
      }
      
// Start of the Strict class
public static class Strict{

// "equals" method checks to see if arrays are strictly equal
public static boolean equals(int[][] m1, int[][] m2){

if (m1.length != m2.length || m1[0].length != m2[0].length) return false;

        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m1[i].length; j++) {

                if (m1[i][j] != m2[i][j]) return false;
            }
        }


        return true;
        
        }
         
// "howmany" method returns how many cells in the array are identical
public static int howmany(int[][] m1, int[][] m2){

int count = 0;

   for (int i=0; i<m1.length;i++){
      for (int j=0; j<m1[i].length;j++){
      if (m1[i][j] == m2[i][j]){
      count++;
   }
      }
         }

return count;

}

// "diagonal" method returns the number of cells that are identical diagonally
public static int diagonal(int[][] m1, int[][] m2){

int count = 0;

   for (int i=0; i<m1.length;i++){
      for (int j=0; j<m1[i].length;j++){
      if(i == j)
      if (m1[i][j] == m2[i][j]){
      count++;
   }
      }
         }

return count;

}

// "average" method will calculate the average of the values in both arrays
public static double  average(int[][] m1,int[][] m2){

int sum = 0;

   for (int i=0; i<m1.length;i++){
      for (int j=0; j<m1[i].length;j++){
      sum += m1[i][j];
   }
      }

   for (int i=0; i<m2.length;i++){
      for (int j=0; j<m2[i].length;j++){
      sum += m2[i][j];
   }
      }

double average;
average = (sum/18.00);

return average;

}

// "display" method will display all the odd numbers in the arrays
public static void display(int[][] m1, int[][] m2){

      for(int i = 0; i < m1.length; i++){
           for(int j = 0; j < m1[i].length; j++){
               if(((m1[i][j])%2) == 1){
                  if(((m1[i][j])/10) == 0){
                     System.out.print((" " + m1[i][j])+ "   ");
                  }else{
                     System.out.print((m1[i][j])+ "   ");
                  }
               }else{
                  System.out.print("     ");
               }
           }
           System.out.println("");
       }
       
       System.out.println("");
       System.out.println("");
       
       for(int i = 0; i < m2.length; i++){
           for(int j = 0; j < m2[i].length; j++){
               if(((m2[i][j])%2) == 1){
                  if(((m2[i][j])/10) == 0){
                     System.out.print((" " + m2[i][j])+ "   ");
                  }else{
                     System.out.print((m2[i][j])+ "   ");
                  }
               }else{
                  System.out.print("     ");
               }
           }
           System.out.println("");
       }
   }
   
// "silly" method checks the arrays to see if the values are greater than 1 or less than or equal to 10
public static boolean silly(int[][] m1, int[][] m2){

boolean validate = false;
 
   for (int i=0; i<m1.length;i++){
      for (int j=0; j<m1[i].length;j++){
         if((m1[i][j]) > 1 && (m1[i][j] <= 10)){
         validate = true;
         }else{
         validate = false;

         }
            }
   if(validate == false);{
   break;
   }
      }

   for (int i=0; i<m2.length;i++){
      for (int j=0; j<m2[i].length;j++){
         if((m1[i][j]) > 1 && (m1[i][j] <= 10)){
         validate = true;
         }else{
         validate = false;

         break;

         }
            }
   if(validate == false);{
   break;
   }
      }

return validate;

   }                
      } 
         }
