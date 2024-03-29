package com.marioapps.activityforresult;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener {

    Button btnGetResult;
    EditText etX, etY;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnGetResult = findViewById(R.id.btnGetResult);
        etX = findViewById(R.id.etX);
        etY = findViewById(R.id.etY);
        tvResult = findViewById(R.id.tvResult);

        btnGetResult.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        // 1. create an intent pass class name or intnet action name
        Intent intent = new Intent(this, ActivityAnother.class);

        // 2. put X, Y in intent
        intent.putExtra("x",  etX.getText().toString());
        intent.putExtra("y",  etY.getText().toString());

        // 3. start the activity
        startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if(resultCode == RESULT_OK){
            tvResult.setText(data.getIntExtra("result",-1)+"");
        }

    }

}