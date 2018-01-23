package com.thehemantkaushik.samples;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.thehemantkaushik.ResourceView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ResourceView resourceView = findViewById(R.id.resourceView);

        findViewById(R.id.showLoader).setOnClickListener(v -> {
            // show loader
            resourceView.showLoadingLayout(R.string.please_wait);
        });
        findViewById(R.id.showError).setOnClickListener(v -> {
            // show error
            resourceView.showErrorLayout(R.drawable.ic_error_outline_white_24px, "Some error occurred!");
        });
        findViewById(R.id.showContents).setOnClickListener(v -> {
            // show contents
            resourceView.showContents();
        });

    }
}
