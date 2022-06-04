package onlineTraning;

import java.util.List;
import java.util.concurrent.RecursiveAction;

public class MergeSortTask <T> extends RecursiveAction {

    private List<T> list;
    private int n;

    public MergeSortTask(List<T> list) {
        this.list = list;
        this.n = list.size();
    }

    @Override
    protected void compute() {
        if(list.size() == 1)
            return;
        var left = list.subList(0, n/2);
        var right = list.subList(n/2, n);
        var leftTask = new MergeSortTask(left);
        var rightTask = new MergeSortTask(right);
        leftTask.fork();
        rightTask.compute();
        leftTask.join();
        merge(left, right);
    }

    private <T> void merge(List<T> left, List<T> right) {
        var i = 0;
        var j = 0;
        int z = 0;
        while (i < left.size() && j < right.size()){
//            if(left.get(i) < right.get(j)){
//                list.set(z++) = left.get(i);
//            } else {
//                list.set(z++) = right.get(j);
//            }
        }
    }
}
