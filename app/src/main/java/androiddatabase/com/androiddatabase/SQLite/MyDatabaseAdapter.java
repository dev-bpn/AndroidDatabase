package androiddatabase.com.androiddatabase.SQLite;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Dell on 10/20/2015.
 */
public class MyDatabaseAdapter {

    MySQLiteHelper helper;

    public MyDatabaseAdapter(Context context){
        helper = new MySQLiteHelper(context);
    }
    public void insertData(String username , String password){



    }

    static class MySQLiteHelper extends SQLiteOpenHelper{
        private static final String DATABASE_NAME = "my_database";
        private static final String TABLE_NAME = "my_table";
        private static final int DATABASE_VERSION = 6;
        private static final String UID = "_id";
        private static final String NAME = "Name";
        private static final String PASSWORD = "Password";
        private Context context;

        private static final String CREATE_TABLE= "CREATE TABLE "+TABLE_NAME+" ("+UID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+NAME+" VARCHAR(255) , "+PASSWORD+" VARCHAR(255));";
        private static final String DROP_TABLE = "DROP TABLE IF EXISTS "+ TABLE_NAME;

        public MySQLiteHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
            this.context = context;
            DisplayMessage.message(context , "Constructor is called");
        }

        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {
            // CREATE TABLE TABLE_NAME (_id PRIMARY KEY AUTOINCREMENT , Name Varchar(255));
            try {
                DisplayMessage.message(context , "onCreate is called");
                sqLiteDatabase.execSQL(CREATE_TABLE);
            } catch (SQLException e) {
                DisplayMessage.message(context , "EXCEPTION: "+e);
                e.printStackTrace();
            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
            try {
                DisplayMessage.message(context , "onUpgrade is called");
                sqLiteDatabase.execSQL(DROP_TABLE);
                onCreate(sqLiteDatabase);
            } catch (SQLException e) {
                DisplayMessage.message(context , "EXCEPTION: "+e);
                e.printStackTrace();
            }
        }
    }
}
