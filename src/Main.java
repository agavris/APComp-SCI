import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import Week15.Stock;
public class Main {
    public static void main(String[] args) {
        ArrayList<Stock> stocks = new ArrayList<>();
        stocks.add(new Stock("AAPL", 100, 0.1, new ArrayList<Double>(), 1000));
        stocks.add(new Stock("AAPL", 100, 0.1, new ArrayList<Double>(), 111));
        stocks.add(new Stock("MSFT", 100, 0.1, new ArrayList<Double>(), 1000));
        stocks.add(new Stock("GOOG", 100, 0.1, new ArrayList<Double>(), 1000));
        stocks.add(new Stock("AMZN", 100, 0.1, new ArrayList<Double>(), 1000));
        stocks.add(new Stock("FB", 100, 0.1, new ArrayList<Double>(), 1000));
        stocks.add(new Stock("TSLA", 100, 0.1, new ArrayList<Double>(), 1000));
        System.out.println(stocks.get(0).equals(stocks.get(1)));
    }
}