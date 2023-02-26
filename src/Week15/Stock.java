package Week15;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Collections;

public class Stock implements Comparable {
    private String ticker;
    private double currentPrice;
    private final double pastYearIncrease;
    private final ArrayList<Double> past10Days;
    private final int volume;

    public Stock(String ticker, double currentPrice, double pastYearIncrease, ArrayList<Double> past10Days, int volume) {
        this.ticker = ticker;
        this.currentPrice = currentPrice;
        this.pastYearIncrease = pastYearIncrease;
        this.past10Days = past10Days;
        this.volume = volume;
    }

    public String getTicker() {
        return this.ticker;
    }

    public double getCurrentPrice() {
        return this.currentPrice;
    }

    public double getPastYearIncrease() {
        return this.pastYearIncrease;
    }

    public ArrayList<Double> getPastMonthlyPrices() {
        return this.past10Days;
    }

    public int getVolume() {
        return this.volume;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public void setCurrentPrice(double currentPrice) {
        this.currentPrice = currentPrice;
    }

    public double bestBuy() {
        double bestBuy = this.past10Days.get(0);
        for (Double past10Day : this.past10Days) {
            if (past10Day < bestBuy) {
                bestBuy = past10Day;
            }
        }
        return bestBuy;
    }

    public double bestSell() {
        double bestSell = this.past10Days.get(0);
        for (Double past10Day : this.past10Days) {
            if (past10Day > bestSell) {
                bestSell = past10Day;
            }
        }
        return bestSell;
    }


    @Override
    public int compareTo(Object o) {
        int last = this.ticker.compareTo(((Stock)o).getTicker());
        return last == 0 ? this.ticker.compareTo(((Stock)o).getTicker()) : last;
    }


    @Override
    public String toString(){
        return this.ticker + " " + this.currentPrice + " " + this.pastYearIncrease + " " + this.past10Days + " " + this.volume;
    }

    @Override
    public boolean equals(Object o) {
        if(o == this) return true;
        if(!(o instanceof Stock)) return false;

        Stock c = (Stock) o;
        return Objects.equals(this.ticker, c.getTicker()) &&
                Objects.equals(this.currentPrice, c.getCurrentPrice()) &&
                Objects.equals(this.pastYearIncrease, c.getPastYearIncrease()) &&
                Objects.equals(this.past10Days, c.getPastMonthlyPrices()) &&
                Objects.equals(this.volume, c.getVolume());
    }

    public static void main(String[] args) {
        ArrayList<Double> past10Days = new ArrayList<>();
        past10Days.add(100.0);
        past10Days.add(101.0);
        past10Days.add(102.0);
        past10Days.add(103.0);
        past10Days.add(104.0);
        past10Days.add(105.0);
        past10Days.add(106.0);
        past10Days.add(107.0);
        past10Days.add(108.0);
        past10Days.add(109.0);

        ArrayList<Stock> stocks = new ArrayList<>();
        stocks.add(new Stock("AAPL", 100.0, 0.0, past10Days, 100));
        stocks.add(new Stock("MSFT", 100.0, 0.0, past10Days, 100));
        stocks.add(new Stock("AAPL", 100.0, 0.0, past10Days, 100));
        stocks.add(new Stock("GOOG", 100.0, 0.0, past10Days, 100));
        stocks.add(new Stock("AMZN", 100.0, 0.0, past10Days, 100));
        stocks.add(new Stock("FB", 100.0, 0.0, past10Days, 100));
        stocks.add(new Stock("TSLA", 100.0, 0.0, past10Days, 100));

        System.out.println(stocks);

        Collections.sort(stocks);

        System.out.println(stocks);

        System.out.println(stocks.get(0).equals(stocks.get(1)));
        System.out.println(stocks.get(0).equals(stocks.get(2)));

        System.out.println(stocks.get(0).toString());
    }

}