public class Ride {
    private String name;
    private String type;
    private int capacity;
    private Employee operator;

    // 默认构造
    public Ride() {
    }

    // 带参构造
    public Ride(String name, String type, int capacity, Employee operator) {
        this.name = name;
        this.type = type;
        this.capacity = capacity;
        this.operator = operator;
    }

    // Getter 和 Setter
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    public int getCapacity() {
        return capacity;
    }
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Employee getOperator() {
        return operator;
    }
    public void setOperator(Employee operator) {
        this.operator = operator;
    }
}
