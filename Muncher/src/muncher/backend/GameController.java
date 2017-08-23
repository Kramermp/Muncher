/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package muncher.backend;

import java.awt.event.KeyEvent;
import muncher.frontend.GameUI;

/**
 *
 * @author mpk5206
 */
public class GameController {
    int playerX = 0;
    int playerY = 0;
    GameUI gameUI;
    
    public GameController () {
        this.gameUI = new GameUI(this);
        this.gameUI.requestFocusInWindow();
    }
    
    public void keyPressed(KeyEvent ke) {
        switch(ke.getKeyCode()) {
            case 32: //Space
                System.out.println("Space");
                checkCurrentSpace();
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
}
