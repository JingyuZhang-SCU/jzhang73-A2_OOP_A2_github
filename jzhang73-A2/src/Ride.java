import java.util.LinkedList;
import java.util.Queue;
import java.util.List;

public class Ride implements RideInterface {
    private String name;
    private String type;
    private int maxCapacity;
    private Employee operator;
    private Queue<Visitor> waitingQueue = new LinkedList<>();
    private List<Visitor> rideHistory = new LinkedList<>();

    @Override
    public void addVisitorToQueue(Visitor visitor) {
        waitingQueue.add(visitor);
    }

    @Override
    public Visitor removeVisitorFromQueue() {
        return waitingQueue.poll();
    }

    @Override
    public void printQueue() {
        System.out.println("Waiting visitors:");
        for (Visitor visitor : waitingQueue) {
            System.out.println(visitor.getName());
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