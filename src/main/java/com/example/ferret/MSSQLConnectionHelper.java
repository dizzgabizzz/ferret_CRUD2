package com.example.ferret;

import android.content.Context;
import android.os.StrictMode;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MSSQLConnectionHelper {


    public static final String TAG = "Connection Database";

    private static String mStringConnectionUrl;

    private static String mStringServerIpName = "NewFerret.mssql.somee.com";

    private static String mStringUserName = "tccFerret";

    private static String mStringPassword = "12345678";

    private static String mStringDatabase = "NewFerret";

    public static Connection getConnection(Context mContext) {

        Connection mConnection = null;

        try {
            StrictMode.ThreadPolicy mPolicy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy((mPolicy));

            Class.forName("net.sourceforge.jtds.jdbc.Driver");

            mStringConnectionUrl = "jdbc:jtds:sqlserver://" + mStringServerIpName +
                    ";databaseName=" + mStringDatabase +
                    ";user=" + mStringUserName +
                    ";password=" + mStringPassword + ";" ;


            mConnection = DriverManager.getConnection(mStringConnectionUrl);

            Log.i(TAG , "Connection Sucessful");


        } catch (ClassNotFoundException e) {
            String mMessage = "Class Not Found " + e.getMessage();
            Log.e(TAG , mMessage);
        } catch (SQLException e) {
            String mMessage = "Database Fail" + e.getMessage();
            Log.e(TAG , mMessage);
        } catch (Exception e) {
            String mMessage = "Failure Unknow " + e.getMessage();
            Log.e(TAG , mMessage);
        }

        return mConnection;


    }

}