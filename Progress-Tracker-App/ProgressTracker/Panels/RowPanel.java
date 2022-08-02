// Reviewed on 08/02/2022 at 10:16 AM

package ProgressTracker.Panels;

import javax.swing.*;
import ProgressTracker.*;

public class RowPanel extends JPanel{

    private MyFrame myFrame;
    private Records records;
    private int rowNumber;

    public RowPanel(MyFrame myFrame, Records records, int rowNumber){
        this.myFrame = myFrame;
        this.records = records;
        this.rowNumber = rowNumber;
    }

    public MyFrame getMyFrame() {
        return myFrame;
    }

    public void setMyFrame(MyFrame myFrame) {
        this.myFrame = myFrame;
    }

    public Records getRecords() {
        return records;
    }

    public void setRecords(Records records) {
        this.records = records;
    }

    public int getRowNumber() {
        return rowNumber;
    }

    public void setRowNumber(int rowNumber) {
        this.rowNumber = rowNumber;
    }
}