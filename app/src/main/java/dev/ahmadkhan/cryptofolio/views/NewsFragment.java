package dev.ahmadkhan.cryptofolio.views;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import dev.ahmadkhan.cryptofolio.R;
import dev.ahmadkhan.cryptofolio.models.NewsDetails;

public class NewsFragment extends Fragment {
    public NewsFragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_news, container, false);

        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.newsRecyclerView);
        // recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        NewsRecyclerAdapter newsRecyclerAdapter;
        newsRecyclerAdapter = new NewsRecyclerAdapter(NewsDetails.newsList);
        recyclerView.setAdapter(newsRecyclerAdapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        return rootView;
    }
}
