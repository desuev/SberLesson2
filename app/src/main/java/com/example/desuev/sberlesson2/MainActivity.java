package com.example.desuev.sberlesson2;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button goBtn;
    private TextView mainText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initComponents();
        initListeners();
    }

    private void initComponents(){
        goBtn = findViewById(R.id.mainBtn);
        mainText = findViewById(R.id.mainText);
    }

    private void initListeners(){
        goBtn.setOnClickListener(new ButtonClick());
    }

    private class ButtonClick implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            startActivity(SplashActivity.newIntent(MainActivity.this, "Text from MainActivity: " + mainText.getText().toString()));
        }
    }

    public static Intent newIntent(Context context){
        Intent intent = new Intent(context, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        return intent;
    }
}
