package com.example.switchingcolors;

import androidx.appcompat.app.AppCompatActivity;


import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Utils.onActivityCreateSetTheme(this);
        setContentView(R.layout.activity_main);
        initView();

    }

    public void initView() {
        Button button = findViewById(R.id.button);
        final Spinner spinnerLanguage = findViewById(R.id.spinner_language);
        final Spinner spinnerColors = findViewById(R.id.spinner_color);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                switch (spinnerLanguage.getSelectedItemPosition()) {
                    case 0:
                        changeLocale("ru");
                        break;
                    case 1:
                        changeLocale("en");
                        break;
                    case 2:
                        changeLocale("de");
                        break;
                }
                switch (spinnerColors.getSelectedItemPosition()) {
                    case 0:
                        Utils.changeToTheme(MainActivity.this, Utils.THEME_BLACK);
                        break;
                    case 1:
                        Utils.changeToTheme(MainActivity.this, Utils.THEME_GREEN);
                        break;
                    case 2:
                        Utils.changeToTheme(MainActivity.this, Utils.THEME_BLUE);
                        break;
                }
            }
        });
    }

    public void changeLocale(String language) {
        Locale locale = new Locale(language);
        Configuration config = new Configuration();
        config.setLocale(locale);
        getResources().updateConfiguration(config, getBaseContext()
                .getResources()
                .getDisplayMetrics());
        recreate();
    }
}
