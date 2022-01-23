package dev.ahmadkhan.cryptofolio.models;

import java.util.Arrays;
import java.util.List;

public class CryptoDetails {
    public final String name;
    public final String symbol;
    public final double price;
    public final String imagePath;

    public CryptoDetails(String name, String symbol, double price, String imagePath) {
        this.name = name;
        this.symbol = symbol;
        this.price = price;
        this.imagePath = imagePath;
    }
}
