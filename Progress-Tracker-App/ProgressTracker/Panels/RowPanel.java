/*
 * Written by:      Thomas Williams
 * Last Updated:    08/18/2022, at 1:46PM(PT)
 * Version:         1.0
 */

package ProgressTracker.Panels;

import java.awt.*;
//
import javax.swing.*;
import ProgressTracker.*;

public class RowPanel extends JPanel{

    private MyFrame myFrame;
    private SmallNotePanel smallNotePanel;
    private int rowNumber;
    private int screenNumber;

    public RowPanel(MyFrame myFrame, int rowNumber, int screenNumber){
        setMyFrame(myFrame);
        setRowNumber(rowNumber);
        setScreenNumber(screenNumber);
        setLayout(new GridLayout(1, 1, 10, 10));
        //
        setSmallNotePanel(new SmallNotePanel(myFrame, rowNumber, screenNumber));
        add(smallNotePanel);
        //
        updatePaint();
        updateFonts();
    }

    public void updatePaint(){
        smallNotePanel.updatePaint();
    }

    public void updateFonts(){
        smallNotePanel.updateFonts();
    }

    public void updateBorders(){

    }

    public void updateNotes(){
        smallNotePanel.updateNotes();
    }

    public MyFrame getMyFrame() {
        return myFrame;
    }

    public void setMyFrame(MyFrame myFrame) {
        this.myFrame = myFrame;
    }
    
    public SmallNotePanel getSmallNotePanel() {
        return smallNotePanel;
    }

    public void setSmallNotePanel(SmallNotePanel smallNotePanel) {
        this.smallNotePanel = smallNotePanel;
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