package dev.ahmadkhan.cryptofolio.models;

public class NewsDetails {
    public final String title;
    public final String text;
    public final String imagePath;
    public final String link;

    public NewsDetails(String title, String text, String imagePath, String link) {
        this.title = title;
        this.text = text;
        this.imagePath = imagePath;
        this.link = link;
    }
}
