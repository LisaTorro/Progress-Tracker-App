/*
 * Written by:          Thomas Williams
 * Last Updated:        08/18/2022, at 11:36AM(PT)
 * Version:             1.0
 * Coding Module ID(s): 2.2, 2.3, 3.2, 3.3, 4.2, 5.2, 6.2, 7.1, 7.2, 7.3, 7.4, 8.1, 10.1, 10.2, 10.3, 11.1, 11.2
 */

package ProgressTracker;

public class Task {

    private String[]    values = new String[3]; // title, contents, user.

    public Task(String title, String contents, String user){
        this.values[0] = title;
        this.values[1] = contents;
        this.values[2] = user;
    }

    public String getTitle(){
        return values[0];
    }

    public void setTitle(String title){
        this.values[0] = title;
    }

    public String getContents(){
        return values[1];
    }

    public void setContents(String contents){
        this.values[1] = contents;
    }
    
    public String getUser(){
        return values[2];
    }

    public void setUser(String user){
        this.values[2] = user;
    }

    public String[] getValues(){
        return values;
    }

    public void setValues(String[] values){
        this.values = values;
    }
}
