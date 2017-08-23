/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package muncher.frontend;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import muncher.backend.GameController;

/**
 *
 * @author mpk5206
 */
public class MainMenuUI extends JFrame {
    
    public MainMenuUI () {
        this.setVisible(true);
        this.setSize(new Dimension(500, 500));
        configureWindow();
        addComponents();
    }
    
    private void configureWindow () {
        this.setTitle("Muncher");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    private void addComponents() {
        this.setLayout(new GridBagLayout());
        JButton startGameBtn = new JButton("Start Game");
        JButton hallOfFameBtn = new JButton("Hall Of Fame");
        JButton selectLvlBtn = new JButton("Select Level");
        JButton exitBtn = new JButton("Exit Game");
        
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        startGameBtn.addActionListener((ActionEvent ae) -> {
           new GameController(); 
        });
        this.add(startGameBtn, c);
        
        c.gridy = 1; 
        this.add(hallOfFameBtn, c);
        
        c.gridy = 2;
        this.add(selectLvlBtn, c);
        
        c.gridy = 3;
        exitBtn.addActionListener((ActionEvent ae) -> {
            System.exit(0);
        });
        this.add(exitBtn, c);
    }
}
