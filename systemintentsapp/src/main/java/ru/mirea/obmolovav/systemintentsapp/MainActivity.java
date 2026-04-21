package ru.mirea.obmolovav.systemintentsapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickCall(View view) {
        try {
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:89811112233"));
            startActivity(intent);
        } catch (Exception e) {
            Toast.makeText(this, "Не удалось открыть набор номера", Toast.LENGTH_SHORT).show();
        }
    }

    public void onClickOpenBrowser(View view) {
        try {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("https://developer.android.com"));
            startActivity(intent);
        } catch (Exception e) {
            Toast.makeText(this, "Не удалось открыть браузер", Toast.LENGTH_SHORT).show();
        }
    }

    public void onClickOpenMaps(View view) {
        try {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            // Координаты МГУ / Кремля для примера
            intent.setData(Uri.parse("geo:55.749479,37.613944"));
            startActivity(intent);
        } catch (Exception e) {
            Toast.makeText(this, "Не удалось открыть карты", Toast.LENGTH_SHORT).show();
        }
    }
}