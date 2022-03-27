package com.example.exercise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class view extends AppCompatActivity {

    TextView txtask, txjns, txtm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        txtask = findViewById(R.id.textView5);
        txjns = findViewById(R.id.textView7);
        txtm = findViewById(R.id.textView9);

        Bundle bundle = getIntent().getExtras();

        String task = bundle.getString("a");
        String jnstask = bundle.getString("b");
        String tmtask = bundle.getString("c");

        txtask.setText(task);
        txjns.setText(jnstask);
        txtm.setText(tmtask);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.view, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected( MenuItem item) {
        if(item.getItemId() == R.id.logout){
            Intent i = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(i);
        }else{
            Intent i = new Intent(getApplicationContext(), MainMenu.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }
}