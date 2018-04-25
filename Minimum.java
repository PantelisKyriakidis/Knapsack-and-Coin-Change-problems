/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cloudcomputing;

/**
 * Here is the algorithm for the exercise 1.
 * I took it from : https://github.com/mission-peace/interview/blob/master/src/com/interview/dynamic/CoinChangingMinimumCoin.java
 * I made some changes to have the needed results.
 * @author Kyriakidis Pantelis
 */
public class Minimum {

    /**
     * Bottom up way of solving this problem.
     * Keep input sorted. Otherwise temp[j-arr[i]) + 1 can become Integer.Max_value + 1 which
     * can be very low negative number
     * Returns Integer.MAX_VALUE - 1 if solution is not possible.
     * @param total: core Amount that the client asks for.
     * @param coins: the different i-core combinations.
     * @param index: the number of the client.
     */
    public void minimumCoinBottomUp(int total, int coins[],int index){
        int T[] = new int[total + 1];
        int R[] = new int[total + 1];
        T[0] = 0;
        for(int i=1; i <= total; i++){
            T[i] = Integer.MAX_VALUE-1;
            R[i] = -1;
        }
        for(int j=0; j < coins.length; j++){
            for(int i=1; i <= total; i++){
                if(i >= coins[j]){
                    if (T[i - coins[j]] + 1 < T[i]) {
                        T[i] = 1 + T[i - coins[j]];
                        R[i] = j;
                    }
                }
            }
        }
        printCoinCombination(R, coins,index);
        
    }

    private void printCoinCombination(int R[], int coins[],int index) {
        if (R[R.length - 1] == -1) {
            System.out.print("No solution is possible");
            return;
        }
        //sum: how many i-cores are needed. 
        int sum[]=new int[coins.length]; // array component is initialized with a default value when it is created. For type int, the default value is zero, that is, 0.
        
        int start = R.length - 1;
        while ( start != 0 ) {
            int j = R[start];
            sum[j]+=1;
            start = start - coins[j];
        }
        
        System.out.print("Client "+(index+1)+":");
        for (int j=0;j<coins.length;j++){                   //printing the results.
            if(j==0)
                System.out.printf(" %d %d-core", sum[j],coins[j]);
            else if(j!=coins.length-1)
                System.out.printf(", %d %d-core", sum[j],coins[j]);
            else
                System.out.printf(" and %d %d-core ", sum[j],coins[j]);
        }
        System.out.println("VMs");
    }
}
