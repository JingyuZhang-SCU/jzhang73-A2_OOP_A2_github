public class AssignmentTwo {
    public static void main(String[] args) {
        partThree();
    }
    public static void partThree() {
        Ride ride = new Ride("Roller Coaster", "Thrill Ride", 20, new Employee("John Doe", 30, "ID1234", "Operator", "EMP001"));

        Visitor visitor1 = new Visitor("Alice", 25, "V001", "VIP", "Season Pass");
        Visitor visitor2 = new Visitor("Bob", 28, "V002", "Regular", "One Day Pass");
        Visitor visitor3 = new Visitor("Charlie", 22, "V003", "VIP", "Season Pass");
        Visitor visitor4 = new Visitor("David", 35, "V004", "Regular", "Weekend Pass");
        Visitor visitor5 = new Visitor("Eve", 29, "V005", "VIP", "Season Pass");

        ride.addVisitorToQueue(visitor1);
        ride.addVisitorToQueue(visitor2);
        ride.addVisitorToQueue(visitor3);
        ride.addVisitorToQueue(visitor4);
        ride.addVisitorToQueue(visitor5);

        ride.removeVisitorFromQueue();
        ride.printQueue();
    }
    public void partFourA(){
    }
    public void partFourB(){
    }
    public void partFive(){
    }
    public void partSix(){
    }
    public void partSeven(){
    }
}