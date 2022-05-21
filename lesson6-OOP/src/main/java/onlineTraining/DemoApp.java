package onlineTraining;

//Implement a generic method that accepts and sorts a List of Comparable elements using a recursive Merge Sort algorithm

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DemoApp {

    public static void main(String[] args) {
        List<Integer> elements = List.of(2, 6, 99, 22, 7, 3, 8);
        sort(elements);
    }

    private static void sort(List<Integer> elements) {
        if(elements.size() <=2){
            return;
        }

        var leftSize = elements.size()/2;
        var rightSize = elements.size() - leftSize;

        List<Integer> left = new ArrayList<>();
        for(int i = 1; i < leftSize; i++){
            left.add(elements.get(i));
        }

        List<Integer> right = new ArrayList<>();
        for(int i = 1; i < rightSize; i++){
            right.add(elements.get(i));
        }
        
        sort(left);
        sort(right);
        merge(left, right);

    }

    private static void merge(List<Integer> left, List<Integer> right) {


        return ;
    }


}
