package com.example.dark.baiontonghop;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.dark.baiontonghop.DTO.department_class;

import java.util.List;

/**
 * Created by Dark on 4/23/2017.
 */

public class CustomDepartmentAdapter extends ArrayAdapter{
    Context context;
    int resource;
    List<department_class> list;

    public CustomDepartmentAdapter(Context context, int resource, List<department_class> objects) {
        super(context, resource, objects);
        this.context=context;
        this.resource=resource;
        this.list=objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater=((Activity)context).getLayoutInflater();
        View row=inflater.inflate(R.layout.row_department_layout,null);

        TextView txtDeptID= (TextView) row.findViewById(R.id.txtdeptId);
        TextView txtDeptName= (TextView) row.findViewById(R.id.txtDeptName);

        department_class dept=list.get(position);
        txtDeptID.setText(String.valueOf(dept.getId()));
        txtDeptName.setText(dept.getName());

        return row;
    }
}
