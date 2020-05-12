package com.example.bloodpressureushakov;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button pressureButton;
    Button healthRateButton;
    Button saveButton;
    TextView name;
    TextView surname;
    TextView middleName;
    TextView age;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    public void init(){
        pressureButton = findViewById(R.id.pressureButton);
        healthRateButton = findViewById(R.id.healthRateButton);
        saveButton = findViewById(R.id.saveButton);
        name = findViewById(R.id.name);
        surname = findViewById(R.id.surname);
        middleName = findViewById(R.id.middleName);
        age = findViewById(R.id.age);
        pressureButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("info", "Пользователь перешёл в давление");
                Intent intent = new Intent(MainActivity.this,
                        PressureActivity.class);
                startActivity(intent);
            }
        });

        healthRateButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Log.i("info", "Пользователь перешёл в показатели здоровья");
                Intent intent = new Intent(MainActivity.this,
                        HealthRateActivity.class);
                startActivity(intent);
            }
        });

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("info", "Пользователь нажал кнопку сохранить");
                String nameValue = name.getText().toString();
                String surnameValue = surname.getText().toString();
                String middleNameValue = middleName.getText().toString();
                String ageValue = age.getText().toString();
                try {
                    int ageValueInt = Integer.parseInt(ageValue);
                    CredentialsClass userCreds = new CredentialsClass(nameValue,
                            surnameValue, middleNameValue, ageValueInt);
                    Toast.makeText(MainActivity.this,
                            R.string.successSave, Toast.LENGTH_LONG).show();
                } catch (Exception e) {
                    Log.e("error", "Неверно введён возраст");
                    Toast.makeText(MainActivity.this,
                            R.string.saveBtnError,
                            Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}
