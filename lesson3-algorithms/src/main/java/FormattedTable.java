import java.util.HashMap;

public class FormattedTable {

    public static void main(String[] args) {
        String[] input = new String[]{"1", "2", "3", "x", "5", "6", "a", "porosiatko", "c", "10", "11", "12", "13", "14", "15", "16"};
        printIntoFormattedTable(input);
    }

    private static void printIntoFormattedTable(String[] input) {

        HashMap<Integer, Integer> columnWidth = new HashMap<>();
        int i = 0;
        int k = 0;
        while (i < input.length) {
            while (k < 5 && i < input.length) {
                if(columnWidth.get(k) != null){
                    int previousWidth = columnWidth.get(k);
                    if(previousWidth < input[i].length()){
                        columnWidth.put(k, input[i].length());
                    }
                } else {
                    columnWidth.put(k, input[i].length());
                }
                k++;
                i++;
            }
            k = 0;
        }

        i = 0;
        String space = " ";
        while (i < input.length) {
            while (k < 5 && i < input.length) {
                System.out.print(input[i]);
                System.out.print(space.repeat(columnWidth.get(k) - input[i].length() + 4));
                k++;
                i++;
            }
            k = 0;
            System.out.print("\n");
        }

    }

}

