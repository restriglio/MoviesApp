package base.apptrailers.mobile.globant.com.moviesapp.dataresources;

import android.content.ContentValues;
import android.database.Cursor;

/**
 * Created by raul.striglio on 02/09/16.
 */
public interface IAccessData {
    Cursor query(String[] projection, String where, String[] whereValue);
    long create(ContentValues values);
    int update(String table, ContentValues values, String whereClause, String[] whereArgs);
    int delete(String table, String whereClause, String[] whereArgs);
}
