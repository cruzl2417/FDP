package com.example;

public class Rating {
    private double rate;
    private int count;

    // Constructor
    public Rating(double rate, int count) {
        this.rate = rate;
        this.count = count;
    }

    // Getters y Setters
    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    // Método toString
    @Override
    public String toString() {
        return "Rating{" +
                "rate=" + rate +
                ", count=" + count +
                '}';
    }
}
