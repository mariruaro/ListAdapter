package mariana.studio.com.listadapter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText txtFirstName, txtLastName, txtFood;
    Button btnAdd,btnView;
    DatabaseHelper myDb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtFirstName=(EditText) findViewById(R.id.editText_FirstName);
        txtLastName=(EditText) findViewById(R.id.editText_LastName);
        txtFood=(EditText) findViewById(R.id.editText_Food);
        btnAdd=(Button) findViewById(R.id.button_add);
        btnView=(Button) findViewById(R.id.button_view);
        myDb = new DatabaseHelper(this);

        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ViewListContents.class);
                startActivity(intent);
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fName = txtFirstName.getText().toString();
                String lName = txtLastName.getText().toString();
                String food = txtFood.getText().toString();
                if(fName.length()!=0 && lName.length()!=0 && food.length()!=0){
                    AddData(fName,lName,food);
                    txtFirstName.setText("");
                    txtLastName.setText("");
                    txtFood.setText("");
                }else{
                    Toast.makeText(MainActivity.this,"You must put something int the text field",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void AddData(String fName, String lName, String food){
        boolean insertData = myDb.addData(fName,lName,food);
        if(insertData){
            Toast.makeText(MainActivity.this,"Data Inserted",Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(MainActivity.this,"Something went wrong",Toast.LENGTH_LONG).show();
        }
    }
}
