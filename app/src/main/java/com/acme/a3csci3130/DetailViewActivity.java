package com.acme.a3csci3130;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DetailViewActivity extends Activity {

    private EditText buisnessnameField, buisnessaddressField, buisnessnumberField;
    private Spinner buisnesssectorSpinner, buisnessprovinceSpinner;
    Contact receivedBuisnessInfo;
    ArrayAdapter<String> sectoradaptor, provinceadaptor;

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
            sectoradaptor = (ArrayAdapter<String>) buisnesssectorSpinner.getAdapter();
            buisnesssectorSpinner.setSelection(sectoradaptor.getPosition(receivedBuisnessInfo.buisnesssector));
            provinceadaptor = (ArrayAdapter<String>) buisnessprovinceSpinner.getAdapter();
            buisnessprovinceSpinner.setSelection(provinceadaptor.getPosition(receivedBuisnessInfo.buisnessprovince));
        }
    }


    public void updateContact(View v){
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference();

        ref.child("contacts").child(receivedBuisnessInfo.buisnessid).child("buisnessname").setValue(buisnessnameField.getText().toString());
        ref.child("contacts").child(receivedBuisnessInfo.buisnessid).child("buisnessaddress").setValue(buisnessaddressField.getText().toString());
        ref.child("contacts").child(receivedBuisnessInfo.buisnessid).child("buisnessnumber").setValue(buisnessnumberField.getText().toString());
        ref.child("contacts").child(receivedBuisnessInfo.buisnessid).child("buisnessprovince").setValue(buisnessprovinceSpinner.getSelectedItem().toString());
        ref.child("contacts").child(receivedBuisnessInfo.buisnessid).child("buisnesssector").setValue(buisnesssectorSpinner.getSelectedItem().toString());
    }

    public void eraseContact(View v)
    {
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference();

        receivedBuisnessInfo = (Contact)getIntent().getSerializableExtra("Contact");

        ref.child("contacts").child(receivedBuisnessInfo.buisnessid).removeValue();
    }
}
