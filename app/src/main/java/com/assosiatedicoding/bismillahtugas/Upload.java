package com.assosiatedicoding.bismillahtugas;

import com.google.firebase.database.Exclude;

public class Upload {
    private String mName;
    private String mImageUrl;
    private String mDescription;
    private String mLatitude;
    private String mLongitude;
    private String mKey;


    public Upload() {
        //empty constructor needed
    }

    public Upload(String name, String imageUrl, String description, String latitude, String longitude) {
        if (name.trim().equals("")) {
            name = "No Name";
        }

        mName = name;
        mImageUrl = imageUrl;
        mDescription = description;
        mLatitude = latitude;
        mLongitude = longitude;

    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }



    public String getImageUrl() {
        return mImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        mImageUrl = imageUrl;
    }
    public void setDescription(String description){
        mDescription = description;
    }
    public String getDescription(){
        return mDescription;
    }
    public void setLatitude(String latitude){
        mLatitude = latitude;
    }
    public String getLatitude(){
        return mLatitude;
    }
    public void setLongitude(String longitude){
        mLongitude = longitude;
    }
    public String getLongitude(){
        return mLongitude;
    }
    @Exclude
    public String getmKey(){
        return mKey;
    }
    @Exclude
    public void setmKey(String key){
        mKey = key;
    }
}
