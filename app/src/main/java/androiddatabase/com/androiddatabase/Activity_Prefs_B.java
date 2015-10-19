package androiddatabase.com.androiddatabase;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Activity_Prefs_B extends AppCompatActivity {

    private static final String DEFAULT_VAL = "N/A";
    EditText name, password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__b);
        name = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);

    }

    public void load(View view){
        SharedPreferences sharedPreferences = getSharedPreferences("MY_PREFS_FILE" , Context.MODE_PRIVATE);
        String name1 = sharedPreferences.getString("name", DEFAULT_VAL);
        String password1 = sharedPreferences.getString("password" , DEFAULT_VAL);
        if(name1 == DEFAULT_VAL || password1 == DEFAULT_VAL){
            Toast.makeText(this , "Prefs data file is empty" , Toast.LENGTH_LONG).show();
        }else{
            name.setText(name1);
            password.setText(password1);
        }
    }

    public void prev(View view){
        startActivity(new Intent(this , Activity_Prefs_A.class));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_activity__b, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
