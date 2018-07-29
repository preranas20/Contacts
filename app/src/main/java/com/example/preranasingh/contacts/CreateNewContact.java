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
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class CreateNewContact extends AppCompatActivity implements View.OnClickListener {

    private static final int CAMERA_REQ=100;
    private ImageButton image;
    private EditText first,last,company,phone,email,url,address,birthday,nickname,fbUrl,twitterUrl,skype,youtube;
    private String textFirst,textLast,textCompany,textPhone,textEmail,textUrl,textAddress,textBirthday,textNickname,textFbUrl,textTwitterUrl,textSkype,textYoutube;
    private Date date;
    public static ArrayList<Contact> contactList = new ArrayList<Contact>();
    private  Bitmap photo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new_contact);


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
                    Contact contact = new Contact(textFirst, textLast, textCompany, textPhone, textEmail, textUrl, textAddress, textNickname, textFbUrl, textTwitterUrl, textSkype, textYoutube, date,photo );
                    contactList.add(contact);
                    Toast.makeText(this, "Contact Saved", Toast.LENGTH_LONG).show();
                    Log.d("demo", "Contacts saved: "+contactList.toString());
                    //Intent intent = new Intent(CreateNewContact.this, Contacts.class);
                    //startActivity(intent);
                    finish();
                }
            }



        }


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==CAMERA_REQ && resultCode==Activity.RESULT_OK){
            photo = (Bitmap) data.getExtras().get("data");
            image.setImageBitmap(photo);

        }

    }

}
