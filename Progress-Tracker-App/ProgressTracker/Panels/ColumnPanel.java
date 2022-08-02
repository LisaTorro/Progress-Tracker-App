// Reviewed on 08/02/2022 at 10:16 AM

package ProgressTracker.Panels;

import java.awt.*;
import java.util.*;
import javax.swing.*;
import ProgressTracker.*;

public class ColumnPanel extends JPanel{

    private MyFrame myFrame;
    private LinkedList<NotePanel> notePanels = new LinkedList<>();
    private int noteCount;
    private int columnNumber;
    private Palette palette = new Palette();
    private Records records;

    public ColumnPanel(MyFrame myFrame, Records records, int columnNumber, int noteCount){
        this.myFrame = myFrame;
        this.columnNumber = columnNumber;
        this.noteCount = noteCount;
        this.records = records;
        
        int notePanelsWidth = getWidth() - 20;
        int notePanelsHeight = (getHeight() - (10 * noteCount)) / noteCount;
        Dimension notePanelsDimension = new Dimension(notePanelsWidth, notePanelsHeight);
        
        for(int counter = 0; counter < 4; counter++){
            notePanels.add(new NotePanel(myFrame, records, new BorderLayout(), palette.getNotePanelsColors().get(columnNumber).get(counter), notePanelsDimension, JLabel.CENTER));
            notePanels.get(counter).getLeftButton().addActionListener(myFrame);
            notePanels.get(counter).getRightButton().addActionListener(myFrame);
            notePanels.get(counter).getBottomButton().addActionListener(myFrame);
            add(notePanels.get(counter));
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
    public int getNoteCount() {
        return noteCount;
    }

    public void setNoteCount(int noteCount) {
        this.noteCount = noteCount;
    }
    
    public int getColumnNumber() {
        return columnNumber;
    }

    public void setColumnNumber(int columnNumber) {
        this.columnNumber = columnNumber;
    }

    public Palette getPalette() {
        return palette;
    }

    public void setPalette(Palette palette) {
        this.palette = palette;
    }

    public Records getRecords() {
        return records;
    }

    public void setRecord(Records records) {
        this.records = records;
    }
}