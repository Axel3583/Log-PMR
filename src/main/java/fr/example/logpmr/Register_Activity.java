package fr.example.logpmr;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Register_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }



    public void homeActivity(View view) {
        Intent intent = new Intent(this, homeActivity.class);
                            startActivity(intent);
                        }




}