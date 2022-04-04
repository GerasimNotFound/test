package com.example.a411;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText textEt, numberEt;
    Button load, save;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textEt = findViewById(R.id.textEt);
        numberEt = findViewById(R.id.number);
        load = findViewById(R.id.load);
        save = findViewById(R.id.save);
        load.setOnClickListener(this);
        save.setOnClickListener(this);
    }
    @Override
    public void onClick(View view){
        SharedPreferences pref = getPreferences(MODE_PRIVATE);
        switch (view.getId()){
            case R.id.load:
                textEt.setText(pref.getString("text_key", "nothing saved"));
                numberEt.setText(pref.getInt("number_key", 777));
                break;
            case R.id.save:
                SharedPreferences.Editor editor = pref.edit();
                editor.putString("text_key", textEt.getText().toString());
                editor.putInt("text_key", Integer.parseInt(numberEt.getText().toString()));
                break;
        }
    }
}