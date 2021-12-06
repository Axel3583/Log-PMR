package fr.example.logpmr;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class Register_Activity extends AppCompatActivity {

    EditText uUsername, mE_mail, mPassword, rRepass, mPhone;
    Button mRegisterBtn;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        uUsername = findViewById(R.id.user_name);
        mE_mail = findViewById(R.id.email);
        mPassword = findViewById(R.id.pass);
        rRepass = findViewById(R.id.repass);
        mPhone = findViewById(R.id.phone);

        mAuth = FirebaseAuth.getInstance();

        mRegisterBtn = findViewById(R.id.registerBtn);

        mRegisterBtn.setOnClickListener(v -> {

            String email = mE_mail.getText().toString().trim();
            String password = mPassword.getText().toString().trim();
            String phone = mPhone.getText().toString().trim();
            String userName = uUsername.getText().toString().trim();
            String rePass = rRepass.getText().toString().trim();

            if (userName.isEmpty()) {
                uUsername.setError("Full name is required");
                uUsername.requestFocus();

            }
            if (email.isEmpty()) {
                mE_mail.setError("Email required");
                mE_mail.requestFocus();

            }

            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {

                mE_mail.setError("Please provide valid email");
                mE_mail.requestFocus();
            }

            if (phone.isEmpty()) {
                mPhone.setError("Number is required");
                mPhone.requestFocus();

            }
            if (password.isEmpty()) {
                mPassword.setError("Password is required");
                mPassword.requestFocus();

            }

            if (password.length() < 6) {

                mPassword.setError("Min password length 6 char");
                mPassword.requestFocus();


            }

            if (rePass.isEmpty()) {
                rRepass.setError("Re_pass is required");
                rRepass.requestFocus();

            } else {
                mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        Log.d(TAG, "createUserWithEmail:success");
                        Toast.makeText(Register_Activity.this, "User Created", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(Register_Activity.this, MainActivity.class));
                    } else {
                        Log.w(TAG, "createUserWithEmail:failure", task.getException());
                        Toast.makeText(Register_Activity.this, "Error !" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }

        });
    }

}


 /*
     EditText mE_mail, mPassword;
    Button mLoginBtn;

    private void createAccount(String email, String password) {
        // [START create_user_with_email]



        mE_mail = findViewById(R.id.email);
        mPassword = findViewById(R.id.password);

        mLoginBtn = findViewById(R.id.login);

        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Toast.makeText(Register_Activity.this, "Logged Successfully" + task.getException(),Toast.LENGTH_SHORT).show();
                            FirebaseUser user = mAuth.getCurrentUser();
                            updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(Register_Activity.this, "Error !" + task.getException(), Toast.LENGTH_SHORT).show();
                            updateUI(null);
                        }
                    }
                });
        // [END create_user_with_email]
    }
     */


/* public void homeActivity (View view){
            Intent intent = new Intent(this, homeActivity.class);
            startActivity(intent);
        }

        */


/*    EditText uUsername, mE_mail, mPassword, rRepass, mPhone;
    Button mRegisterBtn;

    TextView mLoginBtn;
    FirebaseAuth fAuth;
    TextView tTitle1;
    FirebaseAuth mAuth;
    ProgressBar progressBar;
 mAuth = FirebaseAuth.getInstance();

        tTitle1 = findViewById(R.id.page_title1);
        tTitle1.setOnClickListener(this);

        mRegisterBtn = findViewById(R.id.registerBtn);
        mRegisterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uUsername = findViewById(R.id.user_name);
                mE_mail = findViewById(R.id.email);
                mPassword = findViewById(R.id.password);
                rRepass = findViewById(R.id.repass);
                mPhone = findViewById(R.id.phone);

                progressBar = findViewById(R.id.progressBar);


                uUsername = findViewById(R.id.user_name);
                mE_mail = findViewById(R.id.email);
                mPassword = findViewById(R.id.password);
                mPhone = findViewById(R.id.phone);
                mRegisterBtn = findViewById(R.id.registerBtn);
                mLoginBtn = findViewById(R.id.login);

                fAuth = FirebaseAuth.getInstance();
                progressBar = findViewById(R.id.progressBar);

                if (fAuth.getCurrentUser() != null) {
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                    finish();
                }

                mRegisterBtn.setOnClickListener(v -> {

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





        progressBar.setVisibility(View.VISIBLE);

        // Resgister the user in firebase
        fAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(Register_Activity.this, "User Created", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                } else {
                    Toast.makeText(Register_Activity.this, "Error !" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });


        mLoginBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));

                switch (v.getId()) {
                    case R.id.page_title1:
                        startActivity(new Intent(this, MainActivity.class));
                        break;
                    case R.id.registerBtn:
                        mRegisterBtn();
                        break;
                }
            }



            private void mRegisterBtn () {

                String email = mE_mail.getText().toString().trim();
                String password = mPassword.getText().toString().trim();
                String phone = mPhone.getText().toString().trim();
                String userName = uUsername.getText().toString().trim();
                String rePass = rRepass.getText().toString().trim();

                if (userName.isEmpty()) {
                    uUsername.setError("Full name is required");
                    uUsername.requestFocus();
                    return;
                }
                if (email.isEmpty()) {
                    mE_mail.setError("Email required");
                    mE_mail.requestFocus();
                    return;
                }

                if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {

                    mE_mail.setError("Please provide valid email");
                    mE_mail.requestFocus();
                }

                if (phone.isEmpty()) {
                    mPhone.setError("Number is required");
                    mPhone.requestFocus();
                    return;
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

                }

                if (rePass.isEmpty()) {
                    rRepass.setError("Re_pass is required");
                    rRepass.requestFocus();
                    return;
                }
            }
        }



 */

