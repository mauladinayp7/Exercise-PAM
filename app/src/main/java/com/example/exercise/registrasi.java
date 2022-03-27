package com.example.exercise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class registrasi extends AppCompatActivity {

    private EditText edusername, edemail, edpassword, edrepass;

    String nama, email, passw, repassw;

    MaterialButton btnsignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrasi);

        edusername = findViewById(R.id.username);
        edemail = findViewById(R.id.email);
        edpassword = findViewById(R.id.password);
        edrepass = findViewById(R.id.repass);
        btnsignup=findViewById(R.id.btnregis);

        btnsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nama = edusername.getText().toString();
                email = edemail.getText().toString();
                passw = edpassword.getText().toString();
                repassw = edrepass.getText().toString();

                if (nama.isEmpty() || email.isEmpty() || passw.isEmpty() || repassw.isEmpty()) {
                    edusername.setError("nama tidak boleh kosong!");
                    edemail.setError("email tidak boleh kosong!");
                    edpassword.setError("password tidak boleh kosong!");
                    edrepass.setError("repassword tidak boleh kosong!");
                } else {
                    if (repassw.equals(passw)) {
                        Toast t = Toast.makeText(getApplicationContext(),
                                "registrasi berhasil!", Toast.LENGTH_LONG);
                        t.show();

                        //membuat objek bundle
                        Bundle b = new Bundle();

                        //memasukkan value dari variabel nama dengan kunci "a" dan password dengan kata kunci "b"
                        //dan dimasukkan ke bundle
                        b.putString("a", nama.trim());
                        b.putString("e", email.trim());
                        b.putString("c", passw.trim());
                        b.putString("d", repassw.trim());

                        Intent i = new Intent(getApplicationContext(), MainActivity.class);

                        i.putExtras(b);

                        startActivity(i);
                    } else {
                        Toast t = Toast.makeText(getApplicationContext(),
                                "registrasi gagal!", Toast.LENGTH_LONG);
                        t.show();
                    }
                }
            }
    });
}}