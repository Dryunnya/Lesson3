package ru.mirea.obmolovav.simplefragmentapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {

    private Fragment fragment1;
    private Fragment fragment2;
    private Fragment currentFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 🔹 Создаём экземпляры фрагментов
        fragment1 = new FirstFragment();
        fragment2 = new SecondFragment();

        // 🔹 Получаем менеджер фрагментов
        FragmentManager fragmentManager = getSupportFragmentManager();

        // 🔹 Инициализация кнопок
        Button btnFirstFragment = findViewById(R.id.btnFirstFragment);
        Button btnSecondFragment = findViewById(R.id.btnSecondFragment);

        // 🔹 Обработчик кнопки "First screen"
        btnFirstFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(fragment1);
            }
        });

        // 🔹 Обработчик кнопки "Second screen"
        btnSecondFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(fragment2);
            }
        });

        // 🔹 Загружаем первый фрагмент по умолчанию (только если это первый запуск)
        if (savedInstanceState == null) {
            loadFragment(fragment1);
        }
    }

    /**
     * Метод для загрузки фрагмента в контейнер
     * @param fragment - фрагмент для отображения
     */
    private void loadFragment(Fragment fragment) {
        // Не перезагружаем, если фрагмент уже отображается
        if (fragment == currentFragment) {
            return;
        }

        currentFragment = fragment;

        // 🔹 Начинаем транзакцию с фрагментами
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        // 🔹 Заменяем содержимое контейнера на новый фрагмент
        transaction.replace(R.id.fragmentContainerView, fragment);

        // 🔹 Добавляем в back stack (опционально, для кнопки "Назад")
        // transaction.addToBackStack(null);

        // 🔹 Фиксируем изменения
        transaction.commit();
    }
}