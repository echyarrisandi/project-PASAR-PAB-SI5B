package com.example.pab;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class AdapterData extends RecyclerView.Adapter<AdapterData.HolderData> {
    String title[];
    String description[];
    String address[];
    String images[];
    String coordinate[];
    Context context;

    public AdapterData(Context context, String[] title,String address[],String coordinate[], String[] description, String[] images) {
        this.title = title;
        this.description = description;
        this.coordinate = coordinate;
        this.address = address;
        this.images = images;
        this.context = context;
    }

    @NonNull
    @Override
    public HolderData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_data, parent, false);
        return new HolderData(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HolderData holder, int position) {
        holder.tvTitle.setText(title[position]);
        holder.tvAddress.setText(address[position]);
        int res = context.getResources().getIdentifier(images[position], "drawable", context.getPackageName());
        holder.ivImage.setImageResource(res);
        holder.cvData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("title", title[holder.getAdapterPosition()]);
                intent.putExtra("description", description[holder.getAdapterPosition()]);
                intent.putExtra("address", address[holder.getAdapterPosition()]);
                intent.putExtra("coordinate", coordinate[holder.getAdapterPosition()]);
                intent.putExtra("image", res);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return title.length;
    }

    public class HolderData extends RecyclerView.ViewHolder {
        CardView cvData;
        TextView tvTitle;
        TextView tvAddress;
        ImageView ivImage;

        public HolderData(@NonNull View itemView) {
            super(itemView);
            cvData = itemView.findViewById(R.id.cv_data);
            tvTitle = itemView.findViewById(R.id.tv_title);
            ivImage = itemView.findViewById(R.id.iv_image);
            tvAddress = itemView.findViewById(R.id.tv_address);
        }
    }
}
