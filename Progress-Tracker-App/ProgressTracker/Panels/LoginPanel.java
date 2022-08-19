/*
 * Written by:          Thomas Williams
 * Last Updated:        08/18/2022, at 1:45PM(PT)
 * Version:             1.0
 * Coding Module ID(s): 
 */

package ProgressTracker.Panels;

import java.awt.*;
import javax.swing.*;
import ProgressTracker.*;

public class LoginPanel extends FivePanel{

    private JPanel  subPanel = new JPanel(),
                    subSubPanel = new JPanel();
    private JTextArea   username = new JTextArea();
    private JPasswordField  password = new JPasswordField();
    private JButton enterButton = new JButton("Enter");

    public LoginPanel(MyFrame myFrame){
        super(myFrame);
        getCenterPanel().setLayout(new BorderLayout());
        getSubPanel().setLayout(new BorderLayout());
        getUsername().setPreferredSize(getMyFrame().getSmallDimension());
        getPassword().setPreferredSize(getMyFrame().getSmallDimension());
        getEnterButton().setPreferredSize(getMyFrame().getSmallDimension());
        getSubSubPanel().add(enterButton, BorderLayout.NORTH);
        getSubPanel().add(subSubPanel, BorderLayout.CENTER);
        getSubPanel().add(password, BorderLayout.NORTH);
        getCenterPanel().add(subPanel, BorderLayout.CENTER);
        getCenterPanel().add(username, BorderLayout.NORTH);
        getEnterButton().addActionListener(myFrame);
        updatePaint();
        updateFonts();
    }

    public void updatePaint(){
        super.updatePaint();
        Color layoutPanelsColor = getMyFrame().getPalette().getLayoutPanelsColor();
        Color columnPanelsColor = getMyFrame().getPalette().getColumnPanelsColor();
        Color buttonColor = getMyFrame().getPalette().getSouthButtonColor();
        getSubPanel().setBackground(layoutPanelsColor);
        getSubSubPanel().setBackground(layoutPanelsColor);
        getUsername().setBackground(columnPanelsColor);
        getPassword().setBackground(columnPanelsColor);
        getEnterButton().setBackground(buttonColor);
    }

    public void updateFonts(){
        getUsername().setFont(getMyFrame().getPalette().getTextAreaFont());
        getPassword().setFont(getMyFrame().getPalette().getTextAreaFont());
        getEnterButton().setFont(getMyFrame().getPalette().getButtonFont());
    }

    public void updateBorders(){
        
    }

    public JPanel getSubPanel() {
        return subPanel;
    }

    public void setSubPanel(JPanel subPanel) {
        this.subPanel = subPanel;
    }

    public JPanel getSubSubPanel() {
        return subSubPanel;
    }

    public void setSubSubPanel(JPanel subSubPanel) {
        this.subSubPanel = subSubPanel;
    }
    
    public JTextArea getUsername() {
        return username;
    }

    public void setUsername(JTextArea username) {
        this.username = username;
    }

    public JPasswordField getPassword() {
        return password;
    }

    public void setPassword(JPasswordField password) {
        this.password = password;
    }

    public JButton getEnterButton() {
        return enterButton;
    }

    public void setEnterButton(JButton enterButton) {
        this.enterButton = enterButton;
    }
}