package onlineTraning;

import com.vikmir.data.Accounts;
import com.vikmir.model.Account;

import java.util.Comparator;

public class ReflectionDemo {
    public static void main(String[] args) {
        Comparator<Account> accountComparator = new RandomFieldComparator<>(Account.class);
        System.out.println(accountComparator);
        Accounts.generateAccountList(10)
                .stream()
                .sorted(accountComparator)
                .forEach(System.out::println);
    }
}
