package com.example.hesu.db;

import android.database.sqlite.SQLiteDatabase;
import android.content.Context;
import com.example.hesu.bean.City;
import java.util.List;
import java.util.ArrayList;
import android.database.Cursor;


/**
 * Created by hesu on 16/11/30.
 */

public class CityDB {
    public static final String CITY_DB_NAME = "city.db";
    private static final String CITY_TABLE_NAME = "city";
    private SQLiteDatabase db;
    public CityDB(Context context, String path) {
        db = context.openOrCreateDatabase(path, Context.MODE_PRIVATE, null);
    }
    public List<City> getAllCity() {
        List<City> list = new ArrayList<City>();
        Cursor c = db.rawQuery("SELECT * from " + CITY_TABLE_NAME, null);
        while (c.moveToNext()) {
            String province = c.getString(c.getColumnIndex("province"));
                    String city = c.getString(c.getColumnIndex("city"));
            String number = c.getString(c.getColumnIndex("number"));
                    String allPY = c.getString(c.getColumnIndex("allpy"));
            String allFirstPY = c.getString(c.getColumnIndex("allfirstpy"));
                    String firstPY = c.getString(c.getColumnIndex("firstpy"));
                            City item = new City(province, city, number, firstPY, allPY,allFirstPY);
            list.add(item);
        }
        return list;
    }
}
