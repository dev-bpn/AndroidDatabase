package androiddatabase.com.androiddatabase.SQLite;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Dell on 10/20/2015.
 */
public class SQLiteHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "my_database";
    private static final String TABLE_NAME = "my_table";
    private static final int DATABASE_VERSION = 1;
    private static final String UID = "_id";
    private static final String NAME = "Name";

    private static final String CREATE_TABLE= "CREATE TABLE "+TABLE_NAME+" ("+UID+" PRIMARY KEY AUTOINCREMENT , "+NAME+" Varchar(255));";
    private Context context;

    public SQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        // CREATE TABLE TABLE_NAME (_id PRIMARY KEY AUTOINCREMENT , Name Varchar(255));
        try {
            sqLiteDatabase.execSQL(CREATE_TABLE);
        } catch (SQLException e) {
            DisplayMessage.message(context , ""+e);
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
