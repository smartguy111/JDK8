package lambda;

public class Person {
    private String name;
    private Integer age;
    private Status status;

    public Person() {
    }

    public Person(String name, Integer age, Status status ) {
        this.name = name;
        this.age = age;
        this.status = status;
    }

    public String getName() {
        return name;
    }


    public Integer getAge() {
        return age;
    }

    public Status getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", status='" + status + '\'' +
                '}';
    }
}
