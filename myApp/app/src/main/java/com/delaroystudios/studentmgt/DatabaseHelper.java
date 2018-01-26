package com.delaroystudios.studentmgt;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String TABLE_NAME = "student";
    private static final String COL_1 = "ID";
    private static final String COL_2 = "roll_no";
    private static final String COL_3 = "name";
    private static final String COL_4 = "marks";


    public DatabaseHelper(Context context) {
        super(context, TABLE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        String create_table = "Create table " + TABLE_NAME + " ( "
                + COL_1 + " INTEGER PRIMARY KEY AUTO_INCREMENT,"
                + COL_2 + " TEXT, " + COL_3 + " TEXT, "
                + COL_4 + " TEXT);";
        db.execSQL(create_table);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("Drop table if exists " + TABLE_NAME);
        onCreate(db);
    }

    public boolean add(String roll_no, String name, String marks)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentVal= new ContentValues();

        contentVal.put(COL_2,roll_no);
        contentVal.put(COL_3,name);
        contentVal.put(COL_4,marks);

        Log.d(Globals.LOG_TAG,"Success,Record added successfully");

        long result=db.insert(TABLE_NAME,null,contentVal);

        if (result != -1)
            return true;
        return false;
    }


}
