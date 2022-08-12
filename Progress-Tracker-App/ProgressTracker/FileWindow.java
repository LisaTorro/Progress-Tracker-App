// Reviewed on 08/12/2022 at 8:55AM
// I could consider making all the JVariables into one JComponent array.

package ProgressTracker;

import java.awt.*;
import javax.swing.*;

public class FileWindow extends JFrame {

    private MyFrame myFrame;
    private JPanel screenPanel = new JPanel(new GridLayout(3, 1, 10, 10));
    private JLabel fileNameLabel = new JLabel("File Name");
    private JTextField inputFileName = new JTextField();
    private JButton enterButton = new JButton("Enter");

    public FileWindow(MyFrame myFrame, String frameTitle){
        this.myFrame = myFrame;
        setTitle(frameTitle);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setSize(250, 150);
        setVisible(true);
        setResizable(true);
        this.add(screenPanel);
        JComponent[] allComponents = {fileNameLabel, inputFileName, enterButton};
        for(int counter = 0; counter < 3; counter++){
            screenPanel.add(allComponents[counter]);
        }
        updatePaint();
        updateFonts();
    }

    public void updatePaint(){
        Color mainPanelColor = myFrame.getPalette().getMainPanelColor();
        Color layoutPanelColor = myFrame.getPalette().getLayoutPanelsColor();
        Color buttonColor = myFrame.getPalette().getSouthButtonColor();
        getScreenPanel().setBackground(mainPanelColor);
        getInputFileName().setBackground(layoutPanelColor);
        getEnterButton().setBackground(buttonColor);
    }

    public void updateFonts(){
        Font labelsFont = getMyFrame().getPalette().getLabelsFont();
        Font textAreaFont = getMyFrame().getPalette().getTextAreaFont();
        Font buttonFont = getMyFrame().getPalette().getButtonFont();
        getFileNameLabel().setFont(labelsFont);
        getInputFileName().setFont(textAreaFont);
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
}