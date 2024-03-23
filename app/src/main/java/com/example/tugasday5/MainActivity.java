package com.example.tugasday5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etNama;
    RadioGroup rgMember;
    RadioButton rbMgold;
    RadioButton rbMsilver;
    RadioButton rbMbiasa;
    EditText etKbarang;
    EditText etJbarang;
    Button btnProses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNama = findViewById(R.id.etNama);
        rgMember = findViewById(R.id.rgMember);
        rbMgold = findViewById(R.id.rbMgold);
        rbMsilver = findViewById(R.id.rbMsilver);
        rbMbiasa = findViewById(R.id.rbMbiasa);
        etKbarang = findViewById(R.id.etKbarang);
        etJbarang = findViewById(R.id.etJbarang);
        btnProses = findViewById(R.id.btnProses);
        btnProses.setOnClickListener(v -> prosesData());
    }
    private void prosesData() {
        int goldBtn = 2131231080;
        int silverBtn = 2131231081;
        int biasaBtn = 2131231079;

        String itemName = etKbarang.getText().toString();
        double Hargabarang = 0;
        String Namabarang = "";

        String nama = etNama.getText().toString();

        int tipePelanggan = rgMember.getCheckedRadioButtonId();
        if (tipePelanggan == goldBtn){
            System.out.println("GOLD");
        } else if (tipePelanggan == silverBtn){
            System.out.println("SILVER");
        } else if (tipePelanggan == biasaBtn){
            System.out.println("BIASA");
        }

        if (itemName.isEmpty()){
            Toast.makeText(this, "Masukkan Nama", Toast.LENGTH_SHORT).show();
        } else if (tipePelanggan != 0) {
            Toast.makeText(this, "Kode barang tidak valid", Toast.LENGTH_SHORT).show();
        }
        System.out.println(itemName);

        String kodeBarang = etKbarang.getText().toString();
        switch (kodeBarang) {
            case "IPX":
                Hargabarang = 5725300;
                Namabarang = "Iphone X";
                break;
            case "AAE":
                Hargabarang = 8676981;
                Namabarang = "Acer Aspire E14";
                break;
            case "MP3":
                Hargabarang = 28999999;
                Namabarang = "Macbook Pro M3";
                break;
            default:
                return;
        }

        System.out.println(kodeBarang);

        int Jumlahbarang = 0;
        try {
            Jumlahbarang = Integer.parseInt(etJbarang.getText().toString());
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Masukkan Jumlah Barang", Toast.LENGTH_SHORT).show();
            return;
        }

        double totalHarga = Hargabarang * Jumlahbarang;
        int selectedId = rgMember.getCheckedRadioButtonId();
        double discountMember = 0;
        String membership = null;
        if (selectedId != -1) {
            RadioButton radioButton = findViewById(selectedId);
            membership = radioButton.getText().toString();
            switch (membership) {
                case "Gold":
                    discountMember = totalHarga * 0.1;
                    break;
                case "Silver":
                    discountMember = totalHarga * 0.05;
                    break;
                case "Biasa":
                    discountMember = totalHarga * 0.02;
                    break;
            }
        }

        if (totalHarga > 10000000) {
            totalHarga -= 100000;
        }

        double discountHarga = (Hargabarang * Jumlahbarang) - totalHarga;
        double jumlahBayar = totalHarga - discountMember;

        Intent jualbeli = new Intent(this, MainActivity2.class);
        jualbeli.putExtra("Name", itemName);
        jualbeli.putExtra("Membership", membership);
        jualbeli.putExtra("HargaBarang", Hargabarang);
        jualbeli.putExtra("NamaBarang", Namabarang);
        jualbeli.putExtra("DiscountHarga", discountHarga);
        jualbeli.putExtra("DiscountMember", discountMember);
        jualbeli.putExtra("TotalHarga", totalHarga);
        jualbeli.putExtra("JumlahBayar", jumlahBayar);
        startActivity(jualbeli);
    }
}