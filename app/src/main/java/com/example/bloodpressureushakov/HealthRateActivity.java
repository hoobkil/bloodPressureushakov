package com.example.bloodpressureushakov;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;

public class HealthRateActivity extends AppCompatActivity {
    TextView weigth;
    TextView stepCount;
    Button saveButton;
    HealthRateClass health = new HealthRateClass();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_rate);
        getSupportActionBar().setTitle(R.string.saveHealthRate);

        init();
    }

    public void init() {
        weigth = findViewById(R.id.weigth);
        stepCount = findViewById(R.id.stepCount);
        saveButton = findViewById(R.id.saveButton);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("info", "Пользователь попытался сохранить данные");
                String weigthValue = weigth.getText().toString();
                String stepCountValue = stepCount.getText().toString();

                try {
                    int weigthValueInt = Integer.parseInt(weigthValue);
                    int stepCountValueInt = Integer.parseInt(stepCountValue);
                    health.addData(weigthValueInt, stepCountValueInt);
                    Toast.makeText(HealthRateActivity.this, R.string.successSave,
                            Toast.LENGTH_LONG).show();
                } catch (Exception ex) {
                    Log.e("error", "Ошибка", ex);
                    Toast.makeText(HealthRateActivity.this,
                            R.string.saveBtnError,
                            Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
