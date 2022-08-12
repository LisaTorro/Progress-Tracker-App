// Reviewed on 08/12/2022 at 10:57AM

package ProgressTracker.Panels;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import ProgressTracker.*;

public class NotePanel extends JPanel{
    
    private MyFrame myFrame;
    private JButton title = new JButton();
    private JButton contents = new JButton();
    private JButton user = new JButton();
    private JButton leftButton = new JButton("<==");
    private JButton rightButton = new JButton("==>");
    private Border buttonBorder = BorderFactory.createEmptyBorder();
    private int columnNumber;
    private int noteNumber;

    public NotePanel(MyFrame myFrame, int columnNumber, int noteNumber){
        this.myFrame = myFrame;
        this.columnNumber = columnNumber;
        this.noteNumber = noteNumber;
        setLayout(new BorderLayout());
        setPreferredSize(getMyFrame().getSmallDimension());
        int horizontalAlignment = JLabel.CENTER;
        title.setHorizontalAlignment(horizontalAlignment);
        contents.setHorizontalAlignment(horizontalAlignment);
        user.setHorizontalAlignment(horizontalAlignment);
        leftButton.setBorder(buttonBorder);
        rightButton.setBorder(buttonBorder);
        title.setBorder(buttonBorder);
        contents.setBorder(buttonBorder);
        user.setBorder(buttonBorder);
        //////////////////////////////////////////////////
        getLeftButton().addActionListener(myFrame);     //
        getRightButton().addActionListener(myFrame);    //
        getTitle().addActionListener(myFrame);          // <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
        getContents().addActionListener(myFrame);       //
        getUser().addActionListener(myFrame);           //
        //////////////////////////////////////////////////
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
        leftButton.setBackground(noteColor);
        rightButton.setBackground(noteColor);
        title.setBackground(noteColor);
        contents.setBackground(noteColor);
        user.setBackground(noteColor);
    }

    public void updateFonts(){
        Font noteFont = getMyFrame().getPalette().getButtonFont();
        leftButton.setFont(noteFont);
        rightButton.setFont(noteFont);
        title.setFont(noteFont);
        contents.setFont(noteFont);
        user.setFont(noteFont);
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