package com.acme.a3csci3130;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class DetailViewActivity extends Activity {

    private EditText buisnessnameField, buisnessaddressField, buisnessnumberField;
    private Spinner buisnesssectorSpinner, buisnessprovinceSpinner;
    Contact receivedBuisnessInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_view);
        receivedBuisnessInfo = (Contact)getIntent().getSerializableExtra("Contact");

        buisnessnameField = (EditText) findViewById(R.id.buisnessname);
        buisnessaddressField = (EditText) findViewById(R.id.buisnessaddress);
        buisnessnumberField = (EditText) findViewById(R.id.buisnessnumber);
        buisnesssectorSpinner = (Spinner) findViewById(R.id.buisnesssector);
        buisnessprovinceSpinner = (Spinner) findViewById(R.id.buisnessprovince);

        if(receivedBuisnessInfo != null){
            buisnessnameField.setText(receivedBuisnessInfo.buisnessname);
            buisnessaddressField.setText(receivedBuisnessInfo.buisnessaddress);
            buisnessnumberField.setText(receivedBuisnessInfo.buisnessnumber);
            ArrayAdapter<String> sectoradaptor = (ArrayAdapter<String>) buisnesssectorSpinner.getAdapter();
            buisnesssectorSpinner.setSelection(sectoradaptor.getPosition(receivedBuisnessInfo.buisnesssector));
            ArrayAdapter<String> provinceadaptor = (ArrayAdapter<String>) buisnessprovinceSpinner.getAdapter();
            buisnessprovinceSpinner.setSelection(provinceadaptor.getPosition(receivedBuisnessInfo.buisnessprovince));
        }
    }


    public void updateContact(View v){
        //TODO: Update contact funcionality
        
    }

    public void eraseContact(View v)
    {
        //TODO: Erase contact functionality
    }
}
