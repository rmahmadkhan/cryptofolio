package dev.ahmadkhan.cryptofolio.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import android.os.Bundle;
import android.view.MenuItem;

import dev.ahmadkhan.cryptofolio.R;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);

        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.market);

    }
    MarketFragment marketFragment = new MarketFragment();
    NewsFragment newsFragment = new NewsFragment();

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.market:
                getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, marketFragment).commit();
                return true;

            case R.id.news:
                getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, newsFragment).commit();
                return true;
        }
        return false;
    }
}

