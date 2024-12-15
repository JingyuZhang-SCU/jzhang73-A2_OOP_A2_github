public class AssignmentTwo {
    public static void main(String[] args) {
        partThree();
        partFourA();
        partFourB();
        partFive();
        partSix();
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
        Employee operator = new Employee("E22224A", 28, "ID5678", "Operator", "EMP002");
        Ride waterRide = new Ride("Water Riders", "Water Ride", 4, operator);
        Visitor visitor1 = new Visitor("AAAA4A", 27, "V006", "VIP", "Season Pass");
        Visitor visitor2 = new Visitor("BBBB4A", 32, "V007", "Regular", "One Day Pass");
        Visitor visitor3 = new Visitor("CCCC4A", 24, "V008", "VIP", "Season Pass");
        Visitor visitor4 = new Visitor("DDDD4A", 30, "V009", "Regular", "Weekend Pass");
        Visitor visitor5 = new Visitor("EEEE4A", 26, "V010", "VIP", "Season Pass");

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

    public static void partFourB() {
        System.out.println("\n----- Part 4B: Sorting the Collection Demonstration -----");
        Employee operator = new Employee("E33334B", 29, "ID9012", "Operator", "EMP003");
        Ride ferrisWheel = new Ride("Ferris Wheel", "Leisure Ride", 5, operator);
        Visitor visitor1 = new Visitor("AAAA4B", 24, "V011", "VIP", "Season Pass");
        Visitor visitor2 = new Visitor("BBBB4B", 31, "V012", "Regular", "One Day Pass");
        Visitor visitor3 = new Visitor("CCCC4B", 22, "V013", "VIP", "Season Pass");
        Visitor visitor4 = new Visitor("DDDD4B", 28, "V014", "Regular", "Weekend Pass");
        Visitor visitor5 = new Visitor("EEEE4B", 26, "V015", "VIP", "Season Pass");

        ferrisWheel.addVisitorToQueue(visitor1);
        ferrisWheel.addVisitorToQueue(visitor2);
        ferrisWheel.addVisitorToQueue(visitor3);
        ferrisWheel.addVisitorToQueue(visitor4);
        ferrisWheel.addVisitorToQueue(visitor5);

        ferrisWheel.runOneCycle();
        System.out.println("\n历史记录中的游客（排序前）：");
        ferrisWheel.printRideHistory();
        VisitorComparator comparator = new VisitorComparator();
        ferrisWheel.sortRideHistory(comparator);
        System.out.println("\n历史记录中的游客（排序后）：");
        ferrisWheel.printRideHistory();
    }
    public static void partFive() {
        System.out.println("\n----- Part 5: Run a ride cycle -----");
        Employee operator = new Employee("E44445", 34, "ID3456", "Operator", "EMP004");
        Ride bumperCars = new Ride("Bumper Cars", "Family Ride", 4, operator);

        Visitor visitor1 = new Visitor("AAAA5", 20, "V016", "VIP", "Season Pass");
        Visitor visitor2 = new Visitor("BBBB5", 21, "V017", "Regular", "One Day Pass");
        Visitor visitor3 = new Visitor("CCCC5", 22, "V018", "VIP", "Season Pass");
        Visitor visitor4 = new Visitor("DDDD5", 23, "V019", "Regular", "Weekend Pass");
        Visitor visitor5 = new Visitor("EEEE5", 24, "V020", "VIP", "Season Pass");
        Visitor visitor6 = new Visitor("FFFF5", 25, "V021", "Regular", "One Day Pass");
        Visitor visitor7 = new Visitor("GGGG5", 26, "V022", "VIP", "Season Pass");
        Visitor visitor8 = new Visitor("HHHH5", 27, "V023", "Regular", "Weekend Pass");
        Visitor visitor9 = new Visitor("IIII5", 28, "V024", "VIP", "Season Pass");
        Visitor visitor10 = new Visitor("JJJJ5", 29, "V025", "Regular", "One Day Pass");

        bumperCars.addVisitorToQueue(visitor1);
        bumperCars.addVisitorToQueue(visitor2);
        bumperCars.addVisitorToQueue(visitor3);
        bumperCars.addVisitorToQueue(visitor4);
        bumperCars.addVisitorToQueue(visitor5);
        bumperCars.addVisitorToQueue(visitor6);
        bumperCars.addVisitorToQueue(visitor7);
        bumperCars.addVisitorToQueue(visitor8);
        bumperCars.addVisitorToQueue(visitor9);
        bumperCars.addVisitorToQueue(visitor10);

        bumperCars.printQueue();
        bumperCars.runOneCycle();
        bumperCars.printQueue();
        bumperCars.printRideHistory();
    }
    public static void partSix() {
        System.out.println("\n----- Part 6: Writing to a file -----");
        Employee operator = new Employee("E55556", 35, "ID4567", "Operator", "EMP005");
        Ride logFlume = new Ride("Log Flume", "Water Ride", 5, operator);

        Visitor visitor1 = new Visitor("AAAA6", 30, "V026", "VIP", "Season Pass");
        Visitor visitor2 = new Visitor("BBBB6", 31, "V027", "Regular", "One Day Pass");
        Visitor visitor3 = new Visitor("CCCC6", 32, "V028", "VIP", "Season Pass");
        Visitor visitor4 = new Visitor("DDDD6", 33, "V029", "Regular", "Weekend Pass");
        Visitor visitor5 = new Visitor("EEEE6", 34, "V030", "VIP", "Season Pass");

        logFlume.addVisitorToQueue(visitor1);
        logFlume.addVisitorToQueue(visitor2);
        logFlume.addVisitorToQueue(visitor3);
        logFlume.addVisitorToQueue(visitor4);
        logFlume.addVisitorToQueue(visitor5);

        logFlume.runOneCycle();
        System.out.println("\n历史记录中的游客：");
        logFlume.printRideHistory();
        String filename = "log_flume_history.csv";
        logFlume.exportRideHistory(filename);
    }
    public void partSeven(){
    }
}