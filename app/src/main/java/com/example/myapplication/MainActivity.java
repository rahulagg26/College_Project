package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
//import android.content.SharedPreferences;
import android.os.Bundle;
//import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.view.inputmethod.InputMethodManager;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;

import java.util.ArrayList;

//import java.lang.reflect.Array;
//import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private EditText Name;
    private EditText Password;
    private TextView Info;
    private Button Login;
    private int counter= 5;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Name = (EditText) findViewById(R.id.editText);
        Password = (EditText) findViewById(R.id.editText2);
        Info = (TextView) findViewById(R.id.textView);
        Login = (Button) findViewById(R.id.button);

        Info.setText("No.of attempts: 5");

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               try {
                   InputMethodManager inputManager = (InputMethodManager)
                           getSystemService(Context.INPUT_METHOD_SERVICE);
                   inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
                           InputMethodManager.HIDE_NOT_ALWAYS);
               } catch (Exception e) {
                   e.printStackTrace();
               }



                String name = Name.getText().toString();
                String password = Password.getText().toString();
                login_backend login = new login_backend(MainActivity.this);
                login.execute(name, password);

                if(Name.getText().toString().trim().equals("") && Password.getText().toString().trim().equals("")){
                    Name.setError( "Username is required!" );
                    Password.setError( "Password is required!" );
                }
                else if(Name.getText().toString().equals("RahulAgg") &&
                        Password.getText().toString().equals("1234")) {
                    Toast.makeText(getApplicationContext(), "Redirecting...", Toast.LENGTH_SHORT).show();
                    openSecondActivity();
                }
                else if(Name.getText().toString().equals("Vishal") &&
                        Password.getText().toString().equals("123")) {
                    Toast.makeText(getApplicationContext(), "Redirecting...", Toast.LENGTH_SHORT).show();
                    openSecondActivity();
                }
                else if(Name.getText().toString().equals("Chandan") &&
                        Password.getText().toString().equals("12345")) {
                    Toast.makeText(getApplicationContext(), "Redirecting...", Toast.LENGTH_SHORT).show();
                    openSecondActivity();
                }




//               else  if ( Name.getText().toString().equals(new login_backend(getApplicationContext()).execute(name)) &&
//                        Password.getText().toString().equals(new login_backend(getApplicationContext()).execute(password))){
//
//                   Toast.makeText(getApplicationContext(),"login_successfull", Toast.LENGTH_SHORT).show();
//                }
                  else{
                    validate(Name.getText().toString(), Password.getText().toString());


                }

            }
        });
    }
    private void validate(String userName, String userPassword){


            counter--;

            Info.setText("No. of attempts remaining: "+ String.valueOf(counter));

            if(counter == 0){
                Login.setEnabled(false);
            }


    }
    public void openSecondActivity(){
           Intent intent = new Intent(this, SecondActivity.class);
            startActivity(intent);

    }



}
