package ru.mirea.obmolovav.systemintentsapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button btnCall;
    private Button btnBrowser;
    private Button btnMaps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Инициализация кнопок
        btnCall = findViewById(R.id.btnCall);
        btnBrowser = findViewById(R.id.btnBrowser);
        btnMaps = findViewById(R.id.btnMaps);

        // 🔹 Обработчик кнопки "Позвонить"
        btnCall.setOnClickListener(v -> onClickCall(v));

        // 🔹 Обработчик кнопки "Открыть браузер"
        btnBrowser.setOnClickListener(v -> onClickOpenBrowser(v));

        // 🔹 Обработчик кнопки "Открыть карту"
        btnMaps.setOnClickListener(v -> onClickOpenMaps(v));
    }

    /**
     * Метод для открытия набора номера
     * Использует ACTION_DIAL для открытия dialer с указанным номером
     */
    public void onClickCall(View view) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        // Устанавливаем данные - номер телефона
        intent.setData(Uri.parse("tel:89811112233"));

        // Проверяем, есть ли приложение для обработки этого Intent
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    /**
     * Метод для открытия браузера
     * Использует ACTION_VIEW для открытия веб-страницы
     */
    public void onClickOpenBrowser(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        // Устанавливаем данные - URL веб-страницы
        intent.setData(Uri.parse("http://developer.android.com"));

        // Проверяем, есть ли браузер
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    /**
     * Метод для открытия карты
     * Использует ACTION_VIEW с geo: URI для открытия Google Maps
     */
    public void onClickOpenMaps(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        // Устанавливаем данные - географические координаты (Москва, Красная площадь)
        intent.setData(Uri.parse("geo:55.749479,37.613944"));

        // Проверяем, есть ли приложение карт
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}