package mariana.studio.com.listadapter;

import android.database.Cursor;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ViewListContents extends AppCompatActivity{
    DatabaseHelper myDb;
    ArrayList<User> userList;
    ListView listView;
    User user;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewcontents_layout);

        myDb = new DatabaseHelper(this);

        userList = new ArrayList<>();
        Cursor data = myDb.getListContents();
        int numRows = data.getCount();
        if(numRows==0){
            Toast.makeText(ViewListContents.this,"There is nothing in this database",Toast.LENGTH_LONG).show();
        }else{
            while(data.moveToNext()){
                user = new User(data.getString(1),data.getString(2),data.getString(3));
                userList.add(user);
            }
            ThreeColumn_ListAdapter adapter = new ThreeColumn_ListAdapter(this, R.layout.list_adapter_view,userList);
            listView = (ListView) findViewById(R.id.listView);
            listView.setAdapter(adapter);
        }
    }
}
