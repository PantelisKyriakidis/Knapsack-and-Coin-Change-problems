
package cloudcomputing;

import java.util.ArrayList;

/**
 * In this class I wrote the code for the second exersice
 * Time complexity of Knapsack problem is O(nW) where, n is the number of clients and W is the number of all cores.
 * @author Kyriakidis Pantelis
 */
public class knapsack {
    
    /**
     * Knapsack algorithm.
     * First I create an array total.
     * Then i fill this array : when the coreAmount is bigger than the current cores(j) then total is the same with the above. 
     * Else its the max value from the above and (the one at -1 row and -coreAmount)+ total price that the client gives.
     * @param al: price per core
     * @param coreAmount: how many cores the client need
     * @param cores: total cores
     */
    public void algorithm(ArrayList al,ArrayList coreAmount, int cores){
        float total[][]=new float[al.size()+1][cores+1];
        
        for (int i=1; i<al.size()+1; i++){
                float price=(float) al.get(i-1);
                int coreAm=(int) coreAmount.get(i-1);
            for(int j=1; j<cores+1; j++){ 
                if(coreAm>j)
                    total[i][j]=total[i-1][j];
                else
                    total[i][j]=Math.max(total[i-1][j], total[i-1][j-coreAm] + price*coreAm);
            }
        }
        printResults(al,coreAmount,cores,total);    
    }
    
    /**
     * Printing the results.
     * choosing clients: when the above number is not the same with the current.
     */
    public void printResults(ArrayList al,ArrayList coreAmount, int cores, float[][] total){
        int i=al.size();
        int j=cores;
        String s;
        s="Clients accepted: ";
        while (i>0 && j>0){
            if (total[i][j] == total[i-1][j])
                i-=1;
            else{
                s+=i;
                i-=1;
                j-=(int)coreAmount.get(i);
                if(i>0 && j>0){
                    s+=",";
                }
            }    
        }
        System.out.println(s.substring(0, s.length() - 1));
        System.out.println("Total amount: "+total[al.size()][cores]);
    }
    
}
