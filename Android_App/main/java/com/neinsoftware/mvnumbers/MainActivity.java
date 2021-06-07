package com.obama.mvnumbers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentProviderOperation;
import android.os.Bundle;
import android.view.View;

import android.app.Activity ;
import android.content.Intent ;
import android.os.Bundle ;
import android.provider.ContactsContract ;
import android.view.View ;
import android.widget.EditText ;
import android.widget.TextView;
import android.widget.Toast ;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void addContact(View view) {
        TextView etContactName = findViewById(R.id. etContactName ) ;
        TextView etContactNumber = findViewById(R.id. etContactNumber ) ;
        String DisplayName = "XYZ";
        String MobileNumber = "123456";
        for (int i = 7000000; i < 7999999; i++) { //create loop based on company 
            DisplayName = String.valueOf(i); //set display name to phone number
            MobileNumber = "960"+String.valueOf(i); //add +960 to the number so telegram knows its a mv number
            ArrayList<ContentProviderOperation> ops = new ArrayList<ContentProviderOperation>();

            ops.add(ContentProviderOperation.newInsert(
                    ContactsContract.RawContacts.CONTENT_URI)
                    .withValue(ContactsContract.RawContacts.ACCOUNT_TYPE, null)
                    .withValue(ContactsContract.RawContacts.ACCOUNT_NAME, null)
                    .build());

            //------------------------------------------------------ Names
            if (DisplayName != null) {
                ops.add(ContentProviderOperation.newInsert(
                        ContactsContract.Data.CONTENT_URI)
                        .withValueBackReference(ContactsContract.Data.RAW_CONTACT_ID, 0)
                        .withValue(ContactsContract.Data.MIMETYPE,
                                ContactsContract.CommonDataKinds.StructuredName.CONTENT_ITEM_TYPE)
                        .withValue(
                                ContactsContract.CommonDataKinds.StructuredName.DISPLAY_NAME,
                                DisplayName).build());
            }

            //------------------------------------------------------ Mobile Number
            if (MobileNumber != null) {
                ops.add(ContentProviderOperation.
                        newInsert(ContactsContract.Data.CONTENT_URI)
                        .withValueBackReference(ContactsContract.Data.RAW_CONTACT_ID, 0)
                        .withValue(ContactsContract.Data.MIMETYPE,
                                ContactsContract.CommonDataKinds.Phone.CONTENT_ITEM_TYPE)
                        .withValue(ContactsContract.CommonDataKinds.Phone.NUMBER, MobileNumber)
                        .withValue(ContactsContract.CommonDataKinds.Phone.TYPE,
                                ContactsContract.CommonDataKinds.Phone.TYPE_MOBILE)
                        .build());
            }


            // Asking the Contact provider to create a new contact
            try {
                getContentResolver().applyBatch(ContactsContract.AUTHORITY, ops);
                etContactName.setText(DisplayName);  //just for basic output
                etContactNumber.setText(MobileNumber);
            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(this, "Exception: " + e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
    }
}