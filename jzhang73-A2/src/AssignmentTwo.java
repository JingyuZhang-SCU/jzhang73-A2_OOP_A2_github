/*
  主类，游乐设施管理系统
  Main class, amusement facilities management system
 */
public class AssignmentTwo {
    public static void main(String[] args) {
        partThree();
        partFourA();
        partFourB();
        partFive();
        partSix();
        partSeven();
    }

    /*
      Part 3: Queue Interface Demonstration
      队列接口的使用，添加、移除、打印队列和历史记录
      Use of the queue interface to add, remove, and print queues and history
     */
    public static void partThree() {
        System.out.println("----- Part 3: Queue Interface Demonstration -----");
        Employee operator = new Employee("E11113", 30, "ID1234", "Operator", "EMP001");
        Ride rollerCoaster = new Ride("Roller Coaster", "Thrill Ride", 3, operator);
        Visitor visitor1 = new Visitor("AAAA3", 25, "V001", MembershipType.VIP, TicketType.SEASON_PASS);
        Visitor visitor2 = new Visitor("BBBB3", 28, "V002", MembershipType.REGULAR, TicketType.ONE_DAY_PASS);
        Visitor visitor3 = new Visitor("CCCC3", 22, "V003", MembershipType.VIP, TicketType.SEASON_PASS);
        Visitor visitor4 = new Visitor("DDDD3", 35, "V004", MembershipType.REGULAR, TicketType.WEEKEND_PASS);
        Visitor visitor5 = new Visitor("EEEE3", 29, "V005", MembershipType.VIP, TicketType.SEASON_PASS);

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

        System.out.println("Is there AAAA in the history? " + rollerCoaster.checkVisitorFromHistory(visitor1));
        System.out.println("Is there DDDD in the history? " + rollerCoaster.checkVisitorFromHistory(visitor5));
        System.out.println("Number of visitors in historical records:" + rollerCoaster.numberOfVisitors());
    }

    /*
      Part 4A: LinkedList Collection Demonstration
      使用LinkedList管理游乐设施的历史记录。
      Use LinkedList to manage ride history.
     */
    public static void partFourA() {
        System.out.println("\n----- Part 4A: LinkedList Collection Demonstration -----");
        Employee operator = new Employee("E22224A", 28, "ID5678", "Operator", "EMP002");
        Ride waterRide = new Ride("Water Riders", "Water Ride", 4, operator);
        Visitor visitor1 = new Visitor("AAAA4A", 27, "V006", MembershipType.VIP, TicketType.SEASON_PASS);
        Visitor visitor2 = new Visitor("BBBB4A", 32, "V007", MembershipType.REGULAR, TicketType.ONE_DAY_PASS);
        Visitor visitor3 = new Visitor("CCCC4A", 24, "V008", MembershipType.VIP, TicketType.SEASON_PASS);
        Visitor visitor4 = new Visitor("DDDD4A", 30, "V009", MembershipType.REGULAR, TicketType.WEEKEND_PASS);
        Visitor visitor5 = new Visitor("EEEE4A", 26, "V010", MembershipType.VIP, TicketType.SEASON_PASS);

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

    /*
      Part 4B: Sorting the Collection Demonstration
      对历史记录进行排序
      Sort the history
     */
    public static void partFourB() {
        System.out.println("\n----- Part 4B: Sorting the Collection Demonstration -----");
        Employee operator = new Employee("E33334B", 29, "ID9012", "Operator", "EMP003");
        Ride ferrisWheel = new Ride("Ferris Wheel", "Leisure Ride", 5, operator);
        Visitor visitor1 = new Visitor("AAAA4B", 24, "V011", MembershipType.VIP, TicketType.SEASON_PASS);
        Visitor visitor2 = new Visitor("BBBB4B", 31, "V012", MembershipType.REGULAR, TicketType.ONE_DAY_PASS);
        Visitor visitor3 = new Visitor("CCCC4B", 22, "V013", MembershipType.VIP, TicketType.SEASON_PASS);
        Visitor visitor4 = new Visitor("DDDD4B", 28, "V014", MembershipType.REGULAR, TicketType.WEEKEND_PASS);
        Visitor visitor5 = new Visitor("EEEE4B", 26, "V015", MembershipType.VIP, TicketType.SEASON_PASS);

        ferrisWheel.addVisitorToQueue(visitor1);
        ferrisWheel.addVisitorToQueue(visitor2);
        ferrisWheel.addVisitorToQueue(visitor3);
        ferrisWheel.addVisitorToQueue(visitor4);
        ferrisWheel.addVisitorToQueue(visitor5);

        ferrisWheel.runOneCycle();
        System.out.println("\nVisitors in history (before sorting) :");
        ferrisWheel.printRideHistory();
        VisitorComparator comparator = new VisitorComparator();
        ferrisWheel.sortRideHistory(comparator);
        System.out.println("\nVisitors in history (sorted) :");
        ferrisWheel.printRideHistory();
    }

    /*
      Part 5: Run a ride cycle
      演示在一个游乐设施运行周期中，如何处理队列中的游客。
      Demonstrates how to process visitors in a queue during a ride cycle.
     */
    public static void partFive() {
        System.out.println("\n----- Part 5: Run a ride cycle -----");
        Employee operator = new Employee("E44445", 34, "ID3456", "Operator", "EMP004");
        Ride bumperCars = new Ride("Bumper Cars", "Family Ride", 4, operator);

        Visitor visitor1 = new Visitor("AAAA5", 20, "V016", MembershipType.VIP, TicketType.SEASON_PASS);
        Visitor visitor2 = new Visitor("BBBB5", 21, "V017", MembershipType.REGULAR, TicketType.ONE_DAY_PASS);
        Visitor visitor3 = new Visitor("CCCC5", 22, "V018", MembershipType.VIP, TicketType.SEASON_PASS);
        Visitor visitor4 = new Visitor("DDDD5", 23, "V019", MembershipType.REGULAR, TicketType.WEEKEND_PASS);
        Visitor visitor5 = new Visitor("EEEE5", 24, "V020", MembershipType.VIP, TicketType.SEASON_PASS);
        Visitor visitor6 = new Visitor("FFFF5", 25, "V021", MembershipType.REGULAR, TicketType.ONE_DAY_PASS);
        Visitor visitor7 = new Visitor("GGGG5", 26, "V022", MembershipType.VIP, TicketType.SEASON_PASS);
        Visitor visitor8 = new Visitor("HHHH5", 27, "V023", MembershipType.REGULAR, TicketType.WEEKEND_PASS);
        Visitor visitor9 = new Visitor("IIII5", 28, "V024", MembershipType.VIP, TicketType.SEASON_PASS);
        Visitor visitor10 = new Visitor("JJJJ5", 29, "V025", MembershipType.REGULAR, TicketType.ONE_DAY_PASS);

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

    /*
      Part 6: Writing to a file
      将历史记录导出到文件(CSV)中
      Export the history to a file (CSV)
     */
    public static void partSix() {
        System.out.println("\n----- Part 6: Writing to a file -----");
        Employee operator = new Employee("E55556", 35, "ID4567", "Operator", "EMP005");
        Ride logFlume = new Ride("Log Flume", "Water Ride", 5, operator);

        Visitor visitor1 = new Visitor("AAAA6", 30, "V026", MembershipType.VIP, TicketType.SEASON_PASS);
        Visitor visitor2 = new Visitor("BBBB6", 31, "V027", MembershipType.REGULAR, TicketType.ONE_DAY_PASS);
        Visitor visitor3 = new Visitor("CCCC6", 32, "V028", MembershipType.VIP, TicketType.SEASON_PASS);
        Visitor visitor4 = new Visitor("DDDD6", 33, "V029", MembershipType.REGULAR, TicketType.WEEKEND_PASS);
        Visitor visitor5 = new Visitor("EEEE6", 34, "V030", MembershipType.VIP, TicketType.SEASON_PASS);

        logFlume.addVisitorToQueue(visitor1);
        logFlume.addVisitorToQueue(visitor2);
        logFlume.addVisitorToQueue(visitor3);
        logFlume.addVisitorToQueue(visitor4);
        logFlume.addVisitorToQueue(visitor5);

        logFlume.runOneCycle();
        System.out.println("\nVisitors in the historical record:");
        logFlume.printRideHistory();
        String filename = "log_flume_history.csv";
        logFlume.exportRideHistory(filename);
    }

    /*
      Part 7: Reading from a file
      从文件中(CSV)导入历史记录。
      Import history from a file (CSV).
     */
    public static void partSeven() {
        System.out.println("\n----- Part 7: Reading from a file -----");
        Employee operator = new Employee("E66667", 36, "ID5678", "Operator", "EMP006");
        Ride restoredRide = new Ride("Restored Ride", "Thrill Ride", 5, operator);
        String importFilename = "log_flume_history.csv";
        restoredRide.importRideHistory(importFilename);
        System.out.println("\nNumber of visitors in historical records:" + restoredRide.numberOfVisitors());
        System.out.println("Visitors in the historical record:");
        restoredRide.printRideHistory();
    }
}
