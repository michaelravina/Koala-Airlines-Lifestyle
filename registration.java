package com.example.koala_lifestyle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Registration extends AppCompatActivity {

    TextView Error;
    EditText Username;
    EditText Password;
    EditText Conform_Password;
    Button SignUp;
    TextView SignIn;
    DataBaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        Username = (EditText) findViewById(R.id.username);
        Password = (EditText) findViewById(R.id.password);
        Conform_Password = (EditText) findViewById(R.id.conformpassword);
        SignUp = (Button) findViewById(R.id.signupbtn);
        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = Username.getText().toString().trim();
                String password = Password.getText().toString().trim();
                String conformpassword = Conform_Password.getText().toString().trim();

                if (password.equals(conformpassword)) {
                    long value = db.addUser(username, password);

                    if (value > 1) {
                        Intent moveToLogin = new Intent(Registration.this, MainActivity.class);
                        startActivity(moveToLogin);
                    }
                }
                else {
                    Error = (TextView) findViewById(R.id.error);
                    Error.setText("Password does not match");
                }
            }
        });

        SignIn = (TextView) findViewById(R.id.signin);
        SignIn.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                openLoginActivity();
            }
        });
    }

    private void openLoginActivity() {
        Intent login = new Intent(Registration.this,MainActivity.class);
        startActivity(login);
    }
}
