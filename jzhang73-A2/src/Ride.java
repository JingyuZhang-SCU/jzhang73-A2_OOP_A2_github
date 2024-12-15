import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
import java.util.Collections;
import java.util.Comparator;
import java.io.FileWriter;
import java.io.IOException;

public class Ride implements RideInterface {
    private String name;
    private String type;
    private int maxRider;
    private int numOfCycles;
    private Employee operator;
    private Queue<Visitor> queue;
    private LinkedList<Visitor> history;

    // 默认构造
    public Ride() {
        this.queue = new LinkedList<>();
        this.history = new LinkedList<>();
        this.numOfCycles = 0;
    }

    // 带参构造
    public Ride(String name, String type, int maxRider, Employee operator) {
        this.name = name;
        this.type = type;
        this.maxRider = maxRider;
        this.operator = operator;
        this.queue = new LinkedList<>();
        this.history = new LinkedList<>();
        this.numOfCycles = 0;
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

    public int getMaxRider() {
        return maxRider;
    }
    public void setMaxRider(int maxRider) {
        if (maxRider < 1) {
            System.out.println("maxRider 必须至少为1。");
            return;
        }
        this.maxRider = maxRider;
    }

    public int getNumOfCycles() {
        return numOfCycles;
    }
    public void setNumOfCycles(int numOfCycles) {
        this.numOfCycles = numOfCycles;
    }

    public Employee getOperator() {
        return operator;
    }
    public void setOperator(Employee operator) {
        this.operator = operator;
    }


    @Override
    public void addVisitorToQueue(Visitor visitor) {
        queue.add(visitor);
        System.out.println(visitor.getName() + " 已加入 " + name + " 的队列。");
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
        System.out.print(this.name + " 有 " + queue.size() + " 位游客 (");
        if (!queue.isEmpty()) {
            StringBuilder visitorNames = new StringBuilder();
            for (Visitor v : queue) {
                visitorNames.append(v.getName()).append(", ");
            }
            visitorNames.setLength(visitorNames.length() - 2);
            System.out.print(visitorNames.toString());
        }
        System.out.println(") 在等待列队中。");
    }

    @Override
    public void runOneCycle() {
        if (operator == null) {
            System.out.println(name + " 无法运行，因为没有分配操作员。");
            return;
        }

        if (queue.isEmpty()) {
            System.out.println(name + " 无法运行，因为队列中没有等待的游客。");
            return;
        }

        System.out.println(name + " 开始进行一个周期的处理。");
        int cycleCapacity = maxRider;
        int processed = 0;
        StringBuilder processedVisitors = new StringBuilder();

        for (int i = 0; i < cycleCapacity; i++) {
            Visitor visitor = removeVisitorFromQueue();
            if (visitor == null) {
                break;
            }
            processed++;
            processedVisitors.append(visitor.getName()).append(", ");
        }
        if (processedVisitors.length() > 0) {

            processedVisitors.setLength(processedVisitors.length() - 2);
        }
        System.out.println(name + " 该周期结束。已处理 " + processed + " 位游客 (" + processedVisitors.toString() + ")。");
        numOfCycles++;
    }

    @Override
    public void addVisitorToHistory(Visitor visitor) {
        history.add(visitor);
        System.out.println(visitor.getName() + " 已被添加到 " + name + " 的历史记录中。");
    }

    @Override
    public boolean checkVisitorFromHistory(Visitor visitor) {
        boolean exists = history.contains(visitor);
        if (exists) {
            System.out.println(visitor.getName() + " 在 " + name + " 的历史记录中。");
        } else {
            System.out.println(visitor.getName() + " 不在 " + name + " 的历史记录中。");
        }
        return exists;
    }

    @Override
    public int numberOfVisitors() {
        int count = history.size();
        System.out.println(name + " 的历史记录中有 " + count + " 位游客。");
        return count;
    }

    @Override
    public void printRideHistory() {
        System.out.print(this.name + " 有 " + history.size() + " 位游客 (");
        if (!history.isEmpty()) {
            Iterator<Visitor> iterator = history.iterator();
            StringBuilder visitorNames = new StringBuilder();
            while (iterator.hasNext()) {
                Visitor v = iterator.next();
                visitorNames.append(v.getName());
                if (iterator.hasNext()) {
                    visitorNames.append(", ");
                }
            }
            System.out.print(visitorNames.toString());
        }
        System.out.println(") 已经乘坐了这个过山车。");
    }

    public void sortRideHistory(Comparator<Visitor> comparator) {
        Collections.sort(history, comparator);
        System.out.println(name + " 的历史记录已按指定顺序排序。");
    }

    public void exportRideHistory(String filename) {
        if (history.isEmpty()) {
            System.out.println(name + " 的历史记录为空，无法导出。");
            return;
        }

        try (FileWriter writer = new FileWriter(filename)) {
            for (Visitor visitor : history) {
                // 将 Visitor 的属性以 CSV 格式写入文件
                String line = visitor.getName() + "," + visitor.getAge() + "," + visitor.getId() + ","
                        + visitor.getMembershipId() + "," + visitor.getTicketType() + "\n";
                writer.write(line);
            }
            System.out.println(name + " 的历史记录已成功导出到文件：" + filename);
        } catch (IOException e) {
            System.out.println("导出 " + name + " 的历史记录到文件时发生错误： " + e.getMessage());
        }
    }
}
