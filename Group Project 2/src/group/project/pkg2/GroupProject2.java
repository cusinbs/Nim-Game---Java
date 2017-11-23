/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package group.project.pkg2;

import java.util.Scanner;

/**
 *
 * @author Sin
 */
public class GroupProject2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Scanner input = new Scanner(System.in);
        int choice;
        Nim newGame = new Nim();
        do{
            choice = menu();
            switch(choice){
                case 1:
                    System.out.println("Game Start!");
                    newGame.PvP();
                    break;
                case 2:
                    System.out.println("Game Start!");
                    newGame.PvC();
                    break;
                case 3:
                    System.out.println("Thank you for using");
                    break;
                default:
                    System.out.println("Invalid Selection");
            }
        }while(choice>3 || choice < 1);
    }
    
    public static int menu(){
        Scanner aScanner = new Scanner(System.in);
        System.out.println("\n1. PvP");
        System.out.println("2. PvC");
        System.out.println("3. QUIT");
        System.out.print("Enter your choice----> ");
        return aScanner.nextInt();
    }
}
