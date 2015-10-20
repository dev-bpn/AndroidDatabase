package androiddatabase.com.androiddatabase.SQLite;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by Dell on 10/20/2015.
 */
public class DisplayMessage {
    public static void message(Context context , String message){
        Toast.makeText(context , message , Toast.LENGTH_LONG).show();
    }
}
