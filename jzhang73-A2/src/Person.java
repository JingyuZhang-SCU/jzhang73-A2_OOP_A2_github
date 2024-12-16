/*
  抽象类，作用于任意一个人（如游客、员工），包括名称、年龄和ID。
 */
public abstract class Person {
    private String name;
    private int age;
    private String id;

    public Person() {
    }

    public Person(String name, int age, String id) {
        if (age <= 0) {
            throw new IllegalArgumentException("年龄必须为正数。");
        }
        this.name = name;
        this.age = age;
        this.id = id;
    }

    // Getter 和 Setter
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        if(age <=0 ){
            throw new IllegalArgumentException("年龄必须为正数。");
        }
        this.age = age;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
}
