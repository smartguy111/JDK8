package StreamApi;

import lambda.Person;
import lambda.Status;
import org.junit.Test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 *  终止操作
 *      allMatch
 *      anyMatch
 *      noneMatch
 *      findFirst
 *      findAny
 *      count
 *      max
 *      min
 *
 *      归约
 *      reduce(T identity, BinaryOperator) / reduce(BinaryOperator)
 *      -- 可以将流中元素反复结合起来，得到一个值。
 *
 *      收集
 *      collect - 将流转换为其他形式。接受一个Collector接口的实现，用于给Stream中元素流汇总的方法
 *
 */

public class TestStreamAPI3 {
    List<Person> people = Arrays.asList(
            new Person("张三", 20, Status.FREE),
            new Person("李四", 30, Status.BUSY),
            new Person("王五", 40, Status.FREE),
            new Person("赵六", 50, Status.VOCATION),
            new Person("田七", 60, Status.BUSY)
    );
    //收集所有姓名
    @Test
    public void test2() {
        List<String> collect = people.stream()
                .map(Person::getName)
                .collect(Collectors.toList());
        collect.forEach(System.out::println);

        //放入指定集合
        LinkedHashSet<String> linkedHashSet = people.stream()
                .map(Person::getName)
                .collect(Collectors.toCollection(LinkedHashSet::new));
        System.out.println(linkedHashSet);
    }

    @Test
    public void test3(){
        Long count = people.stream()
                .collect(Collectors.counting());
        System.out.println(count);
        System.out.println("-----------------------");

        //平均值
        Double avg = people.stream()
                .collect(Collectors.averagingInt(Person::getAge));
        System.out.println(avg);
    }

    // 分组
    @Test
    public void test4(){
        Map<Status, List<Person>> map = people.stream()
                .collect(Collectors.groupingBy(Person::getStatus));
        System.out.println(map);
    }

    @Test
    public void test1(){
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Integer sum = list.stream()
                .reduce(0, Integer::sum);
        System.out.println(sum);
        System.out.println("----------------------------");

        Optional<Integer> op = people.stream()
                .map(Person::getAge)
                .reduce(Integer::sum);
        System.out.println(op.get());
    }

    @Test
    public void test() {
        //获取总数
        long count = people.stream().count();
        System.out.println(count);
        System.out.println("--------------");

        // 获取年龄最大的人
        Optional<Person> maxPerson = people.stream()
                .max((p1, p2) -> Integer.compare(p1.getAge(), p2.getAge()));
        System.out.println(maxPerson.get());
        System.out.println("-------------");

        Optional<Integer> min = people.stream()
//                .map(person -> person.getAge())
//                .min((p1, p2) -> Integer.compare(p1, p2));
                .map(Person::getAge)
                .min(Integer::compare);
        // 获取最小的年龄
        System.out.println(min.get());

    }
}
