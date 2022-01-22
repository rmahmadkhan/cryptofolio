package dev.ahmadkhan.cryptofolio;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import dev.ahmadkhan.cryptofolio.models.CryptoDetails;

public class MarketActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    CryptoRecyclerAdapter cryptoRecyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_market);


        recyclerView = findViewById(R.id.cryptoRecyclerView);
        cryptoRecyclerAdapter = new CryptoRecyclerAdapter(CryptoDetails.cryptoList);
        recyclerView.setAdapter(cryptoRecyclerAdapter);
    }
}