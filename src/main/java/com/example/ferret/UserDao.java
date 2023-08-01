package com.example.ferret;

import android.content.Context;
import android.util.Log;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDao {

    public static final String TAG = "CRUD User";

    public static int insertUser(User mUser , Context mContext) {

        int vResponse = 0;
        String mSql;
        try{

            mSql = "INSERT INTO users (fullName, username, password, email, createdate, apikey, reset_password_otp , reset_password_created_at) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement mPreparedStatement = MSSQLConnectionHelper.getConnection(mContext).prepareStatement(mSql);

            mPreparedStatement.setString(1,mUser.getFullName());
            mPreparedStatement.setString(2,mUser.getUserName());
            mPreparedStatement.setString(3,mUser.getPassword());
            mPreparedStatement.setString(4,mUser.getEmail());
            mPreparedStatement.setLong(5,mUser.getCreateDate());
            mPreparedStatement.setString(6,mUser.getApiKey());
            mPreparedStatement.setString(7,mUser.getResetPasswordOtp());
            mPreparedStatement.setLong(8,mUser.getResetPasswordCreatedAt());

            vResponse = mPreparedStatement.executeUpdate();



        } catch (Exception e){
            Log.e(TAG , e.getMessage());
        }

        return vResponse;
    }

    public  static int updateUser(User mUser , Context mContext) {

        int vResponse = 0;
        String mSql;

        try{
            mSql = "UPDATE users SET fullname=?, username=?, password=?, email=?, createdate=?, apikey=?, reset_password_otp=?, reset_password_created_at=? WHERE id=?";
            PreparedStatement mPreparedStatement = MSSQLConnectionHelper.getConnection(mContext).prepareStatement(mSql);

            mPreparedStatement.setString(1,mUser.getFullName());
            mPreparedStatement.setString(2,mUser.getUserName());
            mPreparedStatement.setString(3,mUser.getPassword());
            mPreparedStatement.setString(4,mUser.getEmail());
            mPreparedStatement.setLong(5,mUser.getCreateDate());
            mPreparedStatement.setString(6,mUser.getApiKey());
            mPreparedStatement.setString(7,mUser.getResetPasswordOtp());
            mPreparedStatement.setLong(8,mUser.getResetPasswordCreatedAt());
            mPreparedStatement.setInt(9,mUser.getId());


        } catch (Exception e){
            Log.e(TAG , e.getMessage());}

        return vResponse;

    }

    public  static int deleteUser(User mUser , Context mContext) {

        int vResponse = 0;
        String mSql;

        try{
            mSql = "DELETE FROM users WHERE id=?";
            PreparedStatement mPreparedStatement = MSSQLConnectionHelper.getConnection(mContext).prepareStatement(mSql);


            mPreparedStatement.setInt(1,mUser.getId());

            vResponse = mPreparedStatement.executeUpdate();


        } catch (Exception e){
            Log.e(TAG , e.getMessage());}

        return vResponse;

    }

    public  static int deleteAllUser(Context mContext) {

        int vResponse = 0;
        String mSql;

        try{
            mSql = "DELETE FROM users ";
            PreparedStatement mPreparedStatement = MSSQLConnectionHelper.getConnection(mContext).prepareStatement(mSql);

            vResponse = mPreparedStatement.executeUpdate();


        } catch (Exception e){
            Log.e(TAG , e.getMessage());}

        return vResponse;

    }

    public static List<User> listAllUser(Context mContext){
        List<User> mUserList = null;
        String mSql;
        try {
            mSql = "SELECT id, fullName, username, password, email, createdate, apikey, reset_password_otp , reset_password_created_at FROM users ORDER BY name ASC";
            PreparedStatement mPreparedStatement = MSSQLConnectionHelper.getConnection(mContext).prepareStatement(mSql);
            ResultSet mResultSet = mPreparedStatement.executeQuery();
            mUserList = new ArrayList<User>();
            while (mResultSet.next()) {
                mUserList.add(new User(
                        mResultSet.getInt(1),
                        mResultSet.getString(2),
                        mResultSet.getString(3),
                        mResultSet.getString(4),
                        mResultSet.getString(5),
                        mResultSet.getLong(6),
                        mResultSet.getString(7),
                        mResultSet.getString(8),
                        mResultSet.getLong(9)

                ));
            }
        }catch (Exception e){
            Log.e(TAG , e.getMessage());
        }
        return mUserList;
    }

    public static List<User> searchUsersByName(String mName , Context mContext){
        List<User> mUserList = null;
        String mSql;
        try {
            mSql = "SELECT id, fullName, username, password, email, createdate, apikey, reset_password_otp , reset_password_created_at FROM users WHERE fullname LIKE '%" + mName + " ORDER BY fullname ASC";
            PreparedStatement mPreparedStatement = MSSQLConnectionHelper.getConnection(mContext).prepareStatement(mSql);
            ResultSet mResultSet = mPreparedStatement.executeQuery();
            mUserList = new ArrayList<User>();
            while (mResultSet.next()) {
                mUserList.add(new User(
                        mResultSet.getInt(1),
                        mResultSet.getString(2),
                        mResultSet.getString(3),
                        mResultSet.getString(4),
                        mResultSet.getString(5),
                        mResultSet.getLong(6),
                        mResultSet.getString(7),
                        mResultSet.getString(8),
                        mResultSet.getLong(9)

                ));
            }
        }catch (Exception e){
            Log.e(TAG , e.getMessage());
        }
        return mUserList;
    }


    public static String authenticateUser(User mUser , Context mContext ){
        String mResponse = "";
        String mSql = "SELECT id, fullname, email, password FROM users WHERE password LIKE ? AND email LIKE";
        try{
            PreparedStatement mPreparedStatement = MSSQLConnectionHelper.getConnection(mContext).prepareStatement(mSql);
            mPreparedStatement.setString(1, mUser.getPassword());
            mPreparedStatement.setString(2, mUser.getEmail());
            ResultSet mResultSet = mPreparedStatement.executeQuery();
            while (mResultSet.next()){
                mResponse = mResultSet.getString(2);
                //mResponse = mResultSet.getString("fullname");
            }

        } catch (Exception e){
            mResponse = "Exception";
            Log.e(TAG , e.getMessage());
            e.printStackTrace();
        }
        return mResponse;
    }



}