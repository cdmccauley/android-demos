package tech.mccauley.androidmathflashcards;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // declarations
    Button showButtonComponent, clearButtonComponent;
    EditText topNumberComponent, bottomNumberComponent;
    TextView answerNumberComponent;
    Spinner operationSignComponent;
    int topNumber, bottomNumber, answerNumber;
    String operationSign;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // init
        showButtonComponent = findViewById(R.id.show_button);
        clearButtonComponent = findViewById(R.id.clear_button);
        topNumberComponent = findViewById(R.id.top_number);
        bottomNumberComponent = findViewById(R.id.bottom_number);
        answerNumberComponent = findViewById(R.id.answer_number);
        operationSignComponent = findViewById(R.id.operation_sign);

        // clearButton action listener
        clearButtonComponent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // reset text and hint
                topNumberComponent.setText("");
                topNumberComponent.setHint("1");
                bottomNumberComponent.setText("");
                bottomNumberComponent.setHint("1");
                answerNumberComponent.setText("");

                // enable fields
                showButtonComponent.setEnabled(true);
                topNumberComponent.setEnabled(true);
                bottomNumberComponent.setEnabled(true);
                operationSignComponent.setEnabled(true);

            }
        });

        // showButton action listener
        showButtonComponent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // declarations
                boolean errorSentinel = false;
                Toast errorToast = Toast.makeText(MainActivity.this, "", Toast.LENGTH_SHORT);
                errorToast.setGravity(Gravity.TOP, 0, 100);

                // get and validate topNumber
                if (topNumberComponent.getText().length() != 0) {

                    // get number
                    topNumber = Integer.parseInt(topNumberComponent.getText().toString());

                    // validate number
                    if (topNumber < 0 || topNumber > 20) {

                        // topNumber error
                        errorSentinel = true;
                        errorToast.setText("Number must be 0-20");
                        errorToast.show();
                    }
                } else {

                    // topNumber error
                    errorSentinel = true;
                    errorToast.setText("Please provide a number.");
                    errorToast.show();
                }

                // get and validate bottomNumber
                if (bottomNumberComponent.getText().length() != 0) {

                    // get number
                    bottomNumber = Integer.parseInt(bottomNumberComponent.getText().toString());

                    // validate number
                    if (bottomNumber < 0 || bottomNumber > 20) {

                        // bottomNumber error
                        errorSentinel = true;
                        errorToast.setText("Number must be 0-20");
                        errorToast.show();
                    }
                } else {

                    // bottomNumber error
                    errorSentinel = true;
                    errorToast.setText("Please provide a number.");
                    errorToast.show();
                }

                // get operationSign
                operationSign = operationSignComponent.getSelectedItem().toString();

                // process input
                if (!errorSentinel) {
                    switch (operationSign) {
                        case ("+"):
                            answerNumber = topNumber + bottomNumber;
                            break;
                        case ("-"):
                            answerNumber = topNumber - bottomNumber;
                            break;
                        case ("x"):
                            answerNumber = topNumber * bottomNumber;
                            break;
                    }

                    // set answerNumber
                    answerNumberComponent.setText(Integer.toString(answerNumber));

                    // disable fields
                    showButtonComponent.setEnabled(false);
                    topNumberComponent.setEnabled(false);
                    bottomNumberComponent.setEnabled(false);
                    operationSignComponent.setEnabled(false);
                }
            }
        });
    }
}
