/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package group.project.pkg2;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Sin
 */
public class Nim {
    private int[] nimBoard = {8,3,7,4};
    private Scanner input = new Scanner(System.in);
    public Nim(){
        createNim();
    }
    
    
    public void createNim(){
        Random rand = new Random();
        int numStack = rand.nextInt(8) + 3;
        nimBoard = new int[numStack];
        for(int i = 0; i < numStack; i++){
            int numToken = rand.nextInt(10) + 1;
            nimBoard[i] = numToken;
        }
    }
    
    public void PvP(){
        int heap, token,countTurn =0, player;
        do{
            display();
            player = (countTurn%2) +1;
            System.out.println("Player " + player + "'s turn:");
            humanMove();
            countTurn++;
        }while(checkEndGame());
        System.out.println("Player " + player + " lost!");
    }
    
    public void PvC(){
        String player;
        Random rand = new Random();
        int goFirst = rand.nextInt(2);
        if(goFirst == 1){
            do{
                display();
                humanMove();
                display();
                compMove();
            }while(checkEndGame());
            System.out.println("You lost");
        }else{
            do{
                display();
                compMove();
                display();
                humanMove();
            }while(checkEndGame());
            System.out.println("You lost");
        }
    }
    
    private boolean checkEndGame(){
        if(totalToken()<=0)
            return false;
        return true;
    }
    
    private void display(){
        for(int i = 0 ; i < nimBoard.length; i++){
            System.out.print(i+1 + ": ");
        for(int j = 0; j < nimBoard[i]; j ++){
            System.out.print("0");
        }
        System.out.println();
        }
    }
    
    private void humanMove(){
        int heap,token;
        System.out.print("Choose heap number: ");
        heap = input.nextInt();
        System.out.print("Choose token number: ");
        token = input.nextInt();
        nimBoard[heap-1] -= token;
    }
    
    private void compMove(){
        int nimSum = nimSum(), heapTakenIndex=0;
        int smallestHeapSum = nimSum ^ nimBoard[0];
        int numTokenTakeOff;
        for(int i = 0; i < nimBoard.length; i++){
            int temp = nimSum ^ nimBoard[i];
            int tempTokenOff = nimBoard[i] - temp;
            //System.out.println("Temp token off: " + tempTokenOff);
            if((smallestHeapSum > temp) && (tempTokenOff<= nimBoard[i]) && tempTokenOff > 0){
                heapTakenIndex = i;
                smallestHeapSum = temp;
            }
        }
        if(totalToken() == nimBoard[heapTakenIndex])
            numTokenTakeOff = nimBoard[heapTakenIndex] - 1;
        else
            numTokenTakeOff = nimBoard[heapTakenIndex] - smallestHeapSum;
        
        nimBoard[heapTakenIndex] -= numTokenTakeOff;
        
        System.out.println("Computer took " + numTokenTakeOff + " from heap " + (heapTakenIndex+1));
    }
    
    private int nimSum(){
        int nimSum = 0;
        for(int i = 0; i < nimBoard.length; i++){
            nimSum ^= nimBoard[i];
        }
        return nimSum;
    }
    
    private int totalToken(){
        int total =0;
        for(int i = 0; i < nimBoard.length;i++){
            total += nimBoard[i];
        }
        return total;
    }
}
