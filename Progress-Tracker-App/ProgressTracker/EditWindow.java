// Reviewed on 08/12/2022 at 8:55AM
// I could consider making all the JVariables into one JComponent array.

package ProgressTracker;

import java.awt.*;
import javax.swing.*;

public class EditWindow extends JFrame{

    private MyFrame myFrame;
    private JPanel screenPanel = new JPanel(new GridLayout(7, 1, 10, 10));
    private JLabel titleLabel = new JLabel("Title:");
    private JLabel contentsLabel = new JLabel("Contents:");
    private JLabel userLabel = new JLabel("User:");
    private JTextArea inputTitle = new JTextArea();
    private JTextArea inputContents = new JTextArea();
    private JTextArea inputUser = new JTextArea();
    private JButton enterButton = new JButton("Enter");

    public EditWindow(MyFrame myFrame, String frameTitle){
        this.myFrame = myFrame;
        setTitle(frameTitle);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setSize(250, 300);
        setVisible(true);
        setResizable(true);
        this.add(screenPanel);
        JComponent[] allComponents = {titleLabel, inputTitle, contentsLabel, inputContents, userLabel, inputUser, enterButton};
        for(int counter = 0; counter < 7; counter++){
            screenPanel.add(allComponents[counter]);
        }
        updatePaint();
        updateFonts();
    }

    public EditWindow(MyFrame myFrame, String frameTitle, String[] values){
        this(myFrame, frameTitle);
        inputTitle.setText(values[0]);
        inputContents.setText(values[1]);
        inputUser.setText(values[2]);
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
    }

    public void updateBorders(){

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

    public String[] getCurrentValue() {
        String[] output = {inputTitle.getText(), inputContents.getText(), inputUser.getText()};
        return output;
    }
}