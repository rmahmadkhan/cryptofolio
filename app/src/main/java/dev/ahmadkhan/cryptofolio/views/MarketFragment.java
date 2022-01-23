package dev.ahmadkhan.cryptofolio.views;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import dev.ahmadkhan.cryptofolio.R;
import dev.ahmadkhan.cryptofolio.models.CryptoDetails;

public class MarketFragment extends Fragment {
    public MarketFragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_market, container, false);

        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.cryptoRecyclerView);
        // recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        CryptoRecyclerAdapter cryptoRecyclerAdapter;
        cryptoRecyclerAdapter = new CryptoRecyclerAdapter(CryptoDetails.cryptoList);
        recyclerView.setAdapter(cryptoRecyclerAdapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        return rootView;
    }
}