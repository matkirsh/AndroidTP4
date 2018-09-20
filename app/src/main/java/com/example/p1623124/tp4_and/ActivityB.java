package com.example.p1623124.tp4_and;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.*;


public class ActivityB extends AppCompatActivity {
    private TextView textView;
    private EditText editText;
    public static final String KEY_FROM_B= "keyB";



protected void onCreate(Bundle savedInstanceState){
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_b);
    textView=(TextView)findViewById(R.id.TxtViewActB);
    editText=(EditText) findViewById(R.id.edTxtMessToBActB);

    String chaine = getIntent().getStringExtra(ActivityA.KEY_FROM_A);
    Log.d("Activity B", chaine);
    textView.setText(chaine);
}

public void finish(){
    Intent intent = new Intent();
    intent.putExtra(KEY_FROM_B, editText.getText().toString());
    setResult(RESULT_OK, intent);

    super.finish();
}

}
