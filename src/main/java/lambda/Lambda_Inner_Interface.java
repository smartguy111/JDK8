package lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 *  Java8 内置的四大核心函数式接口
 *
 *  Consumer<T> : 消费型接口
 *      void accept(T t);
 *
 *  Supplier(T) : 供给型接口
 *      T get();
 *
 *  Function<T, R> : 函数型接口
 *      R apply(T t);
 *
 *  Predicate<T> : 断言型接口
 *      boolean test(T t);
 *
 */

public class Lambda_Inner_Interface {
    // Consumer<T> : 消费型接口
    public void happy(double money, Consumer<Double> consumer) {
        consumer.accept(money);
    }

    // Supplier(T) : 供给型接口
    public List<Integer> getNumList(int num, Supplier<Integer> supplier) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            Integer integer = supplier.get();
            list.add(integer);
        }
        return list;
    }

    // Function<T, R> : 函数型接口
    // 需求：用于处理字符串
    public String strHandler(String str, Function<String, String> function) {
        return function.apply(str);
    }

    // Predicate<T> : 断言型接口
    //需求： 将满足条件的字符串放入集合
    public List<String> filterStr(List<String> list, Predicate<String> predicate) {
        List<String> stringList = new ArrayList<>();
        for (String string : list) {
            if (predicate.test(string)) {
                stringList.add(string);
            }
        }
        return stringList;
    }

}
