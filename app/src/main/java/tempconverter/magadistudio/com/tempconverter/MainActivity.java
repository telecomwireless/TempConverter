package tempconverter.magadistudio.com.tempconverter;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;



/*
     Formulas (from wikipedia)  http://en.wikipedia.org/wiki/Fahrenheit
     [°C] = ([°F] − 32) × 5⁄9 --> From Fahrenheit to celsius
     [°F] = [°C] × 9⁄5 + 32  --> From Celsius to Fahrenheit

 */

public class MainActivity extends ActionBarActivity {


    private EditText tempEditText;
    private Button celButton;
    private Button fButton;
    private TextView showTempTextView;

    // create a decimal format object to round our values to 1 decimal places
    DecimalFormat round = new DecimalFormat("0.0");



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tempEditText = (EditText) findViewById(R.id.editText);
        celButton = (Button) findViewById(R.id.celsiusButtonId);
        fButton   = (Button) findViewById(R.id.fButtonId);
        showTempTextView = (TextView) findViewById(R.id.showResultTextView); //change: correct id

        //Set up our buttons (event listeners)
        celButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                 //call convertToCelsius()
                String editTextVal = tempEditText.getText().toString();

                if (editTextVal.isEmpty()){

                    // display a short message to the screen if things go wrong
                    Toast.makeText(getApplicationContext(), "Enter a Value", Toast.LENGTH_LONG).show();

                }else {
                     // we are good
                    double intEditText = Double.parseDouble(editTextVal);

                    // put the returned value into a variable so we can use it (make things organized)
                    double convertedVal = convertToCelsius(intEditText);

                    //use the String.valueOf() method to convert our double value into it's corresponding string format so we can out put it

                    String stringResult = String.valueOf(round.format(convertedVal));

                    showTempTextView.setText(stringResult + " C ");


                }

            }
        });

        fButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                //call convertToFahrenheit()
                String editTextVal = tempEditText.getText().toString();

                if (editTextVal.isEmpty()){

                     Toast.makeText(getApplicationContext(), "Enter a value", Toast.LENGTH_LONG).show();

                }else {
                    // all is good
                    double doubleEditText = Double.parseDouble(editTextVal);

                    double convertedVal = convertToFahrenheit(doubleEditText);

                    String stringResult = String.valueOf(round.format(convertedVal));

                    showTempTextView.setText(stringResult + " F");

                }
            }
        });

    }

    public double convertToCelsius(double farVal){

       // [°C] = ([°F] − 32) × 5⁄9 --> From Fahrenheit to celsius
        double resultCel;

        resultCel = (farVal - 32) * 5/9;



        return resultCel;
    }

    public double convertToFahrenheit(double celVal){

       // [°F] = [°C] × 9⁄5 + 32  --> From Celsius to Fahrenheit
        double resultFahr;

        resultFahr = (celVal * 9/5) + 32;

        return resultFahr;
    }


}
