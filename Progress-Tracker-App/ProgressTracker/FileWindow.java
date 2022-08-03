// Reviewed on 08/03/2022 at 10:24AM

package ProgressTracker;
import java.awt.*;
import javax.swing.*;

public class FileWindow extends JFrame {

    private JPanel screenPanel = new JPanel(new GridLayout(5, 1, 10, 10));
    private JPanel buffer = new JPanel();
    private JLabel fileNameLabel = new JLabel("File Name");
    private JTextField inputFileName = new JTextField();
    private JButton enterButton = new JButton("Enter");
    private String frameTitle;
    private String value;

    FileWindow(String frameTitle){
        this.frameTitle = frameTitle;
        setTitle(frameTitle);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setSize(250, 200);
        setVisible(true);
        setResizable(false);
        this.add(screenPanel);
        JComponent[] allComponents = {buffer, fileNameLabel, inputFileName, enterButton};
        for(int counter = 0; counter < 4; counter++){
            screenPanel.add(allComponents[counter]);
        }
        buffer.setPreferredSize(new Dimension(400, 5));
        fileNameLabel.setVerticalAlignment(JLabel.BOTTOM);
    }

    FileWindow(String frameTitle, String value){
        this(frameTitle);
        this.value = value;
        inputFileName.setText(value);
    }

    public JPanel getScreenPanel() {
        return screenPanel;
    }

    public void setScreenPanel(JPanel screenPanel) {
        this.screenPanel = screenPanel;
    }
    
    public JPanel getBuffer() {
        return buffer;
    }

    public void setBuffer(JPanel buffer) {
        this.buffer = buffer;
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
    
    public String getFrameTitle() {
        return frameTitle;
    }

    public void setFrameTitle(String frameTitle) {
        this.frameTitle = frameTitle;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void updateValue(){
        setValue(inputFileName.getText());
    }
}