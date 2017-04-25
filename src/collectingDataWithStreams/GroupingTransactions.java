package collectingDataWithStreams;

import model.Currency;
import model.Transaction;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by hahalele on 4/24/17.
 */
public class GroupingTransactions {

    private static List<Transaction> transactions = Arrays.asList( new Transaction(Currency.EUR, 1500.0),
            new Transaction(Currency.USD, 2300.0),
            new Transaction(Currency.GBP, 9900.0),
            new Transaction(Currency.EUR, 1100.0),
            new Transaction(Currency.JPY, 7800.0),
            new Transaction(Currency.CHF, 6700.0),
            new Transaction(Currency.EUR, 5600.0),
            new Transaction(Currency.USD, 4500.0),
            new Transaction(Currency.CHF, 3400.0),
            new Transaction(Currency.GBP, 3200.0),
            new Transaction(Currency.USD, 4600.0),
            new Transaction(Currency.JPY, 5700.0),
            new Transaction(Currency.EUR, 6800.0)
    );


    public static void main(String[] args) {
        groupingByCurrency(transactions);
    }

    public static void groupingByCurrency(List<Transaction> transactions) {

        //old style
        Map<Currency, List<Transaction>> transactionByCurrencies = new HashMap<>();
        for (Transaction transaction : transactions) {
            List<Transaction> curr = transactionByCurrencies.get(transaction.getCurrency());
            if (curr == null) {
                curr = new ArrayList<>();
                transactionByCurrencies.put(transaction.getCurrency(), curr);
            }
            curr.add(transaction);
        }
        System.out.println(transactionByCurrencies);

        //new style - functional programming
        Map<Currency, List<Transaction>> map = transactions.stream().collect(Collectors.groupingBy(Transaction::getCurrency));
        System.out.println(map);
    }
}
