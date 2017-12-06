package com.quitz.test.db;


import java.io.File;
import java.util.ArrayList;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class SQLiteHelper {
public static ArrayList<String[]> DATA = new ArrayList<String[]>();
private static final String DATABASE_NAME = "friendmapper.db";
private static final int DATABASE_VERSION = 1;
private static final String STUDENT_TABLE = "friend";
private Context context;
private SQLiteDatabase db = null;
OpenHelper openHelper;

public SQLiteHelper(Context context) {
this.context = context;

if (db != null)
if (db.isOpen())
db.close();

openHelper = new OpenHelper(this.context);
this.db = openHelper.getWritableDatabase();
}

public void close() {
if (openHelper != null) {
openHelper.close();
}
}

public int insertData(String name, String address, String contact) {
int entryId = 0;
ContentValues values = new ContentValues();
values.put("name", name);
values.put("address", address);
values.put("contact", contact);
entryId = (int) this.db.insert(STUDENT_TABLE, null, values);
return entryId;
}

public ArrayList<String[]> selectdatabase(String search) {
Cursor c = null;
DATA.clear();
String[] columns = new String[] { "seat" };
c = db.query(STUDENT_TABLE, columns,
"travels=", new String[] { search,
search, search }, null, null, "id DESC");
if (c.moveToFirst()) {
do {
if (c.getColumnCount() == 4) {
String[] str = new String[3];
str[0] = c.getString(1);
str[1] = c.getString(2);
str[2] = c.getString(3);
DATA.add(str);
}
} while (c.moveToNext());
}

if (c != null && !c.isClosed()) {
c.close();
}
return DATA;
}
public void cr(String k,String k1)
{
	ContentValues values=new ContentValues();
	values.put("seat",k);
	

	int id=db.update(STUDENT_TABLE,values,"tarvels=?",new String[]{k1});

}
public String loginData(String h) {
	// TODO Auto-generated method stub
	Cursor c1 = null;
	DATA.clear();
	String[] columns = new String[] { "seat" };

	c1 = db.query(STUDENT_TABLE, columns,"tarvels=? ", new String[] {h}, null,null,null);
	if (c1.moveToNext()) {

String n=c1.getString(0);
	return n;
	}
	else
	{
	return "fail";
	}
	}


public ArrayList<String[]> selectalldatabase() {
Cursor c = null;
DATA.clear();
String[] columns = new String[] {"tarvels", "seat" };
c = db.query(STUDENT_TABLE, columns, null, null, null, null, "tarvels DESC");
if (c.moveToFirst()) {
do {
if (c.getColumnCount() == 2) {
String[] str = new String[2];
str[0] = c.getString(1);
str[1] = c.getString(2);

DATA.add(str);
}
} while (c.moveToNext());
}

if (c != null && !c.isClosed()) {
c.close();
}

return DATA;
}









static class OpenHelper extends SQLiteOpenHelper {

OpenHelper(Context context) {
super(context, DATABASE_NAME, null, DATABASE_VERSION);
}

@Override
public void onCreate(SQLiteDatabase db) {

db.execSQL("CREATE TABLE " + STUDENT_TABLE + "("
		 + "tarvels TEXT, "
		 + " seat TEXT)");

String Insert_Data="INSERT INTO friend VALUES('BANGALORE TRAVELS','12345678')";
String Insert_Data1="INSERT INTO friend VALUES('TRICHY TRAVELS','12345678')";
String Insert_Data2="INSERT INTO friend VALUES('MADURAI TRAVELS','12345678')";
String Insert_Data3="INSERT INTO friend VALUES('COIMBATORE TRAVELS','12345678')";
String Insert_Data4="INSERT INTO friend VALUES('SALEM TRAVELS','12345678')";
db.execSQL(Insert_Data);
db.execSQL(Insert_Data1);
db.execSQL(Insert_Data2);
db.execSQL(Insert_Data3);
db.execSQL(Insert_Data4);


}

@Override
public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
Log.w("Catch DB",
"Upgrading database, this will drop tables and recreate.");
db.execSQL("DROP TABLE IF EXISTS " + STUDENT_TABLE);
onCreate(db);
}
}



public SQLiteDatabase getWritableDatabase() {
	// TODO Auto-generated method stub
	return null;
}

}
