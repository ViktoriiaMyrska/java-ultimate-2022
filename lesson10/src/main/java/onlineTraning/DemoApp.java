package onlineTraning;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;

public class DemoApp {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(7);
        list.add(3);
        list.add(88);
        list.add(33);
        list.add(22);
        list.add(0);
        System.out.println(list);
        ForkJoinPool.commonPool().invoke(new MergeSortTask(list));
        System.out.println(list);
    }

}
