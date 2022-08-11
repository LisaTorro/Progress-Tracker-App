// Reviewed on 08/03/2022 at 12:40PM

package ProgressTracker;

public class Task {

    private String title;
    private String contents;
    private String user;

    public Task(String title, String contents, String user){
        this.title = title;
        this.contents = contents;
        this.user = user;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getContents(){
        return contents;
    }

    public void setContents(String contents){
        this.contents = contents;
    }
    
    public String getUser(){
        return user;
    }

    public void setUser(String user){
        this.user = user;
    }

    public String[] getValues(){
        String[] values = new String[3];
        values[0] = getTitle();
        values[1] = getContents();
        values[2] = getUser();
        return values;
    }
}
