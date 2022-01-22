package dev.ahmadkhan.cryptofolio;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import dev.ahmadkhan.cryptofolio.models.NewsDetails;

public class NewsActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    NewsRecyclerAdapter newsRecyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        recyclerView = findViewById(R.id.newsRecyclerView);
        newsRecyclerAdapter = new NewsRecyclerAdapter(NewsDetails.newsList);
        recyclerView.setAdapter(newsRecyclerAdapter);
    }
}
