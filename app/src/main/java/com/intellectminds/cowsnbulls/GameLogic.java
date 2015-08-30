package com.intellectminds.cowsnbulls;

import java.util.Dictionary;
import java.util.Scanner;

/**
 * Created by enaamon on 2015-08-29.
 */
public class GameLogic {

    private int cows, bulls;
    private String gameWord;

    public GameLogic() {

        GameDictionary cw = new GameDictionary();
        Dictionary<Integer, String> gameDict = cw.addWords();
        int index=returnInt();
        gameWord = gameDict.get(index).toUpperCase();
        System.out.println("Game word is "+gameWord);
    }

    public int getCows() {
        return cows;
    }

    public int getBulls() {
        return bulls;
    }

    public static int returnInt(){
        int index=1;
        index = (int)((Math.random())*10);

        return index;
    }
    public void matchWord(String inputWord) {

        int numOfGuesses = 0;
        String guessWord;
        System.out.println("######################################################################");
        System.out.println("                       Welcome To The Game");
        System.out.println("                         COWS AND BULLS");
        System.out.println("######################################################################");


         System.out.println("\n\n\n");
        System.out.println("Input Word is "+inputWord);

            cows = 0;
            bulls = 0;
            char[] letters = inputWord.toCharArray();
            for(int i=0;i<gameWord.length();i++){
                for(int j=0;j<letters.length;j++){
                    if(gameWord.charAt(i)==letters[j]){
                        cows+=1;
                        if(i==j){
                            bulls+=1;
                        }
                    }
                }
            }
            System.out.println("Cows:"+cows+"  Bulls:"+bulls);
            numOfGuesses+=1;

        System.out.println("You have guessed correctly in "+numOfGuesses+" guesses. \n The word is "+inputWord);

    }

}
