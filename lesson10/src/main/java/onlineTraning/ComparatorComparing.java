package onlineTraning;

import com.vikmir.data.Accounts;
import com.vikmir.model.Account;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;

public class ComparatorComparing {

    public static void main(String[] args) {
        List<Account> accounts = Accounts.generateAccountList(10);
        var accountWithMaxBalance = accounts
                .stream()
                .max(createComparatorComparing(Account::getBalance))
                .orElseThrow();
        System.out.println("My comparator result: " + accountWithMaxBalance.getBalance());
        List<BigDecimal> collect = accounts.stream()
                .map(Account::getBalance).toList();
        System.out.println("Collections method result: " + Collections.max(collect));
    }

    private static <T, R extends Comparable<? super R>> Comparator<T> createComparatorComparing(Function<? super T, R> extractor) {
        Objects.requireNonNull(extractor);
        return (o1, o2) -> {
            R r1 = extractor.apply(o1);
            R r2 = extractor.apply(o2);
            return r1.compareTo(r2);
        };
    }

    private static <T, R extends Comparable<? super R>> Comparator<T> composeComparatorThenComparing(
            Comparator<? super T> comparator, Function<? super T, ? extends R> extractor) {
        Objects.requireNonNull(comparator);
        Objects.requireNonNull(extractor);
        return (o1, o2) -> {
            if(comparator.compare(o1, o2) == 0){
                return extractor.apply(o1).compareTo(extractor.apply(o2));
            }
            return comparator.compare(o1, o2);
        };
    }

}
