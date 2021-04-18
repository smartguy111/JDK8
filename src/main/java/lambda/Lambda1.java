package lambda;

import java.util.Comparator;
import java.util.function.Consumer;

/**
 * 一、 lambda表达式的基础语法：
 *
 * 左侧：Lambda表达式参数列表
 * 右侧：Lambda表达式中所需执行的功能， 即 Lambda体
 *
 * 语法格式一：无参数，无返回值
 *        () -> System.out.println("");
 * 语法格式二：有一个参数，且无返回值
 *        (x) -> System.out.println(x);
 * 语法格式三：若参数只有一个参数，小括号可以不写
 *        x -> System.out.println(x);
 * 语法格式四：有两个以上参数，有返回值，且lambda体中有多条语句
 *         Comparator<Integer> comparator = (x, y) -> {
 *             System.out.println("函数式接口");
 *             return Integer.compare(x, y);
 *         };
 * 语法格式五：若Lambda体中只有一条语句，return和大括号都可以省略不写
 *          Comparator<Integer> comparator = (x, y) -> Integer.compare(x, y);
 *
 * 语法格式六：Lambda表达式的参数列表的数据类型可以省略不写，因为jvm编译器通过上下文推断出数据类型
 *          Comparator<Integer> comparator =(Integer x, Integer y) -> Integer.compare(x, y);
 *
 * 二、Lambda表达式需要"函数式接口"的支持
 *  函数式接口：接口中只有一个抽象方法的接口，称为函数式接口。 可以使用注解 @FunctionalInterface 修饰
 *
 */

public class Lambda1 {

    public void lambda1(){
        Runnable r = new Runnable() {
            public void run() {
                System.out.println("hello world");
            }
        };
        r.run();
        System.out.println("--------------------");

        Runnable r1 = () -> System.out.println("hello lambda");
        r1.run();
    }

    public void lambda2(){
        Consumer<String> consumer = (x) -> System.out.println(x);
        consumer.accept("xxxxxxxx");
    }

    public void lambda3(){
        Comparator<Integer> comparator = (x, y) -> {
            System.out.println("函数式接口");
            return Integer.compare(x, y);
        };
        System.out.println(comparator.compare(5, 8));
    }

    public void lambda4() {
        Comparator<Integer> comparator = (x, y) -> Integer.compare(x, y);
        System.out.println(comparator.compare(5, 8));
    }

    public Integer operation(Integer num, MyFunction myFunction) {
        return myFunction.getValue(num);
    }
}
