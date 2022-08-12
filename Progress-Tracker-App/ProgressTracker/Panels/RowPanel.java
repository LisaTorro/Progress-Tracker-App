// Reviewed on 08/12/2022 at 11:16AM

package ProgressTracker.Panels;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import ProgressTracker.*;

public class RowPanel extends JPanel{

    private MyFrame myFrame;
    private int rowNumber;
    private JButton title = new JButton();
    private JButton contents = new JButton();
    private JButton user = new JButton();
    private JButton functionButton = new JButton("");

    public RowPanel(MyFrame myFrame, int rowNumber){
        this.myFrame = myFrame;
        this.rowNumber = rowNumber;
        setLayout(new GridLayout(1, 4, 10, 10));
        title.addActionListener(myFrame);
        contents.addActionListener(myFrame);
        user.addActionListener(myFrame);
        functionButton.addActionListener(myFrame);
        Border invisibleBorder = BorderFactory.createEmptyBorder();
        title.setBorder(invisibleBorder);
        contents.setBorder(invisibleBorder);
        user.setBorder(invisibleBorder);
        functionButton.setBorder(invisibleBorder);
        add(title);
        add(contents);
        add(user);
        add(functionButton);
        updatePaint();
        updateFonts();
    }

    public void updatePaint(){
        Color rowColor = getMyFrame().getPalette().getNotePanelsColor();
        getTitle().setBackground(rowColor);
        getContents().setBackground(rowColor);
        getUser().setBackground(rowColor);
        getFunctionButton().setBackground(rowColor);
    }

    public void updateFonts(){
        Font buttonFont = getMyFrame().getPalette().getButtonFont();
        getTitle().setFont(buttonFont);
        getContents().setFont(buttonFont);
        getUser().setFont(buttonFont);
        getFunctionButton().setFont(buttonFont);
    }

    public MyFrame getMyFrame() {
        return myFrame;
    }

    public void setMyFrame(MyFrame myFrame) {
        this.myFrame = myFrame;
    }

    public int getRowNumber() {
        return rowNumber;
    }

    public void setRowNumber(int rowNumber) {
        this.rowNumber = rowNumber;
    }

    public JButton getTitle() {
        return title;
    }

    public void setTitle(JButton title) {
        this.title = title;
    }
    
    public JButton getContents() {
        return contents;
    }

    public void setContents(JButton contents) {
        this.contents = contents;
    }

    public JButton getUser() {
        return user;
    }

    public void setUser(JButton user) {
        this.user = user;
    }

    public JButton getFunctionButton() {
        return functionButton;
    }

    public void setFunctionButton(JButton functionButton) {
        this.functionButton = functionButton;
    }
}