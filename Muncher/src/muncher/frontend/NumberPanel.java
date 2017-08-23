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
import javax.swing.JTextField;

/**
 *
 * @author mpk5206
 */
public class NumberPanel extends JPanel {
    private int number;
    private JTextField label;
    private boolean hasBeenChecked = false;
    private Color backgroundColor = Color.GRAY;
    public final static Color errorColor = Color.RED;
    public final static Color correctColor = Color.GREEN;
    
    public NumberPanel(int number) {
        this.number = number;
        this.label = new JTextField(3);
        this.label.setHorizontalAlignment(JTextField.CENTER);
        this.label.setEditable(false);
        this.label.setText(Integer.toString(this.number));
        configurePanel();
    }

    private void configurePanel() {
        Random rng = new Random();
        this.setBackground(backgroundColor);
        this.add(this.label);
    }
    
    public int getNumber () {
        return this.number;
    }
    
    public void setSelected(boolean isSelected) {
        if(isSelected) {
            setBackground(Color.BLUE);
        } else {
            setBackground(backgroundColor);
        }
    }
    
    public void setBackgroundColor(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
    }
    
    public void setHasBeenChecked(boolean hasBeenChecked) {
        this.hasBeenChecked = hasBeenChecked;
    }
    
    public boolean getHasBeenChecked() {
        return this.hasBeenChecked;
    }
}
