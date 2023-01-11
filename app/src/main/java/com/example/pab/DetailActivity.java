package com.example.pab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DetailActivity extends AppCompatActivity {
    ImageView ivImage;
    TextView tvTitle,tvDescription,tvAddress;
    Button btnLocation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ivImage = findViewById(R.id.iv_image);
        tvTitle = findViewById(R.id.tv_title);
        tvAddress = findViewById(R.id.tv_address);
        tvDescription = findViewById(R.id.tv_description);
        btnLocation = findViewById(R.id.btn_location);

        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        String description = intent.getStringExtra("description");
        String address = intent.getStringExtra("address");
        String coordinate = intent.getStringExtra("coordinate");
        int res = intent.getIntExtra("image",0);
        ivImage.setImageResource(res);
        tvTitle.setText(title);
        tvAddress.setText(address);
        tvDescription.setText(description);
        btnLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String uri = "geo:"+coordinate+"?q="+address;
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                startActivity(intent);
            }
        });
    }
}