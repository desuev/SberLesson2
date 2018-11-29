package com.example.desuev.sberlesson2;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class InfoActivity extends AppCompatActivity {

    private static final String VALUE = "msg";
    private Button goBtn;
    private TextView infoText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        initComponents();
        initListeners();
        logMessageFromPrevActivity();

    }

    private void initComponents(){
        goBtn = findViewById(R.id.infoBtn);
        infoText = findViewById(R.id.infoText);
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
            startActivity(MainActivity.newIntent(InfoActivity.this));
        }
    }

    public static Intent newIntent(Context context, String messageToLog){
        Intent intent = new Intent(context, InfoActivity.class);
        intent.putExtra(VALUE, messageToLog);
        return intent;
    }
}
