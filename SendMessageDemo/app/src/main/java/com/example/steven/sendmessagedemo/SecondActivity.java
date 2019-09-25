package com.example.steven.sendmessagedemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    public static final int Result_Code = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();

        TextView textView = findViewById(R.id.receiveTextView);

        textView.setText(intent.getStringExtra("send"));

    }

    public void replyMessage(View view) {

        EditText editText = findViewById(R.id.replyEditText);
        String replyMsg = editText.getText().toString();
        Intent intent = new Intent();
        intent.putExtra("reply", replyMsg);
        setResult(Result_Code, intent);
        finish();

    }


}
