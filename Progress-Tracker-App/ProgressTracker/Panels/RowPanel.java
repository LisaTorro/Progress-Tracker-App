package ProgressTracker.Panels;

import javax.swing.*;
import ProgressTracker.*;

public class RowPanel extends JPanel{

    MyFrame myFrame;
    Records records;
    int rowNumber;

    public RowPanel(MyFrame myFrame, Records records, int rowNumber){
        this.myFrame = myFrame;
        this.records = records;
        this.rowNumber = rowNumber;
    }
    
}