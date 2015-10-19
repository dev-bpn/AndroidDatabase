package androiddatabase.com.androiddatabase;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Activity_ExternalAndCache_A extends AppCompatActivity {

    private EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__external_and_cache_a);
        editText = (EditText) findViewById(R.id.editText_a);
    }

    public void writeData(File file , String data){
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(data.getBytes());
            displayToast(data + " is successfully written  to "+ file.getAbsolutePath());
        } catch (FileNotFoundException e) {
            Log.i("FILE_ERROR" , "FileNotFoundException");
            e.printStackTrace();
        } catch (IOException e) {
            Log.i("FILE_ERROR" , "IOException");
            e.printStackTrace();
        }finally {
            try {
                if(fileOutputStream != null) {
                    fileOutputStream.close();
                }
            } catch (IOException e) {
                Log.i("FILE_ERROR" , "IOException");
                e.printStackTrace();
            }
        }
    }

    public void internalCache(View view){

        String data = editText.getText().toString();
        File folder = getCacheDir();
        File file = new File(folder , "data1.txt");
        writeData(file, data);

    }

    public void externalCache(View view){

        String data = editText.getText().toString();
        File folder = getExternalCacheDir();
        File file = new File(folder , "data2.txt");
        writeData(file, data);

    }

    public void externalPrivate(View view){

        String data = editText.getText().toString();
        File folder = getExternalFilesDir("Bpn");
        File file = new File(folder , "data3.txt");
        writeData(file, data);

    }

    public void externalPublic(View view){

        String data = editText.getText().toString();
        File folder = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        File file = new File(folder , "data4.txt");
        writeData(file, data);

    }

    public void next(View view){
        startActivity(new Intent(this , Activity_ExternalAndCache_B.class));
        Toast.makeText(this , "Next" , Toast.LENGTH_LONG).show();
    }

    private void displayToast(String message){
        Toast.makeText(this , message , Toast.LENGTH_LONG).show();
    }
}
