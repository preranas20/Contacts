package com.example.preranasingh.contacts;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ListItemUI extends LinearLayout {

    public TextView first,last,phone;
    public ImageView imgContact;
    public ListItemUI(Context context) {
        super(context);
        inflateXML(context);
    }

    private void inflateXML(Context context){
        LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView=inflater.inflate(R.layout.listitem,this);
        this.imgContact=(ImageView) findViewById(R.id.imgContact);
        this.first=(TextView) findViewById(R.id.txtFirst);
        this.last=(TextView) findViewById(R.id.txtLast);
        this.phone=(TextView) findViewById(R.id.txtPhone);
    }
}
