/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package muncher.backend;

import java.util.Random;

/**
 *
 * @author Michael Kramer
 */
public class GameRule {
    Random rng = new Random();
    boolean isPrimeNumberGame = false;
    int targetNumber = rng.nextInt(50) + 1;
    String ruleText = "";
    int[][] numberSet = new int[7][7];
    int correctAnswerCount = 1;
    int correctResponseCount = 0;
    
    public GameRule () {
        if(rng.nextInt(2) == 0) {
            ruleText = "Select All Prime Numbers.";
        } else {
            ruleText = "Select All Multiples of " + targetNumber;
        }
        generateNumberSet();
    }
    
    public int get(int x, int y) {
        return numberSet[x][y];
    }
    
    private void generateNumberSet(){
        int randomX = rng.nextInt(7);
        int randomY = rng.nextInt(7);
        boolean foundAnswer = false;
        int possibleAnswer;
        
        do {
            possibleAnswer = rng.nextInt(1000) + 1;
            if (isPrimeNumberGame) {
               foundAnswer = isPrime(possibleAnswer);
            } else {
               foundAnswer = true;
               possibleAnswer = targetNumber * rng.nextInt(20) + 1;
            }
        } while (!foundAnswer);
        
        for(int i = 0; i < 7; i++) {
            for(int j = 0; j < 7; j++) {
                if(i == randomY && j == randomX) {
                    numberSet[i][j] = possibleAnswer;
                } else {
                    int answer = rng.nextInt(1000) + 1;
                    numberSet[i][j] = answer;
                    if (isPrimeNumberGame) {
                        if(isPrime(answer)) {
                           correctAnswerCount++;
                        }
                    } else {
                        if (answer % targetNumber == 0) {
                            correctAnswerCount++;
                        }
                    }
                }
            }
        }
    }
    
    public static boolean isPrime(int number) {
        if (number <= 1 || number == 4) {
            return false;
        } if (number == 2 || number == 3) {
            return true;
        } else {
            int cutoff = (int) Math.sqrt(number);
            for(int i = 5; i < cutoff; i+= 6) {
                if (number % i == 0) {
                    return false;
                }
            }
            return true;
        } 
    }
    
    public int getTargetNumber() {
        return targetNumber;
    }
    
    public boolean isPrimeGame() {
        return this.isPrimeNumberGame;
    }
    
    public String getRuleString() {
        return this.ruleText;
    }
           
}
