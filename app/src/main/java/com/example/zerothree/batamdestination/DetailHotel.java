package com.example.zerothree.batamdestination;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailHotel extends AppCompatActivity {

    ImageView GambarHotel;
    TextView JudulHotel, DekskripsiHotel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_hotel);

        GambarHotel = (ImageView)findViewById(R.id.imgHotel);
        JudulHotel = (TextView)findViewById(R.id.txtHotel);
        DekskripsiHotel = (TextView)findViewById(R.id.txtDetailHotel);

        JudulHotel.setText(getIntent().getStringExtra("TempatHotel"));
        DekskripsiHotel.setText(getIntent().getStringExtra("DetailHotel"));
        GambarHotel.setImageResource(getIntent().getIntExtra("FotoHotel", 1));
    }
}
