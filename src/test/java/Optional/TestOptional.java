package Optional;

import lambda.Person;
import lambda.Status;
import org.junit.Test;

import java.util.Optional;
import java.util.function.Supplier;

public class TestOptional {
    // 创建一个Optional实例
    @Test
    public  void test1() {
        Optional<Person> op = Optional.of(new Person());
        Person person = op.get();
        System.out.println(person);
    }
    // 创建一个空的Optional实例
    @Test
    public  void test2() {
        Optional<Person> op = Optional.empty();
        Person person = op.get();
        System.out.println(person);
    }
    // ofNullable(T t)：若t不为null，创建Optional实例，否则创建空实例
    @Test
    public  void test3() {
//        Optional<Person> op = Optional.ofNullable(new Person());
        Optional<Person> op = Optional.ofNullable(null);
        // isPresent()：判断是否包含值
        if (op.isPresent()) {
            Person person = op.get();
            System.out.println(person);
        }
        // orElse(T t)：如果调用对象包含值，否则返回t
        Person person = op.orElse(new Person("zhangsan", 18, Status.BUSY));
        System.out.println(person);

        // orElseGet(Supplier s)：如果调用对象包含值，返回该值，否则返回s获取的值
        Person person1 = op.orElseGet(() -> new Person("lisi", 28, Status.BUSY));
        System.out.println(person1);
    }

}
