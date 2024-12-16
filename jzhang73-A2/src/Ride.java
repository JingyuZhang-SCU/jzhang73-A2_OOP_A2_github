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
  Indicates an amusement facility, including queue management, history, import and export functions.
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
      The default constructor.
     */
    public Ride() {
        this.queue = new LinkedList<>();
        this.history = new LinkedList<>();
        this.numOfCycles = 0;
    }

    /*
      带参数的构造方法。
      Construction method with parameters.
     */
    public Ride(String name, String type, int maxRider, Employee operator) {
        this.name = name; //游乐设施名称  Name of amusement facilities
        this.type = type; //游乐设施类型  Type of amusement facilities
        this.maxRider = maxRider; //每个周期最大乘客数  Maximum number of passengers per cycle
        this.operator = operator; //操作员  operator
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
            System.out.println("maxRider must be at least 1.");
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

    // RideInterface
    @Override
    public void addVisitorToQueue(Visitor visitor) {
        queue.add(visitor);
        System.out.println(visitor.getName() + " has joined " + name + " 's lineup.");
    }

    @Override
    public Visitor removeVisitorFromQueue() {
        Visitor visitor = queue.poll();
        if (visitor != null) {
            addVisitorToHistory(visitor);
            System.out.println(visitor.getName() + " Left the queue and the record has been recorded in history.");
        } else {
            System.out.println("The queue was empty and failed to be removed. Procedure");
        }
        return visitor;
    }

    @Override
    public void printQueue() {
        System.out.print(this.name + " has " + queue.size() + " tourists (");
        if (!queue.isEmpty()) {
            String visitorNames = queue.stream()
                    .map(Visitor::getName)
                    .collect(Collectors.joining(", "));
            System.out.print(visitorNames);
        }
        System.out.println(") waiting in line.");
    }

    @Override
    public void runOneCycle() {
        if (operator == null) {
            System.out.println(name + " Cannot run because no operator is assigned.");
            return;
        }

        if (queue.isEmpty()) {
            System.out.println(name + " Cannot run because there are no waiting tourists in the queue.");
            return;
        }

        System.out.println(name + " Start a cycle of processing.");
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
        System.out.println(name + " The period ends.  " + processed + " visitors processed. (" + processedVisitors.toString() + ")");
        numOfCycles++;
    }

    @Override
    public void addVisitorToHistory(Visitor visitor) {
        history.add(visitor);
        System.out.println(visitor.getName() + " has been added to " + name + " 's history.");
    }

    @Override
    public boolean checkVisitorFromHistory(Visitor visitor) {
        boolean exists = history.contains(visitor);
        if (exists) {
            System.out.println(visitor.getName() + " is in " + name + " 's history.");
        } else {
            System.out.println(visitor.getName() + " is not in " + name + " 's history.");
        }
        return exists;
    }

    @Override
    public int numberOfVisitors() {
        int count = history.size();
        System.out.println(name + " has " + count + "  tourists in its history.");
        return count;
    }

    @Override
    public void printRideHistory() {
        System.out.print(this.name + " has " + history.size() + " tourists(");
        if (!history.isEmpty()) {
            String visitorNames = history.stream()
                    .map(Visitor::getName)
                    .collect(Collectors.joining(", "));
            System.out.print(visitorNames);
        }
        System.out.println(") Have already played this project.");
    }

    /*
     排序历史记录。
     Sort the history.
     */
    public void sortRideHistory(Comparator<Visitor> comparator) {
        history.sort(comparator);
        System.out.println(" The history of "+ name + " is sorted in the specified order.");
    }

    /*
      导出历史记录到指定文件，使用CSV格式。
      Export history records to a specified file in CSV format.
     */
    public void exportRideHistory(String filename) {
        if (history.isEmpty()) {
            System.out.println(" The history of "+ name + "  is empty and cannot be exported.");
            return;
        }

        try (FileWriter writer = new FileWriter(filename)) {
            for (Visitor visitor : history) {
                String line = visitor.getName() + "," + visitor.getAge() + "," + visitor.getId() + ","
                        + visitor.getMembershipType() + "," + visitor.getTicketType() + "\n";
                writer.write(line);
            }
            System.out.println(name + "  history has been successfully exported to file:" + filename);
        } catch (IOException e) {
            System.out.println("An error occurred while exporting " + name + " history to a file: " + e.getMessage());
        }
    }

    /*
      从指定文件导入历史记录，使用CSV格式。
      Import history from a specified file, using CSV format.
     */
    public void importRideHistory(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            int importedCount = 0;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length != 5) {
                    System.out.println(" Skip an invalid line (formatting error) : " + line);
                    continue;
                }
                String name = parts[0].trim();
                int age;
                try {
                    age = Integer.parseInt(parts[1].trim());
                } catch (NumberFormatException e) {
                    System.out.println(" Skip invalid age values: " + parts[1].trim() + " in line : " + line);
                    continue;
                }
                String id = parts[2].trim();
                MembershipType membershipType;
                try {
                    membershipType = MembershipType.valueOf(parts[3].trim().toUpperCase());
                } catch (IllegalArgumentException e) {
                    System.out.println("Skip invalid membership types: " + parts[3].trim() + " in line: " + line);
                    continue;
                }
                TicketType ticketType;
                try {
                    ticketType = TicketType.valueOf(parts[4].trim().toUpperCase().replace(" ", "_"));
                } catch (IllegalArgumentException e) {
                    System.out.println("Skip invalid ticket types: " + parts[4].trim() + " in line: " + line);
                    continue;
                }

                Visitor visitor = new Visitor(name, age, id, membershipType, ticketType);
                history.add(visitor);
                importedCount++;
            }
            System.out.println(" Successfully import " + importedCount + " visitors from file " + filename + " to " + name + " history.");
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filename);
        } catch (IOException e) {
            System.out.println(" Error while reading file " + filename + " ：" + e.getMessage());
        }
    }

    /*
      获取历史记录的不可变列表。
      Gets an immutable list of history records.
     */
    public List<Visitor> getHistory() {
        return Collections.unmodifiableList(history);
    }
}
