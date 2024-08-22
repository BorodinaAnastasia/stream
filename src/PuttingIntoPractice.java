import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PuttingIntoPractice {

    public static void main(String... args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        System.out.println("1. Найти все транзакции за 2011 год и отсортировать их по сумме");
        transactions.stream()
                .filter(t -> t.getYear() == 2011)
                .sorted(Comparator.comparingInt(Transaction::getValue))
                .forEach(System.out::println);

        System.out.println("2. Вывести список неповторяющихся городов, в которых работают трейдеры.");
        transactions.stream()
                .map(t1 -> t1.getTrader().getCity())
                .distinct()
                .forEach(System.out::println);

        System.out.println("3. Найти всех трейдеров из Кембриджа и отсортировать их по именам.");
        transactions.stream()
                .map(Transaction::getTrader)
                .filter(t3 -> t3.getCity() == "Cambridge")
                .distinct()
                .sorted((Comparator.comparing(Trader::getName)))
                .forEach(System.out::println);


        System.out.println("4.Вернуть строку со всеми именами трейдеров, отсортированными в алфавитном порядке");
        transactions.stream()
                .map(Transaction::getTrader)
                .distinct()
                .sorted(Comparator.comparing(Trader::getName))
                .forEach(System.out::println);

        System.out.println("5.Cуществует ли хоть один трейдер из Милана.");
        transactions.stream()
                .map(Transaction::getTrader)
                .distinct()
                .filter(t5 -> t5.getCity().equals("Milan"))
                .forEach(System.out::println);

        System.out.println("6. Вывести суммы всех транзакций трейдеров из Кембриджа.");
        transactions.stream()
                .filter(t6 -> t6.getTrader().getCity().equals("Cambridge"))
                .map(Transaction::getValue)
                .forEach(System.out::println);

        System.out.println("7. Максимальная сумма всех транзакций");
        Integer max = transactions.stream()
                .map(Transaction::getValue)
                .max(Integer::compareTo).get();
        System.out.println(max);

        System.out.println("8. Найти транзакцию с минимальной суммой.");
        Integer min = transactions.stream()
                .map(Transaction::getValue)
                .min(Integer::compareTo).get();
        System.out.println(min);
    }
}
