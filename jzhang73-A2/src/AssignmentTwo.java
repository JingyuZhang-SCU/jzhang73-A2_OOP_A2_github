public class AssignmentTwo {
    public static void main(String[] args) {
        partThree();
        partFourA();
    }

    public static void partThree() {
        System.out.println("----- Part 3: Queue Interface Demonstration -----");
        Employee operator = new Employee("Simon Zhang", 30, "ID1234", "Operator", "EMP001");
        Ride rollerCoaster = new Ride("Roller Coaster", "Thrill Ride", 3, operator);
        Visitor visitor1 = new Visitor("Wang", 25, "V001", "VIP", "Season Pass");
        Visitor visitor2 = new Visitor("Lie", 28, "V002", "Regular", "One Day Pass");
        Visitor visitor3 = new Visitor("Cheng", 22, "V003", "VIP", "Season Pass");
        Visitor visitor4 = new Visitor("Ma", 35, "V004", "Regular", "Weekend Pass");
        Visitor visitor5 = new Visitor("Zhan", 29, "V005", "VIP", "Season Pass");

        rollerCoaster.addVisitorToQueue(visitor1);
        rollerCoaster.addVisitorToQueue(visitor2);
        rollerCoaster.addVisitorToQueue(visitor3);
        rollerCoaster.addVisitorToQueue(visitor4);
        rollerCoaster.addVisitorToQueue(visitor5);

        rollerCoaster.removeVisitorFromQueue();

        rollerCoaster.printQueue();

        rollerCoaster.runOneCycle();
        rollerCoaster.printQueue();
        rollerCoaster.printRideHistory();

        System.out.println("是否有 Wang 在历史记录中？ " + rollerCoaster.checkVisitorFromHistory(visitor1));
        System.out.println("是否有 Zhan 在历史记录中？ " + rollerCoaster.checkVisitorFromHistory(visitor5));
        System.out.println("历史记录中的访客数量：" + rollerCoaster.numberOfVisitors());
    }

    public static void partFourA() {
        System.out.println("\n----- Part 4A: LinkedList Collection Demonstration -----");
        Employee operator = new Employee("Liu Wei", 28, "ID5678", "Operator", "EMP002");
        Ride waterRide = new Ride("Water Riders", "Water Ride", 4, operator);
        Visitor visitor1 = new Visitor("Nehemia", 27, "V006", "VIP", "Season Pass");
        Visitor visitor2 = new Visitor("Jason", 32, "V007", "Regular", "One Day Pass");
        Visitor visitor3 = new Visitor("Lily", 24, "V008", "VIP", "Season Pass");
        Visitor visitor4 = new Visitor("Tom", 30, "V009", "Regular", "Weekend Pass");
        Visitor visitor5 = new Visitor("Anna", 26, "V010", "VIP", "Season Pass");

        waterRide.addVisitorToQueue(visitor1);
        waterRide.addVisitorToQueue(visitor2);
        waterRide.addVisitorToQueue(visitor3);
        waterRide.addVisitorToQueue(visitor4);
        waterRide.addVisitorToQueue(visitor5);

        waterRide.runOneCycle();
        waterRide.runOneCycle();

        waterRide.checkVisitorFromHistory(visitor1);
        waterRide.checkVisitorFromHistory(visitor5);
        waterRide.numberOfVisitors();
        waterRide.printRideHistory();
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