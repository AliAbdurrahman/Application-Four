package com.example.zerothree.batamdestination;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailWisata extends AppCompatActivity {

    ImageView GambarWisata;
    TextView JudulWisata, DekskripsiWisata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_wisata);

        GambarWisata = (ImageView)findViewById(R.id.imgWisata);
        JudulWisata = (TextView)findViewById(R.id.txtWisata);
        DekskripsiWisata = (TextView)findViewById(R.id.txtDetailWisata);

        JudulWisata.setText(getIntent().getStringExtra("TempatWisata"));
        DekskripsiWisata.setText(getIntent().getStringExtra("DetailWisata"));
        GambarWisata.setImageResource(getIntent().getIntExtra("FotoWisata", 1));
    }
}
