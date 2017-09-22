package com.andrew.designerlist.views;

import android.app.Activity;
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

        adapter = new DesignerAdapter(this, R.layout.designer_list_item, populateDesignerList());
        /*
        create a reference to the list
         */
        ListView designersListView = (ListView) findViewById(R.id.designersListView);
        designersListView.setAdapter(adapter);

        designersListView.setOnItemClickListener(
                new AdapterView.OnItemClickListener(){
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String designers = String.valueOf(parent.getItemAtPosition(position));
                        Toast.makeText(MainActivity.this, designers, Toast.LENGTH_LONG).show();

                    }
                }
        );

    }

    private List<Designer> populateDesignerList() {
        String[] designersStringArray = {"Robert Geller", "Native Son", "Ace & Jig", "The Row", "Lemaire", "Siki Im"};
        List<Designer> designers = new ArrayList<Designer>();
        for (int i = 0; i < designersStringArray.length; i++) {
            designers.add(new Designer(designersStringArray[i]));
        }

        return designers;
    }
}

