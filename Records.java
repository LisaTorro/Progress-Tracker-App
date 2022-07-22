import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

public class Records {

    LinkedList<LinkedList<Task>> records = new LinkedList<LinkedList<Task>>();

    Records(){
        for(int i = 0; i < 4; i++){
            records.addFirst(new LinkedList<Task>());
        }
    }

    public void stock(){

        records.getFirst().addFirst(new Task("Title 1", "Contents 1", "Tom"));
        records.get(1).addFirst(new Task("Title 2", "Contents 2", "Anthony"));
        records.get(1).addFirst(new Task("Title 3", "Contents 3", "Ashli"));
        records.get(2).addFirst(new Task("Title 4", "Contents 4", "Lisa"));
        records.get(2).addFirst(new Task("Title 5", "Contents 5", "Tom"));
        records.get(2).addFirst(new Task("Title 6", "Contents 6", "Anthony"));
        records.get(2).addFirst(new Task("Title 7", "Contents 7", "Ashli"));
        records.get(2).addFirst(new Task("Title 8", "Contents 8", "Lisa"));
        records.getLast().addFirst(new Task("Title 9", "Contents 9", "Tom"));
        records.getLast().addFirst(new Task("Title 10", "Contents 10", "Anthony"));
        records.getLast().addFirst(new Task("Title 11", "Contents 11", "Ashli"));
    }
    
    public LinkedList<Task> getList(int a){
        if(a < records.size()){
            return records.get(a);
        }
        return null;
    }

    public Task getTask(int a, int b){
        if(a < records.size()){
            if(b < records.get(a).size()){
                return records.get(a).get(b);
            }
        }
        return null;
    }

    public void removeTask(int a, int b){
        records.get(a).remove(b);
    }

    public void moveBackTask(int a, int b){
        moveTask(a, b, a - 1);
    }

    public void moveForwardTask(int a, int b){
        moveTask(a, b, a + 1);
    }

    public void moveTask(int a, int b, int c){
        Task task = records.get(a).get(b);
        records.get(a).remove(b);
        records.get(c).addLast(task);
    }

    public void addTask(Task task){
        records.get(0).addLast(task);
    }

    public void editTask(int a, int b, String[] values){
        records.get(a).get(b).setTitle(values[0]);
        records.get(a).get(b).setContents(values[1]);
        records.get(a).get(b).setUser(values[2]);
    }

    public String allDataToString(){
        String output = "";
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < records.get(i).size(); j++){
                output += i + ",";
                output += records.get(i).get(j).getTitle() + ",";
                output += records.get(i).get(j).getContents() + ",";
                output += records.get(i).get(j).getUser() + ",,";
            }
        }
        return output;
    }

    public void saveToFile(String fileName) throws IOException{
        try{
            File myObj = new File(fileName);
            if(myObj.createNewFile()){
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch(IOException exception){
            System.out.println("An error occured");
            exception.printStackTrace();
        }

        try{
            FileWriter myWriter = new FileWriter(fileName);
            myWriter.write(allDataToString());
            myWriter.close();
            System.out.println("Successfully wrote to the file");
        } catch(IOException exception){
            exception.printStackTrace();
        }
    }

    public void loadFromFile(String fileName){

    }
        
}