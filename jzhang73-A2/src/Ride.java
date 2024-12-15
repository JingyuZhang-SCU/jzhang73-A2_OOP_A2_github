import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;
import java.util.List;

public class Ride implements RideInterface {
    private String name;
    private String type;
    private int capacity;
    private Employee operator;
    private Queue<Visitor> queue;
    private List<Visitor> history;

    // 默认构造
    public Ride() {
        this.queue = new LinkedList<>();
        this.history = new ArrayList<>();
    }

    // 带参构造
    public Ride(String name, String type, int capacity, Employee operator) {
        this.name = name;
        this.type = type;
        this.capacity = capacity;
        this.operator = operator;
        this.queue = new LinkedList<>();
        this.history = new ArrayList<>();
    }

    // Getter 和 Setter
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    public int getCapacity() {
        return capacity;
    }
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Employee getOperator() {
        return operator;
    }
    public void setOperator(Employee operator) {
        this.operator = operator;
    }


    @Override
    public void addVisitorToQueue(Visitor visitor) {
        if (queue.size() < capacity) {
            queue.add(visitor);
            System.out.println(visitor.getName() + " 已加入 " + name + " 的队列。");
        } else {
            System.out.println("队列已满，" + visitor.getName() + " 无法加入。");
        }
    }

    @Override
    public Visitor removeVisitorFromQueue() {
        Visitor visitor = queue.poll();
        if (visitor != null) {
            addVisitorToHistory(visitor);
            System.out.println(visitor.getName() + " 已离开队列，该记录已被记录到历史中。");
        } else {
            System.out.println("队列为空，移除失败。");
        }
        return visitor;
    }

    @Override
    public void printQueue() {
        System.out.println(name + " 当前队列：");
        if (queue.isEmpty()) {
            System.out.println("队列为空。");
        } else {
            for (Visitor v : queue) {
                System.out.println("- " + v.getName() + " (" + v.getTicketType() + ")");
            }
        }
    }

    @Override
    public void runOneCycle() {
        System.out.println(name + " 开始进行一个周期的处理。");
        // 假设一个周期处理一定数量的访客，例如5个
        int cycleCapacity = 5;
        for (int i = 0; i < cycleCapacity; i++) {
            Visitor visitor = removeVisitorFromQueue();
            if (visitor == null) {
                break; // 队列为空，停止处理
            }

        }
        System.out.println(name + " 该周期结束。");
    }

    @Override
    public void addVisitorToHistory(Visitor visitor) {
        history.add(visitor);
    }

    @Override
    public boolean checkVisitorFromHistory(Visitor visitor) {
        return history.contains(visitor);
    }

    @Override
    public int numberOfVisitors() {
        return history.size();
    }

    @Override
    public void printRideHistory() {
        System.out.println(name + " 的历史记录：");
        if (history.isEmpty()) {
            System.out.println("历史记录为空。");
        } else {
            for (Visitor v : history) {
                System.out.println("- " + v.getName() + " (" + v.getTicketType() + ")");
            }
        }
    }
}
