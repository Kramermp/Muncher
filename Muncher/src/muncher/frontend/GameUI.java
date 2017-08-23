/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package muncher.frontend;

import java.awt.Dimension;
import javax.swing.JFrame;

/**
 *
 * @author mpk5206
 */
public class GameUI extends JFrame {
    public GameUI() {
        this.setVisible(true);
        configureWindow();
        addComponents();
    }
    
    private void configureWindow() {
        this.setSize(new Dimension(500, 500));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    private void addComponents () {
        
    }
}
