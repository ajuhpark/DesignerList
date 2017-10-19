package com.andrew.designerlist.views;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.andrew.designerlist.R;
import com.andrew.designerlist.adapters.DesignerAdapter;
import com.andrew.designerlist.models.Designer;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    private DesignerAdapter adapter;
    private ArrayList<Designer> designers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        Create an array
        */

        /*
        We need an adapter that's responsible for conversion from
        java code (the array) to list items that I can use.
        The ArrayAdapter object knows we're trying to convert the array
        to list items.  It takes in the parameters "this" and
        android.R.layout.simple_list_items_1. We're using simple
        list items 1 for text list.
         */

        populateDesignerList();

        /*
        todo: need to go over adapters and its parameters.
         */

        /*
        we're going to create our own adapter so we can customize how list looks.
        todo: Not sure where we got designer_list_item.
        designers is the arrayList of designers we made.

         */
        adapter = new DesignerAdapter(this, R.layout.designer_list_item, designers);

        //create a reference to the list
        ListView designersListView = (ListView) findViewById(R.id.designersListView);
        designersListView.setAdapter(adapter);

        designersListView.setOnItemClickListener(
                new AdapterView.OnItemClickListener(){
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        //todo: not sure what this get(position) does. Do I create a new
                        Designer designer = designers.get(position);
                        showDesignerDetail(designer);
                    }
                }
        );
    }

    //populate designer list

    private void populateDesignerList() {
        String[] designersStringArray = {"Robert Geller", "Native Son", "Ace & Jig", "The Row", "Lemaire", "Siki Im"};
        designers = new ArrayList<Designer>();
        for (int i = 0; i < designersStringArray.length; i++) {
            designers.add(new Designer(designersStringArray[i]));
        }
    }

    private void showDesignerDetail(Designer designer) {
        /*
        An Intent is an object that provides runtime binding between separate components,
        such as two activities. The Intent represents an app’s "intent to do something."
        So we create an instance of the intent and then put DesignerDetailActivity as the
        class we want to go to for the second parameter.
         */
        Intent intent = new Intent(this, DesignerDetailActivity.class);
        /*
        An Intent can carry data types as key-value pairs called extras.
        In this case, the Designer.DESIGNER_NAME_EXTRA is the key, designer.getName is value.
        We set DESIGNER_NAME_EXTRA to the "designer_name" variable.
        */
        intent.putExtra(Designer.DESIGNER_NAME_EXTRA, designer.getName());
        startActivity(intent);
    }
}

