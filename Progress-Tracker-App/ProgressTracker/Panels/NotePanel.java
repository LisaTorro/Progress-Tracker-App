/*
 * Written by:          Thomas Williams
 * Last Updated:        08/18/2022, at 1:46PM(PT)
 * Version:             1.0
 * Coding Module ID(s): 
 */

package ProgressTracker.Panels;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import ProgressTracker.*;

public class NotePanel extends JPanel{
    
    private MyFrame myFrame;
    private JButton title = new JButton(),
                    contents = new JButton(),
                    user = new JButton(),
                    leftButton = new JButton("<=="),
                    rightButton = new JButton("==>");
    private Border  buttonBorder = BorderFactory.createEmptyBorder();
    private int columnNumber,
                noteNumber;

    public NotePanel(MyFrame myFrame, int columnNumber, int noteNumber){
        setMyFrame(myFrame);
        setColumnNumber(columnNumber);
        setNoteNumber(noteNumber);
        setLayout(new BorderLayout());
        setPreferredSize(getMyFrame().getSmallDimension());
        int horizontalAlignment = JLabel.CENTER;
        getTitle().setHorizontalAlignment(horizontalAlignment);
        getContents().setHorizontalAlignment(horizontalAlignment);
        getUser().setHorizontalAlignment(horizontalAlignment);
        getLeftButton().setBorder(buttonBorder);
        getRightButton().setBorder(buttonBorder);
        getTitle().setBorder(buttonBorder);
        getContents().setBorder(buttonBorder);
        getUser().setBorder(buttonBorder);
        getLeftButton().addActionListener(myFrame);
        getRightButton().addActionListener(myFrame);
        getTitle().addActionListener(myFrame);
        getContents().addActionListener(myFrame);
        getUser().addActionListener(myFrame);
        add(title, BorderLayout.NORTH);
        add(contents, BorderLayout.CENTER);
        add(user, BorderLayout.SOUTH);
        add(leftButton, BorderLayout.WEST);
        add(rightButton, BorderLayout.EAST);
        updatePaint();
        updateFonts();
    }

    public void updatePaint(){
        Color noteColor = getMyFrame().getPalette().getNotePanelsColor();
        setBackground(noteColor);
        getLeftButton().setBackground(noteColor);
        getRightButton().setBackground(noteColor);
        getTitle().setBackground(noteColor);
        getContents().setBackground(noteColor);
        getUser().setBackground(noteColor);
    }

    public void updateFonts(){
        Font noteFont = getMyFrame().getPalette().getButtonFont();
        getLeftButton().setFont(noteFont);
        getRightButton().setFont(noteFont);
        getTitle().setFont(noteFont);
        getContents().setFont(noteFont);
        getUser().setFont(noteFont);
    }

    public void updateBorders(){

    }

    public void updateNotes(){
        Task task = getMyFrame().getRecords().retrieveTask((columnNumber + 1), noteNumber);
        if(task != null){
            getTitle().setText(task.getTitle());
            getContents().setText(task.getContents());
            getUser().setText(task.getUser());
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
    
    public JButton getLeftButton() {
        return leftButton;
    }

    public void setLeftButton(JButton leftButton) {
        this.leftButton = leftButton;
    }

    public JButton getRightButton() {
        return rightButton;
    }

    public void setRightButton(JButton rightButton) {
        this.rightButton = rightButton;
    }

    public Border getButtonBorder() {
        return buttonBorder;
    }

    public void setButtonBorder(Border buttonBorder) {
        this.buttonBorder = buttonBorder;
    }

    public int getColumnNumber() {
        return columnNumber;
    }

    public void setColumnNumber(int columnNumber) {
        this.columnNumber = columnNumber;
    }

    public int getNoteNumber() {
        return noteNumber;
    }

    public void setNoteNumber(int noteNumber) {
        this.noteNumber = noteNumber;
    }
}