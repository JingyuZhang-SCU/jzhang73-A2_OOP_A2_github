import java.util.Comparator;

/*
  按年龄排序游客，如果年龄相同，则按姓名排序。
 */
public class VisitorComparator implements Comparator<Visitor> {
    @Override
    public int compare(Visitor v1, Visitor v2) {
        if (v1.getAge() != v2.getAge()) {
            return v1.getAge() - v2.getAge();
        } else {
            return v1.getName().compareTo(v2.getName());
        }
    }
}
