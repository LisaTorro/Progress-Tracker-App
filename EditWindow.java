import java.awt.*;
import javax.swing.*;

public class EditWindow extends JFrame{

    String frameTitle;
    JPanel screenPanel = new JPanel(new GridLayout(5, 1, 10, 10));
    JPanel buffer = new JPanel();
    JTextField inputTitle = new JTextField();
    JTextField inputContents = new JTextField();
    JTextField inputUser = new JTextField();
    JButton enterButton = new JButton("Enter");
    String[] values = new String[3];
    
    EditWindow(String frameTitle){
        this.frameTitle = frameTitle;

        buffer.setPreferredSize(new Dimension(400, 5));

        screenPanel.add(buffer);
        screenPanel.add(inputTitle);
        screenPanel.add(inputContents);
        screenPanel.add(inputUser);
        screenPanel.add(enterButton);

        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setTitle(frameTitle);
        setSize(400, 400);
        setVisible(true);
        setResizable(false);
        this.add(screenPanel);
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