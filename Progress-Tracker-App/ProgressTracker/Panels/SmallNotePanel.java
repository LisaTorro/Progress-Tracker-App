/*
 * Written by:      Thomas Williams
 * Last Updated:    08/18/2022, at 1:46PM(PT)
 * Version:         1.0
 */

package ProgressTracker.Panels;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import ProgressTracker.*;

public class SmallNotePanel extends JPanel{

    private MyFrame myFrame;
    private JButton title = new JButton(),
                    contents = new JButton(),
                    user = new JButton(),
                    functionButton = new JButton();
    private Border buttonBorder = BorderFactory.createEmptyBorder();
    private int rowNumber;
    private int screenNumber; // 0 for ToDo and 1 for Completed

    public SmallNotePanel(MyFrame myFrame, int rowNumber, int screenNumber) {
        setMyFrame(myFrame);
        setRowNumber(rowNumber);
        setScreenNumber(screenNumber);
        setLayout(new GridLayout(1, 4, 10, 10));
        setPreferredSize(getMyFrame().getSmallDimension());
        //
        //
        //
        //
        getTitle().setBorder(buttonBorder);
        getContents().setBorder(buttonBorder);
        getUser().setBorder(buttonBorder);
        getFunctionButton().setBorder(buttonBorder);
        //
        getTitle().addActionListener(myFrame);
        getContents().addActionListener(myFrame);
        getUser().addActionListener(myFrame);
        getFunctionButton().addActionListener(myFrame);
        //
        add(title);
        add(contents);
        add(user);
        add(functionButton);
        //
        updatePaint();
        updateFonts();
    }

    public void updatePaint(){
        Color smallNoteColor = getMyFrame().getPalette().getNotePanelsColor();
        setBackground(smallNoteColor);
        getTitle().setBackground(smallNoteColor);
        getContents().setBackground(smallNoteColor);
        getUser().setBackground(smallNoteColor);
        getFunctionButton().setBackground(smallNoteColor);
    }

    public void updateFonts(){
        Font buttonFont = getMyFrame().getPalette().getButtonFont();
        getTitle().setFont(buttonFont);
        getContents().setFont(buttonFont);
        getUser().setFont(buttonFont);
        getFunctionButton().setFont(buttonFont);
    }

    public void updateBorders(){
        
    }

    public void updateNotes(){
        int outterIndex = screenNumber * (getMyFrame().getColumnCount() + 1);// 0 * # = 0, so if screenNumber == 0 this will equal 0
        Task task = getMyFrame().getRecords().retrieveTask(outterIndex, rowNumber);
        if(task != null){
            getTitle().setText(task.getTitle());
            getContents().setText(task.getContents());
            getUser().setText(task.getUser());
            if(screenNumber == 0){
                getFunctionButton().setText("==>");
            } else {
                getFunctionButton().setText("<==");
            }
            setVisible(true);
        } else {
            setVisible(false);
        }

    }
    
    public MyFrame getMyFrame() {
        return myFrame;
    }

    public void setMyFrame(MyFrame myFrame) {
        this.myFrame = myFrame;
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

    public JButton getFunctionButton() {
        return functionButton;
    }

    public void setFunctionButton(JButton functionButton) {
        this.functionButton = functionButton;
    }

    public Border getButtonBorder() {
        return buttonBorder;
    }

    public void setButtonBorder(Border buttonBorder) {
        this.buttonBorder = buttonBorder;
    }
    
    public int getRowNumber() {
        return rowNumber;
    }

    public void setRowNumber(int rowNumber) {
        this.rowNumber = rowNumber;
    }

    public int getScreenNumber() {
        return screenNumber;
    }

    public void setScreenNumber(int screenNumber) {
        this.screenNumber = screenNumber;
    }
}