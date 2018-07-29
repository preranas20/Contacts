package com.example.preranasingh.contacts;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class Contacts extends AppCompatActivity implements View.OnClickListener {
    private Intent intent1,intentEdit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);

        findViewById(R.id.btnFinish).setOnClickListener(this);
        findViewById(R.id.btnCreateNew).setOnClickListener(this);
        findViewById(R.id.btnEditContact).setOnClickListener(this);
        intent1 = new Intent(Contacts.this,CreateNewContact.class);
        intentEdit=new Intent(Contacts.this,ContactsList.class);
        }

    @Override
    public void onClick(View view) {

        switch(view.getId()){


            case R.id.btnCreateNew:
                  startActivity(intent1);
                  break;


            case R.id.btnEditContact:
                startActivity(intentEdit);
                break;

            case R.id.btnDeleteContact:

            case R.id.btnDisplayContact:

            case R.id.btnFinish:{
                finish();
                System.exit(0);
            }

        }


    }
}
