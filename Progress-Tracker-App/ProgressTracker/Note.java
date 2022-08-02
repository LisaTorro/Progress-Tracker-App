// THIS SHOULD BE ABLE TO BE DELETED
/*
package ProgressTracker;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class Note extends JPanel{

    private JPanel middle = new JPanel(new BorderLayout());
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

    Note(BorderLayout borderLayout, Color color, Dimension dimension, int horizontalAlignment){
        super(borderLayout);
        setColor(color);
        setDimension(dimension);
        setHorizontalAlignment(horizontalAlignment);

        setBackground(color);
        middle.setBackground(color);
        leftButton.setBackground(color);
        rightButton.setBackground(color);
        bottomButton.setBackground(color);

        setPreferredSize(dimension);

        title.setHorizontalAlignment(horizontalAlignment);
        contents.setHorizontalAlignment(horizontalAlignment);
        user.setHorizontalAlignment(horizontalAlignment);

        leftButton.setBorder(buttonBorder);
        rightButton.setBorder(buttonBorder);
        bottomButton.setBorder(buttonBorder);

        middle.add(title, BorderLayout.NORTH);
        middle.add(contents, BorderLayout.CENTER);
        middle.add(user, BorderLayout.SOUTH);
        this.add(middle, BorderLayout.CENTER);
        this.add(leftButton, BorderLayout.WEST);
        this.add(rightButton, BorderLayout.EAST);
        this.add(bottomButton, BorderLayout.SOUTH);
    }

    public JPanel getMiddle(){
        return middle;
    }

    public void setMiddle(JPanel middle){
        this.middle = middle;
    }

    public JLabel getTitle(){
        return title;
    }

    public void setTitle(JLabel title){
        this.title = title;
    }

    public JLabel getContents(){
        return contents;
    }

    public void setContents(JLabel contents){
        this.contents = contents;
    }

    public JLabel getUser(){
        return user;
    }

    public void setUser(JLabel user){
        this.user = user;
    }
    
    public JButton getLeftButton(){
        return leftButton;
    }

    public void setLeftButton(JButton leftButton){
        this.leftButton = leftButton;
    }

    public JButton getRightButton(){
        return rightButton;
    }

    public void setRightButton(JButton rightButton){
        this.rightButton = rightButton;
    }

    public JButton getBottomButton(){
        return bottomButton;
    }

    public void setBottomButton(JButton bottomButton){
        this.bottomButton = bottomButton;
    }

    public Border getButtonBorder(){
        return buttonBorder;
    }

    public void setButtonBorder(Border buttonBorder){
        this.buttonBorder = buttonBorder;
    }

    public Color getColor(){
        return color;
    }

    public void setColor(Color color){
        this.color = color;
    }

    public Dimension getDimension(){
        return dimension;
    }

    public void setDimension(Dimension dimension){
        this.dimension = dimension;
    }

    public int getHorizontalAlignment(){
        return horizontalAlignment;
    }

    public void setHorizontalAlignment(int horizontalAlignment){
        this.horizontalAlignment = horizontalAlignment;
    }
}
*/