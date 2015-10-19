package androiddatabase.com.androiddatabase;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Activity_ExternalAndCache_B extends AppCompatActivity {

    private EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__external_and_cache__b);
        editText = (EditText) findViewById(R.id.editText_a);
    }

    private String readData(File file){
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
            int read = -1;
            StringBuffer stringBuffer = new StringBuffer();

            while((read = fileInputStream.read()) != -1){
                    stringBuffer.append((char)read);
            }
            return stringBuffer.toString();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(fileInputStream != null){
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
    public void internalCache(View view){

        File folder = getCacheDir();
        File file = new File(folder , "data1.txt");
        String retrivedData = readData(file);
        if(retrivedData != null){
            editText.setText(retrivedData);
        }else{
            editText.setText("No data returned");
        }
        displayToast("Data retrived from "+ file.getAbsolutePath());
    }

    public void externalCache(View view){

        File folder = getExternalCacheDir();
        File file = new File(folder , "data2.txt");
        String retrivedData = readData(file);
        if(retrivedData != null){
            editText.setText(retrivedData);
        }else{
            editText.setText("No data returned");
        }
        displayToast("Data retrived from " + file.getAbsolutePath());    }

    public void externalPrivate(View view){

        File folder = getExternalFilesDir("Bpn");
        File file = new File(folder , "data3.txt");
        String retrivedData = readData(file);
        if(retrivedData != null){
            editText.setText(retrivedData);
        }else{
            editText.setText("No data returned");
        }
        displayToast("Data retrived from " + file.getAbsolutePath());    }

    public void externalPublic(View view){

        File folder = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        File file = new File(folder , "data4.txt");
        String retrivedData = readData(file);
        if(retrivedData != null){
            editText.setText(retrivedData);
        }else{
            editText.setText("No data returned");
        }
        displayToast("Data retrived from " + file.getAbsolutePath());    }

    public void next(View view){
        startActivity(new Intent(this , Activity_ExternalAndCache_A.class));
        Toast.makeText(this , "Back" , Toast.LENGTH_LONG).show();
    }

    private void displayToast(String message){
        Toast.makeText(this , message , Toast.LENGTH_LONG).show();
    }
}
