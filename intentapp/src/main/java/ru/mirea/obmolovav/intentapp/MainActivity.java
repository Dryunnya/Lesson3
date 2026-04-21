package ru.mirea.obmolovav.intentapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnNext = findViewById(R.id.btnNext);

        if (btnNext != null) {
            btnNext.setOnClickListener(v -> {
                // Получаем системное время
                long dateInMillis = System.currentTimeMillis();
                String format = "yyyy-MM-dd HH:mm:ss";
                SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.getDefault());
                String currentTime = sdf.format(new Date(dateInMillis));

                // Ваш номер по списку
                int myNumber = 14;
                int squaredNumber = myNumber * myNumber;

                // Создаем Intent
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("CURRENT_TIME", currentTime);
                intent.putExtra("SQUARED_NUMBER", squaredNumber);

                startActivity(intent);
            });
        }
    }
}