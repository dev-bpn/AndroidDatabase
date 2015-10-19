package androiddatabase.com.androiddatabase;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

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

        String username = name.getText().toString();
        String pass = password.getText().toString();

        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = openFileOutput("FILE_NAME.txt" , Context.MODE_PRIVATE);
            fileOutputStream.write(username.getBytes());
            fileOutputStream.write(pass.getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public void next(View view){
        Intent intent = new Intent(this , Activity_FileStorage_B.class);
        startActivity(intent);
    }
}
