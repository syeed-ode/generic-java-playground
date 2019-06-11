package com.syeedode.leagerachin_fikir.yonas.palindromicprime.service;

/**
 *  Notice that there is a class to do each operation.
 *
 *  Every class should have only one area of responsibility.
 *
 *  Small classes that do one thing is the best way to code.
 */
public class PrimeNumberService {
    /**
     * Taken from https://www.javatpoint.com/prime-number-program-in-java
     * @param n
     * @return
     */
    public boolean isPrimeNumber(int n){
        int i,m=0,flag=0;
        m=n/2;
        if(n==0||n==1){
            return false;
        }else{
            for(i=2;i<=m;i++){
                if(n%i==0){
                    flag=1;
                    break;
                }
            }
            if(flag==0)  { return true; }
        }//end of else
        return false;
    }
}
