package com.acme.a3csci3130;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class CreateContactAcitivity extends Activity {

    private Button submitButton;
    private EditText buisnessnumField, buisnessaddressField, buisnessnameField;
    private Spinner  buisnesssectorSpinner, buisnessprovinceSpinner;
    private MyApplicationData appState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_contact_acitivity);
        //Get the app wide shared variables
        appState = ((MyApplicationData) getApplicationContext());

        submitButton = (Button) findViewById(R.id.submitButton);
        buisnessnumField = (EditText) findViewById(R.id.buisnessnumber);
        buisnessnameField = (EditText) findViewById(R.id.buisnessname);
        buisnessaddressField = (EditText) findViewById(R.id.buisnessaddress);

        buisnesssectorSpinner = (Spinner) findViewById(R.id.buisnesssector);
        buisnessprovinceSpinner = (Spinner) findViewById(R.id.buisnessprovince);
    }

    public void submitInfoButton(View v) {
        //each entry needs a unique ID
        String buisnessID = appState.firebaseReference.push().getKey();
        String buisnessnum = buisnessnumField.getText().toString();
        String buisnessaddress = buisnessaddressField.getText().toString();
        String buisnessname = buisnessnameField.getText().toString();

        String buisnesssector = buisnesssectorSpinner.getSelectedItem().toString();
        String buisnessprovince = buisnessprovinceSpinner.getSelectedItem().toString();

        Contact person = new Contact(buisnessID, buisnessnum, buisnessaddress, buisnessname, buisnesssector, buisnessprovince);

        appState.firebaseReference.child(buisnessID).setValue(person);

        finish();

    }
}
