package StreamApi;

import lambda.Person;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 *  一、Stream 的三个操作步骤
 *  1. 创建stream
 *
 *  2. 中间操作
 *
 *  3. 终止操作
 */

public class TestStreamAPI {
    //创建Stream
    @Test
    public void test1(){
        //1. 通过Conllection系列集合提供的stream()或 parallelStream()
        List<String> list = new ArrayList<>();
        Stream<String> stream = list.stream();

        //2. 通过Arrays 中的静态方法stream()获取数组流
        Person[] people = new Person[10];
        Stream<Person> personStream = Arrays.stream(people);

        //3. 通过Stream的静态方法of()
        Stream<String> stringStream = Stream.of("aa", "bb", "cc");

        //4. 创建无限流
        //迭代
        Stream<Integer> integerStream = Stream.iterate(0, x -> x + 1);
        integerStream.limit(100).forEach(System.out::println);

        //生成
        Stream.generate(() -> 100*Math.random() )
                .limit(10)
                .forEach(System.out::println);
    }
}