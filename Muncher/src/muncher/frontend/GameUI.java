/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package muncher.frontend;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JLabel;
import muncher.backend.GameController;
import muncher.backend.GameListener;
import muncher.backend.GameRule;

/**
 *
 * @author mpk5206
 */
public class GameUI extends JFrame {
    public GamePanel game = new GamePanel();
    private GameController parentController;
    
    public GameUI(GameController parentController) {
        this.parentController = parentController;
        this.setVisible(true);
        configureWindow();
        addComponents();
    }
    
    private void configureWindow() {
        this.setSize(new Dimension(500, 500));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    private void addComponents () {
        this.setLayout(new BorderLayout());
        this.add(new JLabel(game.getRuleString()), BorderLayout.NORTH);
        this.add(game, BorderLayout.CENTER);
        this.addKeyListener(new GameListener(this.parentController));
    }
    
    public void movePlayer(int playerX, int playerY) {
        game.movePlayer(playerX, playerY);
    }
    
    public NumberPanel getCurrentSpace() {
        return game.getCurrentSpace();
    }
    
    public int getTargetNumber() {
        return game.getTargetNumber();
    }
    
    public boolean isPrimeGame() {
        return game.isPrimeGame();
    }
    
    public int getAnswerCount () {
        return game.getAnswerCount();
    }
}
