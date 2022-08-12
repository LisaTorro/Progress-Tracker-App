// Reviewed on 08/12/2022 at 11:10AM

package ProgressTracker.Panels;

import java.awt.*;
import java.util.*;
import javax.swing.*;
import ProgressTracker.*;

public class TaskViewPanel extends FivePanel{

    private LinkedList<JButton> southButtons = new LinkedList<>();
    private JTextArea title = new JTextArea();
    private JTextArea contents = new JTextArea();
    private JTextArea user = new JTextArea();

    public TaskViewPanel(MyFrame myFrame){
        super(myFrame);
        getSouthPanel().setLayout(new GridLayout(1, 6, 10, 10));
        String[] newButtonStrings = {"", "To Do Panel", "Board Panel", "Completed Panel", "Settings Panel", ""};
        for(int counter = 0; counter < 6; counter++){
            southButtons.add(new JButton(newButtonStrings[counter]));
            southButtons.get(counter).setPreferredSize(getMyFrame().getSmallDimension());
            getSouthPanel().add(southButtons.get(counter));
            if(counter != 0 && counter != 5){
                southButtons.get(counter).addActionListener(myFrame);
            } else {
                southButtons.get(counter).setEnabled(false);
                southButtons.get(counter).setVisible(false);
            }
        }
        getCenterPanel().setLayout(new BorderLayout());
        title.setPreferredSize(getMyFrame().getSmallDimension());
        user.setPreferredSize(getMyFrame().getSmallDimension());
        getCenterPanel().add(title, BorderLayout.NORTH);
        getCenterPanel().add(contents, BorderLayout.CENTER);
        getCenterPanel().add(user, BorderLayout.SOUTH);
        title.setEditable(false);
        contents.setEditable(false);
        user.setEditable(false);
        updatePaint();
        updateFonts();
    }

    public void updatePaint(){
        super.updatePaint();
        Color columnPanelsColor = getMyFrame().getPalette().getColumnPanelsColor();
        Color buttonColor = getMyFrame().getPalette().getSouthButtonColor();
        getTitle().setBackground(columnPanelsColor);
        getContents().setBackground(columnPanelsColor);
        getUser().setBackground(columnPanelsColor);
        for(int counter = 0; counter < 6; counter++){
            southButtons.get(counter).setBackground(buttonColor);
        }
    }

    public void updateFonts(){
        Font textAreaFont = getMyFrame().getPalette().getTextAreaFont();
        Font buttonFont = getMyFrame().getPalette().getButtonFont();
        getTitle().setFont(textAreaFont);
        getContents().setFont(textAreaFont);
        getUser().setFont(textAreaFont);
        for(int counter = 0; counter < 6; counter++){
            southButtons.get(counter).setFont(buttonFont);
        }
    }

    public void updateBorders(){

    }

    public void modify(String[] values) {
        title.setText(values[0]);
        contents.setText(values[1]);
        user.setText(values[2]);
    }

    public LinkedList<JButton> getSouthButtons() {
        return southButtons;
    }

    public void setSouthButtons(LinkedList<JButton> southButtons) {
        this.southButtons = southButtons;
    }

    public JTextArea getTitle() {
        return title;
    }

    public void setTitle(JTextArea title) {
        this.title = title;
    }

    public JTextArea getContents() {
        return contents;
    }

    public void setContents(JTextArea contents) {
        this.contents = contents;
    }

    public JTextArea getUser() {
        return user;
    }

    public void setUser(JTextArea user) {
        this.user = user;
    }
}