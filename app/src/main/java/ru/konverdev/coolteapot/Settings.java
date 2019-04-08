package ru.konverdev.coolteapot;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Settings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
    }

    public void clickSI1(View view) {
        Intent intent = new Intent(this, activity_autobolling.class);
        startActivity(intent);
    }
}
