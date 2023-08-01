package com.example.ferret;

public class User {

    //marcação
    public static final String TAG ="User Entity";

    //colunas
    private int mId;
    private String mFullName;
    private String mUserName;

    @Override
    public String toString() {
        return "User{" +
                "mId=" + mId +
                ", mFullName='" + mFullName + '\'' +
                ", mUserName='" + mUserName + '\'' +
                ", mPassword='" + mPassword + '\'' +
                ", mEmail='" + mEmail + '\'' +
                ", mCreateDate=" + mCreateDate +
                ", mApiKey='" + mApiKey + '\'' +
                ", mResetPasswordOtp='" + mResetPasswordOtp + '\'' +
                ", mResetPasswordCreatedAt=" + mResetPasswordCreatedAt +
                '}';
    }

    public User(String fullName, String userName, String password, String email, long createDate, String apiKey, String resetPasswordOtp, long resetPasswordCreatedAt) {
        mFullName = fullName;
        mUserName = userName;
        mPassword = password;
        mEmail = email;
        mCreateDate = createDate;
        mApiKey = apiKey;
        mResetPasswordOtp = resetPasswordOtp;
        mResetPasswordCreatedAt = resetPasswordCreatedAt;
    }

    public User(int id, String fullName, String userName, String password, String email, long createDate, String apiKey, String resetPasswordOtp, long resetPasswordCreatedAt) {
        mId = id;
        mFullName = fullName;
        mUserName = userName;
        mPassword = password;
        mEmail = email;
        mCreateDate = createDate;
        mApiKey = apiKey;
        mResetPasswordOtp = resetPasswordOtp;
        mResetPasswordCreatedAt = resetPasswordCreatedAt;
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public String getFullName() {
        return mFullName;
    }

    public void setFullName(String fullName) {
        mFullName = fullName;
    }

    public String getUserName() {
        return mUserName;
    }

    public void setUserName(String userName) {
        mUserName = userName;
    }

    public String getPassword() {
        return mPassword;
    }

    public void setPassword(String password) {
        mPassword = password;
    }

    public String getEmail() {
        return mEmail;
    }

    public void setEmail(String email) {
        mEmail = email;
    }

    public long getCreateDate() {
        return mCreateDate;
    }

    public void setCreateDate(long createDate) {
        mCreateDate = createDate;
    }

    public String getApiKey() {
        return mApiKey;
    }

    public void setApiKey(String apiKey) {
        mApiKey = apiKey;
    }

    public String getResetPasswordOtp() {
        return mResetPasswordOtp;
    }

    public void setResetPasswordOtp(String resetPasswordOtp) {
        mResetPasswordOtp = resetPasswordOtp;
    }

    public long getResetPasswordCreatedAt() {
        return mResetPasswordCreatedAt;
    }

    public void setResetPasswordCreatedAt(long resetPasswordCreatedAt) {
        mResetPasswordCreatedAt = resetPasswordCreatedAt;
    }

    private String mPassword;
    private String mEmail;
    private long mCreateDate;
    private String mApiKey;
    private String mResetPasswordOtp;
    private long mResetPasswordCreatedAt;




}