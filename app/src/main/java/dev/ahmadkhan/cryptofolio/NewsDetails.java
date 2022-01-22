package dev.ahmadkhan.cryptofolio;

import java.util.Arrays;
import java.util.List;

public class NewsDetails {
    final String title;
    final String text;
    final String imagePath;

    public NewsDetails(String title, String text, String imagePath) {
        this.title = title;
        this.text = text;
        this.imagePath = imagePath;
    }

    public static List<NewsDetails> newsList = Arrays.asList(
            new NewsDetails("News 1", "Text for news 1",  "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRP97gbb4ASJYSUkdtSI5GhODCvLoO0QVX7aA&usqp=CAU"),
            new NewsDetails("News 2", "Text for news 2",  "https://d1csarkz8obe9u.cloudfront.net/posterpreviews/news-background-design-template-db1bc18b8f91b11bb5e1594a5032e1db.jpg?ts=1589089157"),
            new NewsDetails("News 3", "Text for news 3",  "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRp6Wydfl6p4mUE7rJ26HhvNU9stLN2EXlzOw&usqp=CAU")
    );
}
