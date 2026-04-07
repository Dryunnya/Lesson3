package ru.mirea.obmolovav.intentapp;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView textView = findViewById(R.id.textViewResult);

        if (textView != null) {
            // Получаем данные
            String currentTime = getIntent().getStringExtra("CURRENT_TIME");
            int squaredNumber = getIntent().getIntExtra("SQUARED_NUMBER", 0);

            // Формируем строку
            String result = "КВАДРАТ ЗНАЧЕНИЯ МОЕГО НОМЕРА ПО СПИСКУ В ГРУППЕ " +
                    "СОСТАВЛЯЕТ ЧИСЛО " + squaredNumber +
                    ", а текущее время " + currentTime;

            textView.setText(result);
        }
    }
}