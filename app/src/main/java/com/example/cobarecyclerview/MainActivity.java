package com.example.cobarecyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Mhs> mhsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText edNama = (EditText) findViewById(R.id.edNama);
        EditText edNim = (EditText) findViewById(R.id.edNim);
        EditText edNoHp = (EditText) findViewById(R.id.edNoHp);

        Button btnSimpan = (Button) findViewById(R.id.btnSimpan);

        mhsList = new ArrayList<>();

        Intent intent_list = new Intent(MainActivity.this, ListMhsActivity.class);

        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String isian_nama = edNama.getText().toString();
                String isian_nim = edNim.getText().toString();
                String isian_nohp = edNoHp.getText().toString();

                if (isian_nama.isEmpty() || isian_nim.isEmpty() || isian_nohp.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Isian masih kosong", Toast.LENGTH_SHORT).show();
                }else {
                    mhsList.add(new Mhs(isian_nama, isian_nim, isian_nohp));

                    edNama.setText("");
                    edNim.setText("");
                    edNoHp.setText("");

                    // Log.i("tes", String.valueOf(mhsList.size()));
                     // intent_list.putParcelableArrayListExtra("mhsList", mhsList);
                     // startActivity(intent_list);


                }
            }
        });

        Button btnLihat = (Button) findViewById(R.id.btnLihat);

        btnLihat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (mhsList.isEmpty()){
                    Toast.makeText(getApplicationContext(), "belum ada data", Toast.LENGTH_SHORT).show();
                }else {
                    intent_list.putParcelableArrayListExtra("mhsList", mhsList);
                    startActivity(intent_list);
                }

            }
        });

    }
}