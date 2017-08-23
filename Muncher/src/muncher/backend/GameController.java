/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package muncher.backend;

import java.awt.Color;
import java.awt.event.KeyEvent;
import muncher.frontend.GameUI;
import muncher.frontend.NumberPanel;

/**
 *
 * @author mpk5206
 */
public class GameController {
    double playerScore;
    double difficulty = 1;
    int playerX = 0;
    int playerY = 0;
    int userLives = 10;
    int targetNumber;
    GameUI gameUI;
    
    public GameController () {
        this.gameUI = new GameUI(this);
        this.gameUI.requestFocusInWindow();
        this.targetNumber = this.gameUI.getTargetNumber();
    }
    
    public void keyPressed(KeyEvent ke) {
        switch(ke.getKeyCode()) {
            case 32: //Space
                System.out.println("Space");
                checkCurrentSpace();
                break;
            case 37: // Left
                System.out.println("Left");
                movePlayerLeft();
                break;
            case 38: // Up
                System.out.println("Up");
                movePlayerUp();
                break;
            case 39: // Right
                System.out.println("Right");
                movePlayerRight();
                break;
            case 40: // Down
                System.out.println("Down");
                movePlayerDown();
                break;       
            default: // Unknown or unbound key
                System.out.println("Unknown Key.");
                System.out.println(ke.getKeyCode());
                break; 
        }
    }

    private void movePlayerLeft() {
        if(playerX == 0) {
            //Do Nothing
            return;
        }
        playerX--;
        gameUI.movePlayer(playerX, playerY); 
        System.out.println("Player is now at " + playerX + " " + playerY);
    }

    private void movePlayerUp() {
        if(playerY == 0) {
            //do Nothing
            return;
        }
        playerY--;
        gameUI.movePlayer(playerX, playerY);         
        System.out.println("Player is now at " + playerX + " " + playerY);
    }

    private void movePlayerRight() {
        if(playerX == 6) {
            //Do Nothing
            return;
        }
        playerX++;
        gameUI.movePlayer(playerX, playerY);        
        System.out.println("Player is now at " + playerX + " " + playerY);
    }

    private void movePlayerDown() {
        if(playerY == 6) {
            //Do nothing
            return;
        }
        playerY++;
        gameUI.movePlayer(playerX, playerY);       
        System.out.println("Player is now at " + playerX + " " + playerY);
    }
    
    private void checkCurrentSpace() {
        System.out.println("Checking current Space.");
        NumberPanel currentSpace = gameUI.getCurrentSpace();
        if(!currentSpace.getHasBeenChecked()) {
            currentSpace.setHasBeenChecked(true);
            int number = currentSpace.getNumber();
            //Needs to be able to validate for different Numbers
            if(answerIsCorrect(currentSpace)) {
                //Answer is correct
                currentSpace.setBackground(Color.GREEN); //We change the current color to green
                currentSpace.setBackgroundColor(Color.GREEN); //Will ensure it returns to green
                playerScore = playerScore + Math.floor((100) * difficulty);
            } else {
                //Answer is wrong
                currentSpace.setBackground(Color.RED); //Will set current color to red
                currentSpace.setBackgroundColor(Color.RED); //Will ensure it returns to red
                userLives--;
            }
            checkIfFinished();
        } else {
            //This space has been already checked and does not need to be
            //Checked again
            //Possible TODO: Maybe alert the user of this fact
        }
    }
    private boolean answerIsCorrect(NumberPanel currentSpace) {
        if(isPrimeGame()) {
            //Is a game based off of prime number
            if(GameRule.isPrime(currentSpace.getNumber())) {
                return true;
            }
        } else {
            //Is a game based off of multiples
            if(currentSpace.getNumber() % targetNumber == 0) {
                return true;
            }
        }
        return false;
    }
    
    private boolean isPrimeGame() {
        return gameUI.isPrimeGame();
    }
    private void checkIfFinished() {
        if(userLives <= 0) {
            //User ran out of lives and has lost the game
            gameUI.dispose();
        }
    }
    
}
