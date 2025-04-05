package com.mirea.komkovaa.favoritebook;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivityFavoriteBook extends AppCompatActivity {
    private TextView textViewUserBook;

    private ActivityResultLauncher<Intent> activityResultLauncher;
    static final String BOOK_NAME_KEY = "Любимая книга: Война и мир";
    static final String QUOTES_KEY = "Любимая цитата: Это был Наполеон — его герой, но в эту минуту Наполеон казался ему столь маленьким, ничтожным человеком";
    static final String USER_MESSAGE=BOOK_NAME_KEY +"\n"+QUOTES_KEY;

    public void btn1click(View view) {
        Intent intent = new Intent(MainActivityFavoriteBook.this, MainActivityFavoriteBook2.class);
        intent.putExtra(BOOK_NAME_KEY, "Любимая книга: Война и мир");
        intent.putExtra(QUOTES_KEY, "Любимая цитата: Это был Наполеон — его герой, но в эту минуту Наполеон казался ему столь маленьким, ничтожным человеком");
        activityResultLauncher.launch(intent);
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_favorite_book);

        ActivityResultCallback<ActivityResult> callback = new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult result) {
                if (result.getResultCode() == Activity.RESULT_OK) {
                    Intent data = result.getData();
                    String userBook = data.getStringExtra(USER_MESSAGE);

                    TextView textViewUserBook = findViewById(R.id.textView2);
                    String full_text = "Любимая книга и цитата пользователя: " + userBook;
                    textViewUserBook.setText(full_text);
                }
            }
        };


        activityResultLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                callback);
    }
}