/*
 * Written by:          Thomas Williams
 * Last Updated:        08/18/2022, at 1:43PM(PT)
 * Version:             1.0
 * Coding Module ID(s): 
 */

package ProgressTracker.Panels;

import java.awt.*;
import java.util.*;
import javax.swing.*;
import ProgressTracker.*;

public class ColumnPanel extends JPanel{

    private MyFrame myFrame;
    private LinkedList<NotePanel>   notePanels = new LinkedList<>();
    private int columnNumber;

    public ColumnPanel(MyFrame myFrame,int columnNumber){
        setMyFrame(myFrame);
        setColumnNumber(columnNumber);
        int noteCount = getMyFrame().getNoteCount();
        setLayout(new GridLayout(noteCount, 1, 10, 10));
        for(int counter = 0; counter < noteCount; counter++){
            notePanels.add(new NotePanel(myFrame, columnNumber, counter));
            add(notePanels.get(counter));
        }
        updatePaint();
        updateFonts();
    }

    public void updatePaint(){
        int noteCount = getMyFrame().getNoteCount();
        for(int counter = 0; counter < noteCount; counter++){
            notePanels.get(counter).updatePaint();
        }
    }

    public void updateFonts(){
        int noteCount = getMyFrame().getNoteCount();
        for(int counter = 0; counter < noteCount; counter++){
            notePanels.get(counter).updateFonts();
        }
    }

    public void updateBorders(){

    }

    public void updateNotes(){
        int noteCount = getMyFrame().getNoteCount();
        for(int counter = 0; counter < noteCount; counter++){
            notePanels.get(counter).updateNotes();
        }
    }

    public MyFrame getMyFrame() {
        return myFrame;
    }

    public void setMyFrame(MyFrame myFrame) {
        this.myFrame = myFrame;
    }
    
    public LinkedList<NotePanel> getNotePanels() {
        return notePanels;
    }

    public void setNotePanels(LinkedList<NotePanel> notePanels) {
        this.notePanels = notePanels;
    }
    
    public int getColumnNumber() {
        return columnNumber;
    }

    public void setColumnNumber(int columnNumber) {
        this.columnNumber = columnNumber;
    }
}