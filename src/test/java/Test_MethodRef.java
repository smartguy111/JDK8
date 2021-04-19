import lambda.MethodRef;
import org.junit.Test;

public class Test_MethodRef {
    private MethodRef _methodRef = new MethodRef();

    @Test
    // 对象::实例方法名
    public void testMethodRef(){
        _methodRef.methodRef("ref", x-> System.out.println(x));
        _methodRef.methodRef("ref", System.out::println);
    }


}
