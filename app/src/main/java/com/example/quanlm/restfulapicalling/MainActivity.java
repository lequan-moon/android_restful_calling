package com.example.quanlm.restfulapicalling;

import android.preference.PreferenceActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {
    ListView listContacts;
    ArrayAdapter listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listAdapter = new AdtContact(this, R.layout.contact_item);
        initControls();
//        initEvents();
    }

    private void initControls() {
        listContacts = (ListView) findViewById(R.id.listContacts);

        AsyncHttpClient client = new AsyncHttpClient();
        client.get("https://api.androidhive.info/contacts/", new AsyncHttpResponseHandler() {

            @Override
            public void onStart() {
                // called before request is started
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {

                try {
                    List<Model_Contact> lstContacts = new ArrayList<>();
                    JSONObject object = new JSONObject(new String(responseBody));
                    JSONArray jsonContacts = object.getJSONArray("contacts");
                    for (int i = 0; i< jsonContacts.length(); i++) {
                        JSONObject contact = jsonContacts.getJSONObject(i);
                        String id = contact.getString("id");
                        String name = contact.getString("name");
                        String email = contact.getString("email");
                        String address = contact.getString("address");
                        lstContacts.add(new Model_Contact(id, name, email, address));
                    }

                    listAdapter.addAll(lstContacts);
                    listContacts.setAdapter(listAdapter);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] errorResponse, Throwable e) {
                // called when response HTTP status is "4XX" (eg. 401, 403, 404)
            }

            @Override
            public void onRetry(int retryNo) {
                // called when request is retried
            }
        });

    }
}
