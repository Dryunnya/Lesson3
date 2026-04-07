package ru.mirea.obmolovav.mireaproject.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import ru.mirea.obmolovav.mireaproject.R;

public class DataFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_data, container, false);

        // 🔹 Настройка TextView с информацией об отрасли
        TextView textView = root.findViewById(R.id.text_data);

        // 🔹 Формируем текст с использованием Material You стилей
        String industryInfo = "🚀 ОТРАСЛЬ: РАЗРАБОТКА МОБИЛЬНЫХ ПРИЛОЖЕНИЙ\n\n" +
                "📋 Основные направления:\n" +
                "• Native Android (Java/Kotlin)\n" +
                "• Cross-platform (Flutter/React Native)\n" +
                "• Backend для мобильных приложений\n\n" +
                "🛠️ Ключевые технологии:\n" +
                "• Android SDK, Jetpack Compose\n" +
                "• Firebase, Room, Retrofit\n" +
                "• MVVM, Clean Architecture\n\n" +
                "💼 Востребованные навыки:\n" +
                "• Работа с REST API\n" +
                "• Оптимизация производительности\n" +
                "• Публикация в Google Play";

        textView.setText(industryInfo);

        return root;
    }
}