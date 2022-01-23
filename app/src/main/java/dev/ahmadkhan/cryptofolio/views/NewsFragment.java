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

import dev.ahmadkhan.cryptofolio.R;
import dev.ahmadkhan.cryptofolio.models.NewsDetails;

public class NewsFragment extends Fragment {
    private ArrayList<NewsDetails> newsList;
    private NewsRecyclerAdapter newsRecyclerAdapter;

    public NewsFragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_news, container, false);

        newsList = new ArrayList<>();

        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.newsRecyclerView);

        newsRecyclerAdapter = new NewsRecyclerAdapter(newsList);
        recyclerView.setAdapter(newsRecyclerAdapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        getData();

        return rootView;
    }


    private void getData() {
        String url = "https://newsdata.io/api/1/news?apikey=pub_3936a5d450e6055e0bed734842ad6aa6a7ac&q=crypto";
        RequestQueue queue = Volley.newRequestQueue(getContext());
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, response -> {

            try {
                JSONArray dataArray = response.getJSONArray("results");
                for (int i = 0; i < dataArray.length(); i++) {
                    JSONObject dataObj = dataArray.getJSONObject(i);
                    String title = dataObj.getString("title");
                    String description = dataObj.getString("description");
                    String imagePath = dataObj.getString("image_url");
                    String link = dataObj.getString("link");

                    newsList.add(new NewsDetails(title, description, imagePath, link));
                }
                newsRecyclerAdapter.notifyDataSetChanged();
            } catch (JSONException e) {
                e.printStackTrace();
                Toast.makeText(getContext(), "Something went wrong. Please try again later", Toast.LENGTH_SHORT).show();
            }
        }, error -> Toast.makeText(getContext(), "Something went amiss. Please try again later", Toast.LENGTH_SHORT).show());
        queue.add(jsonObjectRequest);
    }
}
