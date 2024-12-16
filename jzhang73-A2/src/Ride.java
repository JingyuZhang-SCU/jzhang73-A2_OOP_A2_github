import java.util.LinkedList;
import java.util.Queue;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;

/*
  表示一个游乐设施，包括管理队列、历史记录、导入导出等功能。
 */
public class Ride implements RideInterface {
    private String name;
    private String type;
    private int maxRider;
    private int numOfCycles;
    private Employee operator;
    private Queue<Visitor> queue;
    private List<Visitor> history;

    /*
      默认构造方法。
     */
    public Ride() {
        this.queue = new LinkedList<>();
        this.history = new LinkedList<>();
        this.numOfCycles = 0;
    }

    /*
      带参数的构造方法。
     */
    public Ride(String name, String type, int maxRider, Employee operator) {
        this.name = name; //游乐设施名称
        this.type = type; //游乐设施类型
        this.maxRider = maxRider; //每个周期最大乘客数
        this.operator = operator; //操作员
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

    // RideInterface 方法实现
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
            String visitorNames = queue.stream()
                    .map(Visitor::getName)
                    .collect(Collectors.joining(", "));
            System.out.print(visitorNames);
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
            String visitorNames = history.stream()
                    .map(Visitor::getName)
                    .collect(Collectors.joining(", "));
            System.out.print(visitorNames);
        }
        System.out.println(") 已经游玩过了这个项目。");
    }

    /*
     排序历史记录。
     */
    public void sortRideHistory(Comparator<Visitor> comparator) {
        history.sort(comparator);
        System.out.println(name + " 的历史记录已按指定顺序排序。");
    }

    /*
      导出历史记录到指定文件，使用CSV格式。
     */
    public void exportRideHistory(String filename) {
        if (history.isEmpty()) {
            System.out.println(name + " 的历史记录为空，无法导出。");
            return;
        }

        try (FileWriter writer = new FileWriter(filename)) {
            for (Visitor visitor : history) {
                String line = visitor.getName() + "," + visitor.getAge() + "," + visitor.getId() + ","
                        + visitor.getMembershipType() + "," + visitor.getTicketType() + "\n";
                writer.write(line);
            }
            System.out.println(name + " 的历史记录已成功导出到文件：" + filename);
        } catch (IOException e) {
            System.out.println("导出 " + name + " 的历史记录到文件时发生错误： " + e.getMessage());
        }
    }

    /*
      从指定文件导入历史记录，使用CSV格式。
     */
    public void importRideHistory(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            int importedCount = 0;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length != 5) {
                    System.out.println("跳过无效的行（格式错误）: " + line);
                    continue;
                }
                String name = parts[0].trim();
                int age;
                try {
                    age = Integer.parseInt(parts[1].trim());
                } catch (NumberFormatException e) {
                    System.out.println("跳过无效的年龄值: " + parts[1].trim() + " 在行: " + line);
                    continue;
                }
                String id = parts[2].trim();
                MembershipType membershipType;
                try {
                    membershipType = MembershipType.valueOf(parts[3].trim().toUpperCase());
                } catch (IllegalArgumentException e) {
                    System.out.println("跳过无效的会员类型: " + parts[3].trim() + " 在行: " + line);
                    continue;
                }
                TicketType ticketType;
                try {
                    ticketType = TicketType.valueOf(parts[4].trim().toUpperCase().replace(" ", "_"));
                } catch (IllegalArgumentException e) {
                    System.out.println("跳过无效的票务类型: " + parts[4].trim() + " 在行: " + line);
                    continue;
                }

                Visitor visitor = new Visitor(name, age, id, membershipType, ticketType);
                history.add(visitor);
                importedCount++;
            }
            System.out.println("成功从文件 " + filename + " 导入 " + importedCount + " 位游客到 " + name + " 的历史记录中。");
        } catch (FileNotFoundException e) {
            System.out.println("文件未找到： " + filename);
        } catch (IOException e) {
            System.out.println("读取文件 " + filename + " 时发生错误： " + e.getMessage());
        }
    }

    /*
      获取历史记录的不可变列表。
     */
    public List<Visitor> getHistory() {
        return Collections.unmodifiableList(history);
    }
}
