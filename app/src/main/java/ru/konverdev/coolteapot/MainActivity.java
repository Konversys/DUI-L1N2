package ru.konverdev.coolteapot;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

import model.TeapotSettings;

public class MainActivity extends AppCompatActivity {

    TextView changeTurn;
    TextView currentStatus;
    ImageView currentStatusColor;
    ImageView mainWater;
    ImageView mainTea;
    ImageView mainCoffie;
    ImageView mainBear;
    TextView curTemp;
    Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TeapotSettings.SetDefault();
        curTemp = findViewById(R.id.currentTemp);
        changeTurn = findViewById(R.id.changeTurn);
        currentStatus = findViewById(R.id.currentStatus);
        currentStatusColor = findViewById(R.id.currentStatusColor);
        mainWater = findViewById(R.id.mainWater);
        mainTea = findViewById(R.id.mainTea);
        mainCoffie = findViewById(R.id.mainCoffie);
        mainBear = findViewById(R.id.mainBear);
        timer = new Timer();
        timer.schedule(new TimerTaskTemp(), 0,1000);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_basic, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_rasp) {
            Intent intent = new Intent(this, activity_autobolling.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    public void ChangeTurnStatus(View view) {
        if (!TeapotSettings.isTurnOn()) {
            changeTurn.setText("Выключить");
            currentStatus.setText("Чайник нагревается");
            currentStatusColor.setColorFilter(getResources().getColor(R.color.colorAccent));
            TeapotSettings.setTurnOn(true);
        } else {
            changeTurn.setText("Включить");
            currentStatus.setText("Чайник остывает");
            currentStatusColor.setColorFilter(getResources().getColor(R.color.colorSubBlue));
            TeapotSettings.setTurnOn(false);
        }
    }

    public void clickMBear(View view) {
        if (TeapotSettings.isTurnOn())
            return;
        DisableAllItems();
        mainBear.setAlpha(1f);
    }

    public void clickMCoffie(View view) {
        if (TeapotSettings.isTurnOn())
            return;
        DisableAllItems();
        mainCoffie.setAlpha(1f);
    }

    public void clickMTea(View view) {
        if (TeapotSettings.isTurnOn())
            return;
        DisableAllItems();
        mainTea.setAlpha(1f);
    }

    public void clickMWater(View view) {
        if (TeapotSettings.isTurnOn())
            return;
        DisableAllItems();
        mainWater.setAlpha(1f);
    }

    private void DisableAllItems() {
        mainWater.setAlpha(0.4f);
        mainTea.setAlpha(0.4f);
        mainCoffie.setAlpha(0.4f);
        mainBear.setAlpha(0.4f);
    }

    class TimerTaskTemp extends TimerTask {

        @Override
        public void run() {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (TeapotSettings.isTurnOn()) {
                        TeapotSettings.TempUp();
                    } else {
                        TeapotSettings.TempDown();
                    }
                    String str = "Температура: " + TeapotSettings.getCurTemp() + "°";
                    curTemp.setText(str);
                }
            });
        }
    }
}