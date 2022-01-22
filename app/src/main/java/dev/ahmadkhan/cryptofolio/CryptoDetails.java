package dev.ahmadkhan.cryptofolio;

import java.util.Arrays;
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
            new CryptoDetails("Bitcoin", "BTC", 36000, "https://cdn4.iconfinder.com/data/icons/crypto-currency-and-coin-2/256/bitoin_btc_coin_crypto-1024.png"),
            new CryptoDetails("Ethereum", "ETH", 4000, "https://cdn4.iconfinder.com/data/icons/cryptocoins/227/ETH-alt-1024.png"),
            new CryptoDetails("Ripple", "XRP", 0.54, "https://cdn0.iconfinder.com/data/icons/cryptocurrency-137/128/1_xrp_coin_xrp_xrp_symbol_xrp_sign_currency_xrp_logo_-362-1024.png")
    );
}
