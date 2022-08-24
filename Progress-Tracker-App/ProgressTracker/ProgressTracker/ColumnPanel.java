/*
 * Written by:          Thomas Williams
 * Last Updated:        08/18/2022, at 1:43PM(PT)
 * Version:             1.1
 * Coding Module ID(s): 3.1, 3.2, 3.3, 4.1, 4.2, 5.1, 5.2, 6.1, 6.2, 7.2, 7.3, 10.1, 11.1, 11.2
 */

package ProgressTracker.ProgressTracker;

import java.awt.*;
import java.util.*;
import javax.swing.*;
import ProgressTracker.*;

public class ColumnPanel extends JPanel{

    private MyFrame myFrame;
    private JPanel columnSubPanel = new JPanel();
    private JLabel columnLabel = new JLabel();
    private LinkedList<NotePanel>   notePanels = new LinkedList<>();
    private int columnNumber;

    public ColumnPanel(MyFrame myFrame,int columnNumber){
        setMyFrame(myFrame);
        setColumnNumber(columnNumber);
        int noteCount = getMyFrame().getNoteCount();

        setLayout(new BorderLayout());
        columnLabel.setText("Column " + (columnNumber + 1));
        add(columnLabel, BorderLayout.NORTH);
        add(columnSubPanel, BorderLayout.CENTER);

        columnSubPanel.setLayout(new GridLayout(noteCount, 1, 10, 10));
        for(int counter = 0; counter < noteCount; counter++){
            notePanels.add(new NotePanel(myFrame, columnNumber, counter));
            columnSubPanel.add(notePanels.get(counter));
        }
        updatePaint();
        updateFonts();
    }

    public void updatePaint(){
        columnSubPanel.setBackground(getMyFrame().getPalette().getColumnPanelsColor());
        int noteCount = getMyFrame().getNoteCount();
        for(int counter = 0; counter < noteCount; counter++){
            notePanels.get(counter).updatePaint();
        }
    }

    public void updateFonts(){
        columnLabel.setFont(getMyFrame().getPalette().getLabelsFont());
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

    public JPanel getColumnSubPanel() {
        return columnSubPanel;
    }

    public void setColumnSubPanel(JPanel columnSubPanel) {
        this.columnSubPanel = columnSubPanel;
    }

    public JLabel getColumnLabel() {
        return columnLabel;
    }

    public void setColumnLabel(JLabel columnLabel) {
        this.columnLabel = columnLabel;
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