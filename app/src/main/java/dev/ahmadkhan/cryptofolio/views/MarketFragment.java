package dev.ahmadkhan.cryptofolio.views;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import dev.ahmadkhan.cryptofolio.R;
import dev.ahmadkhan.cryptofolio.models.CryptoDetails;

public class MarketFragment extends Fragment {
    private ArrayList<CryptoDetails> cryptoList;
    private CryptoRecyclerAdapter cryptoRecyclerAdapter;

    public MarketFragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_market, container, false);

        cryptoList = new ArrayList<>();

        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.cryptoRecyclerView);
        // recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        cryptoRecyclerAdapter = new CryptoRecyclerAdapter(cryptoList);
        recyclerView.setAdapter(cryptoRecyclerAdapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        getData();

        return rootView;
    }


    private void getData() {
        String url = "https://pro-api.coinmarketcap.com/v1/cryptocurrency/listings/latest";
        RequestQueue queue = Volley.newRequestQueue(getContext());
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, response -> {

            try {
                JSONArray dataArray = response.getJSONArray("data");
                for (int i = 0; i < dataArray.length(); i++) {
                    JSONObject dataObj = dataArray.getJSONObject(i);
                    String symbol = dataObj.getString("symbol");
                    String name = dataObj.getString("name");
                    // String logo = dataObj.getString("logo");
                    String logo = "https://cryptologos.cc/logos/" + name.toLowerCase() +"-" + symbol.toLowerCase() +"-logo.png";
                    JSONObject quote = dataObj.getJSONObject("quote");
                    JSONObject USD = quote.getJSONObject("USD");
                    double price = USD.getDouble("price");
                    // adding all data to our array list.
                    cryptoList.add(new CryptoDetails(name, symbol, price, logo));
                }
                cryptoRecyclerAdapter.notifyDataSetChanged();
            } catch (JSONException e) {
                e.printStackTrace();
                Toast.makeText(getContext(), "Something went wrong. Please try again later", Toast.LENGTH_SHORT).show();
            }
        }, error -> {
            Toast.makeText(getContext(), "Something went amiss. Please try again later", Toast.LENGTH_SHORT).show();
        }) {
            @Override
            public Map<String, String> getHeaders() {
                HashMap<String, String> headers = new HashMap<>();
                headers.put("X-CMC_PRO_API_KEY", "8d185ff7-5c02-41da-9ce8-a1ead8b8cdea");
                return headers;
            }
        };
        queue.add(jsonObjectRequest);
    }

}