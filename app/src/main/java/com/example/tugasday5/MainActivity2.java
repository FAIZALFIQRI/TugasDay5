package com.example.tugasday5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.Locale;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener {

    TextView tvSdatang;
    TextView tvTmember;
    TextView tvNbar;
    TextView tvHarga;
    TextView tvTharga;
    TextView tvDharga;
    TextView tvDmember;
    TextView tvJbayar;
    Button btnShare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String nama = extras.getString("Name");
            String membership = extras.getString("Membership");
            String namaBarang = extras.getString("NamaBarang");
            double hargaBarang = extras.getDouble("HargaBarang");
            double totalHarga = extras.getDouble("TotalHarga");
            double discountHarga = extras.getDouble("DiscountHarga");
            double discountMember = extras.getDouble("DiscountMember");
            double jumlahBayar = extras.getDouble("JumlahBayar");

            tvSdatang = findViewById(R.id.tvSdatang);
            tvTmember = findViewById(R.id.tvTmember);
            tvNbar = findViewById(R.id.tvNbar);
            tvHarga = findViewById(R.id.tvHarga);
            tvTharga = findViewById(R.id.tvTharga);
            tvDharga = findViewById(R.id.tvDharga);
            tvDmember = findViewById(R.id.tvDmember);
            tvJbayar = findViewById(R.id.tvJbayar);
            btnShare = findViewById(R.id.btnShare);

            Locale localeID = new Locale("in", "ID");
            NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(localeID);


            tvSdatang.setText("Selamat Datang " + nama);
            tvTmember.setText("Tipe Member " + membership);
            tvNbar.setText("Nama Barang: " + namaBarang);
            tvHarga.setText("Harga: " + formatRupiah.format(hargaBarang));
            tvTharga.setText("Total Harga: " + formatRupiah.format(totalHarga));
            tvDharga.setText("Discount Harga: " + formatRupiah.format(discountHarga));
            tvDmember.setText("Discount Member: " + formatRupiah.format(discountMember));
            tvJbayar.setText("Jumlah Bayar: " + formatRupiah.format(jumlahBayar));

            btnShare.setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View v) {
        Intent intentshare = new Intent();
        intentshare.setAction(Intent.ACTION_SEND);
        intentshare.putExtra(Intent.EXTRA_TEXT, "INI TOKO PENJUALAN PAKAIAN");
        intentshare.setType("plain/text");

        if (intentshare.resolveActivity(getPackageManager()) != null) {
            startActivity(intentshare);
            {

            }
        }
    }
}
