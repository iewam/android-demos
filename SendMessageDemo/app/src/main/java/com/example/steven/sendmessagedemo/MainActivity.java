package com.example.steven.sendmessagedemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final int Request_Code = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendMessage(View view) {

        EditText editText = findViewById(R.id.sendEditText);
        String sendMsg = editText.getText().toString();

        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("send", sendMsg);
//        startActivity(intent);

        startActivityForResult(intent, Request_Code);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == Request_Code && resultCode == SecondActivity.Result_Code) {

            String reply = data.getStringExtra("reply");

            TextView textView = findViewById(R.id.receiveTextView);

            textView.setText(reply);
        }
    }
}
