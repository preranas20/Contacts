package com.example.preranasingh.contacts;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

/**
 * Created by preranasingh on 9/16/17.
 */

public class Contact implements Parcelable{
    String first,last,company,phone,email,url,address,nickName,facebookUrl,TwitterUrl,skype,youtube;
    Date birthday;
    Bitmap photo;


    @Override
    public String toString() {
        return this.getFirst()+" "+ this.getLast()+" "+ this.getPhone();
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public void setFacebookUrl(String facebookUrl) {
        this.facebookUrl = facebookUrl;
    }

    public void setTwitterUrl(String twitterUrl) {
        TwitterUrl = twitterUrl;
    }

    public void setSkype(String skype) {
        this.skype = skype;
    }

    public void setYoutube(String youtube) {
        this.youtube = youtube;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void setPhoto(Bitmap photo) {
        this.photo = photo;
    }

    public Contact(String first, String last, String company, String phone, String email, String url, String address, String nickName, String facebookUrl, String twitterUrl, String skype, String youtube, Date birthday, Bitmap photo) {
        this.first = first;
        this.last = last;
        this.company = company;
        this.phone = phone;

        this.email = email;

        this.url = url;
        this.address = address;
        this.nickName = nickName;
        this.facebookUrl = facebookUrl;
        TwitterUrl = twitterUrl;
        this.skype = skype;
        this.youtube = youtube;
        this.birthday = birthday;
        this.photo = photo;
    }

    public Contact(Parcel in) {
        first = in.readString();
        last = in.readString();
        company = in.readString();
        phone = in.readString();
        email = in.readString();
        url = in.readString();
        address = in.readString();
        nickName = in.readString();
        facebookUrl = in.readString();
        TwitterUrl = in.readString();
        skype = in.readString();
        youtube = in.readString();
        photo = in.readParcelable(Bitmap.class.getClassLoader());
    }

    public static final Creator<Contact> CREATOR = new Creator<Contact>() {
        @Override
        public Contact createFromParcel(Parcel in) {
            return new Contact(in);
        }

        @Override
        public Contact[] newArray(int size) {
            return new Contact[size];
        }
    };

    public String getFirst() {
        return first;
    }

    public String getLast() {
        return last;
    }

    public String getCompany() {
        return company;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getUrl() {
        return url;
    }

    public String getAddress() {
        return address;
    }

    public String getNickName() {
        return nickName;
    }

    public String getFacebookUrl() {
        return facebookUrl;
    }

    public String getTwitterUrl() {
        return TwitterUrl;
    }

    public String getSkype() {
        return skype;
    }

    public String getYoutube() {
        return youtube;
    }

    public Date getBirthday() {
        return birthday;
    }

    public Bitmap getPhoto() {
        return photo;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(first);
        parcel.writeString(last);
        parcel.writeString(company);
        parcel.writeString(phone);
        parcel.writeString(email);
        parcel.writeString(url);
        parcel.writeString(address);
        parcel.writeString(nickName);
        parcel.writeString(facebookUrl);
        parcel.writeString(TwitterUrl);
        parcel.writeString(skype);
        parcel.writeString(youtube);
        parcel.writeParcelable(photo, i);
    }
}

