package androiddatabase.com.androiddatabase;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class Activity_FileStorage_A extends AppCompatActivity {

    EditText name , password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);
        name = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
    }

    public void save(View view){


    }

    public void next(View view){
        Intent intent = new Intent(this , Activity_FileStorage_B.class);
        startActivity(intent);
    }
}
