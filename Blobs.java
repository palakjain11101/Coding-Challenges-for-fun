import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class Main {
  /**
   * Iterate through each line of input.
   */
  public static void main(String[] args) throws IOException {
    InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
    BufferedReader in = new BufferedReader(reader);
    String line;
    while ((line = in.readLine()) != null) {
      String[] splittedInput = line.split(";");
      String pattern = splittedInput[0];
      String blobs = splittedInput[1];
      Main.doSomething(pattern, blobs);
    }
  }
  
  public static void doSomething(String pattern, String blobs) {
    
    String[] blobsList = blobs.split("\\|");
    
    int count = 0;
    int length1 = pattern.length();
    int answer = 0;
    
    for(int i = 0; i < blobsList.length; i++){
      int index = 0;
      count = 0;
      String a = blobsList[i];
      if(pattern.length() != 0){
         while((index+length1) <= a.length()){
            String b = a.substring(index, index + length1); 
            index += 1;
            if((b).equals(pattern)){
              count++;
            }
         }
      }
      answer = answer + count;
      System.out.print(count);
      System.out.print("|");
      
    }
    System.out.println(answer);
  }
    
    // Write your code here. Feel free to create more methods and/or classes
  
}
