package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
public class Main {
    static ArrayList<String> duplicates = new ArrayList<>();

    public static void main(String[] args) {


        WordToGuess();

    }

    public static void Start(String[] compWord, ArrayList<String> wordArr,int missed,int guessed) {
        Scanner playerChoice = new Scanner(System.in);
        Scanner playAgain = new Scanner(System.in);
        DrawMan( missed);
        String choice="";
        boolean isDuplicate=true;

        System.out.println("Missed letters:" +missed);
        for(var letters : wordArr){
            System.out.print(letters);
        }
        System.out.println();
        while(isDuplicate==true) {
            System.out.println("Guess a Letter");
             choice = playerChoice.nextLine();
             if(ChoiceCheck(choice)==false){
                 isDuplicate=false;
             }else{
                 System.out.println("You already guessed that letter");
             }
        }
        if(guessed!=compWord.length && missed != 4) {
            GamePlay(choice, compWord, wordArr, guessed, missed);
        }else{
            System.out.println("YOu WIN!");
            System.out.println("Would you like to play again y or n");
            String replay = playAgain.nextLine();
            if(replay.toLowerCase().equals("y")){
                WordToGuess();
            }else {
                System.out.println("Thanks for playing Good Bye");
            }
        }

    }

    public static void WordToGuess(){
        ArrayList<String> wordBank = new ArrayList<>(
        Arrays.asList("polymorphism","abstraction","inheritance","encapsulation"));
            int chooseWord= (int) (Math.random() *4);
       String computerWord = wordBank.get(chooseWord);
       ArrayList<String> wordArray = new ArrayList<>();
       for (int i =0; i < computerWord.length();i++){
           wordArray.add("-");
       }
       String[] compWordArray = computerWord.split("");
       Start(compWordArray,wordArray,0,0);

    }

    public static void GamePlay(String letter,String[] compArray,ArrayList<String> wordArr,int guess,int miss){
        int guessed =guess;
        int missed =miss;
        boolean isCorrect = Arrays.asList(compArray).contains(letter);
        if(isCorrect){
            guessed++;
            for(int i =0; i<compArray.length; i++){
                if(letter.equals(compArray[i])){
                    wordArr.set(i,compArray[i]);
                }
            }
        }
        else{
            missed++;
        }
        Start(compArray, wordArr, missed, guessed);

    }



    public static  void DrawMan(int missed){

        System.out.println("H A N G M A N");
        System.out.println("+---+");
        if(missed >= 1){
            System.out.println("0  |");
        } else{
            System.out.println("   |");
        }
        if(missed >=2){
            System.out.println("|  |");
        }
        else{
            System.out.println("   |");
        }
        if(missed >=3){
            System.out.println("|  |");
        }
        else{
            System.out.println("   |");
        }


        System.out.print("  ");
        System.out.print("=".repeat(3));
        System.out.println("  ");
    }

    public static boolean ChoiceCheck(String choice){

        if(duplicates.contains(choice)==false){
            duplicates.add(choice);
            System.out.println(duplicates);
            return false;
        }else{
            return true;
        }
    }



}
