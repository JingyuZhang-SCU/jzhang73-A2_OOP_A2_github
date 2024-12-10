
import java.util.Queue;
import java.util.LinkedList;

public class Ride {
    private String name;
    private String type;
    private int maxCapacity;
    private Employee operator;

    public Ride() {
        // ...后续根据作业内容进行完成
    }

    public Ride(String name, String type, int maxCapacity, Employee operator) {
        this.name = name;
        this.type = type;
        this.maxCapacity = maxCapacity;
        this.operator = operator;
    }


    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    public int getMaxCapacity() { return maxCapacity; }
    public void setMaxCapacity(int maxCapacity) { this.maxCapacity = maxCapacity; }
    public Employee getOperator() { return operator; }
    public void setOperator(Employee operator) { this.operator = operator; }
}