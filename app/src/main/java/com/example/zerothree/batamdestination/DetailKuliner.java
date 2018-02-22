package com.example.zerothree.batamdestination;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailKuliner extends AppCompatActivity {

    ImageView GambarKuliner;
    TextView JudulKuliner, DekskripsiKuliner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_kuliner);

        GambarKuliner = (ImageView)findViewById(R.id.imgKuliner);
        JudulKuliner = (TextView)findViewById(R.id.txtKuliner);
        DekskripsiKuliner = (TextView)findViewById(R.id.txtDetailKuliner);

        JudulKuliner.setText(getIntent().getStringExtra("TempatKuliner"));
        DekskripsiKuliner.setText(getIntent().getStringExtra("DetailKuliner"));
        GambarKuliner.setImageResource(getIntent().getIntExtra("FotoKuliner", 1));
    }
}
