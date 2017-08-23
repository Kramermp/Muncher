/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package muncher.frontend;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import muncher.backend.GameListener;

/**
 *
 * @author mpk5206
 */
public class GamePanel extends JPanel {
    NumberPanel[][] gameBoard = new NumberPanel[7][7];
    Color errorColor = Color.RED;
    Color backgroundColor = Color.GRAY;
    Color correctColor = Color.GREEN;
    Color selectedColor = Color.BLUE;
    int currentPlayerX;
    int currentPlayerY;
    
    public GamePanel() {
        this.setFocusable(true);
        addComponents();
    }
    
    private void addComponents() {
        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
        for(int i = 0; i < 7; i++) {
            for(int j = 0; j < 7; j++) {
                NumberPanel currentPanel = new NumberPanel(5);
                gameBoard[i][j] = currentPanel;
                c.gridy = i;
                c.gridx = j;
                this.add(currentPanel, c);
            }
        }
        gameBoard[currentPlayerX][currentPlayerY].setBackground(Color.RED);    
    }
    
    public void movePlayer(int newPlayerX, int newPlayerY) {
        gameBoard[currentPlayerY][currentPlayerX].setBackground(backgroundColor);
        gameBoard[newPlayerY][newPlayerX].setBackground(selectedColor);
        currentPlayerX = newPlayerX;
        currentPlayerY = newPlayerY;
    }
    

}
