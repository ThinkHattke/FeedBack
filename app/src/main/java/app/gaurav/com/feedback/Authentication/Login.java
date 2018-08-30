package app.gaurav.com.feedback.Authentication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import app.gaurav.com.feedback.Home;
import app.gaurav.com.feedback.Model.Pass;
import app.gaurav.com.feedback.R;

public class Login extends AppCompatActivity {

    FirebaseFirestore db;

    LinearLayout userBox, passBox, create;

    ImageView passwordIcon, userIcon;

    EditText username, pass;

    TextView forgot;

    Button submit;

    String Username="", Password="";

    @Override
    protected void onStart() {
        super.onStart();
        SharedPreferences prefs = getSharedPreferences("Auth", MODE_PRIVATE);
        boolean auth = prefs.getBoolean("user",false);
        if (auth){
            Intent i = new Intent(Login.this, Home.class);
            startActivity(i);
            finish();
        }
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        db = FirebaseFirestore.getInstance();

        userBox = findViewById(R.id.usernameBox);
        passBox = findViewById(R.id.passwordBox);
        userIcon = findViewById(R.id.emailIcon);
        passwordIcon = findViewById(R.id.passwordIcon);
        username = findViewById(R.id.username);
        pass = findViewById(R.id.password);
        create = findViewById(R.id.createAccount);
        forgot = findViewById(R.id.forgotPassword);
        submit = findViewById(R.id.loginButton);

        username.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                userBox.setBackgroundResource(R.drawable.voilet_round);
                userIcon.setColorFilter(ContextCompat.getColor(Login.this, R.color.creamy), android.graphics.PorterDuff.Mode.SRC_IN);
                passBox.setBackgroundResource(R.drawable.grey_round);
                passwordIcon.setColorFilter(ContextCompat.getColor(Login.this, R.color.textGrey), android.graphics.PorterDuff.Mode.SRC_IN);

                return false;
            }
        });

        pass.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                userBox.setBackgroundResource(R.drawable.grey_round);
                userIcon.setColorFilter(ContextCompat.getColor(Login.this, R.color.textGrey), android.graphics.PorterDuff.Mode.SRC_IN);
                passBox.setBackgroundResource(R.drawable.voilet_round);
                passwordIcon.setColorFilter(ContextCompat.getColor(Login.this, R.color.creamy), android.graphics.PorterDuff.Mode.SRC_IN);

                return false;
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (checkFields()) {

                    db.collection("Users").document(Username).get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                        @Override
                        public void onSuccess(DocumentSnapshot documentSnapshot) {
                            if (documentSnapshot.exists()){
                                Pass pass = documentSnapshot.toObject(Pass.class);
                                if(pass.getPassword().equals(Password)){
                                    Intent i = new Intent(Login.this, Home.class);
                                    startActivity(i);
                                    finish();
                                } else {
                                    print("Incorrect Password");
                                }
                            } else {
                                print("User doesn't exist");
                            }
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            print("User doesn't exist");
                        }
                    });

                }

            }
        });

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Login.this, SignUp.class);
                startActivity(i);
                finish();
            }
        });

    }

    private Boolean checkFields() {

        Username = username.getText().toString().trim();
        Password = pass.getText().toString().trim();

        if (Username.isEmpty()){
            print("Enter a Username to continue");
            return false;
        } else if (Password.isEmpty()){
            print("Enter your Password to continue");
            return false;
        }

        return true;

    }

    public void print(String s) {

        Toast.makeText(Login.this,s,Toast.LENGTH_SHORT).show();

    }

}
