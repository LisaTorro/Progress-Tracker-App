package ProgressTracker;
import java.awt.*;
import javax.swing.*;

public class EditWindow extends JFrame{

    String frameTitle;
    JPanel screenPanel = new JPanel(new GridLayout(8, 1, 10, 10));
    JPanel buffer = new JPanel();

    JLabel editTitle = new JLabel();
    JLabel titleLabel = new JLabel("Title");
    JTextArea inputTitle = new JTextArea();
    JLabel contentsLabel = new JLabel("Details");
    JTextArea inputContents = new JTextArea();
    JLabel userLabel = new JLabel("User Name");
    JTextArea inputUser = new JTextArea();
    JButton enterButton = new JButton("Enter");
    String[] values = new String[3];
    
    


    EditWindow(String frameTitle){
        this.frameTitle = frameTitle;

        buffer.setPreferredSize(new Dimension(400, 8));

        screenPanel.add(buffer);
        screenPanel.add(titleLabel);
        screenPanel.add(inputTitle);
        screenPanel.add(contentsLabel);
        screenPanel.add(inputContents);
        screenPanel.add(userLabel);
        screenPanel.add(inputUser);
        screenPanel.add(enterButton);

        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setTitle(frameTitle);
        setSize(400, 600);
        setVisible(true);
        setResizable(true);
        this.add(screenPanel);

        titleLabel.setVerticalAlignment(JLabel.BOTTOM);
        contentsLabel.setVerticalAlignment(JLabel.BOTTOM);
        userLabel.setVerticalAlignment(JLabel.BOTTOM);
    }

    EditWindow(String frameTitle, String[] values){
        this(frameTitle);
        this.values = values;

        inputTitle.setText(values[0]);
        inputContents.setText(values[1]);
        inputUser.setText(values[2]);
    }

    public String[] getValues(){
        return values;
    }

    public void setValues(String[] values){
        this.values = values;
    }

    public JButton getEnterButton(){
        return enterButton;
    }

    public void setEnterButton(JButton enterButton){
        this.enterButton = enterButton;
    }

    public void updateValues(){
        values[0] = inputTitle.getText();
        values[1] = inputContents.getText();
        values[2] = inputUser.getText();
    }
}
