/*
 * Written by:          Thomas Williams
 * Last Updated:        08/24/2022, at 8:28PM(PT)
 * Version:             1.2
 * Coding Module ID(s): 1.1, 1.2, 1.3
 */

package ProgressTracker.ProgressTracker;

import java.awt.*;
import javax.swing.*;
import ProgressTracker.*;

public class LoginPanel extends FivePanel{

    private JPanel  subPanel = new JPanel(),
                    subSubPanel = new JPanel(),
                    usernamePanel = new JPanel(),
                    passwordPanel = new JPanel();
    private JTextArea   username = new JTextArea();
    private JPasswordField  password = new JPasswordField();
    private JButton enterButton = new JButton("Enter");
    private JLabel  usernameLabel = new JLabel("Username:"),
                    passwordLabel = new JLabel("Password:");

    public LoginPanel(MyFrame myFrame){
        super(myFrame);
        getCenterPanel().setLayout(new BorderLayout());
        getSubPanel().setLayout(new BorderLayout());
        getUsername().setPreferredSize(getMyFrame().getSmallDimension());
        getPassword().setPreferredSize(getMyFrame().getSmallDimension());
        getEnterButton().setPreferredSize(getMyFrame().getSmallDimension());

        getSubSubPanel().add(enterButton, BorderLayout.NORTH);

        getSubPanel().add(subSubPanel, BorderLayout.CENTER);
        passwordPanel.setLayout(new BorderLayout());
        passwordPanel.add(passwordLabel, BorderLayout.WEST);
        passwordPanel.add(password, BorderLayout.CENTER);
        getSubPanel().add(passwordPanel, BorderLayout.NORTH);
        // getSubPanel().add(password, BorderLayout.NORTH);

        getCenterPanel().add(subPanel, BorderLayout.CENTER);
        usernamePanel.setLayout(new BorderLayout());
        usernamePanel.add(usernameLabel, BorderLayout.WEST);
        usernamePanel.add(username, BorderLayout.CENTER);
        getCenterPanel().add(usernamePanel, BorderLayout.NORTH);
        // getCenterPanel().add(username, BorderLayout.NORTH);
        getEnterButton().addActionListener(myFrame);

        usernameLabel.setVerticalAlignment(JLabel.NORTH);
        // passwordLabel.setVerticalAlignment(JLabel.NORTH);
        password.setBorder(BorderFactory.createEmptyBorder());

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
        getUsernamePanel().setBackground(columnPanelsColor);
        getPasswordPanel().setBackground(columnPanelsColor);
    }

    public void updateFonts(){
        getUsername().setFont(getMyFrame().getPalette().getTextAreaFont());
        getPassword().setFont(getMyFrame().getPalette().getTextAreaFont());
        getEnterButton().setFont(getMyFrame().getPalette().getButtonFont());
        getPasswordLabel().setFont(getMyFrame().getPalette().getLabelsFont());
        getUsernameLabel().setFont(getMyFrame().getPalette().getLabelsFont());
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

    public JPanel getPasswordPanel() {
        return passwordPanel;
    }

    public void setPasswordPanel(JPanel passwordPanel) {
        this.passwordPanel = passwordPanel;
    }

    public JPanel getUsernamePanel() {
        return usernamePanel;
    }

    public void setUsernamePanel(JPanel usernamePanel) {
        this.usernamePanel = usernamePanel;
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

    public JLabel getPasswordLabel() {
        return passwordLabel;
    }

    public void setPasswordLabel(JLabel passwordLabel) {
        this.passwordLabel = passwordLabel;
    }

    public JLabel getUsernameLabel() {
        return usernameLabel;
    }

    public void setUsernameLabel(JLabel usernameLabel) {
        this.usernameLabel = usernameLabel;
    }
}