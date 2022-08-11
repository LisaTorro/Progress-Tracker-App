// Reviewed on 08/03/2022 at 1:27PM

package ProgressTracker.Panels;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import ProgressTracker.*;

public class NotePanel extends JPanel{
    
    private MyFrame myFrame;
    // private JPanel middlePanel = new JPanel(new BorderLayout());
    private Records records;

    // +IDEA?+
    // In the past there was a mix of JLabels and JButtons, but now I have them all as JButtons,
    // and if I continue to have things that way what I could do is have an array of JButtons
    // instead of individually named JButton variables.
    private JButton title = new JButton();
    private JButton contents = new JButton();
    private JButton user = new JButton();
    private JButton leftButton = new JButton("<==");
    private JButton rightButton = new JButton("==>");
    // private JButton bottomButton = new JButton("Edit");


    private Border buttonBorder = BorderFactory.createEmptyBorder();
    private Color color;
    private Dimension dimension;
    private int horizontalAlignment;

    public NotePanel(MyFrame myFrame, Records records, BorderLayout borderLayout, Color color, Dimension dimension, int horizontalAlignment){
        setLayout(borderLayout);
        this.myFrame = myFrame;
        this.records = records;
        this.color = color;
        this.dimension = dimension;
        this.horizontalAlignment = horizontalAlignment;

        setBackground(color);
        // middlePanel.setBackground(color);
        // bottomButton.setBackground(color);
        leftButton.setBackground(color);
        rightButton.setBackground(color);
        title.setBackground(color);
        contents.setBackground(color);
        user.setBackground(color);
        setPreferredSize(dimension);
        title.setHorizontalAlignment(horizontalAlignment);
        contents.setHorizontalAlignment(horizontalAlignment);
        user.setHorizontalAlignment(horizontalAlignment);
        leftButton.setBorder(buttonBorder);
        rightButton.setBorder(buttonBorder);
        // bottomButton.setBorder(buttonBorder);
        title.setBorder(buttonBorder);
        contents.setBorder(buttonBorder);
        user.setBorder(buttonBorder);
        // middlePanel.add(title, BorderLayout.NORTH);
        // middlePanel.add(contents, BorderLayout.CENTER);
        // middlePanel.add(user, BorderLayout.SOUTH);
        // add(middlePanel, BorderLayout.CENTER);
        add(title, BorderLayout.NORTH);
        add(contents, BorderLayout.CENTER);
        add(user, BorderLayout.SOUTH);
        add(leftButton, BorderLayout.WEST);
        add(rightButton, BorderLayout.EAST);
        // add(bottomButton, BorderLayout.SOUTH);
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

    /*
    public JPanel getMiddlePanel() {
        return middlePanel;
    }

    public void setMiddlePanel(JPanel middlePanel) {
        this.middlePanel = middlePanel;
    }
    */
    
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
    
    public JButton getLeftButton() {
        return leftButton;
    }

    public void setLeftButton(JButton leftButton) {
        this.leftButton = leftButton;
    }

    public JButton getRightButton() {
        return rightButton;
    }

    public void setRightButton(JButton rightButton) {
        this.rightButton = rightButton;
    }

    /*
    public JButton getBottomButton() {
        return bottomButton;
    }

    public void setBottomButton(JButton bottomButton) {
        this.bottomButton = bottomButton;
    }
    */

    public Border getButtonBorder() {
        return buttonBorder;
    }

    public void setButtonBorder(Border buttonBorder) {
        this.buttonBorder = buttonBorder;
    }
    
    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Dimension getDimension() {
        return dimension;
    }

    public void setDimension(Dimension dimension) {
        this.dimension = dimension;
    }
    
    public int getHorizontalAlignment() {
        return horizontalAlignment;
    }

    public void setHorizontalAlignment(int horizontalAlignment) {
        this.horizontalAlignment = horizontalAlignment;
    }
}