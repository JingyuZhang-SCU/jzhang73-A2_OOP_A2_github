public class AssignmentTwo {
    public static void main(String[] args) {
        partThree();
    }

    public static void partThree() {
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

        System.out.println("是否有 Wang 在历史记录中？ " + rollerCoaster.checkVisitorFromHistory(visitor3));
        System.out.println("是否有 Zhan 在历史记录中？ " + rollerCoaster.checkVisitorFromHistory(visitor4));
        System.out.println("历史记录中的访客数量：" + rollerCoaster.numberOfVisitors());
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