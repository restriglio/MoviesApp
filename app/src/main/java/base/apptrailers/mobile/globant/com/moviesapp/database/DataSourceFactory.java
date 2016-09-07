package base.apptrailers.mobile.globant.com.moviesapp.database;

import android.content.Context;

/**
 * Created by raul.striglio on 05/09/16.
 */
public class DataSourceFactory {
    public static IAccessData getDataSource(String type, Context context) throws Exception {
        switch(type){
            case "Database": return MoviesDataSource.getinstance(context);
            case "File": throw new Exception("Not implemented yet");
        }
        return null;
    }
}
