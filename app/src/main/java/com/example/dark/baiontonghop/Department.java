package com.example.dark.baiontonghop;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.dark.baiontonghop.DAO.DepartmentDAO;
import com.example.dark.baiontonghop.DTO.department_class;

import java.util.List;

public class Department extends AppCompatActivity {
    DepartmentDAO deptDao;
    List<department_class> list;
    CustomDepartmentAdapter adapter;
    ListView lvwDepartment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_department);
        lvwDepartment= (ListView) findViewById(R.id.Mylistview);
        deptDao=new DepartmentDAO(getApplicationContext());
        loadDepartment();
        registerForContextMenu(lvwDepartment);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_department,menu);
        return true;
    }

    private void loadDepartment(){
        list= deptDao.getderpartment();
        adapter=new CustomDepartmentAdapter(this,R.layout.row_department_layout,list);
        lvwDepartment.setAdapter(adapter);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //Toast.makeText(Department.this,"buoc sau lam",Toast.LENGTH_SHORT).show();
        int id=item.getItemId();
        if(id==R.id.mndepartment){
            final Dialog d=new Dialog(this);
            d.setTitle("Thêm Phòng Ban");
            d.setContentView(R.layout.add_dialog);
            final EditText edtDept= (EditText) d.findViewById(R.id.edtIdDepartment);
            Button btnAdd= (Button) d.findViewById(R.id.btnadd);
            d.show();
            btnAdd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    department_class dept=new department_class(edtDept.getText().toString());
                    deptDao.add(dept);
                    loadDepartment();
                    d.dismiss();
                }
            });
        }
        return false;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.context_menu_department,menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info=(AdapterView.AdapterContextMenuInfo)item.getMenuInfo();
        switch (item.getItemId()){
            case R.id.mnuDelete :
                Toast.makeText(getApplicationContext(),"A Department was Delete",Toast.LENGTH_LONG).show();;
                return true;
            case R.id.mnuEdit :
                Toast.makeText(getApplicationContext(),"A Department was Edit",Toast.LENGTH_LONG).show();;
                return true;
            default:
                return super.onContextItemSelected(item);

        }
    }
}
