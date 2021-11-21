package fr.example.logpmr;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        TextView username =(TextView) findViewById(R.id.user_name);
        TextView password =(TextView) findViewById(R.id.password);

        Button login = (Button) findViewById(R.id.login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(username.getText().toString().equals("Admin") && password.getText().toString().equals("Admin")){
                    Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(MainActivity.this, "Login failed", Toast.LENGTH_LONG).show();
                }

            }
        });




    }

    public void Register(View view) {
        Intent intent = new Intent(this, Register_Activity.class);
        startActivity(intent);
    }


}