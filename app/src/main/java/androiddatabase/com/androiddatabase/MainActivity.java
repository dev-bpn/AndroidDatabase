package androiddatabase.com.androiddatabase;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import androiddatabase.com.androiddatabase.SQLite.DisplayMessage;
import androiddatabase.com.androiddatabase.SQLite.MyDatabaseAdapter;

public class MainActivity extends AppCompatActivity {

    private EditText username , password , name_specific;
    MyDatabaseAdapter helper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        name_specific = (EditText) findViewById(R.id.username_specific);

        helper = new MyDatabaseAdapter(this);

    }

    public void addUser(View view){

        String user = username.getText().toString();
        String pass = password.getText().toString();

        long id = helper.insertData(user , pass);
        if(id < 0){
            DisplayMessage.message(this , "No data inserted");
        }else{
            DisplayMessage.message(this , "Data inserted Successfully");
        }

    }

    public void viewAll(View view){
        String data = helper.getAllData();
        if(data != null){
            DisplayMessage.message(this , data);
        }else{
            DisplayMessage.message(this , "Null");
        }

    }

    public void getSpecificDetail(View view){
        String data = name_specific.getText().toString();
        String name = data.substring(0 , data.indexOf(" "));
        String pass = data.substring(data.indexOf(" ")+1);
        String specific_data = helper.getSpecificData(name, pass);
        if(specific_data != null){
            DisplayMessage.message(this , specific_data);
        }else{
            DisplayMessage.message(this , "Null");
        }

    }

    public void update(View view){
        helper.updateData("bipin" , "deepen");
        DisplayMessage.message(this , "Successfully updated..");
    }

    public void delete(View view){

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.action_prefs) {
            startActivity(new Intent(this , Activity_Prefs_A.class));
        }else if(id == R.id.action_file_storage){
            startActivity(new Intent(this , Activity_FileStorage_A.class));
        }else if(id == R.id.action_file_external_storage){
            startActivity(new Intent(this , Activity_ExternalAndCache_A.class));
        }

        return super.onOptionsItemSelected(item);
    }
}
