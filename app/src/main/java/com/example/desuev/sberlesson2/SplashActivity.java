package com.example.desuev.sberlesson2;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SplashActivity extends AppCompatActivity {

    private static final String VALUE = "msg";
    private Button goBtn;
    private TextView splashText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        initComponents();
        initListeners();
        logMessageFromPrevActivity();
    }

    private void initComponents(){
        goBtn = findViewById(R.id.splashBtn);
        splashText = findViewById(R.id.splashText);
    }

    private void initListeners(){
        goBtn.setOnClickListener(new ButtonClick());
    }

    private void logMessageFromPrevActivity(){
        Log.i("INFO", getIntent().getStringExtra(VALUE));
    }

    private class ButtonClick implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            startActivity(DetailsActivity.newIntent(SplashActivity.this, "Text from SplashActivity: " + splashText.getText().toString()));
        }
    }


    public static Intent newIntent(Context context, String messageToLog){
        Intent intent = new Intent(context, SplashActivity.class);
        intent.putExtra(VALUE, messageToLog);
        return intent;
    }
}
