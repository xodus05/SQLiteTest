package com.example.sqlitetest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    myDBHelper myDBHelper;
    EditText edtName, edtNumber, edtNameResultm, edtNumberResult;
    Button btnInit, btnInsert, btnSelect;
    SQLiteDatabase sqlDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("구매 리스트 관리");

        edtName = (EditText) findViewById(R.id.edtName);
        edtNumber = (EditText) findViewById(R.id.edtNumber);
        edtNameResultm = (EditText) findViewById(R.id.edtNameResult);
        edtNumberResult = (EditText) findViewById(R.id.edtNumberResult);

        btnInit = (Button) findViewById(R.id.btnInit);
    }
}
class myDBHelper extends SQLiteOpenHelper {
    public myDBHelper(Context context) {
        super(context,"groupDB", null, 1);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE groupTBL ( gName CHAR(20) PRIMARY KEY, gNumber INTEGER);");
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS groupTBL");
        onCreate(db);
    }
}