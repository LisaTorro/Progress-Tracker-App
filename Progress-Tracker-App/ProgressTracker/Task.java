// Reviewed on 08/12/2022 at 11:18AM

package ProgressTracker;

public class Task {

    private String[] values = new String[3]; // title, contents, user.

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
}
