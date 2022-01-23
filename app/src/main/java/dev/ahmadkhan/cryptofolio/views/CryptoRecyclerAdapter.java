package dev.ahmadkhan.cryptofolio.views;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import dev.ahmadkhan.cryptofolio.R;
import dev.ahmadkhan.cryptofolio.models.CryptoDetails;

public class CryptoRecyclerAdapter extends RecyclerView.Adapter<CryptoRecyclerAdapter.ViewHolder> {

    private ArrayList<CryptoDetails> cryptoList;

    public CryptoRecyclerAdapter(ArrayList<CryptoDetails> list){
        this.cryptoList = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.crypto_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.name.setText(cryptoList.get(position).name);
        holder.symbol.setText(cryptoList.get(position).symbol);
        holder.price.setText(String.format("%s $", cryptoList.get(position).price));

        // Using Picasso, a third-party library, to load and cache the image
        Picasso.get().load(cryptoList.get(position).imagePath).into(holder.image);
    }

    @Override
    public int getItemCount() {
        return cryptoList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView image;
        TextView name, symbol, price;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.cyptoImage);
            name = itemView.findViewById(R.id.cryptoName);
            symbol = itemView.findViewById(R.id.cryptoSymbol);
            price = itemView.findViewById(R.id.cyptoPrice);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Toast.makeText(view.getContext(), "Clicked", Toast.LENGTH_SHORT).show();
        }
    }
}
