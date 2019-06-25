package com.example.recyclerview_images;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private int[] images;
    private Context context;

    public RecyclerAdapter(int[] images,Context context){
        this.images = images;
        this.context = context;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.imageview,viewGroup,false);
        ViewHolder viewHolder = new ViewHolder(view,context,images);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        int image_id = images[i];
        viewHolder.album.setImageResource(image_id);
        viewHolder.album_title.setText("Image:"+ i);

    }

    @Override
    public int getItemCount() {
        return images.length;
    }
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
         ImageView album;
         TextView album_title;
         Context context;
         int[] images;

        public <context> ViewHolder(@NonNull View itemView, Context context, int[] images) {
            super(itemView);

            album = itemView.findViewById(R.id.album);
            album_title = itemView.findViewById(R.id.album_title);
            itemView.setOnClickListener(this);
            this.context = context;
            this.images = images;


        }

        @Override
        public void onClick(View v) {

            Intent intent = new Intent(context,ImageDisplay.class);
            intent.putExtra("image_id",images[getAdapterPosition()]);

            context.startActivity(intent);
        }
    }
}
