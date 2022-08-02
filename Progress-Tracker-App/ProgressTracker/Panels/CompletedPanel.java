// Reviewed on 08/02/2022 at 9:51 AM
// Seems to function correctly in its current role as a placeholder.

package ProgressTracker.Panels;

import java.awt.*;
import java.util.*;
import javax.swing.*;
import ProgressTracker.*;

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

        /*---------------------------------------------------------------------------------------------*/
        getSouthPanel().setLayout(new GridLayout(1, 4, 10, 10));
        String[] newButtonStrings = {"Board Panel", "Completed Panel", "ToDo Panel", "Settings Panel"};
        Color[] newButtonColors = {Color.GREEN, Color.YELLOW, Color.CYAN, Color.MAGENTA};
        for(int counter = 0; counter < 4; counter++){
            southButtons.add(new JButton(newButtonStrings[counter]));
            southButtons.get(counter).addActionListener(myFrame);
            southButtons.get(counter).setBackground(newButtonColors[counter]);
            southButtons.get(counter).setPreferredSize(panelDimension);
            getSouthPanel().add(southButtons.get(counter));
        }

        getNorthPanel().setBackground(Color.BLUE);
    }
    
    public LinkedList<JButton> getSouthButtons() {
        return southButtons;
    }

    public void setSouthButtons(LinkedList<JButton> southButtons) {
        this.southButtons = southButtons;
    }
}