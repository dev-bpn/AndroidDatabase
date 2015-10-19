package androiddatabase.com.androiddatabase;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class Activity_FileStorage_B extends AppCompatActivity {

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


    }

    public void prev(View view){
        startActivity(new Intent(this, Activity_FileStorage_A.class));
    }
}
