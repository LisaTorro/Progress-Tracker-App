package ProgressTracker;

import java.awt.*;
import java.util.*;

public class BoardPanel extends FivePanel{

    private LinkedList<ColumnPanel> columnPanels = new LinkedList<>();
    private int columnCount;

    public BoardPanel(MyFrame myFrame, int columnCount) {
        super(myFrame);
        this.columnCount = columnCount;

        getCenterPanel().setLayout(new GridLayout(1, 4, 10, 10));
        for(int counter = 0; counter < columnCount; counter++){
            columnPanels.add(new ColumnPanel());
            columnPanels.get(counter).setLayout(new GridLayout(4, 1, 10, 10));
            columnPanels.get(counter).setBackground(palette.getColumnPanelsColors().get(counter));
            getCenterPanel().add(columnPanels.get(counter));
        }
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
}