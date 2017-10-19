// Michael Moser
// n00976174

import java.util.*;
import java.lang.*;
import java.io.*;

public class n00976174{


public static void main(String[] args) throws FileNotFoundException{

   // Opening the file and assigns to Scanner
   File file = new File(args[0]);
   Scanner x = new Scanner(file);
   
   // Array used to store all vehicles
   ArrayList<Vehicle> vehicleArray = new ArrayList<>();
   
   // while loop used to fill array and construct the vehicle type by comparing strings
   while (x.hasNextLine()){
      String test = x.nextLine();
   
   if(test.equals("vehicle")){
      String owner = x.nextLine();
      String address = x.nextLine();
      String phone = x.nextLine();
      String email = x.nextLine();
      vehicleArray.add(new Vehicle(owner, address, phone, email));
   }else if(test.equals("car")){
      String owner = x.nextLine();
      String address = x.nextLine();
      String phone = x.nextLine();
      String email = x.nextLine();
      boolean convertible = x.nextBoolean();
      x.nextLine();
      String color = x.nextLine();
      vehicleArray.add(new Car(owner, address, phone, email, convertible, color));
   }else if(test.equals("american car")){
      String owner = x.nextLine();
      String address = x.nextLine();
      String phone = x.nextLine();
      String email = x.nextLine();
      boolean convertible = x.nextBoolean();
      x.nextLine();
      String color = x.nextLine();
      boolean detroit = x.nextBoolean();
      boolean union = x.nextBoolean();
      vehicleArray.add(new AmericanCar(owner, address, phone, email, convertible, color, detroit, union));
   }else if(test.equals("foreign car")){
      String owner = x.nextLine();
      String address = x.nextLine();
      String phone = x.nextLine();
      String email = x.nextLine();
      boolean convertible = x.nextBoolean();
      x.nextLine();
      String color = x.nextLine();
      String country = x.nextLine();
      float duty = x.nextFloat();
      vehicleArray.add(new ForeignCar(owner, address, phone, email, convertible, color, country, duty));
   }else if(test.equals("bicycle")){
      String owner = x.nextLine();
      String address = x.nextLine();
      String phone = x.nextLine();
      String email = x.nextLine();
      int speeds = x.nextInt();
      vehicleArray.add(new Bicycle(owner, address, phone, email, speeds));
   }else if(test.equals("truck")){
      String owner = x.nextLine();
      String address = x.nextLine();
      String phone = x.nextLine();
      String email = x.nextLine();
      float tons = x.nextFloat();
      float cost = x.nextFloat();
      x.nextLine();
      String date = x.nextLine();
      vehicleArray.add(new Truck(owner, address, phone, email, tons, cost, date));
   }
   
   }
   // Closes the file
   x.close();
   
   // printAll method displays the entire array
   System.out.println("All Vehicles\n");
   printAll(vehicleArray);
   System.out.println("\n");
   
   // sort method sorts the array by email A-Z
   System.out.println("Sorted by Emails\n");
   sort(vehicleArray);
   System.out.println("\n");
   
   // numberOfVehicles displays the amount of vehciles in array
   System.out.println("Total Amount of Vehicles\n");
   numberOfVehicles(vehicleArray);
   System.out.println("\n");
   
   // bikesAndTrucks displays the bikes and trucks only in the array
   System.out.println("Bikes and Trucks Only\n");
   bikesAndTrucks(vehicleArray);
   System.out.println("\n");
   
   // areaCode displays the vehicles with the "987" area code only
   System.out.println("987 Area Code\n");
   areaCode(vehicleArray);
   
   }
   // for loop to display all vehicles in array
   public static void printAll(ArrayList<Vehicle> vehicles){
   
   for (int i = 0; i<= vehicles.size()-1; i++){
      System.out.println(vehicles.get(i).toString());
      System.out.println("");
      }
   }
   // compares emails in array to sort
   public static void sort(ArrayList<Vehicle> vehicles){
   
   Collections.sort(vehicles, new EmailCompare());
   
   for (int i = 0; i <= vehicles.size()-1; i++){
      System.out.println(vehicles.get(i).toString());
      System.out.println("");
      }
   }
   // displays the total number of vehicles in array
   public static void numberOfVehicles(ArrayList<Vehicle> vehicles){
   System.out.println("Number of Vehicles: " + vehicles.size());
   
   }
   // displays the instances of bikes and trucks in vehicle array
   public static void bikesAndTrucks(ArrayList<Vehicle> vehicles){
   for (int i = 0; i <= vehicles.size()-1; i++){
      if (vehicles.get(i) instanceof Bicycle){
      System.out.println(vehicles.get(i).toString());
      System.out.println("");
   }else if (vehicles.get(i) instanceof Truck){
      System.out.println(vehicles.get(i).toString());
      System.out.println("");
         }
      }
   }
   // compares the area codes of phone numbers in array and displays only with the "987" area code
   public static void areaCode(ArrayList<Vehicle> vehicles){
   
   String areaCompare;
   
   for (int i = 0; i <= vehicles.size()-1; i++){
      areaCompare = vehicles.get(i).getPhoneNum();
      
      if((areaCompare.substring(1,4)).equals("987")){
      System.out.println(vehicles.get(i).toString());
      System.out.println("");
         }
      }
   }

// class used for comparing emails of each vehicle. Comparator found in java.util   
static class EmailCompare implements Comparator<Vehicle>{

public int compare(Vehicle one, Vehicle two){
   String emailOne = one.getEmail();
   String emailTwo = two.getEmail();
   
   return emailOne.compareTo(emailTwo);
   }
}

   

}


// creates vehicle class with private variables to "get" and "set" each variable and display info using toString method
class Vehicle{

   private String owner;
   private String address;
   private String phoneNum;
   private String email;
   
   public Vehicle(){}
   
   public Vehicle(String owner, String address, String phoneNum, String email){
   
   this.owner = owner;
   this.address = address;
   this.phoneNum = phoneNum;
   this.email = email;
   
   }
   
   public String getOwner(){
      return owner;
   }
   
   public void setOwner(String newOwner){
      this.owner = newOwner;
   }
   
   public String getAddress(){
      return address;
   }
   
   public void setAddress(String newAddress){
      this.address = newAddress;
   }
   
   public String getPhoneNum(){
      return phoneNum;
   }
   
   public void setPhoneNum(String newPhoneNum){
      this.phoneNum = newPhoneNum;
   }
   
   public String getEmail(){
      return email;
   }
   
   public void setEmail(String newEmail){
      this.email = newEmail;
   }
   
   @Override
   public String toString(){
      return "Type: Vehicle" + "\n" + "Owner: " + getOwner() + "\n" + "Address: " + getAddress() + 
          "\n" + "Phone Number: " +getPhoneNum() + "\n" + "Email: " + getEmail();
   }

}
// creates Car class with private variables to "get" and "set" each variable and display info using toString method. Extends the vehicle class
class Car extends Vehicle{

   private boolean convertible;
   private String color;
   
   public Car(){}
   
   public Car(String owner, String address, String phoneNum, String email, boolean convertible, String color){
   
      setOwner(owner);
      setAddress(address);
      setPhoneNum(phoneNum);
      setEmail(email);
      this.convertible = convertible;
      this.color = color;
   }
   
   public boolean getConvertible(){
      return convertible;
   }
   
   public void setConvertible(boolean newConvertible){
      this.convertible = newConvertible;
   }
   
   public String getColor(){
      return color;
   }
   
   public void setColor(String newColor){
      this.color = newColor;
   }
   
   @Override
   public String toString(){
      return "Type: Car" + "\n" + "Owner: " + getOwner() + "\n" + "Address: " + getAddress() + 
          "\n" + "Phone Number: " +getPhoneNum() + "\n" + "Email: " + getEmail() + "\n" + "Convertible?: " + getConvertible() + "\n" + "Color: " + getColor(); 
   }

}
// creates AmericanCar class with private variables to "get" and "set" each variable and display info using toString method. Extends the car class
class AmericanCar extends Car{

   private boolean madeInDetroit;
   private boolean unionShop;

   public AmericanCar(){}

   public AmericanCar(String owner, String address, String phoneNum, String email, boolean convertible, String color, boolean madeInDetroit, boolean unionShop){

   setOwner(owner);
   setAddress(address);
   setPhoneNum(phoneNum);
   setEmail(email);
   setConvertible(convertible);
   setColor(color);
   this.madeInDetroit = madeInDetroit;
   this.unionShop = unionShop;

   }

public boolean getMadeInDetroit(){
   return madeInDetroit;
}

public void setMadeInDetroit(boolean newMadeInDetroit){
   this.madeInDetroit = newMadeInDetroit;
}

public boolean getUnionShop(){
   return unionShop;
}

public void setUnionShop(boolean newUnionShop){
   this.unionShop = newUnionShop;
}

@Override
public String toString(){
   return "Type: American Car" + "\n" + "Owner: " + getOwner() + "\n" + "Address: " + getAddress() + 
          "\n" + "Phone Number: " +getPhoneNum() + "\n" + "Email: " + getEmail() + "\n" + "Convertible?: " + getConvertible() + "\n" + "Color: " + getColor()
          + "\n" + "Made in Detroit: " + madeInDetroit + "\n" + "Union Shop: " + unionShop;
}

}

// creates ForeignCar class with private variables to "get" and "set" each variable and display info using toString method. Extends the car class
class ForeignCar extends Car{

   private String countryOfManufacturer;
   private float importDuty;

   public ForeignCar(){}

   public ForeignCar(String owner, String address, String phoneNum, String email, boolean convertible, String color, String countryOfManufacturer, float importDuty){

   setOwner(owner);
   setAddress(address);
   setPhoneNum(phoneNum);
   setEmail(email);
   setConvertible(convertible);
   setColor(color);
   this.countryOfManufacturer = countryOfManufacturer;
   this.importDuty = importDuty;
}

public String getCountryOfManufacturer(){
   return countryOfManufacturer;
}

public void setCountryOfManufacturer(String newCountryOfManufacturer){
   this.countryOfManufacturer = newCountryOfManufacturer;
}

public float getImportDuty(){
   return importDuty;
}

public void setImportDuty(float newImportDuty){
   this.importDuty = newImportDuty;
}

@Override
public String toString(){
   return "Type: Foreign Car" + "\n" + "Owner: " + getOwner() + "\n" + "Address: " + getAddress() + 
          "\n" + "Phone Number: " +getPhoneNum() + "\n" + "Email: " + getEmail() + "\n" + "Convertible?: " + getConvertible() + "\n" + "Color: " + getColor()
          + "\n" + "Country of Manufacturer: " + countryOfManufacturer + "\n" + "Import Duty: $" + importDuty;

}

}

// creates Bicycle class with private variables to "get" and "set" each variable and display info using toString method. Extends the vehicle class
class Bicycle extends Vehicle{

   private int numberOfSpeeds;

   public Bicycle(){}

public Bicycle(String owner, String address, String phoneNum, String email, int numberOfSpeeds){
   setOwner(owner);
   setAddress(address);
   setPhoneNum(phoneNum);
   setEmail(email);
   this.numberOfSpeeds = numberOfSpeeds;
}

public int getNumberOfSpeeds(){
   return numberOfSpeeds;
}

public void setNumberOfSpeeds(int newNumberOfSpeeds){
   this.numberOfSpeeds = newNumberOfSpeeds;
}

@Override
public String toString(){
   return "Type: Bicycle" + "\n" + "Owner: " + getOwner() + "\n" + "Address: " + getAddress() + 
          "\n" + "Phone Number: " +getPhoneNum() + "\n" + "Email: " + getEmail() + "\n" + "Number of Speeds: " + numberOfSpeeds;
}

}

// creates Truck class with private variables to "get" and "set" each variable and display info using toString method. Extends the vehicle class
class Truck extends Vehicle{

   private float numberOfTons;
   private float cost;
   private String date;

   public Truck(){}

public Truck(String owner, String address, String phoneNum, String email, float numberOfTons, float cost, String date){

   setOwner(owner);
   setAddress(address);
   setPhoneNum(phoneNum);
   setEmail(email);
   this.numberOfTons = numberOfTons;
   this.cost = cost;
   this.date = date;

}

public float getNumberOfTons(){
   return numberOfTons;
}

public void setNumberOfTons(float newNumberOfTons){
   this.numberOfTons = newNumberOfTons;
}

public float getCost(){
   return cost;
}

public void setCost(float newCost){
   this.cost = newCost;
}

public String getDate(){
   return date;
}

public void setDate(String newDate){
   this.date = newDate;
}

@Override
public String toString(){
   return "Type: Truck" + "\n" + "Owner: " + getOwner() + "\n" + "Address: " + getAddress() + 
          "\n" + "Phone Number: " +getPhoneNum() + "\n" + "Email: " + getEmail() + "\n" + "Tons: " + numberOfTons + "\n" + "Cost: $" + cost + "\n" + "Date: " + date;

   }

}

