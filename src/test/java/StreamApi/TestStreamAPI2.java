package StreamApi;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import lambda.Person;
import lambda.Status;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class TestStreamAPI2 {
    List<Person> people = Arrays.asList(
            new Person("张三", 20, Status.FREE),
            new Person("李四", 30, Status.BUSY),
            new Person("王五", 40, Status.FREE),
            new Person("赵六", 50, Status.VOCATION),
            new Person("田七", 60, Status.BUSY)
    );
    //中间操作

    /**
     *   筛选与切片
     *   filter - 接收Lanbda，从流中排除某些元素
     *   limit - 截断流，使其元素不超过给定数量
     *   skip(n) - 跳过元素，返回一个扔掉了前n个元素的流，若流中不足n个，则返回空流。与limit互补
     *   distinct - 筛选，通过流所生成元素的hashcode()和equals()去除重复元素
     */

    /**
     *  映射
     *  map - 接收lambda，将元素转换成其他形式或提取信息。接收一个函数作为参数，该函数会被应用到每个元素上，并将其映射成一个新的元素。
     *  flatMap - 接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有的流连接成一个流。
     *
     */
    @Test
    public void testMap(){
        List<String> list = Arrays.asList("aaa","bbb","ccc","ddd","eee");
        list.stream()
                //.map(s -> s.toUpperCase())
                .map(String::toUpperCase)
                .forEach(System.out::println);
        System.out.println("--------------");
        people.stream()
                .map(Person::getName)
                .forEach(System.out::println);
        System.out.println("--------------");

//        Stream<Stream<Character>> streamStream = list.stream()
//                .map(TestStreamAPI2::filterCharacter);
//        streamStream.forEach(s -> s.forEach(System.out::println));
//        System.out.println("--------------");

        Stream<Character> characterStream = list.stream()
                .flatMap(TestStreamAPI2::filterCharacter);
        characterStream.forEach(System.out::println);


    }

    public static Stream<Character> filterCharacter(String string) {
        List<Character> list = new ArrayList<>();

        for (Character ch : string.toCharArray()) {
            list.add(ch);
        }
        return list.stream();
    }

    @Test
    public void test1(){
        //中间操作
        Stream<Person> newStream = people.stream()
                .filter(e->{
                    System.out.println("中间操作");
                    return e.getAge()>35;

                });
        //终止操作
        newStream.forEach(System.out::println);
    }
}
