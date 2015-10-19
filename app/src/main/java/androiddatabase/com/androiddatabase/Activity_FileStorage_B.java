package androiddatabase.com.androiddatabase;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

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

        FileInputStream fileInputStream = null;
        try {
            fileInputStream = openFileInput("FILE_NAME.txt");

            int read = -1;
            StringBuffer stringBuffer = new StringBuffer();

            while((read = fileInputStream.read()) != -1){
                stringBuffer.append((char)read);
            }

            String text1 = stringBuffer.substring(0 , stringBuffer.indexOf(" "));
            String text2 = stringBuffer.substring(stringBuffer.indexOf(" "));

            name.setText(text1);
            password.setText(text2);

        } catch (FileNotFoundException e) {
            Log.i("ERRORR" , "FileNotFoundException");
            e.printStackTrace();
        } catch (IOException e) {
            Log.i("ERRORR" , "IOException");
            e.printStackTrace();
        }finally {
            try {
                if(fileInputStream != null){
                    fileInputStream.close();
                }
            } catch (IOException e) {
                Log.i("ERRORR" , "IOException");
                e.printStackTrace();
            }
        }
        Toast.makeText(this , "Load data Successfully" , Toast.LENGTH_LONG).show();
    }

    public void prev(View view){
        startActivity(new Intent(this, Activity_FileStorage_A.class));
    }
}
