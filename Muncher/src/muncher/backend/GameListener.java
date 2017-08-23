/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package muncher.backend;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import muncher.frontend.GamePanel;

/**
 *
 * @author mpk5206
 */
public class GameListener implements KeyListener {

    GameController gameController;
    
    public GameListener(GameController gameController) {
        this.gameController = gameController;
    }
    
    @Override
    public void keyTyped(KeyEvent ke) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        gameController.keyPressed(ke);
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
