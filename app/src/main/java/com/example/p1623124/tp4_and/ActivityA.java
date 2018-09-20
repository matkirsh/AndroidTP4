package com.example.p1623124.tp4_and;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.*;

public class ActivityA extends AppCompatActivity {
    public static final String KEY_FROM_A = "keyA";
    public static final int RQC_B = 1;
    private EditText editText;
    private TextView tvSecondaryActivity, tvFromB;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);
        editText = (EditText) findViewById(R.id.edTxtActA);
        tvFromB = (TextView) findViewById(R.id.tvFromB);
        tvSecondaryActivity = (TextView) findViewById(R.id.tvSecondaryActivity);

        Button btn = findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(ActivityA.this, ActivityB.class);
                myIntent.putExtra(KEY_FROM_A, editText.getText().toString());
                startActivityForResult(myIntent, RQC_B);


                AlertDialog builder = new AlertDialog.Builder(ActivityA.this)
                        .setMessage("hgrgbhg")
                        .show();

                /*Context context = getApplicationContext();

                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, st, duration);
                toast.show();*/
            }

        });
    }




public void onClickButtonA (View view){
    Intent myIntent= new Intent (ActivityA.this, Activity.class);
    myIntent.putExtra(KEY_FROM_A, editText.getText().toString());
    startActivityForResult(myIntent, RQC_B);
}

protected void onRestart() {
    super.onRestart();
    editText.setText("");
}

protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
    if (resultCode == RESULT_OK && requestCode == RQC_B) {
        tvSecondaryActivity.setText(R.string.MessageFromB);
        tvFromB.setText(data.getStringExtra(ActivityB.KEY_FROM_B));
    }
}

}