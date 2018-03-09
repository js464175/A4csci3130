package com.acme.a3csci3130;

import com.google.firebase.database.Exclude;
import com.google.firebase.database.IgnoreExtraProperties;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Class that defines how the data will be stored in the
 * Firebase databse. This is converted to a JSON format
 */

public class Contact implements Serializable {

    public  String buisnessid;
    public  String buisnessnumber;          // 9 digit number
    public  String buisnessaddress;     // <50 characters
    public  String buisnessname;        // 2-48 characters
    public  String buisnesssector;      // {Fisher, Distributor, Processor, Fish Monger}
    public  String buisnessprovince;    // {AB, BC, MB, NB, NL, NS, NT, NU, ON, PE, QC, SK, YT, “ “}

    public Contact() {
        // Default constructor required for calls to DataSnapshot.getValue
    }

    public Contact(String buisnessid, String buisnessnum, String buisnessaddress, String buisnessname, String buisnesssector, String buisnessprovince){

        this.buisnessid = buisnessid;
        this.buisnessnumber = buisnessnum;
        this.buisnessaddress = buisnessaddress;
        this.buisnessname = buisnessname;
        this.buisnesssector = buisnesssector;
        this.buisnessprovince = buisnessprovince;
    }

    @Exclude
    public Map<String, Object> toMap(){
        HashMap<String, Object> result = new HashMap<>();
        /*
        result.put("uid", uid);
        result.put("name", name);
        result.put("email", email);
        */
        result.put("buisnessid", buisnessid);
        result.put("buisnessnum", buisnessnumber);
        result.put("buisnessaddress", buisnessaddress);
        result.put("buisnessname", buisnessname);
        result.put("buisnesssector", buisnesssector);
        result.put("buisnessprovince", buisnessprovince);

        return result;
    }
}
