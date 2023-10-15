package com.example.wattwallet;

import com.parse.ParseClassName;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseUser;

@ParseClassName("_User")

public class User extends ParseUser {
    public static final String KEY_PROFILE_PHOTO = "ProfilePhoto";
    public static final String KEY_TOTAL_WATT = "Total_Watts";
    public static final String KEY_TOTAL_INCOME = "Total_Income";


    public ParseObject getTotalWatt(){return getParseObject(KEY_TOTAL_WATT);}

    public ParseObject getTotalIncome(){return getParseObject(KEY_TOTAL_INCOME);}

    public ParseFile getProfilePhoto(){
        return getParseFile(KEY_PROFILE_PHOTO);
    }
    public void setProfilePhoto(ParseFile parseFile){
        put(KEY_PROFILE_PHOTO, parseFile);
    }
}