package ProgressTracker;

import java.awt.*;
import java.util.*;
import javax.swing.*;
import ProgressTracker.Panels.*;

public class CompletedPanel extends FivePanel{

    LinkedList<RowPanel> rowPanels = new LinkedList<>();
    Records records;
    int rowCount;
    LinkedList<JButton> southButtons = new LinkedList<>();
    Palette palette = new Palette();
    Dimension panelDimension = new Dimension(100, 100);

    public CompletedPanel(MyFrame myFrame, Records records, int rowCount){
        super(myFrame);
        this.records = records;
        this.rowCount = rowCount;

        
        getCenterPanel().setLayout(new GridLayout(16, 1, 10, 10));
        for(int counter = 0; counter < rowCount; counter++){
            rowPanels.add(new RowPanel(myFrame, records, counter));
            rowPanels.get(counter).setLayout(new GridLayout(0, 3, 10, 10));
            rowPanels.get(counter).setBackground(palette.getRowPanelsColors().get(counter));
            getCenterPanel().add(rowPanels.get(counter));
        }

        
        getSouthPanel().setLayout(new GridLayout(1, 3, 10, 10));
        southButtons.add(new JButton("Other Frame"));
        southButtons.get(0).addActionListener(myFrame);
        southButtons.get(0).setBackground(Color.CYAN);
        southButtons.get(0).setPreferredSize(panelDimension);
        getSouthPanel().add(southButtons.get(0));;

        getNorthPanel().setBackground(Color.BLUE);
    }
    
    public LinkedList<JButton> getSouthButtons() {
        return southButtons;
    }

    public void setSouthButtons(LinkedList<JButton> southButtons) {
        this.southButtons = southButtons;
    }
    
}