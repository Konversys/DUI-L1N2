package ru.konverdev.coolteapot;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TimePicker;

public class activity_autobolling extends AppCompatActivity {
    TimePicker timePicker;
    ImageView abWater;
    ImageView abTea;
    ImageView abCoffie;
    ImageView abBear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_autobolling);
        timePicker = findViewById(R.id.timePicker);
        timePicker.setIs24HourView(true);
        abWater = findViewById(R.id.abWater);
        abTea = findViewById(R.id.abTea);
        abCoffie = findViewById(R.id.abCoffie);
        abBear = findViewById(R.id.abBear);

    }

    public void clickAWater(View view) {
        DisableAllItems();
        abWater.setAlpha(1f);
    }

    public void clickATea(View view) {
        DisableAllItems();
        abTea.setAlpha(1f);
    }

    public void clickACoffie(View view) {
        DisableAllItems();
        abCoffie.setAlpha(1f);
    }

    public void clickABear(View view) {
        DisableAllItems();
        abBear.setAlpha(1f);
    }

    private void DisableAllItems() {
        abWater.setAlpha(0.4f);
        abTea.setAlpha(0.4f);
        abCoffie.setAlpha(0.4f);
        abBear.setAlpha(0.4f);
    }
}