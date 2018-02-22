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

public class Kuliner extends AppCompatActivity {

    RecyclerView Kulinermenu;
    Kuliner.CustomAdapter adpater;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kuliner);

        Kulinermenu = (RecyclerView)findViewById(R.id.menuKuliner);
        Kulinermenu.setLayoutManager(new LinearLayoutManager(this));
        adpater = new CustomAdapter();
        Kulinermenu.setAdapter(adpater);
    }

    String [] tempatKuliner = {
            "Gong - Gong", "Luti Gendang", "Mi Lendir", "Mi Sagu", "Mi Tarempa"
    };
    int [] fotoKuliner = {
            R.drawable.gong,
            R.drawable.luti,
            R.drawable.milendir,
            R.drawable.misagu,
            R.drawable.mitarempa
    };
    String [] detailKuliner = {
            "Gong-gong adalah sejenis siput laut yang diolah dengan cara direbus atau ditumis dengan bumbu-bumbu khusus. Mungkin Anda dapat menjumpai menu makanan ini di berbagai restoran seafood yang ada di Indonesia, tetapi di Batam gong-gong merupakan ikon kuliner yang dapat ditemukan dengan mudah di semua restoran sari laut yang ada di sana.", "Satu lagi kuliner khas Batam yang tidak boleh dilewatkan adalah Luti Gendang. Yang satu ini bukanlah jenis makanan berat, melainkan cemilan saja. Luti Gendang adalah kue yang menyerupai kroket. Hanya saja, jika kroket memiliki isi ragout, Luti Gendang ini diisi dengan ikan yang dimasak dengan bumbu-bumbu tertentu. Dengan kata lain, Luti Gendang ini juga dikenal sebagai roti goreng isi ikan.", "Apa itu mi lendir? Kok tampilannya mirip dengan Mi Kocok khas Aceh? Ya, menu makanan yang satu ini mungkin memiliki rupa yang sedikit mirip dengan Mi Kocok Aceh atau Emie khas Medan. Namun, rasa dari Mi Lendir tentu berbeda dengan kedua jenis hidangan mi tersebut.", "Jika biasanya sagu digunakan untuk membuat kue, kali ini sagu digunakan sebagai bahan utama untuk membuat mi. Di Batam, Anda bisa menemukan suatu menu makanan khas yang unik, yakni Mi Sagu. Ukuran dari mi sagu lebih besar dari mi pada umumnya. Selain itu, mi ini memiliki aroma sagu yang sangat pekat.", "Selain Mie Lendir, ada juga Mie Tarempa yang merupakan makanan khas Batam. Jenis mie yang dipakai untuk memasak Mie Tarempa ini adalah mie gepeng alias mie dengan bentuk yang agak lebar. Kemudian, mie tersebut dimasak dengan bahan dan rempah yang hampir sama seperti membuat mie goreng biasa."
    };

    private class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {
        @Override
        public CustomAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.listlist, null);
            return new CustomAdapter.MyViewHolder(v);
        }

        @Override
        public void onBindViewHolder(CustomAdapter.MyViewHolder holder, final int position) {
            holder.judul.setText(tempatKuliner[position]);
            holder.img.setImageResource(fotoKuliner[position]);
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent a2 = new Intent(getApplicationContext(), DetailKuliner.class);
                    a2.putExtra("TempatKuliner", tempatKuliner[position]);
                    a2.putExtra("FotoKuliner", fotoKuliner[position]);
                    a2.putExtra("DetailKuliner", detailKuliner[position]);
                    startActivity(a2);
                }
            });
        }

        @Override
        public int getItemCount() {
            return tempatKuliner.length;
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
