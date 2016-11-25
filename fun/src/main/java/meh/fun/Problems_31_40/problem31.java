/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package meh.fun.Problems_31_40;

/**
 *
 * @author n439081
 */
public class problem31 {

  /**
   * In England the currency is made up of pound, £, and pence, p, and there are eight coins in general circulation:

1p, 2p, 5p, 10p, 20p, 50p, £1 (100p) and £2 (200p).
It is possible to make £2 in the following way:

1×£1 + 1×50p + 2×20p + 1×5p + 1×2p + 3×1p
How many different ways can £2 be made using any number of coins?
   */
  public static void main(String[] args) {
    
    //Number of coin combinations that total £2
    int result = 0;
    
    //Quantity of particular coins being used in calculation
    //{£2,£1,50p,20p,10p,5p,2p,1p}
    int[] coinQuantity = {0,0,0,0,0,0,0,0};
    
    while(true){
      coinQuantity[7]++;
      if(coinQuantity[7] == 201){
        coinQuantity[6]++;
        coinQuantity[7] = 0;
        if(coinQuantity[6] == 101){
          coinQuantity[5]++;
          coinQuantity[6] = 0;
          if(coinQuantity[5] == 41){
            coinQuantity[4]++;
            coinQuantity[5] = 0;
            if(coinQuantity[4] == 21){
              coinQuantity[3]++;
              coinQuantity[4] = 0;
              if(coinQuantity[3] == 11){
                coinQuantity[2]++;
                coinQuantity[3] = 0;
                if(coinQuantity[2] == 5){
                  coinQuantity[1]++;
                  coinQuantity[2] = 0;
                  if(coinQuantity[1] == 3){
                    coinQuantity[0]++;
                    coinQuantity[1] = 0;
                  }
                }
              }
            }
          }
        }
      }
      
      int totalSum = 200*coinQuantity[0] + 100*coinQuantity[1] + 50*coinQuantity[2] + 20*coinQuantity[3] + 10*coinQuantity[4] + 5*coinQuantity[5] + 2*coinQuantity[6] + coinQuantity[7];
    
      if(totalSum == 200){
        result++;
        System.out.println(coinQuantity[0] + "x£2 " + coinQuantity[1] + "x£1 " + coinQuantity[2] + "x50p " + coinQuantity[3] + "x20p " + coinQuantity[4] + "x10p " + coinQuantity[5] + "x5p " + coinQuantity[6] + "x2p " + coinQuantity[7] + "x1p");
      }
      
      if(coinQuantity[0] == 1){
        break;
      }
      
    }
    
    System.out.println(result);
    
    
    
    
  }
  
}
