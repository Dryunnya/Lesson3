package ru.mirea.obmolovav.dialog;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editTextText;
    private Button btnSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Инициализация элементов
        editTextText = findViewById(R.id.editTextText);
        btnSend = findViewById(R.id.btnSend);

        // Обработчик нажатия кнопки
        btnSend.setOnClickListener(v -> {
            String textToShare = editTextText.getText().toString();

            // Проверка, чтобы не отправлять пустую строку
            if (!textToShare.isEmpty()) {
                shareText(textToShare);
            } else {
                editTextText.setError("Введите текст для отправки");
            }
        });
    }

    // Метод для отправки данных через Intent
    private void shareText(String text) {
        // Создание намерения с действием ACTION_SEND
        Intent intent = new Intent(Intent.ACTION_SEND);

        // Установка типа MIME (текст)
        intent.setType("text/plain");

        // Добавление текста в extras
        intent.putExtra(Intent.EXTRA_TEXT, text);

        // Добавление заголовка (опционально)
        intent.putExtra(Intent.EXTRA_SUBJECT, "Тема сообщения");

        // Принудительный вывод диалогового окна выбора приложения
        // Если не использовать createChooser, система может запустить приложение по умолчанию
        startActivity(Intent.createChooser(intent, "Выбор за вами!"));
    }
}