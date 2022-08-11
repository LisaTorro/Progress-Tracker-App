// Reviewed on 08/03/2022 at 12:42PM
// Seems to function correctly in its current role as a placeholder.

package ProgressTracker.Panels;

import java.awt.*;
import javax.swing.*;
import ProgressTracker.*;

public class LoginPanel extends FivePanel{

    String userFileName = "userInfo.txt";
    private MyFrame myFrame;
    private JTextArea username = new JTextArea();
    private JTextArea password = new JTextArea();
    private JButton enterButton = new JButton("Enter");
    private LoginHandler loginHandler = new LoginHandler(userFileName);


    public LoginPanel(MyFrame myFrame){
        super(myFrame);
        getCenterPanel().setLayout(new GridLayout(3, 1, 10, 10));
        getCenterPanel().add(username);
        getCenterPanel().add(password);
        getCenterPanel().add(enterButton);
        enterButton.addActionListener(myFrame);
    }
    
    public MyFrame getMyFrame() {
        return myFrame;
    }

    public void setMyFrame(MyFrame myFrame) {
        this.myFrame = myFrame;
    }
    
    public JTextArea getUsername() {
        return username;
    }

    public void setUsername(JTextArea username) {
        this.username = username;
    }

    public JTextArea getPassword() {
        return password;
    }

    public void setPassword(JTextArea password) {
        this.password = password;
    }

    public JButton getEnterButton() {
        return enterButton;
    }

    public void setEnterButton(JButton enterButton) {
        this.enterButton = enterButton;
    }

    public LoginHandler getLoginHandler() {
        return loginHandler;
    }

    public void setLoginHandler(LoginHandler loginHandler) {
        this.loginHandler = loginHandler;
    }
}