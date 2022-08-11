// Reviewed on 

package ProgressTracker;
import java.awt.*;
import javax.swing.*;

public class FileWindow extends JFrame {

    private JPanel screenPanel = new JPanel(new GridLayout(3, 1, 10, 10));
    private JLabel fileNameLabel = new JLabel("File Name");
    private JTextField inputFileName = new JTextField();
    private JButton enterButton = new JButton("Enter");
    // private String value;
    // private JPanel buffer = new JPanel();    REMOVE FROM PERMANENT VARIABLES?
    // private String frameTitle;   REMOVE FROM PERMANENT VARIABLES?
    
    /*
    public JPanel getBuffer() {
        return buffer;
    }

    public void setBuffer(JPanel buffer) {
        this.buffer = buffer;
    }
    
    public String getFrameTitle() {
        return frameTitle;
    }

    public void setFrameTitle(String frameTitle) {
        this.frameTitle = frameTitle;
    }
    */

    FileWindow(String frameTitle){
        // this.frameTitle = frameTitle; REMOVE FROM CONSTRUCTOR?
        setTitle(frameTitle);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setSize(250, 150);
        setVisible(true);
        setResizable(false);
        this.add(screenPanel);
        JComponent[] allComponents = {fileNameLabel, inputFileName, enterButton};
        // JComponent[] allComponents = {buffer, fileNameLabel, inputFileName, enterButton};    OLD VERSION
        for(int counter = 0; counter < 3; counter++){
            screenPanel.add(allComponents[counter]);
        }
        // buffer.setPreferredSize(new Dimension(400, 5));  REMOVE FROM CONSTRUCTOR?
        fileNameLabel.setVerticalAlignment(JLabel.BOTTOM);
    }

    FileWindow(String frameTitle, String value){
        this(frameTitle);
        // this.value = value;  REMOVE FROM CONSTRUCTOR?
        inputFileName.setText(value);
    }

    public JPanel getScreenPanel() {
        return screenPanel;
    }

    public void setScreenPanel(JPanel screenPanel) {
        this.screenPanel = screenPanel;
    }

    public JLabel getFileNameLabel() {
        return fileNameLabel;
    }

    public void setFileNameLabel(JLabel fileNameLabel) {
        this.fileNameLabel = fileNameLabel;
    }
    
    public JTextField getInputFileName() {
        return inputFileName;
    }

    public void setInputFileName(JTextField inputFileName) {
        this.inputFileName = inputFileName;
    }

    public JButton getEnterButton() {
        return enterButton;
    }

    public void setEnterButton(JButton enterButton) {
        this.enterButton = enterButton;
    }

    public String getCurrentValue() {
        return getInputFileName().getText();
    }

    /*
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void updateValue(){
        setValue(inputFileName.getText());
    }
    */
}