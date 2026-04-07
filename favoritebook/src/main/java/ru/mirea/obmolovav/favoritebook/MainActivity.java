package ru.mirea.obmolovav.favoritebook;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // Ключи для передачи данных
    public static final String BOOK_NAME_KEY = "book_name";
    public static final String QUOTES_KEY = "quotes_key";
    public static final String USER_MESSAGE = "user_message";
    public static final String USER_QUOTE = "user_quote";

    private TextView textViewUserBook;
    private ActivityResultLauncher<Intent> activityResultLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Инициализация TextView
        textViewUserBook = findViewById(R.id.textViewBook);

        // Инициализация кнопки
        Button btnOpen = findViewById(R.id.btnOpenInput);

        // 🔹 Регистрируем обработчик результата через Activity Result API
        activityResultLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        // Проверяем, что результат успешный
                        if (result.getResultCode() == Activity.RESULT_OK) {
                            Intent data = result.getData();
                            if (data != null) {
                                // Получаем данные от пользователя
                                String userBook = data.getStringExtra(USER_MESSAGE);
                                String userQuote = data.getStringExtra(USER_QUOTE);

                                // Отображаем результат
                                String resultText = "Название Вашей любимой книги: " +
                                        userBook + ". Цитата: " + userQuote;
                                textViewUserBook.setText(resultText);
                            }
                        }
                    }
                }
        );

        // Обработчик нажатия кнопки
        btnOpen.setOnClickListener(v -> {
            // Создаём явное намерение для перехода к ShareActivity
            Intent intent = new Intent(MainActivity.this, ShareActivity.class);

            // 🔹 Передаём данные разработчика (ЗАМЕНИТЕ НА СВОИ!)
            intent.putExtra(BOOK_NAME_KEY, "Мастер и Маргарита");
            intent.putExtra(QUOTES_KEY, "Рукописи не горят!");

            // Запускаем вторую активность и ждём результат
            activityResultLauncher.launch(intent);
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Освобождаем ресурсы
        if (activityResultLauncher != null) {
            activityResultLauncher.unregister();
        }
    }
}