package app.gaurav.com.feedback;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import app.gaurav.com.feedback.Authentication.Login;

public class Home extends AppCompatActivity {

    ImageView q1Sad, q1Happy, q1Average, q1Wrost, q1Love,
            q2Sad, q2Happy, q2Average, q2Worst, q2Love,
            q3Sad, q3Happy, q3Average, q3Worst, q3Love,
            q4Down, q4Up;

    EditText q5Input;

    String Q1="", Q2="", Q3="", Q4="", Q5="No Answer";

    Button Submit, Restart;

    String Input="";

    Boolean q1sad = false, q1happy = false, q1average = false, q2sad = false, q2happy = false,
            q2average = false;

    CardView q1, q2, q3, q4, q5, done;

    int Next = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        SharedPreferences.Editor editor = getSharedPreferences("Auth", MODE_PRIVATE).edit();
        editor.putBoolean("user", true);
        editor.apply();

        q1Sad = findViewById(R.id.q1sad);
        q1Average = findViewById(R.id.q1average);
        q1Happy = findViewById(R.id.q1happy);
        q1Love = findViewById(R.id.q1love);
        q1Wrost = findViewById(R.id.q1worst);
        q2Sad = findViewById(R.id.q2sad);
        q2Average = findViewById(R.id.q2average);
        q2Happy = findViewById(R.id.q2happy);
        q2Worst = findViewById(R.id.q2worst);
        q2Love = findViewById(R.id.q2love);
        q3Happy = findViewById(R.id.q3happy);
        q3Average = findViewById(R.id.q3average);
        q3Sad = findViewById(R.id.q3sad);
        q3Love = findViewById(R.id.q3love);
        q3Worst = findViewById(R.id.q3worst);
        q4Down = findViewById(R.id.q4down);
        q4Up = findViewById(R.id.q4up);
        q5Input = findViewById(R.id.q5Input);
        Submit = findViewById(R.id.submit);
        Restart = findViewById(R.id.restart);
        q4 = findViewById(R.id.q4);
        q1 = findViewById(R.id.q1);
        q2 = findViewById(R.id.q2);
        q3 = findViewById(R.id.q3);
        q5 = findViewById(R.id.q5);
        done = findViewById(R.id.done);

        setOnClicks();

    }

    public void setOnClicks() {

        Restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Home.this.recreate();

            }
        });

        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



            }
        });

        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Input = q5Input.getText().toString().trim();

                if (!Input.isEmpty()) {

                    Next = 4;

                    Q5 = Input;

                    nextQuestion();

                    ShowResult();

                } else {

                    Toast.makeText(Home.this, " Enter a product to continue :)", Toast.LENGTH_SHORT).show();

                }

            }
        });

        q4Up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                q4Up.animate().scaleX(1.7f).scaleY(1.7f).setDuration(1000);

                q5.setVisibility(View.GONE);

                Next = 4;

                final Handler handler5 = new Handler();

                final Runnable r5 = new Runnable() {
                    public void run() {
                        nextQuestion();
                        handler5.postDelayed(this, 1200);
                    }
                };

                handler5.postDelayed(r5, 1200);

                Q4 = "Yes";

                ShowResult();

            }
        });

        q4Down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                q4Down.animate().scaleX(1.7f).scaleY(1.7f).setDuration(1000);

                Next = 3;

                final Handler handler5 = new Handler();

                final Runnable r = new Runnable() {
                    public void run() {
                        nextQuestion();
                        handler5.postDelayed(this, 1200);
                    }
                };

                handler5.postDelayed(r, 1200);

                Q4 = "No";

            }
        });

        q3Average.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                q3Average.animate().scaleX(1.6f).scaleY(1.6f).setDuration(1000);

                Next = 2;

                final Handler handler3 = new Handler();

                final Runnable r3 = new Runnable() {
                    public void run() {
                        nextQuestion();
                        handler3.postDelayed(this, 1200);
                    }
                };

                handler3.postDelayed(r3, 1200);

                Q3 = "Low";

            }
        });

        q3Worst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                q3Worst.animate().scaleX(1.6f).scaleY(1.6f).setDuration(1000);

                Next = 2;

                final Handler handler3 = new Handler();

                final Runnable r3 = new Runnable() {
                    public void run() {
                        nextQuestion();
                        handler3.postDelayed(this, 1200);
                    }
                };

                handler3.postDelayed(r3, 1200);

                Q3 = "Costly";

            }
        });

        q3Love.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                q3Love.animate().scaleX(1.6f).scaleY(1.6f).setDuration(1000);

                Next = 2;

                final Handler handler3 = new Handler();

                final Runnable r3 = new Runnable() {
                    public void run() {
                        nextQuestion();
                        handler3.postDelayed(this, 1200);
                    }
                };

                handler3.postDelayed(r3, 1200);

                Q3 = "Average";

            }
        });

        q3Sad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                q3Sad.animate().scaleX(1.6f).scaleY(1.6f).setDuration(1000);

                Next = 2;

                final Handler handler3 = new Handler();

                final Runnable r3 = new Runnable() {
                    public void run() {
                        nextQuestion();
                        handler3.postDelayed(this, 1200);
                    }
                };

                handler3.postDelayed(r3, 1200);

                Q3 = "Costly";

            }
        });

        q3Happy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                q3Happy.animate().scaleX(1.6f).scaleY(1.6f).setDuration(1000);

                Next = 2;

                final Handler handler3 = new Handler();

                final Runnable r3 = new Runnable() {
                    public void run() {
                        nextQuestion();
                        handler3.postDelayed(this, 1200);
                    }
                };

                handler3.postDelayed(r3, 1200);

                Q3 = "Good";

            }
        });

        q1Sad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                q1Sad.animate().scaleX(1.6f).scaleY(1.6f).setDuration(1000);

                final Handler handler1 = new Handler();

                final Runnable r = new Runnable() {
                    public void run() {
                        nextQuestion();
                        handler1.postDelayed(this, 1200);
                    }
                };

                handler1.postDelayed(r, 1200);

                Q1 = "Sad";

            }
        });

        q1Wrost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                q1Wrost.animate().scaleX(1.6f).scaleY(1.6f).setDuration(1000);

                final Handler handler1 = new Handler();

                final Runnable r = new Runnable() {
                    public void run() {
                        nextQuestion();
                        handler1.postDelayed(this, 1200);
                    }
                };

                handler1.postDelayed(r, 1200);

                Q1 = "Worst";

            }
        });

        q1Love.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                q1Love.animate().scaleX(1.6f).scaleY(1.6f).setDuration(1000);

                final Handler handler1 = new Handler();

                final Runnable r = new Runnable() {
                    public void run() {
                        nextQuestion();
                        handler1.postDelayed(this, 1200);
                    }
                };

                handler1.postDelayed(r, 1200);

                Q1 = "Amazing";

            }
        });

        q1Average.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                q1Average.animate().scaleX(1.6f).scaleY(1.6f).setDuration(1000);

                final Handler handler1 = new Handler();

                final Runnable r = new Runnable() {
                    public void run() {
                        nextQuestion();
                        handler1.postDelayed(this, 1200);
                    }
                };

                handler1.postDelayed(r, 1200);

                Q1 = "Average";

            }
        });

        q1Happy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                q1Happy.animate().scaleX(1.6f).scaleY(1.6f).setDuration(1000);

                final Handler handler1 = new Handler();

                final Runnable r = new Runnable() {
                    public void run() {
                        nextQuestion();
                        handler1.postDelayed(this, 1200);
                    }
                };

                handler1.postDelayed(r, 1200);

                Q1 = "Happy";

            }
        });

        q2Sad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                q2Sad.animate().scaleX(1.6f).scaleY(1.6f).setDuration(1000);

                Next = 1;

                final Handler handler = new Handler();

                final Runnable r2 = new Runnable() {
                    public void run() {
                        nextQuestion();
                        handler.postDelayed(this, 1200);
                    }
                };

                handler.postDelayed(r2, 1200);

                Q2 = "Sad";

            }
        });

        q2Happy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                q2Happy.animate().scaleX(1.6f).scaleY(1.6f).setDuration(1000);

                Next = 1;

                final Handler handler = new Handler();

                final Runnable r2 = new Runnable() {
                    public void run() {
                        nextQuestion();
                        handler.postDelayed(this, 1200);
                    }
                };

                handler.postDelayed(r2, 1200);

                Q2 = "Happy";

            }
        });

        q2Average.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                q2Average.animate().scaleX(1.6f).scaleY(1.6f).setDuration(1000);

                Next = 1;

                final Handler handler = new Handler();

                final Runnable r2 = new Runnable() {
                    public void run() {
                        nextQuestion();
                        handler.postDelayed(this, 1200);
                    }
                };

                handler.postDelayed(r2, 1200);

                Q2 = "Average";

            }
        });

        q2Worst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                q2Worst.animate().scaleX(1.6f).scaleY(1.6f).setDuration(1000);

                Next = 1;

                final Handler handler = new Handler();

                final Runnable r2 = new Runnable() {
                    public void run() {
                        nextQuestion();
                        handler.postDelayed(this, 1200);
                    }
                };

                handler.postDelayed(r2, 1200);

                Q2 = "Worst";

            }
        });

        q2Love.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                q2Love.animate().scaleX(1.6f).scaleY(1.6f).setDuration(1000);

                Next = 1;

                final Handler handler = new Handler();

                final Runnable r2 = new Runnable() {
                    public void run() {
                        nextQuestion();
                        handler.postDelayed(this, 1200);
                    }
                };

                handler.postDelayed(r2, 1200);

                Q2 = "Amazing";

            }
        });

    }

    public void nextQuestion() {

        if (Next == 0) {

            q1.animate().alpha(0f).setDuration(750);
            q2.animate().translationX(0).setDuration(750);

        }

        if (Next == 1) {

            q2.animate().alpha(0f).setDuration(750);
            q3.animate().translationX(0).setDuration(750);

        }

        if (Next == 2) {

            q3.animate().alpha(0f).setDuration(750);
            q4.animate().translationX(0).setDuration(750);

        }

        if (Next == 3) {

            q4.animate().alpha(0f).setDuration(750);
            q5.animate().translationX(0).setDuration(750);

        }

        if (Next == 4) {

            q5.animate().alpha(0f).setDuration(750);
            done.animate().translationX(0).setDuration(750);

        }

    }

    private void ShowResult() {

        print("Question 1: "+ Q1 +"\nQuestion 2: "+ Q2 +"\nQuestion 3: "+ Q3 +
                "\nQuestion 4: "+ Q4 + "\nQuestion 5: "+ Q5);

    }

    public void print(String s) {

        Toast.makeText(Home.this,s,Toast.LENGTH_LONG).show();

    }

}
