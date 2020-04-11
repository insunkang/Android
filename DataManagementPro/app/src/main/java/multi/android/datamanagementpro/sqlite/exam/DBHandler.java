package multi.android.datamanagementpro.sqlite.exam;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;

import multi.android.datamanagementpro.sqlite.DBHelper;

public class DBHandler  {
    DBHelper dbHelper;
    SQLiteDatabase db;
    Context context;
    ListView list;

    public DBHandler(Context context) {
        this.context = context;
        dbHelper = new DBHelper(context);
        db = dbHelper.getWritableDatabase();
    }

    public void insert(String edtName, String edtPrice, String edtSu){
        ContentValues contentValues = new ContentValues();
        contentValues.put("name",edtName);
        contentValues.put("price",edtPrice);
        contentValues.put("su",edtSu);
        contentValues.put("totPrice",Integer.parseInt(edtPrice)*Integer.parseInt(edtSu));

        db.insert("product",null,contentValues);

    }
    public void delete(View v){
//        db.delete("product","name=?",new String[]{edtName.getText().toString()});
    }
    public ArrayList<String> listView(View v){
        String sql = "select * from member";
        Cursor cursor = db.query("product",null,null,
                null, null,null,null);
        ArrayList<String> ex = new ArrayList<String>();

        while (cursor.moveToNext()){
            int idx = cursor.getInt(0);
            String id = cursor.getString(1);
            String p = cursor.getString(2);
            String d = cursor.getString(3);
            int age = cursor.getInt(4);

            ex.add(Integer.toString(idx)+","+id+Integer.toString(age));


        }
        return ex;

    }
    public ArrayList<String> listView2(View v){
        String sql = "select * from member";
        Cursor cursor = db.query("product",null,null,
                null, null,null,null);
        ArrayList<String> ex = new ArrayList<String>();

        while (cursor.moveToNext()){
            int idx = cursor.getInt(0);
            String id = cursor.getString(1);
            String p = cursor.getString(2);
            String d = cursor.getString(3);
            int age = cursor.getInt(4);

            ex.add(id+"\n"+Integer.toString(age));


        }
        return ex;

    }
    public void update(View v){

    }


}
