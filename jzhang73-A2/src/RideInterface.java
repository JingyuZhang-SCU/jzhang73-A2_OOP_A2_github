/*
  Ride的接口，用于完成游乐设施中的操作。
  The interface of the Ride, which is used to complete operations in the ride.
 */
public interface RideInterface {
    void addVisitorToQueue(Visitor visitor);
    Visitor removeVisitorFromQueue();
    void printQueue();
    void runOneCycle();
    void addVisitorToHistory(Visitor visitor);
    boolean checkVisitorFromHistory(Visitor visitor);
    int numberOfVisitors();
    void printRideHistory();
}
