package onlineTraning;

public class NotNullService {

    public void test1(@NotNull Integer param1, String param2){
        System.out.println("Test1 run");
    }

    public void test2( int param1, String param2){
        System.out.println("Test2 run");
    }

}
