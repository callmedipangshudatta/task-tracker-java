public class Task {

    private int id;
    private String description;
    private String status;

    //new-change
    private String createdAt;
    private String updatedAt;

    //constructor
    public Task(int id, String description, String status,String createdAt,String updatedAt) {
        this.id = id;
        this.description = description;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    //getter
    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getStatus() {
        return status;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    //setter
    public void setDescription(String description){
        this.description = description;
    }

    public void setStatus(String status){
        this.status = status;
    }

    public void setCreatedAt(String createdAt){
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(String updatedAt){
        this.updatedAt = updatedAt;
    }

    //method
    public void printTask() {

        System.out.println("ID: " + id);
        System.out.println("Description: " + description);
        System.out.println("Status: " + status);
        System.out.println("Created At: "+createdAt);
        System.out.println("Updated At: "+updatedAt);
    }
}