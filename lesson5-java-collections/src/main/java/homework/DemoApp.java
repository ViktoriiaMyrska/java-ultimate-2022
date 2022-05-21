package homework;

import com.vikmir.data.Accounts;
import com.vikmir.model.Account;

public class DemoApp {

    public static void main(String[] args) {
        RandomFieldComparator<Account> comparator = new RandomFieldComparator<>(Account.class);
        System.out.println(comparator);
        var accounts = Accounts.generateAccountList(20);
        accounts.stream()
                .sorted(comparator)
                .forEach(System.out::println);
    }

}
