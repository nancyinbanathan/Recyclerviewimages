package com.example.recyclerview_images;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class ImageDisplay extends AppCompatActivity {

    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_display);


        ImageView imageView = findViewById(R.id.imageDisplay);
        imageView.setImageResource(getIntent().getIntExtra("image_id",00));



    }
}
