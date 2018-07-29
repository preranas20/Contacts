package com.example.preranasingh.contacts;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import java.util.ArrayList;

public class ContactsList extends AppCompatActivity {
    private static final int REQ_CODE=101;
    private static final String CONTACTLIST_KEY ="contact list" ;
    private Intent intentedit;
    static final String CONTACT_KEY="CONTACT";
    static final String CONTACT_INDEX="CONTACT INDEX";
   // private int index;
    ArrayList<Contact> listOfContacts;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts_list);
        listOfContacts = CreateNewContact.contactList;
        if (getIntent().getExtras() != null) {
            listOfContacts = getIntent().getExtras().getParcelableArrayList("mode");
        }
            ScrollView sv_main = (ScrollView) findViewById(R.id.svmain);
            LinearLayout container = new LinearLayout(this);
            container.setOrientation(LinearLayout.VERTICAL);


            for (final Contact contact : listOfContacts) {
                ListItemUI item = new ListItemUI(this);
                View itemView = (View) item;
                item.imgContact.setImageBitmap(contact.getPhoto());
                item.first.setText(contact.getFirst());
                item.last.setText(contact.getLast());
                item.phone.setText(contact.getPhone());


                container.addView(itemView);
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        intentedit = new Intent(ContactsList.this, EditContactActvity.class);
                        intentedit.putExtra(CONTACT_KEY, contact);
                        Log.d("demo", "Index on clicking contact: "+CreateNewContact.contactList.indexOf(contact));
                        intentedit.putExtra(CONTACT_INDEX, CreateNewContact.contactList.indexOf(contact));
                        startActivityForResult(intentedit, REQ_CODE);
                    }
                });
            }

            sv_main.addView(container);



    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode,Intent data) {
        //super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==REQ_CODE && resultCode== Activity.RESULT_OK){

            Intent intentRefresh = new Intent(this, ContactsList.class);
            intentRefresh.putExtra("mode", data.getParcelableArrayListExtra(CONTACTLIST_KEY));
            startActivity(intentRefresh);
            finish();

        }
    }
}

