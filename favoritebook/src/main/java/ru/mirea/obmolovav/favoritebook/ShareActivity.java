package ru.mirea.obmolovav.favoritebook;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class ShareActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share);

        // 🔹 Получаем данные от MainActivity
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String developerBook = extras.getString(MainActivity.BOOK_NAME_KEY);
            String developerQuote = extras.getString(MainActivity.QUOTES_KEY);

            // Отображаем данные разработчика
            TextView tvDevBook = findViewById(R.id.textViewDevBook);
            TextView tvDevQuote = findViewById(R.id.textViewDevQuote);

            tvDevBook.setText("Любимая книга разработчика: " + developerBook);
            tvDevQuote.setText("Цитата: " + developerQuote);
        }

        // 🔹 Инициализация полей ввода пользователя
        EditText editUserBook = findViewById(R.id.editUserBook);
        EditText editUserQuote = findViewById(R.id.editUserQuote);
        Button btnSend = findViewById(R.id.btnSend);

        // Обработчик кнопки "Отправить"
        btnSend.setOnClickListener(v -> {
            String userBook = editUserBook.getText().toString().trim();
            String userQuote = editUserQuote.getText().toString().trim();

            // Проверка на пустые поля
            if (userBook.isEmpty() || userQuote.isEmpty()) {
                Toast.makeText(this, "Заполните все поля!", Toast.LENGTH_SHORT).show();
                return;
            }

            // 🔹 Возвращаем результат в MainActivity
            Intent resultIntent = new Intent();
            resultIntent.putExtra(MainActivity.USER_MESSAGE, userBook);
            resultIntent.putExtra(MainActivity.USER_QUOTE, userQuote);

            // Устанавливаем результат и завершаем активность
            setResult(Activity.RESULT_OK, resultIntent);
            finish();
        });
    }
}