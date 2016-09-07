package base.apptrailers.mobile.globant.com.moviesapp.provider;

import android.content.UriMatcher;
import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Created by raul.striglio on 05/09/16.
 */
public class MoviesContract {
    public static final String AUTHORITY = "mobile.globant.contentprovider";
    private static final Uri BASE_URI = Uri.parse("content://" + AUTHORITY);
    public static final UriMatcher URI_MATCHER = buildUriMatcher();


    private MoviesContract(){};

    private static  UriMatcher buildUriMatcher() {
        final UriMatcher matcher = new UriMatcher(UriMatcher.NO_MATCH);
        final String authority = AUTHORITY;

        matcher.addURI(authority, Movies.PATH, Movies.PATH_TOKEN);
        matcher.addURI(authority, Movies.PATH_FOR_ID, Movies.PATH_FOR_ID_TOKEN);

        return matcher;
    }

    public static class Movies {
        public static final String NAME = "movie";
        public static final String PATH = "movies";
        public static final int PATH_TOKEN = 1;
        public static final String PATH_FOR_ID = "movies/#";
        public static final int PATH_FOR_ID_TOKEN = 2;

        public static final Uri CONTENT_URI = BASE_URI.buildUpon().appendPath(PATH).build();

        public static final String CONTENT_TYPE_DIR = "vnd.android.cursor.dir/vnd.movie.app";
        public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/vnd.movie.app";

        public static class Cols {
            public static final String COLUMN_ID = BaseColumns._ID; // convention
            public static final String COLUMN_NAME = "name";
            public static final String COLUMN_YEAR = "year";
            public static final String COLUMN_DIRECTOR = "director";
            public static final String COLUMN_GENDER = "gender";
        }

    }
}