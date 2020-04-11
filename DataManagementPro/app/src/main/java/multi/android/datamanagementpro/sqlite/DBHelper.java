package multi.android.datamanagementpro.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

//데이터베이스가 업데이트 되거나
//DB를 처음 생성


public class DBHelper extends SQLiteOpenHelper {
    public static final int DB_VERSION = 1;
    public DBHelper(Context context) {
        super(context, "product.db", null, DB_VERSION);


    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table product("

                + "_id integer primary key autoincrement,"

                + "name text not null, "

                + "price integer not null, "

                + "su integer not null, "

                + "totPrice integer not null)";
        db.execSQL(sql);
        Log.d("dbtest","생성완료");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.d("dbtest","데이터베이스의 스키마가 변경되었습니다.oldVersion"
                +oldVersion+"==newVersion"+newVersion);
        switch (oldVersion){
            case 1:
                //1버전에 2버전으로 넘어갈때 처리해야 하는 일들을 구현
                Log.d("dbtest", "2버전으로 변경");
            case 2:
                //2버전에서 3버전으로 넘어갈때
            case 3:
                //3버전에서 4버전으로 넘어갈때
        }
    }
}
