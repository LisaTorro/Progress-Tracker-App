/*
 * Written by:          Thomas Williams
 * Last Updated:        08/18/2022, at 11:59AM(PT)
 * Version:             1.0
 * Coding Module ID(s): 2.1, 2.2, 2.3, 7.1, 11.1, 11.2
 */

 // Maybe I was wrong for not having rowCount and smallNoteCount

package ProgressTracker.ProgressTracker;

import java.awt.*;
import java.util.*;
import javax.swing.*;
import ProgressTracker.*;

public class ToDoPanel extends FivePanel{

    private LinkedList<RowPanel>    rowPanels = new LinkedList<>();
    private LinkedList<JButton> southButtons = new LinkedList<>();

    public ToDoPanel(MyFrame myFrame){
        super(myFrame);
        int rowCount = getMyFrame().getRowCount();
        getCenterPanel().setLayout(new GridLayout(rowCount, 1, 10, 10));
        for(int counter = 0; counter < rowCount; counter++){
            rowPanels.add(new RowPanel(myFrame, counter, 0));
            getCenterPanel().add(rowPanels.get(counter));
        }
        getSouthPanel().setLayout(new GridLayout(1, 6, 10, 10));
        String[] southButtonStrings = {"", "To Do Panel", "Board Panel", "Completed Panel", "Settings Panel", ""};
        for(int counter = 0; counter < 6; counter++){            
            southButtons.add(new JButton(southButtonStrings[counter]));
            southButtons.get(counter).setPreferredSize(getMyFrame().getSmallDimension());
            getSouthPanel().add(southButtons.get(counter));
            if(counter != 0 && counter != 5){
                southButtons.get(counter).addActionListener(myFrame);
            } else {
                southButtons.get(counter).setEnabled(false);
                southButtons.get(counter).setVisible(false);
            }
        }
        updatePaint();
        updateFonts();
    }

    public void updatePaint(){
        super.updatePaint();
        Color rowColor = getMyFrame().getPalette().getColumnPanelsColor();
        int rowCount = getMyFrame().getRowCount();
        for(int counter = 0; counter < rowCount; counter++){
            rowPanels.get(counter).setBackground(rowColor);
            rowPanels.get(counter).updatePaint();
        }
        for(int counter = 0; counter < 6; counter++){
            southButtons.get(counter).setBackground(getMyFrame().getPalette().getSouthButtonColor());
        }
    }

    public void updateFonts(){
        int rowCount = getMyFrame().getRowCount();
        for(int counter = 0; counter < rowCount; counter++){
            rowPanels.get(counter).updateFonts();
        }
        for(int counter = 0; counter < 6; counter++){
            southButtons.get(counter).setFont(getMyFrame().getPalette().getButtonFont());
        }
    }

    public void updateBorders(){

    }

    public void updateNotes(){
        int rowCount = getMyFrame().getRowCount();
        for(int counter = 0; counter < rowCount; counter++){
            rowPanels.get(counter).updateNotes();
        }
    }

    public void updateQuantities(){

    }

    public LinkedList<RowPanel> getRowPanels() {
        return rowPanels;
    }

    public void setRowPanels(LinkedList<RowPanel> rowPanels) {
        this.rowPanels = rowPanels;
    }

    public LinkedList<JButton> getSouthButtons() {
        return southButtons;
    }

    public void setSouthButtons(LinkedList<JButton> southButtons) {
        this.southButtons = southButtons;
    }
}