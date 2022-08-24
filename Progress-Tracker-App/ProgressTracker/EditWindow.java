/*
 * Written by:          Thomas Williams
 * Last Updated:        08/18/2022, at 11:25AM(PT)
 * Version:             1.0
 * Coding Module ID(s): 3.3, 8.1
 */

package ProgressTracker;

import java.awt.*;
import javax.swing.*;

public class EditWindow extends JFrame{

    private MyFrame myFrame;
    private JPanel  screenPanel = new JPanel(new GridLayout(8, 1, 10, 10));
    private JLabel  titleLabel = new JLabel("Title:"),
                    contentsLabel = new JLabel("Contents:"),
                    userLabel = new JLabel("User:");
    private JTextArea   inputTitle = new JTextArea(),
                        inputContents = new JTextArea(),
                        inputUser = new JTextArea();
    private JButton enterButton = new JButton("Enter"),
                    deleteButton = new JButton("Delete");

    public EditWindow(MyFrame myFrame, String frameTitle){
        setMyFrame(myFrame);
        setTitle(frameTitle);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setSize(250, 350);
        setVisible(true);
        setResizable(true);
        add(screenPanel);
        JComponent[] allComponents = {deleteButton, titleLabel, inputTitle, contentsLabel, inputContents, userLabel, inputUser, enterButton};
        for(int counter = 0; counter < 8; counter++){
            screenPanel.add(allComponents[counter]);
        }
        getEnterButton().addActionListener(myFrame);
        getDeleteButton().addActionListener(myFrame);
        updatePaint();
        updateFonts();
    }

    public EditWindow(MyFrame myFrame, String frameTitle, String[] values){
        this(myFrame, frameTitle);
        getInputTitle().setText(values[0]);
        getInputContents().setText(values[1]);
        getInputUser().setText(values[2]);
    }

    public void updatePaint(){
        Color mainPanelColor = myFrame.getPalette().getMainPanelColor();
        Color layoutPanelColor = myFrame.getPalette().getLayoutPanelsColor();
        Color buttonColor = myFrame.getPalette().getSouthButtonColor();
        getScreenPanel().setBackground(mainPanelColor);
        getInputTitle().setBackground(layoutPanelColor);
        getInputContents().setBackground(layoutPanelColor);
        getInputUser().setBackground(layoutPanelColor);
        getEnterButton().setBackground(buttonColor);
        getDeleteButton().setBackground(buttonColor);
    }

    public void updateFonts(){
        Font labelsFont = getMyFrame().getPalette().getLabelsFont();
        Font textAreaFont = getMyFrame().getPalette().getTextAreaFont();
        Font buttonFont = getMyFrame().getPalette().getButtonFont();
        getTitleLabel().setFont(labelsFont);
        getContentsLabel().setFont(labelsFont);
        getUserLabel().setFont(labelsFont);
        getInputTitle().setFont(textAreaFont);
        getInputContents().setFont(textAreaFont);
        getInputUser().setFont(textAreaFont);
        getEnterButton().setFont(buttonFont);
        getDeleteButton().setFont(buttonFont);
    }

    public void updateBorders(){

    }

    public String[] getCurrentValue() {
        String[] output = {inputTitle.getText(), inputContents.getText(), inputUser.getText()};
        return output;
    }
    
    public MyFrame getMyFrame() {
        return myFrame;
    }

    public void setMyFrame(MyFrame myFrame) {
        this.myFrame = myFrame;
    }

    public JPanel getScreenPanel() {
        return screenPanel;
    }

    public void setScreenPanel(JPanel screenPanel) {
        this.screenPanel = screenPanel;
    }
    
    public JLabel getTitleLabel() {
        return titleLabel;
    }

    public void setTitleLabel(JLabel titleLabel) {
        this.titleLabel = titleLabel;
    }
    
    public JLabel getContentsLabel() {
        return contentsLabel;
    }

    public void setContentsLabel(JLabel contentsLabel) {
        this.contentsLabel = contentsLabel;
    }
    
    public JLabel getUserLabel() {
        return userLabel;
    }

    public void setUserLabel(JLabel userLabel) {
        this.userLabel = userLabel;
    }

    public JTextArea getInputTitle() {
        return inputTitle;
    }

    public void setInputTitle(JTextArea inputTitle) {
        this.inputTitle = inputTitle;
    }
    
    public JTextArea getInputContents() {
        return inputContents;
    }

    public void setInputContents(JTextArea inputContents) {
        this.inputContents = inputContents;
    }

    public JTextArea getInputUser() {
        return inputUser;
    }

    public void setInputUser(JTextArea inputUser) {
        this.inputUser = inputUser;
    }
    
    public JButton getEnterButton() {
        return enterButton;
    }

    public void setEnterButton(JButton enterButton) {
        this.enterButton = enterButton;
    }

    public JButton getDeleteButton() {
        return deleteButton;
    }

    public void setDeleteButton(JButton deleteButton) {
        this.deleteButton = deleteButton;
    }
}