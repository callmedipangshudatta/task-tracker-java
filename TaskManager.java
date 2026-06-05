//for Local Data and Time
import java.time.LocalDateTime;

//for saveTask()
import java.io.FileWriter;
import java.io.IOException;

//for loadTasks()
import java.io.BufferedReader;
import java.io.FileReader;


import java.util.ArrayList;


public class TaskManager {

    ArrayList<Task> tasks;
    //c-1
    int nextId;

    public TaskManager() {
        tasks = new ArrayList<>();
        //c-2
        nextId = 1;
        loadTasks();
    }

    public void addTask(String description) {
        //createdAt
        String createdAt = LocalDateTime.now().toString();
        String updatedAt = createdAt;
        //c-3
        Task task = new Task(nextId, description,"todo",createdAt,updatedAt);
        tasks.add(task);
        //c-4
        nextId++;
        saveTasks();
    }

    public Task findTaskById(int id){
        for(Task task : tasks){
            if(task.getId() == id){
                return task;
            }
        }
        return null;
    }

    public void updateTask(int id,String newDescription){
        Task task = findTaskById(id);
        if(task != null){
            task.setDescription(newDescription);
            task.setUpdatedAt(LocalDateTime.now().toString());
            System.out.println("Task Updated Successfully");
        }else{
            System.out.println("Task Not Found");
        }
        saveTasks();
    }

    public void deleteTask(int id){
        Task task = findTaskById(id);
        if(task != null){
            tasks.remove(task);
            System.out.println("Task deleted successfully");
        }
        else{
            System.out.println("Task not found");
        }
        saveTasks();

    }

    public void markDone(int id){
        Task task = findTaskById(id);
        if(task != null){
            task.setStatus("done");
            task.setUpdatedAt(LocalDateTime.now().toString());
            System.out.println("Task marked as done");
        }else{
            System.out.println("Task not found!");
        }
        saveTasks();

    }

    public void markInProgress(int id){
        Task task = findTaskById(id);
        if(task != null){
            task.setStatus("in-progress");
            task.setUpdatedAt(LocalDateTime.now().toString());
            System.out.println("Task marked as in-progress");
        }else{
            System.out.println("Task not found!");
        }
        saveTasks();

    }

    public void listDoneTasks(){
        for(Task task : tasks){
            if(task.getStatus().equals("done")){
                task.printTask();
                System.out.println();
            }
        }
    }

    public void listToDoTasks(){
        for(Task task : tasks){
            if(task.getStatus().equals("todo")){
                task.printTask();
                System.out.println();
            }
        }
    }
    public void listInProgressTasks(){
        for(Task task : tasks){
            if(task.getStatus().equals("in-progress")){
                task.printTask();
                System.out.println();
            }
        }
    }

    public void saveTasks(){
        try{
            FileWriter writer = new FileWriter("tasks.txt");
            for(Task task : tasks){
                String line = task.getId() + "|"+task.getDescription() +"|"+task.getStatus()+"|"+task.getCreatedAt()+"|"+task.getUpdatedAt();

                writer.write(line);
                writer.write("\n");
            }
            writer.close();
            // System.out.println("Tasks saved");
        }
        catch(IOException e){
            System.out.println("Error saving tasks");
        }
    }

    //imp
    public void loadTasks(){
        try{
            BufferedReader reader = new BufferedReader(new  FileReader("tasks.txt"));
            String line;
            while((line = reader.readLine())!= null){
                if(line.trim().isEmpty()){
                    continue;
                }
                String[] parts = line.split("\\|");
                if(parts.length<5){
                    continue;
                }

                //Convert values
                int id = Integer.parseInt(parts[0]);
                if(id>= nextId){
                    nextId = id+1;
                }
                String description = parts[1];
                String status = parts[2];
                String createdAt = parts[3];
                String updatedAt = parts[4];

                Task task = new Task(id, description, status,createdAt,updatedAt);

                //Stores in ArrayList
                tasks.add(task);
            }
            reader.close();
            if(tasks.size() > 0){
                // System.out.println("Tasks Loaded");
            }
        }catch(IOException e){
            System.out.println("No saved tasks found");
        }
    }

    public void listTasks() {

        for (Task task : tasks) {
            task.printTask();
            System.out.println();
        }
    }
}