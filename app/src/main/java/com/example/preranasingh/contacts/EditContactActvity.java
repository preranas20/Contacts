package com.example.preranasingh.contacts;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class EditContactActvity extends AppCompatActivity implements View.OnClickListener {
    private static final int CAMERA_REQ=101;
    private ImageButton image;
    private EditText first,last,company,phone,email,url,address,birthday,nickname,fbUrl,twitterUrl,skype,youtube;
    private String textFirst,textLast,textCompany,textPhone,textEmail,textUrl,textAddress,textBirthday,textNickname,textFbUrl,textTwitterUrl,textSkype,textYoutube;
    private Date date;
    private Bitmap photo;
    private int index;
    Contact contact;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_contact_actvity);

        image = (ImageButton)findViewById(R.id.imageBtnContact);
        image.setOnClickListener(this);
        first = (EditText) findViewById(R.id.editFirst);
        last = (EditText) findViewById(R.id.editLast);
        company = (EditText) findViewById(R.id.editCompany);
        phone = (EditText) findViewById(R.id.editPhone);
        email = (EditText) findViewById(R.id.editEmail);
        url = (EditText) findViewById(R.id.editURL);
        address = (EditText) findViewById(R.id.editAddress);
        birthday = (EditText) findViewById(R.id.editBirthday);
        nickname = (EditText) findViewById(R.id.editNickName);
        fbUrl = (EditText) findViewById(R.id.editfbUrl);
        twitterUrl = (EditText) findViewById(R.id.editTwitterUrl);
        skype = (EditText) findViewById(R.id.editSkype);
        youtube = (EditText) findViewById(R.id.edityoutubeChannel);

        if (getIntent().getExtras() != null) {

            contact = getIntent().getExtras().getParcelable(ContactsList.CONTACT_KEY);
            index=getIntent().getExtras().getInt(ContactsList.CONTACT_INDEX);
            image.setImageBitmap(contact.getPhoto());
            first.setText(contact.getFirst());
            last.setText(contact.getLast());
            company.setText(contact.getCompany());
            phone.setText(contact.getPhone());
            email.setText(contact.getEmail());
            url.setText(contact.getUrl());
            address.setText(contact.getAddress());
            birthday.setText((CharSequence) contact.getBirthday());
            nickname.setText(contact.getNickName());
            fbUrl.setText(contact.getFacebookUrl());
            twitterUrl.setText(contact.getTwitterUrl());
            skype.setText(contact.getSkype());
            youtube.setText(contact.getYoutube());

        }

        findViewById(R.id.btnSave).setOnClickListener(this);
    }



    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.imageBtnContact:
                Intent cameraIntent= new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent,CAMERA_REQ);
                break;
            case R.id.btnSave: {
                textFirst = first.getText().toString();
                textLast = last.getText().toString();
                textCompany = company.getText().toString();
                textPhone = phone.getText().toString();
                textEmail = email.getText().toString();
                textUrl = url.getText().toString();
                textAddress = address.getText().toString();
                textBirthday = birthday.getText().toString();
                DateFormat format = new SimpleDateFormat("MMMM dd, yyyy", Locale.ENGLISH);
                try {
                    date = format.parse(textBirthday);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                textNickname = nickname.getText().toString();
                textFbUrl = fbUrl.getText().toString();
                textTwitterUrl = twitterUrl.getText().toString();
                textSkype = skype.getText().toString();
                textYoutube= youtube.getText().toString();
                if (textFirst.equals("")) {
                    Toast.makeText(this, "First Name Required", Toast.LENGTH_LONG).show();
                    return;
                }
                else if (textLast.equals("")) {
                    Toast.makeText(this, "Last Name Required", Toast.LENGTH_LONG).show();
                    return;
                }
                else if (textPhone.equals("")) {
                    Toast.makeText(this, "Phone Required", Toast.LENGTH_LONG).show();
                    return;
                } else {
                    contact.setFirst(textFirst);
                    contact.setLast(textLast);
                    contact.setCompany(textCompany);
                    contact.setPhone(textPhone);
                    contact.setBirthday(date);
                    contact.setEmail(textEmail);
                    contact.setUrl(textUrl);
                    contact.setAddress(textAddress);
                    contact.setNickName(textNickname);
                    contact.setFacebookUrl(textFbUrl);
                    contact.setTwitterUrl(textTwitterUrl);
                    contact.setSkype(textSkype);
                    contact.setYoutube(textYoutube);
                    contact.setPhoto(photo);
                    CreateNewContact.contactList.set(index,contact);
                    Toast.makeText(this, "Contact Saved", Toast.LENGTH_LONG).show();
                    Log.d("demo", "Contacts saved: "+CreateNewContact.contactList.toString());

                    finish();
                }
            }



        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==CAMERA_REQ && resultCode== Activity.RESULT_OK){
            photo = (Bitmap) data.getExtras().get("data");
            image.setImageBitmap(photo);

        }
    }
}
