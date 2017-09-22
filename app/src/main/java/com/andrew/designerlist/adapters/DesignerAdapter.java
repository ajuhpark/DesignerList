package com.andrew.designerlist.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.andrew.designerlist.R;
import com.andrew.designerlist.models.Designer;

import java.util.List;

/**
 * Created by fangbrian on 9/21/17.
 */

public class DesignerAdapter extends ArrayAdapter<Designer> {
    private List<Designer> designers;
    private Context context;

    public DesignerAdapter(@NonNull Context context, int resource, @NonNull List<Designer> designers) {
        super(context, resource, designers);
        this.designers = designers;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Designer designer = designers.get(position);
        LayoutInflater inflater = LayoutInflater.from(context);
        convertView = inflater.inflate(R.layout.designer_list_item, parent, false);
        ((TextView) convertView.findViewById(R.id.designer_name)).setText(designer.getName());
        return convertView;
    }

    @Override
    public int getCount() {
        return designers.size();
    }
}
