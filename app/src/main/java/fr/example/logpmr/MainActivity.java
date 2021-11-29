package fr.example.logpmr;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class MainActivity extends AppCompatActivity {

    EditText mE_mail, mPassword;
    Button mLoginBtn;
    FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mE_mail = findViewById(R.id.email);
        mPassword = findViewById(R.id.password);

        mAuth = FirebaseAuth.getInstance();

        mLoginBtn = (Button) findViewById(R.id.login);
        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = mE_mail.getText().toString().trim();
                String password = mPassword.getText().toString().trim();

                if (email.isEmpty()) {
                    mE_mail.setError("Email required");
                    mE_mail.requestFocus();
                    return;
                }

                if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {

                    mE_mail.setError("Please provide valid email");
                    mE_mail.requestFocus();
                }

                if (password.isEmpty()) {
                    mPassword.setError("Password is required");
                    mPassword.requestFocus();
                    return;
                }

                if (password.length() < 6) {

                    mPassword.setError("Min password length 6 char");
                    mPassword.requestFocus();
                    return;

                }else {
                    mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()){
                                Toast.makeText(MainActivity.this, "User Logged in success", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(MainActivity.this, homeActivity.class));
                            }else {
                                Toast.makeText(MainActivity.this, "log in error !" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });


    }



    public void Register(View view) {
        Intent intent = new Intent(this, Register_Activity.class);
        startActivity(intent);
    }

}


 /* private FirebaseAuth mAuth;

    EditText mE_mail, mPassword;
    Button mLoginBtn;
    TextView mCreateBtn;
    FirebaseAuth fAuth;
    ProgressBar progressBar;
    Button mRegisterBtn;
        mAuth = FirebaseAuth.getInstance();

        mRegisterBtn = findViewById(R.id.registerBtn);
        mRegisterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mE_mail = findViewById(R.id.email);
                mPassword = findViewById(R.id.password);

                progressBar = findViewById(R.id.progressBar);
                fAuth = FirebaseAuth.getInstance();
                mLoginBtn = findViewById(R.id.login);

                mLoginBtn.setOnClickListener(v -> {

                    String email = mE_mail.getText().toString().trim();
                    String password = mPassword.getText().toString().trim();

                    if (TextUtils.isEmpty(email)) {
                        mE_mail.setError(("Email is Required"));
                        return;
                    }

                    if (TextUtils.isEmpty(password)) {
                        mPassword.setError("Password is Required");
                        return;
                    }

                    if (password.length() < 6) {
                        mPassword.setError("Password Must be >= 6 char.");
                        return;
                    }

                });
                mE_mail = findViewById(R.id.email);
                mPassword = findViewById(R.id.password);

                progressBar.setVisibility(View.VISIBLE);

                // Auth the user

                fAuth.signInWithEmailAndPassword(mE_mail, mPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()){
                            Toast.makeText(MainActivity.this, "Logged Successfully" + task.getException(), Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), homeActivity.class));
                        }else{
                            Toast.makeText(MainActivity.this, "Error !" + task.getException(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }



        TextView username =(TextView) findViewById(R.id.user_name);
        TextView password =(TextView) findViewById(R.id.password);

        Button login = (Button) findViewById(R.id.login);

        login.setOnClickListener(new View.OnClickListener()
                @Override
                public void onClick (View v){

                if (username.getText().toString().equals("Admin") && password.getText().toString().equals("Admin")) {
                    Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(MainActivity.this, "Login failed", Toast.LENGTH_LONG).show();
                }

            }

            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.registerBtn:
                        startActivity(new Intent(this, Register_Activity.class));
                        break;
                }
            }



        });

         */