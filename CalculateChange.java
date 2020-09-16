import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class Main {
  /**
   * Iterate through each line of input.
   */
  public static void main(String[] args) throws IOException {
    InputStreamReader reader = new InputStreamReader(System.in);
    BufferedReader in = new BufferedReader(reader);
    try {
        double purchasePrice = Double.parseDouble(in.readLine());
        double cash = Double.parseDouble(in.readLine());
        Main.calculateChange(purchasePrice, cash);
    } catch (Exception e) {
        System.out.println(e);
    }
  }

  public static void calculateChange(double purchasePrice, double cash) {
    double totalChange = cash - purchasePrice;
    List<String> list = new ArrayList<String>();
    if(totalChange < 0){
      System.out.println("ERROR");
    } else {
      double[] arr = {50, 20, 10, 5, 2, 1, 0.5, 0.20, 0.1, 0.05, 0.02, 0.01};
      String[] arr1 = {"Fifty Pounds", "Twenty Pounds", "Ten Pounds", "Five Pounds", "Two Pounds", "One Pound", "Fifty Pence", "Twenty Pence", "Ten Pence", "Five Pence", "Two Pence", "One Pence"};
      for(int i = 0; i < arr.length; i++){    
        while((totalChange - (arr[i])) >= (-0.001)){
          totalChange = totalChange - arr[i];
          list.add(arr1[i]);
        }
        
      }
    }
    for(int i = 0; i < list.size(); i++){
      System.out.print(list.get(i));
      if(i < ((list.size())-1)){
        System.out.print(", ");
      }
    }
    
 
    
   
     
 
  
    // Access your code here. Feel free to create other classes as required
    
  }

}