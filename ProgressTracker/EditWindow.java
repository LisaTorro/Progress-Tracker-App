// Reviewed on 
package ProgressTracker;

import java.awt.*;
import javax.swing.*;

public class EditWindow extends JFrame{

    private JPanel screenPanel = new JPanel(new GridLayout(8, 1, 10, 10));
    private JLabel titleLabel = new JLabel();
    private JLabel contentsLabel = new JLabel();
    private JLabel userLabel = new JLabel();
    private JTextArea inputTitle = new JTextArea();
    private JTextArea inputContents = new JTextArea();
    private JTextArea inputUser = new JTextArea();
    private JButton enterButton = new JButton("Enter");
    // private JPanel buffer = new JPanel();    REMOVE THIS?
    // private JLabel editTitle = new JLabel(); THIS WAS NEVER USED?
    // private String frameTitle;
    // private String[] values = new String[3];

    public EditWindow(String frameTitle){
        // this.frameTitle = frameTitle;
        setTitle(frameTitle);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setSize(400, 600);
        setVisible(true);
        setResizable(false);
        this.add(screenPanel);
        // JComponent[] allComponents = {buffer, titleLabel, inputTitle, contentsLabel, inputContents, userLabel, inputUser, enterButton};  OLD VERSION
        JComponent[] allComponents = {titleLabel, inputTitle, contentsLabel, inputContents, userLabel, inputUser, enterButton};
        for(int counter = 0; counter < 7; counter++){
            screenPanel.add(allComponents[counter]);
        }
        // buffer.setPreferredSize(new Dimension(400, 8));
        titleLabel.setVerticalAlignment(JLabel.BOTTOM);
        contentsLabel.setVerticalAlignment(JLabel.BOTTOM);
        userLabel.setVerticalAlignment(JLabel.BOTTOM);
    }

    public EditWindow(String frameTitle, String[] values){
        this(frameTitle);
        // this.values = values;
        inputTitle.setText(values[0]);
        inputContents.setText(values[1]);
        inputUser.setText(values[2]);
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
    
    /*
    public JPanel getBuffer() {
        return buffer;
    }

    public void setBuffer(JPanel buffer) {
        this.buffer = buffer;
    }
    */

    /*
    public String getFrameTitle() {
        return frameTitle;
    }

    public void setFrameTitle(String frameTitle) {
        this.frameTitle = frameTitle;
    }
    */

    /*
    public String[] getValues() {
        return values;
    }

    public void setValues(String[] values) {
        this.values = values;
    }
    */

    /*
    public void updateValues(){
        values[0] = inputTitle.getText();
        values[1] = inputContents.getText();
        values[2] = inputUser.getText();
    }
    */

    /*
    public JLabel getEditTitle() {
        return editTitle;
    }

    public void setEditTitle(JLabel editTitle) {
        this.editTitle = editTitle;
    }
    */
}