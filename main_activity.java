package com.example.koala_lifestyle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView Error;
    EditText Username;
    EditText Password;
    Button Login;
    TextView Registration;
    DataBaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Username = (EditText) findViewById(R.id.username);
        Password = (EditText) findViewById(R.id.password);
        Login = (Button) findViewById(R.id.loginbtn);
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = Username.getText().toString().trim();
                String password = Password.getText().toString().trim();
                Boolean res = db.checkUser(username, password);

                if (res = true) {
                    Intent login = new Intent(MainActivity.this, HomeScreen.class);
                    startActivity(login);
                }
                else {
                    Error = (TextView) findViewById(R.id.error);
                    Error.setText("Invalid username or password");
                }
            }
        });

        Registration = (TextView) findViewById(R.id.registration);
        Registration.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                openRegistartionActivity();
            }
        });
    }

    private void openRegistartionActivity() {
        Intent registration = new Intent(MainActivity.this, Registration.class);
        startActivity(registration);
    }
}
