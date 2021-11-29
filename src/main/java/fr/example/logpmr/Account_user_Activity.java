package fr.example.logpmr;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class Account_user_Activity extends AppCompatActivity {

    Button btnLogOut;
    FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_user);

        mAuth = FirebaseAuth.getInstance();

        btnLogOut = (Button) findViewById(R.id.logout);
       btnLogOut.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               mAuth.signOut();
               startActivity(new Intent(Account_user_Activity.this, MainActivity.class ));

           }
       });
    }
}