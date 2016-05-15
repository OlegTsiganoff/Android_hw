package com.example.student.contacts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    PhoneBook phoneBook;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        phoneBook = new PhoneBook();
    }

    public void OnSubmitClick(View view) {
        EditText nameText = (EditText)findViewById(R.id.editName);
        EditText lastNameText = (EditText) findViewById(R.id.editLastName);
        EditText phoneText = (EditText) findViewById(R.id.editPhone);

        LinearLayout linear = (LinearLayout)findViewById(R.id.linearLayout);
        Contact contact = new Contact();
        contact.setName(nameText.getText().toString());
        contact.setLastName(lastNameText.getText().toString());
        contact.addPhone(phoneText.getText().toString());

        phoneBook.addContact(contact);


        linear.removeAllViews();
        for (int i = 0; i < phoneBook.contacts.size(); i++) {

            Contact item = phoneBook.contacts.get(i);
            TextView name = new TextView(this);
            name.setText(item.getName());
            TextView secondName = new TextView(this);
            secondName.setText(item.getLastName());
            TextView phones = new TextView(this);
            phones.setText(item.getPhonesAsString());

            LinearLayout linearLayout = new LinearLayout(this);
            linearLayout.setOrientation(LinearLayout.VERTICAL);
            linearLayout.addView(name);
            linearLayout.addView(secondName);
            linearLayout.addView(phones);

            linear.addView(linearLayout);
        }

        nameText.setText("");
        lastNameText.setText("");
        phoneText.setText("");

    }
}
