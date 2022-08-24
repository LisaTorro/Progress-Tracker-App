/*
 * Written by:          Thomas Williams
 * Last Updated:        08/18/2022, at 11:59AM(PT)
 * Version:             1.0
 * Coding Module ID(s): 3.1, 3.2, 3.3, 4.1, 4.2, 5.1, 5.2, 6.1, 6.2, 7.2, 7.3, 7.4, 8.1, 10.1, 12.1, 12.2
 */

package ProgressTracker.ProgressTracker;

import java.awt.*;
import java.util.*;
import javax.swing.*;
import ProgressTracker.*;

public class BoardPanel extends FivePanel{

    private LinkedList<ColumnPanel> columnPanels = new LinkedList<>();
    private LinkedList<JButton> westButtons = new LinkedList<>(),
                                southButtons = new LinkedList<>();

    public BoardPanel(MyFrame myFrame) {
        super(myFrame);
        int columnCount = getMyFrame().getColumnCount();
        getCenterPanel().setLayout(new GridLayout(1, columnCount, 10, 10));
        for(int counter = 0; counter < columnCount; counter++){
            columnPanels.add(new ColumnPanel(myFrame,counter));
            getCenterPanel().add(columnPanels.get(counter));
        }
        getWestPanel().setLayout(new GridLayout(3, 1, 10, 10));
        String[] westButtonStrings = {"New", "Save", "Load"};
        for(int counter = 0; counter < 3; counter++){
            westButtons.add(new JButton(westButtonStrings[counter]));
            westButtons.get(counter).setPreferredSize(getMyFrame().getSmallDimension());
            getWestPanel().add(westButtons.get(counter));
            westButtons.get(counter).addActionListener(myFrame);
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
        Color columnColor = getMyFrame().getPalette().getColumnPanelsColor();
        int columnCount = getMyFrame().getColumnCount();
        for(int counter = 0; counter < columnCount; counter++){
            columnPanels.get(counter).setBackground(columnColor);
            columnPanels.get(counter).updatePaint();
        }
        for(int counter = 0; counter < 3; counter++){
            westButtons.get(counter).setBackground(getMyFrame().getPalette().getSouthButtonColor());
        }
        for(int counter = 0; counter < 6; counter++){
            southButtons.get(counter).setBackground(getMyFrame().getPalette().getSouthButtonColor());
        }
    }

    public void updateFonts(){
        int columnCount = getMyFrame().getColumnCount();
        for(int counter = 0; counter < columnCount; counter++){
            columnPanels.get(counter).updateFonts();
        }
        for(int counter = 0; counter < 3; counter++){
            westButtons.get(counter).setFont(getMyFrame().getPalette().getButtonFont());
        }
        for(int counter = 0; counter < 6; counter++){
            southButtons.get(counter).setFont(getMyFrame().getPalette().getButtonFont());
        }
    }

    public void updateBorders(){

    }

    public void updateNotes(){
        int columnCount = getMyFrame().getColumnCount();
        for(int counter = 0; counter < columnCount; counter++){
            columnPanels.get(counter).updateNotes();
        }
    }

    public void updateQuantities(){

    }

    /*
    public void updateColumnCount(){
        columnPanels = new LinkedList<>();
        int columnCount = getMyFrame().getColumnCount();
        int noteCount = getMyFrame().getNoteCount();
        setCenterPanel(new JPanel());
        getCenterPanel().setLayout(new GridLayout(1, columnCount, 10, 10));
        for(int counter = 0; counter < columnCount; counter++){
            columnPanels.add(new ColumnPanel(getMyFrame(),counter));
            columnPanels.get(counter).setLayout(new GridLayout(noteCount, 1, 10, 10));
            getCenterPanel().add(columnPanels.get(counter));
        }
    }
    */

    public LinkedList<ColumnPanel> getColumnPanels() {
        return columnPanels;
    }

    public void setColumnPanels(LinkedList<ColumnPanel> columnPanels) {
        this.columnPanels = columnPanels;
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