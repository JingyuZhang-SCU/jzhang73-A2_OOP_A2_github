import java.util.Queue;
import java.util.List;

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