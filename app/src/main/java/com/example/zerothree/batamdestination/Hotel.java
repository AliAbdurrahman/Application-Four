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

public class Hotel extends AppCompatActivity {

    RecyclerView Hotelmenu;
    CustomAdapter adpater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel);

        Hotelmenu = (RecyclerView)findViewById(R.id.menuHotel);
        Hotelmenu.setLayoutManager(new LinearLayoutManager(this));
        adpater = new CustomAdapter();
        Hotelmenu.setAdapter(adpater);
    }

    String [] tempatHotel = {
            "Harris Hotel", "Hotel 01", "Pacific Hotel", "Wisma Batam", "Sky-inn Hotel"
    };
    int [] fotoHotel = {
            R.drawable.harishotel,
            R.drawable.hotelkosong,
            R.drawable.pacifichotel,
            R.drawable.pihhotel,
            R.drawable.skyhotel
    };
    String [] detailHotel = {
            "Menghadap ke laut, semenit dari terminal Ferry Pusat Batam Internasional, berjalan kaki ke pusat perbelanjaan dan ke kantor Pemerintah, hotel ini merupakan tempat menginap untuk menikmati pertemuan bisnis dan liburan.",
            "Hotel 01 terletak di Jl. Engku Putri No. 1 Batam Center Indonesia. Hotel kami adalah satu-satunya hotel di Batam yang memiliki konsep Timur Tengah (Mesir), dan memiliki fasilitas 104 kamar, Restaurant, Seafood, Club 23, Massage and Stage Entertainment.",
            "Secara khas dibangun sebagai kapal kolosal, properti elegan ini berjarak hanya lima menit dari Terminal Feri Harbour Bay, yang memungkinkan akses mudah ke kawasan perbelanjaan yang semarak. Pacific Palace Hotel adalah tempat yang cocok untuk menelusuri kota yang hidup ini. Dari sini, para tamu dapat menikmati akses mudah ke semua hal yang dapat ditemukan di sebuah kota yang hidup.",
            "Hotel PIH atau Pusat Informasi Haji ini terletak di Jalan Engku Putri, Batam Pusat, Pulau Batam. Hotel bintang 1 ini juga memiliki berbagai macam pilihan kamar yang siap ditempati. Harga setiap kamar yang ditawarkan oleh hotel PIH berkisar antara 360.000 hingga 820.000. Ciri khas dari hotel ini menggunakan konsep Syariat Islam.",
            "Tersedia beraneka fasilitas di Sky Inn Batam Hotel yang para tamu dapat manfaatkan termasuk di antaranya dry clean, layanan kamar 24 jam dan kafe. Sebagai tambahan, pelayanan hotel meliputi layanan laundry. "
    };

    private class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {
        @Override
        public CustomAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.listlist, null);
            return new CustomAdapter.MyViewHolder(v);
        }

        @Override
        public void onBindViewHolder(CustomAdapter.MyViewHolder holder, final int position) {
            holder.judul.setText(tempatHotel[position]);
            holder.img.setImageResource(fotoHotel[position]);
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent a3 = new Intent(getApplicationContext(), DetailHotel.class);
                    a3.putExtra("TempatHotel", tempatHotel[position]);
                    a3.putExtra("FotoHotel", fotoHotel[position]);
                    a3.putExtra("DetailHotel", detailHotel[position]);
                    startActivity(a3);
                }
            });
        }

        @Override
        public int getItemCount() {
            return tempatHotel.length;
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
