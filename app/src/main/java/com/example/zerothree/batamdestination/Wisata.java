package com.example.zerothree.batamdestination;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class Wisata extends AppCompatActivity {

    RecyclerView Wisatamenu;
    CustomAdapter adpater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wisata);


        Wisatamenu = (RecyclerView)findViewById(R.id.menuWisata);
        Wisatamenu.setLayoutManager(new LinearLayoutManager(this));
        adpater = new CustomAdapter();
        Wisatamenu.setAdapter(adpater);
    }

    String [] tempatWisata = {
            "Jembatan Barelang", "Mega Wisata Ocarina", "Alun - Alun Engku Putri", "Masjid Agung Batam", "Bukit Senyum"
    };
    int [] fotoWisata = {
            R.drawable.jb,
            R.drawable.ocarina,
            R.drawable.alun,
            R.drawable.masjid,
            R.drawable.bukit
    };
    String [] detailWisata = {
            "Jembatan Barelang merupakan sebuah bangunan yang telah menjadi ikon Batam. Jembatan ini menghubungkan banyak pulau sekaligus dengan tujuan untuk memajukan perindustrian. Jembatan Barelang sangat terkenal sampai-sampai yang diingat pertama kali ketika menyebut kata Batam adalah Jembatan Barelang. Jembatan ini juga sering disebut sebagai Jembatan Habibie karena beliaulah yang merencanakan pembangunan jembatan ini pada tahun 1992.", "Ocarina Park adalah Ancol-nya Batam. Dibuka tahun 2008, tempat ini termasuk baru, namun sudah menjadi salah satu tempat wisata di Batam yang wajib dikunjungi. Menempati lahan seluas kurang lebih 40 hektar, Ocarina Park menawarkan wahana permainan yang cocok untuk anak-anak dan dewasa. Selain area bermain, Ocarina Park juga sering kali digunakan sebagai tempat acara besar seperti konser musik. Harga tiket masuk Ocarina Park adalah 5,000 Rupiah per orang, tidak termasuk harga bermain di wahana permainan.", "Alun - Alun", "Masjid Raya", "Bukit Senyum, sesuai dengan namanya, adalah kawasan perbukitan yang ada di Batam. Bukit ini bukan bukit biasa, dari bukit ini Anda dapat melihat keindahan kota Singapura, terutama pada saat malam hari. Uniknya lagi, Anda juga dapat melihat pesawat datang dan pergi dari bandara Changi. Di Bukit Senyum Anda akan menemukan berbagai jenis tempat nongkrong untuk menikmati pemandangan. Waktu terbaik untuk datang ke Bukit Senyum adalah pada saat tahun baru karena Anda dapat dengan jelas melihat gemerlapnya kembang api dari atas Bukit Senyum."
    };

    private class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {
        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.listlist, null);
            return new MyViewHolder(v);
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, final int position) {
            holder.judul.setText(tempatWisata[position]);
            holder.img.setImageResource(fotoWisata[position]);
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent a1 = new Intent(getApplicationContext(), DetailWisata.class);
                    a1.putExtra("TempatWisata", tempatWisata[position]);
                    a1.putExtra("FotoWisata", fotoWisata[position]);
                    a1.putExtra("DetailWisata", detailWisata[position]);
                    startActivity(a1);
                }
            });
        }

        @Override
        public int getItemCount() {
            return tempatWisata.length;
        }

        public class MyViewHolder extends RecyclerView.ViewHolder {
            TextView judul;
            ImageView img;
            public MyViewHolder(View itemView) {
                super(itemView);

                judul = itemView.findViewById(R.id.judul);
                img = itemView.findViewById(R.id.img);

            }
        }
    }
}


