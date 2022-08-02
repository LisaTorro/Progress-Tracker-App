package ProgressTracker.Panels;

import java.awt.*;
import java.util.*;
import javax.swing.*;
import ProgressTracker.*;

public class BoardPanel extends FivePanel{

    private LinkedList<ColumnPanel> columnPanels = new LinkedList<>();
    private int columnCount, noteCount;
    private Records records;
    private LinkedList<JButton> westButtons = new LinkedList<>();
    private LinkedList<JButton> southButtons = new LinkedList<>();
    private Dimension panelDimension = new Dimension(100, 100);
    
    public BoardPanel(MyFrame myFrame, Records records, int columnCount, int noteCount) {
        super(myFrame);
        this.records = records;
        this.columnCount = columnCount;
        this.noteCount = noteCount;

        getCenterPanel().setLayout(new GridLayout(1, 4, 10, 10));
        for(int counter = 0; counter < columnCount; counter++){
            columnPanels.add(new ColumnPanel(myFrame, records, counter, noteCount));
            columnPanels.get(counter).setLayout(new GridLayout(4, 1, 10, 10));
            columnPanels.get(counter).setBackground(palette.getColumnPanelsColors().get(counter));
            getCenterPanel().add(columnPanels.get(counter));
        }

        getWestPanel().setLayout(new GridLayout(3, 1, 10, 10));
        String[] buttonStrings = {"New", "Save", "Load"};
        Color[] buttonColors = {Color.PINK, Color.ORANGE, Color.MAGENTA};
        for(int counter = 0; counter < 3; counter++){
            westButtons.add(new JButton(buttonStrings[counter]));
            westButtons.get(counter).addActionListener(myFrame);
            westButtons.get(counter).setBackground(buttonColors[counter]);
            westButtons.get(counter).setPreferredSize(panelDimension);
            getWestPanel().add(westButtons.get(counter));
        }

        getSouthPanel().setLayout(new GridLayout(1, 3, 10, 10));
        southButtons.add(new JButton("ToDoPanel"));
        southButtons.add(new JButton("CompletedPanel"));
        southButtons.get(0).addActionListener(myFrame);
        southButtons.get(1).addActionListener(myFrame);
        southButtons.get(0).setBackground(Color.GREEN);
        southButtons.get(1).setBackground(Color.YELLOW);
        southButtons.get(0).setPreferredSize(panelDimension);
        southButtons.get(1).setPreferredSize(panelDimension);
        getSouthPanel().add(southButtons.get(0));
        getSouthPanel().add(southButtons.get(1));
    }
    
    public LinkedList<ColumnPanel> getColumnPanels() {
        return columnPanels;
    }

    public void setColumnPanels(LinkedList<ColumnPanel> columnPanels) {
        this.columnPanels = columnPanels;
    }

    public int getColumnCount() {
        return columnCount;
    }

    public void setColumnCount(int columnCount) {
        this.columnCount = columnCount;
    }

    public int getNoteCount() {
        return noteCount;
    }

    public void setNoteCount(int noteCount) {
        this.noteCount = noteCount;
    }

    public Records getRecords() {
        return records;
    }
    public void setRecords(Records records) {
        this.records = records;
    }

    public LinkedList<JButton> getWestButtons() {
        return westButtons;
    }

    public void setWestButtons(LinkedList<JButton> westButtons) {
        this.westButtons = westButtons;
    }

    public LinkedList<JButton> getSouthButtons() {
        return southButtons;
    }

    public void setSouthButtons(LinkedList<JButton> southButtons) {
        this.southButtons = southButtons;
    }
}