package multi.android.datamanagementpro.sqlite.exam;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import multi.android.datamanagementpro.R;
import multi.android.datamanagementpro.sqlite.DBHelper;


public class MainActivity extends
		AppCompatActivity implements AdapterView.OnItemClickListener,OnClickListener {
	DBHandler dbHandler;
	EditText edtName;
	EditText edtSu;
	EditText edtPrice;
	ListView listview;
	SQLiteDatabase db;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		dbHandler = new DBHandler(this);

		findViewById(R.id.btnIns).setOnClickListener(this);
		findViewById(R.id.btnResult).setOnClickListener(this);
		findViewById(R.id.btnResult2).setOnClickListener(this);
		findViewById(R.id.btnSearch).setOnClickListener(this);
		listview = findViewById(R.id.list);
		listview.setOnItemClickListener(this);

		edtName = (EditText)findViewById(R.id.edtName);
		edtSu = (EditText)findViewById(R.id.edtSu);
		edtPrice = (EditText)findViewById(R.id.edtPrice);

	}


	@Override
	public void onClick(View v) {
		if (v.getId()==R.id.btnIns){
			dbHandler.insert(edtName.getText().toString(),
					edtSu.getText().toString(),
					edtPrice.getText().toString());


		}else if(v.getId()==R.id.btnResult){

			ListView list = findViewById(R.id.list);
			ArrayList<String> asd = dbHandler.listView(v);
			ArrayAdapter arrayAdapter = new ArrayAdapter(MainActivity.this,android.R.layout.simple_list_item_1,asd);
			list.setAdapter(arrayAdapter);

		}else if(v.getId()==R.id.btnResult2){
			ListView list = findViewById(R.id.list);
			ArrayList<String> asd = dbHandler.listView2(v);
			ArrayAdapter arrayAdapter = new ArrayAdapter(MainActivity.this,android.R.layout.simple_list_item_1,asd);
			list.setAdapter(arrayAdapter);
		}
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

	}
}



















