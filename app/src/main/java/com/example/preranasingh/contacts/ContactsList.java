package com.example.preranasingh.contacts;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import java.util.ArrayList;

public class ContactsList extends AppCompatActivity {
    private Intent intentedit;
    static final String CONTACT_KEY="CONTACT";
    static final String CONTACT_INDEX="CONTACT INDEX";
    private int index;
    ArrayList<Contact> listOfContacts=CreateNewContact.contactList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts_list);

        ScrollView sv_main= (ScrollView) findViewById(R.id.svmain);
        LinearLayout container= new LinearLayout(this);
        container.setOrientation(LinearLayout.VERTICAL);


        for(final Contact contact:listOfContacts){
          index=CreateNewContact.contactList.indexOf(contact);
          ListItemUI item=new ListItemUI(this);
          View itemView=(View)item;
          item.imgContact.setImageBitmap(contact.getPhoto());
          item.first.setText(contact.getFirst());
          item.last.setText(contact.getLast());
          item.phone.setText(contact.getPhone());


          container.addView(itemView);
          itemView.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
               intentedit=new Intent(ContactsList.this,EditContactActvity.class);
               intentedit.putExtra(CONTACT_KEY,contact) ;
               intentedit.putExtra(CONTACT_INDEX,index);
               startActivity(intentedit);
              }
          });
        }

        sv_main.addView(container);


    }
}
