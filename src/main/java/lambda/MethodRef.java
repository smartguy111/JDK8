package lambda;


import java.util.Comparator;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 *  方法引用：若Lambda 体重内容有方法已经实现了，我们可以使用"方法引用"
 *          （可以理解为方法引用是Lambda 表达式的另外一种表现形式）
 *
 *  主要有三种语法格式：
 *
 *  对象::实例方法名
 *
 *  类::静态方法名
 *
 *  类::实例方法名
 *
 *  注意：
 *      1. Lambda体中调用方法的参数列表与返回值类型，要与函数式接口中抽象方法的函数列表和返回值类型保持一致
 *      2. 若Lambda参数列表中第一参数是实例方法的调用者，第二个是实例方法的参数时，可以使用ClassName：：method
 *
 *  二、构造器引用
 *  格式：
 *      ClassName::new
 *
 *  三、数组引用
 *      Type::new
 */
public class MethodRef {
    private static MethodRef _methodRef = new MethodRef();

    //数组引用

    public void arrayRef(Integer num, Function<Integer, String[]> function) {
        String[] strings = function.apply(num);
        System.out.println(strings.length);
    }

    //构造器引用-无参
    public void constructorRef(Supplier<Person> supplier){
        System.out.println(supplier.get());
    }
    //构造器引用-有参
    public void constructorRef2(String name, Integer age, BiFunction<String, Integer, Person> biFunction){
        System.out.println(biFunction.apply(name, age));
    }


    // 对象::实例方法名
    public void methodRef(String str, Consumer<String> consumer){
        consumer.accept(str);
    }

    //类::静态方法名
    public void methodRef1(Integer i1, Integer i2, Comparator<Integer> comparator){
        comparator.compare(i1, i2);
    }

    public static void main(String[] args) {
        _methodRef.arrayRef(10, x -> new String[x]);
        _methodRef.arrayRef(10, String[]::new);

        // 无参
        _methodRef.constructorRef(()->new Person());
        _methodRef.constructorRef(Person::new);
        // 有参
        _methodRef.constructorRef2("123",123, (x, y)->new Person(x,y));
        _methodRef.constructorRef2("123",123, Person::new);


        _methodRef.methodRef("ref", x-> System.out.println(x));
        _methodRef.methodRef("ref", System.out::println);

        Person p = new Person("zhangsan", 20);
        Supplier<String> supplier = () -> p.getName();
        Supplier<String> supplier1 = p::getName;
        System.out.println(supplier.get());
        System.out.println(supplier1.get());

        Supplier<Integer> supplierA = () -> p.getAge();
        Supplier<Integer> supplier1A = p::getAge;
        System.out.println(supplierA.get());
        System.out.println(supplier1A.get());

        _methodRef.methodRef1(10, 20,(x, y)-> Integer.compare(x,y) );
        _methodRef.methodRef1(10, 20, Integer::compare);

    }
}
