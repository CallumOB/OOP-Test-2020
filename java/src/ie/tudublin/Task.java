package ie.tudublin;

public class Task {
    private String taskDesc;
    private int start;
    private int end;

    public Task(String taskDesc, int start, int end) {
        this.taskDesc = taskDesc;
        this.start = start;
        this.end = end;
    }

    public String getTaskDesc() {
        return taskDesc;
    }
    public void setTaskDesc(String taskDesc) {
        this.taskDesc = taskDesc;
    }
    public int getStart() {
        return start;
    }
    public void setStart(int start) {
        this.start = start;
    }
    public int getEnd() {
        return end;
    }
    public void setEnd(int end) {
        this.end = end;
    }

    public String toString() {
        return taskDesc + ": " + start + ", " + end;
    }
}   
