package resourceview.samples;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import resourceview.ResourceView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ResourceView resourceView = findViewById(R.id.resourceView);

        findViewById(R.id.showLoader).setOnClickListener(v -> {

            // loader with custom message
            resourceView.showLoadingLayout(R.string.please_wait);

            // loader with custom layout
//            resourceView.showLoadingView(R.layout.custom_loading_layout);
        });

        findViewById(R.id.showError).setOnClickListener(v -> {
            // show error
//            resourceView.showErrorLayout(R.drawable.ic_error_outline_white_24px, "Some error occurred!");

            // error with string message
            resourceView.showErrorLayout("My message");


            // error custom view
//            resourceView.showErrorView(R.layout.error_layout);
        });

        findViewById(R.id.showContents).setOnClickListener(v -> {
            // show contents
            resourceView.showContents();
        });

    }
}
