// Reviewed on 08/03/2022 at 12:56PM
package ProgressTracker.Panels;

import java.awt.*;
import javax.swing.*;
import ProgressTracker.*;

public class RowPanel extends JPanel{

    private MyFrame myFrame;
    private Records records;
    private int rowNumber;
    private JButton title = new JButton();
    private JButton contents = new JButton();
    private JButton user = new JButton();
    // private JButton editButton = new JButton("Edit");
    private JButton functionButton = new JButton("");

    public RowPanel(MyFrame myFrame, Records records, int rowNumber){
        this.myFrame = myFrame;
        this.records = records;
        this.rowNumber = rowNumber;
        setLayout(new GridLayout(1, 3, 10, 10));
        // editButton.addActionListener(myFrame);
        functionButton.addActionListener(myFrame);
        title.addActionListener(myFrame);
        contents.addActionListener(myFrame);
        user.addActionListener(myFrame);
        add(title);
        add(contents);
        add(user);
        // add(editButton);
        add(functionButton);
    }

    public MyFrame getMyFrame() {
        return myFrame;
    }

    public void setMyFrame(MyFrame myFrame) {
        this.myFrame = myFrame;
    }

    public Records getRecords() {
        return records;
    }

    public void setRecords(Records records) {
        this.records = records;
    }

    public int getRowNumber() {
        return rowNumber;
    }

    public void setRowNumber(int rowNumber) {
        this.rowNumber = rowNumber;
    }

    public JButton getTitle() {
        return title;
    }

    public void setTitle(JButton title) {
        this.title = title;
    }
    
    public JButton getContents() {
        return contents;
    }

    public void setContents(JButton contents) {
        this.contents = contents;
    }

    public JButton getUser() {
        return user;
    }

    public void setUser(JButton user) {
        this.user = user;
    }

    /*
    public JButton getEditButton() {
        return editButton;
    }

    public void setEditButton(JButton editButton) {
        this.editButton = editButton;
    }
    */

    public JButton getFunctionButton() {
        return functionButton;
    }

    public void setFunctionButton(JButton functionButton) {
        this.functionButton = functionButton;
    }
}