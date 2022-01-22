package dev.ahmadkhan.cryptofolio;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CryptoDetails {
    final String name;
    final String symbol;
    final double price;
    final String imagePath;

    public CryptoDetails(String name, String symbol, double price, String imagePath) {
        this.name = name;
        this.symbol = symbol;
        this.price = price;
        this.imagePath = imagePath;
    }

    public static List<CryptoDetails> cryptoList = Arrays.asList(
            new CryptoDetails("Bitcoin", "BTC", 36000, ""),
            new CryptoDetails("Ethereum", "ETH", 4000, ""),
            new CryptoDetails("Ripple", "XRP", 0.54, "")
    );
}
