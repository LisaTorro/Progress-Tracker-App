// Reviewed on 08/02/2022 at 10:11AN AM
// Seems to function correctly in its current role as a placeholder.

package ProgressTracker.Panels;

import java.awt.*;
import javax.swing.*;

import ProgressTracker.*;

public class LoginPanel extends FivePanel{

    MyFrame myFrame;
    JTextArea username;
    JTextArea password;
    JButton enterButton;

    public LoginPanel(MyFrame myFrame){
        super(myFrame);

        getCenterPanel().setLayout(new GridLayout(3, 1, 10, 10));

        username = new JTextArea();
        password = new JTextArea();
        enterButton = new JButton("Enter");

        getCenterPanel().add(username);
        getCenterPanel().add(password);
        getCenterPanel().add(enterButton);
        
        enterButton.addActionListener(myFrame);
    }

    public JButton getEnterButton() {
        return enterButton;
    }

    public void setEnterButton(JButton enterButton) {
        this.enterButton = enterButton;
    }
}