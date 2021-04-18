import lambda.Lambda1;
import lambda.MyFunction;
import org.junit.Test;

public class TestLambda1 {
    private Lambda1 lambda1 = new Lambda1();
    @Test
    public void test1() {
        lambda1.lambda1();
    }
    @Test
    public void test2() {
        lambda1.lambda2();
    }

    @Test
    public void test3() {
        lambda1.lambda3();
    }

    @Test
    public void test4() {
        lambda1.lambda4();
    }

    @Test
    public void test5() {
        Integer res = lambda1.operation(100, new MyFunction() {
            @Override
            public Integer getValue(Integer num) {
                return num * num;
            }
        });
        System.out.println(res);
        System.out.println( "-------------");

        System.out.println(lambda1.operation(100, num -> num * num));
    }

}
