/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package muncher.frontend;

import java.awt.Color;
import java.util.Random;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author mpk5206
 */
public class NumberPanel extends JPanel {
    private int number;
    private static Color backgroundColor = Color.GRAY;
    private static Color errorColor = Color.RED;
    private static Color correctColor = Color.GREEN;
    
    public NumberPanel(int number) {
        this.number = number;
        configurePanel();
    }

    private void configurePanel() {
        Random rng = new Random();
        this.setBackground(new Color(rng.nextInt(255), rng.nextInt(255), rng.nextInt(255)));
        this.add(new JLabel(Integer.toString(this.number)));
    }
}
