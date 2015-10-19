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

public class Activity_Prefs_A extends AppCompatActivity {

    EditText name , password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);
        name = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
    }

    public void save(View view){
        SharedPreferences sharedPreferences = getSharedPreferences("MY_PREFS_FILE" , Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        if(name.getText().toString().isEmpty() || password.getText().toString().isEmpty()){
            Toast.makeText(this, "Fields are Empty", Toast.LENGTH_SHORT).show();
        }else{
            editor.putString("name" , name.getText().toString());
            editor.putString("password" , password.getText().toString());
            editor.commit();
            Toast.makeText(this, "Successfully Saved", Toast.LENGTH_SHORT).show();
        }
    }

    public void next(View view){
        Intent intent = new Intent(this , Activity_Prefs_B.class);
        startActivity(intent);
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

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
