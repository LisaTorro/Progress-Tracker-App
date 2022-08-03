// Reviewed on 08/03/2022 at 12:56PM
package ProgressTracker.Panels;

import java.awt.*;
import javax.swing.*;
import ProgressTracker.*;

public class RowPanel extends JPanel{

    private MyFrame myFrame;
    private Records records;
    private int rowNumber;
    private JLabel title = new JLabel();
    private JLabel contents = new JLabel();
    private JLabel user = new JLabel();
    private JButton editButton = new JButton("Edit");
    private JButton functionButton = new JButton("");

    public RowPanel(MyFrame myFrame, Records records, int rowNumber){
        this.myFrame = myFrame;
        this.records = records;
        this.rowNumber = rowNumber;
        setLayout(new GridLayout(1, 3, 10, 10));
        editButton.addActionListener(myFrame);
        functionButton.addActionListener(myFrame);
        add(title);
        add(contents);
        add(user);
        add(editButton);
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

    public JLabel getTitle() {
        return title;
    }

    public void setTitle(JLabel title) {
        this.title = title;
    }
    
    public JLabel getContents() {
        return contents;
    }

    public void setContents(JLabel contents) {
        this.contents = contents;
    }

    public JLabel getUser() {
        return user;
    }

    public void setUser(JLabel user) {
        this.user = user;
    }

    public JButton getEditButton() {
        return editButton;
    }

    public void setEditButton(JButton editButton) {
        this.editButton = editButton;
    }

    public JButton getFunctionButton() {
        return functionButton;
    }

    public void setFunctionButton(JButton functionButton) {
        this.functionButton = functionButton;
    }
}