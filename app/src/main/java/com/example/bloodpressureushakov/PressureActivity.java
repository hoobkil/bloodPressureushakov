package com.example.bloodpressureushakov;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;
import java.util.Set;

public class PressureActivity extends AppCompatActivity {
    TextView highPressure;
    TextView lowPressure;
    TextView pulse;
    Button saveButton;
    Switch tachycardiaSwitch;
    Date date = Calendar.getInstance().getTime();
    PressureClass pressureData = new PressureClass();
    int tachycardiaValue = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pressure);
        getSupportActionBar().setTitle(R.string.saveCurrentPressure);


        init();
    }

    public void init(){
        highPressure = findViewById(R.id.highPressure);
        lowPressure = findViewById(R.id.lowPressure);
        pulse = findViewById(R.id.pulse);
        saveButton = findViewById(R.id.saveButton);
        tachycardiaSwitch = findViewById(R.id.tachycardiaSwitch);


        tachycardiaSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Log.i("info", "Пользователь переключил свитч");
                if (isChecked) {
                    tachycardiaValue = 1;
                }
            }
        });

        saveButton.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                Log.i("info", "Пользователь попытался сохранить данные");
                String highPressureValue = highPressure.getText().toString();
                String lowPressureValue = lowPressure.getText().toString();
                String pulseValue = pulse.getText().toString();
                try {
                    int highPressureValueInt = Integer.parseInt(highPressureValue);
                    int lowPressureValueInt = Integer.parseInt(lowPressureValue);
                    int pulseValueInt = Integer.parseInt(pulseValue);
                    pressureData.addData(date,highPressureValueInt, lowPressureValueInt,
                            pulseValueInt, tachycardiaValue);
                    Toast.makeText(PressureActivity.this, R.string.successSave,
                            Toast.LENGTH_LONG).show();
                    Log.i("info", "Данные успешно сохранены");
                } catch (Exception ex) {
                  Log.e("error", "Ошибка", ex);
                  Toast.makeText(PressureActivity.this,
                          R.string.saveBtnError,
                          Toast.LENGTH_LONG).show();
              }
            }
        });
    }
}