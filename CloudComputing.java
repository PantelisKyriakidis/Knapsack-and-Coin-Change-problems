package cloudcomputing;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


/**
 * This is the class that has the main method.
 * @author Kyriakidis Pantelis
 */
public class CloudComputing {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        int cores = 0;      //first line of the txt is stored here. 
        ArrayList<Integer> al1=new ArrayList<>();   //al1: core Amount the user demands
        ArrayList<Float> al2=new ArrayList<>();     //al2: price he provide for a core.
        
        try (BufferedReader in = new BufferedReader( new FileReader("in.txt"));)
            { 
                String l;
                
                int line=1;
                while ((l = in.readLine()) != null)   //reading from txt 
                {
                    if (line==1){
                            cores=Integer.parseInt(l);  //making string to int 
                            line++;
                            continue;
                    }
                    
                    String[] l2=l.split(" ");           //I spited the lines to put them in different vriables.
                        int x=Integer.parseInt(l2[0]);
                        float y=Float.parseFloat(l2[1]);
                        
                        al1.add(x);       //Adding the element to arraylists
                        al2.add(y);
                    line++;
                }
            }
        //exercise 1
        int coins[] = {1, 2, 7, 11};
        Minimum cc = new Minimum();
        
        for (Integer x:al1)
            cc.minimumCoinBottomUp(x, coins, al1.indexOf(x));
        
        //exercise 2
        knapsack knap=new knapsack();
        knap.algorithm(al2, al1, cores);
    }
    
}
