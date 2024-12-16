/*
  员工类，继承自Person，增加职位和员工ID。
 */
public class Employee extends Person {
    private String position;
    private String employeeId;

    public Employee() {
        super();
    }

    public Employee(String name, int age, String id, String position, String employeeId) {
        super(name, age, id);
        this.position = position;
        this.employeeId = employeeId;
    }

    // Getter 和 Setter
    public String getPosition() {
        return position;
    }
    public void setPosition(String position) {
        this.position = position;
    }

    public String getEmployeeId() {
        return employeeId;
    }
    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }
}
