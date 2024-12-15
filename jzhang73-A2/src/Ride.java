import java.util.LinkedList;
import java.util.Queue;
import java.util.List;

public class Ride implements RideInterface {
    private String name;
    private String type;
    private int maxCapacity;
    private Employee operator;
    private final Queue<Visitor> waitingQueue = new LinkedList<>();
    private final List<Visitor> rideHistory = new LinkedList<>();

    public Ride() {}

    public Ride(String name, String type, int maxCapacity, Employee operator) {
        this.name = name;
        this.type = type;
        this.maxCapacity = maxCapacity;
        this.operator = operator;
    }

    @Override
    public void addVisitorToQueue(Visitor visitor) {
        if (visitor != null) {
            waitingQueue.add(visitor);
            System.out.println("Visitor " + visitor.getName() + " has been added to the queue.");
        } else {
            System.out.println("Failed to add visitor: visitor object is null.");
        }
    }

    @Override
    public Visitor removeVisitorFromQueue() {
        Visitor removedVisitor = waitingQueue.poll();
        if (removedVisitor != null) {
            System.out.println("Visitor " + removedVisitor.getName() + " has been removed from the queue.");
        } else {
            System.out.println("Failed to remove visitor: queue is empty.");
        }
        return removedVisitor;
    }

    @Override
    public void printQueue() {
        if (!waitingQueue.isEmpty()) {
            System.out.println("Waiting visitors:");
            for (Visitor visitor : waitingQueue) {
                System.out.println("Name: " + visitor.getName() + ", Ticket Type: " + visitor.getTicketType());
            }
        } else {
            System.out.println("No visitors are currently waiting in the queue.");
        }
    }

    @Override
    public void runOneCycle() {
        // 实现周期运行逻辑...
    }

    @Override
    public void addVisitorToHistory(Visitor visitor) {
        rideHistory.add(visitor);
    }

    @Override
    public boolean checkVisitorFromHistory(Visitor visitor) {
        return rideHistory.contains(visitor);
    }

    @Override
    public int numberOfVisitors() {
        return rideHistory.size();
    }

    @Override
    public void printRideHistory() {
        System.out.println("Ride history:");
        for (Visitor visitor : rideHistory) {
            System.out.println(visitor.getName());
        }
    }
}