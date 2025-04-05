package com.mirea.komkovaa.favoritebook;

import static com.mirea.komkovaa.favoritebook.MainActivityFavoriteBook.BOOK_NAME_KEY;
import static com.mirea.komkovaa.favoritebook.MainActivityFavoriteBook.QUOTES_KEY;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivityFavoriteBook2 extends AppCompatActivity {
    private TextView textViewStudent;
    private TextView textViewStudent2;

    public void clickBtn1(View view) {

        EditText txt = (EditText)findViewById(R.id.EditText);
        String input = txt.getText().toString();

        EditText txt2 = (EditText)findViewById(R.id.EditText2);
        String input2 = txt2.getText().toString();
        String input3 = input  + input2;
        Log.d(MainActivityFavoriteBook2.class.getSimpleName(), "Input: " + input3);
        Intent data = new Intent();
        data.putExtra(MainActivityFavoriteBook.USER_MESSAGE, input3);
        setResult(Activity.RESULT_OK, data);
        finish();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_favorite_book2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        textViewStudent = findViewById(R.id.textView);
        String text = (String) getIntent().getSerializableExtra(BOOK_NAME_KEY);
        textViewStudent.setText(text);


        textViewStudent2 = findViewById(R.id.textView3);
        String text2 = (String) getIntent().getSerializableExtra(QUOTES_KEY);
        textViewStudent2.setText(text2);
    }
}