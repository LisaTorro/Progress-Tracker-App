package ProgressTracker.Panels;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

import ProgressTracker.*;

public class NotePanel extends JPanel{
    
    private MyFrame myFrame;
    private Records records;
    private JPanel middlePanel = new JPanel(new BorderLayout());
    private JLabel title = new JLabel();
    private JLabel contents = new JLabel();
    private JLabel user = new JLabel();
    private JButton leftButton = new JButton("<==");
    private JButton rightButton = new JButton("==>");
    private JButton bottomButton = new JButton("Edit");
    private Border buttonBorder = BorderFactory.createEmptyBorder();
    private Color color;
    private Dimension dimension;
    private int horizontalAlignment;

    public NotePanel(MyFrame myFrame, Records records, BorderLayout borderLayout, Color color, Dimension dimension, int horizontalAlignment){
        // super(borderLayout);
        setLayout(borderLayout);
        this.myFrame = myFrame;
        this.records = records;
        this.color = color;
        this.dimension = dimension;
        this.horizontalAlignment = horizontalAlignment;

        setBackground(color);
        middlePanel.setBackground(color);
        bottomButton.setBackground(color);
        leftButton.setBackground(color);
        rightButton.setBackground(color);

        setPreferredSize(dimension);

        title.setHorizontalAlignment(horizontalAlignment);
        contents.setHorizontalAlignment(horizontalAlignment);
        user.setHorizontalAlignment(horizontalAlignment);

        leftButton.setBorder(buttonBorder);
        rightButton.setBorder(buttonBorder);
        bottomButton.setBorder(buttonBorder);

        middlePanel.add(title, BorderLayout.NORTH);
        middlePanel.add(contents, BorderLayout.CENTER);
        middlePanel.add(user, BorderLayout.SOUTH);
        add(middlePanel, BorderLayout.CENTER);
        add(leftButton, BorderLayout.WEST);
        add(rightButton, BorderLayout.EAST);
        add(bottomButton, BorderLayout.SOUTH);
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

    public JPanel getMiddlePanel() {
        return middlePanel;
    }

    public void setMiddlePanel(JPanel middlePanel) {
        this.middlePanel = middlePanel;
    }
    
    public JLabel getTitle() {
        return title;
    }

    public void setTitle(JLabel title) {
        this.title = title;
    }

    public JLabel getContents() {
        return contents;
    }

    public void setContents(JLabel contents) {
        this.contents = contents;
    }

    public JLabel getUser() {
        return user;
    }

    public void setUser(JLabel user) {
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

    public JButton getBottomButton() {
        return bottomButton;
    }

    public void setBottomButton(JButton bottomButton) {
        this.bottomButton = bottomButton;
    }

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