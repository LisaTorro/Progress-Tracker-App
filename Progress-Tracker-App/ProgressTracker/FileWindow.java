package ProgressTracker;
import java.awt.*;
import javax.swing.*;

public class FileWindow extends JFrame {

    String frameTitle;
    JPanel screenPanel = new JPanel(new GridLayout(5, 1, 10, 10));
    JPanel buffer = new JPanel();
    JLabel fileNameLabel = new JLabel("File Name");
    JTextField inputFileName = new JTextField();
    JButton enterButton = new JButton("Enter");
    String value;

    FileWindow(String frameTitle){
        this.frameTitle = frameTitle;

        buffer.setPreferredSize(new Dimension(400, 5));

        screenPanel.add(buffer);
        screenPanel.add(fileNameLabel);
        screenPanel.add(inputFileName);
        screenPanel.add(enterButton);

        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setTitle(frameTitle);
        setSize(250, 200);
        setVisible(true);
        setResizable(false);
        this.add(screenPanel);

        fileNameLabel.setVerticalAlignment(JLabel.BOTTOM);
    }

    FileWindow(String frameTitle, String value){
        this(frameTitle);
        this.value = value;

        inputFileName.setText(value);
    }

    public String getValue(){
        return value;
    }

    public void setValue(String value){
        this.value = value;
    }

    public JButton getEnterButton(){
        return enterButton;
    }

    public void setEnterButton(JButton enterButton){
        this.enterButton = enterButton;
    }

    public void updateValue(){
        setValue(inputFileName.getText());
    }
    
}
