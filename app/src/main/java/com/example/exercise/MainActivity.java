package com.example.exercise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnSignin;

    TextView registr;

    private EditText Email, Password;

    String e_mail, passw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Email = findViewById(R.id.edEmail);
        Password = findViewById(R.id.edPassword);

        btnSignin = findViewById(R.id.btsignin);

        registr = findViewById(R.id.regissignin);

        registr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), registrasi.class);

                startActivity(i);
            }
        });

        btnSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = getIntent().getExtras();

                e_mail = Email.getText().toString();
                passw = Password.getText().toString();

                String mail = "Pascal";
                String pass = "iniPascal";

                if(e_mail.isEmpty() || passw.isEmpty()){
                    Email.setError("email tidak boleh kosong!");
                    Password.setError("password tidak boleh kosong!");
                }else{
                    if(e_mail.equals(mail) && passw.equals((pass))){
                        Toast t = Toast.makeText(getApplicationContext(),
                        "login berhasil", Toast.LENGTH_LONG);
                        t.show();

                        Bundle bund = new Bundle();

                        bund.putString("f", e_mail.trim());
                        bund.putString("g", passw.trim());

                        Intent i = new Intent(getApplicationContext(), MainMenu.class);

                        i.putExtras(bund);

                        startActivity(i);
                    }else if (e_mail.equals(mail)){
                        Toast t = Toast.makeText(getApplicationContext(),
                        "Password salah!", Toast.LENGTH_LONG);
                        t.show();
                    }else if(passw.equals(pass)){
                        Toast t = Toast.makeText(getApplicationContext(),
                        "Email salah!", Toast.LENGTH_LONG);
                        t.show();
                    }else{
                        Toast t = Toast.makeText(getApplicationContext(),
                        "username dan password salah!", Toast.LENGTH_LONG);
                        t.show();
                    }
                }
            }
        });

    }
}
