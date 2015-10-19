package androiddatabase.com.androiddatabase;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class Activity_ExternalAndCache_A extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__external_and_cache_a);
    }

    public void internalCache(View view){

        Toast.makeText(this , "Save in InternalCache" , Toast.LENGTH_LONG).show();
    }

    public void externalCache(View view){

        Toast.makeText(this , "Save in externalCache" , Toast.LENGTH_LONG).show();
    }

    public void externalPrivate(View view){

        Toast.makeText(this , "Save in externalPrivate" , Toast.LENGTH_LONG).show();
    }

    public void externalPublic(View view){

        Toast.makeText(this , "Save in externalPublic" , Toast.LENGTH_LONG).show();
    }

    public void next(View view){
        startActivity(new Intent(this , Activity_ExternalAndCache_B.class));
        Toast.makeText(this , "Next" , Toast.LENGTH_LONG).show();
    }
}
