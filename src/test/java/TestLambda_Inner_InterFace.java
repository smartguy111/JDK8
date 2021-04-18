import lambda.Lambda_Inner_Interface;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TestLambda_Inner_InterFace {

    private Lambda_Inner_Interface lambda = new Lambda_Inner_Interface();

    @Test
    public void testConsumer(){
        lambda.happy(10000, (m)-> System.out.println("大保健消费了"+m));
    }

    @Test
    public void testSupplier() {
        List<Integer> list = lambda.getNumList(10, () -> (int) (Math.random() * 100));
        System.out.println(list);
    }

    @Test
    public void testFunction() {
        String s1 = lambda.strHandler("\t\t\t  asdf待处理字符串asdf  ", s -> s.trim().toUpperCase());
        System.out.println(s1);
    }

    @Test
    public void testPredicate() {
        List<String> list = new ArrayList<>();
        list.add("11111");
        list.add("22222");
        list.add("33333");
        list.add("44444");
        list.add("55555");

        List<String> result = lambda.filterStr(list, s -> Integer.parseInt(s) > 30000);
        System.out.println(result);
    }
}
