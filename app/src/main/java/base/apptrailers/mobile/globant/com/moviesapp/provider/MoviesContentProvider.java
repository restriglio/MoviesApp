package base.apptrailers.mobile.globant.com.moviesapp.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.support.annotation.Nullable;

import base.apptrailers.mobile.globant.com.moviesapp.R;
import base.apptrailers.mobile.globant.com.moviesapp.database.DataSourceFactory;
import base.apptrailers.mobile.globant.com.moviesapp.database.IAccessData;
import base.apptrailers.mobile.globant.com.moviesapp.database.MoviesDataSource;
import base.apptrailers.mobile.globant.com.moviesapp.database.MyDatabaseHelper;

/**
 * Created by raul.striglio on 02/09/16.
 */
public class MoviesContentProvider extends ContentProvider {

    private IAccessData dataSource;

    public MoviesContentProvider() {
    }

    @Override
    public boolean onCreate() {
        try {
            this.dataSource = DataSourceFactory.getDataSource(getContext().getResources().getString(R.string.provider_selected), getContext());
            if (dataSource != null) {
                ((MoviesDataSource) this.dataSource).open();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Nullable
    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {

        SQLiteQueryBuilder queryBuilder = new SQLiteQueryBuilder();
        queryBuilder.setTables(MyDatabaseHelper.MOVIES_TABLE_NAME);

        final int match = MoviesContract.URI_MATCHER.match(uri);
        switch (match) {
            case MoviesContract.Movies.PATH_TOKEN:
                break;

            case MoviesContract.Movies.PATH_FOR_ID_TOKEN:
                queryBuilder.appendWhere(MoviesContract.Movies.Cols.COLUMN_ID + "=" + uri.getPathSegments().get(1));
                break;

            default:
                throw new IllegalArgumentException("Unknown URI " + uri);
        }

        Cursor cursor = queryBuilder.query(((MoviesDataSource) dataSource).getDatabase(), projection, selection,
                selectionArgs, null, null, sortOrder);
        cursor.setNotificationUri(getContext().getContentResolver(), uri);

        return cursor;
    }

    @Nullable
    @Override
    public String getType(Uri uri) {
        final int match = MoviesContract.URI_MATCHER.match(uri);
        switch (match) {
            case MoviesContract.Movies.PATH_TOKEN:
                return MoviesContract.Movies.CONTENT_TYPE_DIR;
            case MoviesContract.Movies.PATH_FOR_ID_TOKEN:
                return MoviesContract.Movies.CONTENT_ITEM_TYPE;
            default:
                throw new UnsupportedOperationException("URI " + uri + " is not supported.");
        }
    }

    @Nullable
    @Override
    public Uri insert(Uri uri, ContentValues contentValues) {

        int token = MoviesContract.URI_MATCHER.match(uri);
        switch (token) {
            case MoviesContract.Movies.PATH_TOKEN: {
                long rowID = dataSource.create(contentValues);
                getContext().getContentResolver().notifyChange(uri, null);
                return MoviesContract.Movies.CONTENT_URI.buildUpon().appendPath(String.valueOf(rowID)).build();
            }
            default: {
                throw new UnsupportedOperationException("URI: " + uri + " not supported.");
            }
        }
    }

    @Override
    public int delete(Uri uri, String s, String[] strings) {
        int token = MoviesContract.URI_MATCHER.match(uri);
        switch (token) {
            case MoviesContract.Movies.PATH_TOKEN: {
                return dataSource.delete(MyDatabaseHelper.MOVIES_TABLE_NAME,s,strings);
            }
            default: {
                throw new UnsupportedOperationException("URI: " + uri + " not supported.");
            }
        }
    }

    @Override
    public int update(Uri uri, ContentValues contentValues, String s, String[] strings) {
        int token = MoviesContract.URI_MATCHER.match(uri);
        switch (token) {
            case MoviesContract.Movies.PATH_TOKEN: {
                return dataSource.update(MyDatabaseHelper.MOVIES_TABLE_NAME, contentValues, s, strings);
            }
            default: {
                throw new UnsupportedOperationException("URI: " + uri + " not supported.");
            }
        }
    }
}
