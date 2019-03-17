package com.example.myowncard;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String UserName="dawood",PassWord="ct-015",User,Pass;
    EditText UserNameEd,PasswordEd;
    Button LoginBtn;
    CheckBox checkBox;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        UserNameEd = findViewById(R.id.UserNameED);
        PasswordEd = findViewById(R.id.PassED);
        LoginBtn = findViewById(R.id.LogIn);
        checkBox = findViewById(R.id.PasswordRemember_CB);
        sharedPreferences =  getSharedPreferences("User", Context.MODE_PRIVATE);

        UserNameEd.setText(sharedPreferences.getString("UserName",""));
        PasswordEd.setText(sharedPreferences.getString("Password",""));

        LoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (UserNameEd.getText().toString().replace(" ","").replace("\n","").isEmpty()&&PasswordEd.getText().toString().replace(" ","").replace("\n","").isEmpty()){
                    Toast.makeText(MainActivity.this, "Please enter username and password", Toast.LENGTH_SHORT).show();
                }

                else if (UserNameEd.getText().toString().replace(" ","").replace("\n","").isEmpty()){
                    Toast.makeText(MainActivity.this, "Please enter UserName", Toast.LENGTH_SHORT).show();
                }

                else if (PasswordEd.getText().toString().replace(" ","").replace("\n","").isEmpty()){
                    Toast.makeText(MainActivity.this, "Plaese enter Password", Toast.LENGTH_SHORT).show();
                }

                else if (UserNameEd.getText().toString().replace(" ","").replace("\n","").equals(UserName)&&PasswordEd.getText().toString().replace(" ","").replace("\n","").equals(PassWord)){
                    Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                }

                else {

                    Toast.makeText(MainActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();

                }


                if (checkBox.isChecked()){
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("UserName", UserNameEd.getText().toString());
                    editor.putString("Password",PasswordEd.getText().toString());
                    editor.apply();
                }


            }
        });
    }
}
