// JVM cant run this directly

// So javac converts :- 

// Main.java -> Main.class
// Taks.java -> Task.class


// After this command, our folder probably contains:

// Main.java
// Task.java
// Main.class
// Task.class

// For execution we do of 'java Main' 
// The JVM looks inside Main.class and finds 

// --> public static void main(String[] args) 

// public static void main(String[] args) 
// it is known as entry point of program

public class Main {

    public static void main(String[] args) {

        

        if(args.length == 0){
            System.out.println("No command provided");
            return;
        }
        TaskManager manager = new TaskManager();

        String command = args[0];

        if(command.equals("add")){
            if(args.length<2){
                System.out.println("Please provide task description");
                return;
            }
            String description = args[1];
            manager.addTask(description);
            System.out.println("Task Added");
        }
        else if(command.equals("delete")){
            if(args.length <2){
                System.out.println("Please provide ID to move forward");
                return;
            }

            try{
                int id = Integer.parseInt(args[1]);
                manager.deleteTask(id);
            }catch(NumberFormatException e){
                System.out.println("ID should be a number");
            }
        }
        else if(command.equals("update")){
            if(args.length <3){
                System.out.println("Please provide Update details properly");
                return;
            }
            try{
                int id = Integer.parseInt(args[1]);
                String newDescription = args[2];
                manager.updateTask(id, newDescription);
            }
            catch(NumberFormatException e){
                System.out.println("Please enter a valid numeric task ID");
            }
        }
        else if(command.equals("mark-done")){
            if(args.length <2){
                System.out.println("Please provide mark-done details properly");
                return;
            }
            try{
                int id = Integer.parseInt(args[1]);
                manager.markDone(id);
            }
            catch(NumberFormatException e){
                System.out.println("Please enter a valid numeric task ID");
            }
            
        }
        else if(command.equals("mark-in-progress")){
            if(args.length <2){
                System.out.println("Please provide mark-in-progress details properly");
                return;
            }
            try{
                int id = Integer.parseInt(args[1]);
                manager.markInProgress(id);
            }
            catch(NumberFormatException e){
                System.out.println("Please enter a valid numeric task ID");
            }
        }
        else if(command.equals("list")){
            if(args.length == 1){
                manager.listTasks();
            }
            else if(args[1].equals("done")){
                manager.listDoneTasks();
            }
            else if(args[1].equals("todo")){
                manager.listToDoTasks();
            }
            else if(args[1].equals("in-progress")){
                manager.listInProgressTasks();
            }
            else{
                System.out.println("Invalid last option");
            }
        }
        else{
            System.out.println("Unknown commands");
        }

        // System.out.println("Number of arguments: "+ args.length);

        // for(int i = 0;i<args.length;i++){
        //     System.out.println(args[i]);
        // }
        // TaskManager manager = new TaskManager();
        // manager.listTasks();
        
        // manager.addTask("Learn Java");
        // manager.addTask("Go Gym");
        // manager.addTask("Build Task Tracker");
        

        // Task foundTask = manager.findTaskById(4);
        // if(foundTask != null){
        //     foundTask.printTask();
        // }
        // else{
        //     System.out.println("Task not found");
        // }

        // manager.updateTask(2,"Go Gym and Cardio");

        // manager.deleteTask(2);

        // manager.markInProgress(2);
        
        // manager.listDoneTasks();
        // manager.listToDoTasks();

        // manager.saveTasks();

        // manager.listInProgressTasks();
    }
}
