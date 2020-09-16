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
    InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
    BufferedReader in = new BufferedReader(reader);
    String line;
    while ((line = in.readLine()) != null) {
      String[] pfAndBm=line.split(":");
      
      //String associated to the portfolio
      //String associated to benchMarks
      String[] pfs=pfAndBm[0].split("\\|");
      String[] bms=pfAndBm[1].split("\\|");
      
      /* Creates list of Assets of both portfolio and benchMarks */
      ArrayList<Asset> portfolio=new ArrayList<>();
      ArrayList<Asset> benchMarks=new ArrayList<>();
      
      // Parse the string into assets 
      for(int i=0;i<pfs.length;i++)
      {
        String[] pfsData=pfs[i].split(",");
        portfolio.add(new Asset(pfsData[0],pfsData[1],Integer.parseInt(pfsData[2])));
      }
      
      for(int j = 0; j < bms.length; j++){
        String[] bmsData=bms[j].split(",");
        benchMarks.add(new Asset(bmsData[0],bmsData[1],Integer.parseInt(bmsData[2])));
       
      }
        

       /* Calculate number of trades required */
      List<Trade> transactions= transactions(portfolio,benchMarks);
      
      
      //sort the transactions in alphabetical order by name, or by trade type(if names are the same)
      Collections.sort(transactions, new Comparator<Trade>(){
        @Override
         public int compare(Trade a, Trade b) {
           if(!(a.getName().equals(b.getName()))){
             return (a.getName().compareToIgnoreCase(b.getName()));
           } else {
             return (a.getType().compareToIgnoreCase(b.getType()));
           }
         }
     
      });
      
      
      /* print the final output to standard output */
      for(Trade t: transactions)
        System.out.println(t.getChoice() + "," + t.getName()+ "," + t.getType() + "," + t.getNumShares());
    }
  }
 
    

  
  
  public static List<Trade> transactions(ArrayList<Asset> portfolio, ArrayList<Asset> benchMarks){
    
      //records the list of transactions necessary to make portfolio equivalant to benchmark
      List<Trade>  numTransaction = new ArrayList<>();
    
      for(int j = 0; j < benchMarks.size(); j++){
              
          for(int i=0; i<portfolio.size();i++){
                Asset pAsset = portfolio.get(i);
                Asset bAsset = benchMarks.get(j);
            
                //compares each asset in each list and appropriate calculations are made
                if(((benchMarks.get(j)).getName()).equals((portfolio.get(i)).getName())){
                    if(((benchMarks.get(j)).getType()).equals((portfolio.get(i)).getType())){
                                int MVPPortfolio= pAsset.getShares();
                                int MVPBenchMark= bAsset.getShares();

                                if(MVPPortfolio < MVPBenchMark)
                                {
                                    int y= (MVPBenchMark - MVPPortfolio);
                                    numTransaction.add(new Trade("BUY", pAsset.getName(), pAsset.getType(), y));
                                }
                                else if(MVPPortfolio > MVPBenchMark)
                                {
                                    int y = (MVPPortfolio - MVPBenchMark);
                                    numTransaction.add(new Trade("SELL", pAsset.getName(), pAsset.getType(), y));
                                }

                      } else{
                         numTransaction.add(new Trade("BUY", bAsset.getName(), bAsset.getType(), benchMarks.get(j).getShares()));
                      }
                   }
	
		       }
           }

      return numTransaction;
    
  }
  
  


   /**
    * Class  represents the datastructure for trades
    */
  static class Trade{
      private String choice;
      private String type;
      private String tName;
      private int numShares;

      public Trade(String choice, String name, String type, int numShares)
      {
        this.choice = choice;
        this.type=type;
        this.tName=name;
        this.numShares=numShares;
      }

      public String getChoice(){
        return this.choice;
      }

      public String getType()
      {
        return this.type;
      }
      public String getName()
      {
        return this.tName;
      }

      public int getNumShares()
      {
        return this.numShares;
      }

    }

       /**
        * Class  represents the datastructure for Assets
        */

     static class Asset{
         private String name;
         private String assetType;
         private  int shares;

        public Asset(String name, String assetType,int share)
        {
          this.name=name;
          this.assetType=assetType;
          this.shares=share;
        }

        public String getName()
        {
          return this.name;
        }

        public String getType()
        {
          return this.assetType;
        }

        public int getShares()
        {
          return shares;
        }

      }
  
}