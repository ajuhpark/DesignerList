package com.andrew.designerlist.views;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.andrew.designerlist.R;
import com.andrew.designerlist.models.Designer;

/**
 * Created by fangbrian on 9/21/17.
 */

public class DesignerDetailActivity extends Activity {

    private TextView designerNameTextView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.designer_detail_activity);

        designerNameTextView = (TextView) findViewById(R.id.designer_name);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        if (bundle != null) {
            String designerName = bundle.getString(Designer.DESIGNER_NAME_EXTRA);
            designerNameTextView.setText(designerName);
        }
    }
}
