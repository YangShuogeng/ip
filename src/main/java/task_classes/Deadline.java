package task_classes;

public class Deadline extends Task {

    protected String by;

    public Deadline (String description, String by){
        super(description);
        super.type = "D";
        this.by = by;
    }

    /**
     * To get the /by time of the Deadline task
     *
     * @return the time/date of the Deadline task
     */
    public String getBy(){

        return this.by;
    }

    /**
     * To get the status icon of the task
     *
     * @return status icon of the task
     */
    public String getStatusIcon(){
        return (isDone ? "X" : " ");
    }

    /**
     * To get the description of the task
     *
     * @return the description of the task
     */
    public String getDescription(){
        return this.description;
    }

    /**
     * To get the status of the task
     */
    public void markAsDone(){
        this.isDone = true;
    }

    /**
     * To get the type of the task
     *
     * @return the type of the task
     */
    public String getType(){
        return this.type;
    }
}