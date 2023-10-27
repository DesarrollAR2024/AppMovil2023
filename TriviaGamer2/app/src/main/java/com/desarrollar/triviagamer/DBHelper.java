package com.desarrollar.triviagamer;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {
    public static final String DBNAME = "Login.db";

    private static final int DB_VERSION = 10;
    private static final String TABLE_NAME = "users";
    private static final String ID_COL = "id";
    private static final String NAME_COL = "username";
    private static final String PASSWORD_COL = "password";
    private static final String SCORE_COL = "score";

    public DBHelper(Context context) {
        super(context, "Login.db", null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        String query="CREATE TABLE "+ TABLE_NAME +" ("+ ID_COL+" INTEGER PRIMARY KEY AUTOINCREMENT, "+NAME_COL+" TEXT,"+PASSWORD_COL+" TEXT,"+SCORE_COL+" INTEGER" + ")";

        MyDB.execSQL(query);
        fillUserTable(MyDB);
    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int i, int i1) {
        MyDB.execSQL("drop Table if exists users");
        onCreate(MyDB);
    }

    public void fillUserTable(SQLiteDatabase MyDB) {
        String[] names = new String[]{"aaa", "bbb", "ccc", "ddd", "eee"};
        String[] passwords = new String[]{"aaa", "bbb", "ccc", "ddd", "eee"};
        int[] scores = new int[]{1366213,564,6848,8494,321};

        for (int i = 0; i < 5; i++) {
            addUsers(MyDB, names[i], passwords[i], scores[i]);
        }

    }

    public void addUsers(SQLiteDatabase MyDB, String username, String password, int... score)
    {

        ContentValues values = new ContentValues();

        values.put(NAME_COL,username);
        values.put(PASSWORD_COL,password);
        values.put(SCORE_COL, score.length > 0 ? score[0] : 0 );

        MyDB.insert(TABLE_NAME,null,values);
    }

    public Boolean insertData(String username, String password) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(NAME_COL, username);
        contentValues.put(PASSWORD_COL, password);
        contentValues.put(SCORE_COL, 0);
        long result = MyDB.insert(TABLE_NAME, null, contentValues);
        if (result == -1) return false;
        else
            return true;
    }

    public Boolean checkusername(String username) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from users where username = ?", new String[]{username});
        if (cursor.getCount() > 0)
            return true;
        else
            return false;
    }

    public Boolean checkusernamepassword(String username, String password) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from users where username = ? and password = ?", new String[]{username, password});

        if (cursor.getCount() > 0)
            return true;
        else
            return false;
    }

    @SuppressLint("Range")
    public ArrayList<RankingUser> getRankingList() {
        ArrayList<RankingUser> rankingList = new ArrayList<>();

        SQLiteDatabase db = getReadableDatabase();

        Cursor cursor= db.rawQuery("select * from users order by score desc limit 100", null);

        while(cursor.moveToNext()){
            RankingUser user = new RankingUser();
            user.setName(cursor.getString(cursor.getColumnIndex(NAME_COL)));
            user.setScore(cursor.getInt(cursor.getColumnIndex(SCORE_COL)));
            rankingList.add(user);
        }

        cursor.close();
        return rankingList;
    }
}