package ronin.bachtiar.btnsmart.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import java.util.HashMap;

import ronin.bachtiar.btnsmart.activity.ServiceLogin;

@SuppressLint("CommitPrefEdits")
public class SessionManager {
    SharedPreferences pref;
    SharedPreferences.Editor editor1, editor2;
    Context _context;
    int PRIVATE_MODE = 0;
    private static final String PREF_NAME = "Sesi";
    private static final String IS_LOGIN = "status";
    public static final String KEY_ID = "user_id";
    public static final String KEY_NAME = "name";
    public static final String KEY_PHONE = "phone";
    public static final String KEY_EMAIL = "email";
    public static final String KEY_IMG = "img";
    public static final String KEY_RBAC = "rbac";
    public static final String KEY_PASSWORD= "password";
    public static final String KEY_TOKEN = "token";
    public static final String KEY_CREATEDAT = "created_at";


    public SessionManager(Context context) {
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor1 = pref.edit();
    }

    public void createLoginSession(String userID) {
        editor1.putBoolean(IS_LOGIN, true);
        editor1.putString(KEY_ID, userID);
        editor1.commit();

    }

    public void UpdateLoginSession(String imgUser) {
        editor1.putBoolean(IS_LOGIN, true);
        editor1.putString(KEY_IMG, imgUser);
        editor1.commit();

    }

    /**
     * Create login session
     */
    public void createLoginSession(String userId, String name, String phone, String email, String img, String rbac, String password,
                                   String token, String createdAt) {
        editor1.putBoolean(IS_LOGIN, true);
        editor1.putString(KEY_ID, userId);
        editor1.putString(KEY_NAME, name);
        editor1.putString(KEY_PHONE, phone);
        editor1.putString(KEY_EMAIL, email);
        editor1.putString(KEY_IMG, img);
        editor1.putString(KEY_RBAC, rbac);
        editor1.putString(KEY_PASSWORD, password);
        editor1.putString(KEY_TOKEN, token);
        editor1.putString(KEY_CREATEDAT, createdAt);
        editor1.commit();
    }

    //public void feedSession(String roomId) {
      //  editor2.putString(KEY_FEEDROOMID, roomId);
    //}

    /**
     * Check login method wil check user login status
     * If false it will redirect user to login page
     * Else won't do anything
     */
    public void checkLogin() {
        if (!this.isLoggedIn()) {
            editor1.putBoolean(IS_LOGIN, false);
            Intent i = new Intent(_context, ServiceLogin.class);
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            _context.startActivity(i);
        }
    }

    /**
     * Get stored session data
     */
    public HashMap<String, String> getUserDetails() {
        HashMap<String, String> user = new HashMap<String, String>();
        user.put(KEY_ID, pref.getString(KEY_ID, null));
        user.put(KEY_NAME, pref.getString(KEY_NAME, null));
        user.put(KEY_PHONE, pref.getString(KEY_PHONE, null));
        user.put(KEY_EMAIL, pref.getString(KEY_EMAIL, null));
        user.put(KEY_IMG, pref.getString(KEY_IMG, null));
        user.put(KEY_RBAC, pref.getString(KEY_RBAC, null));
        user.put(KEY_PASSWORD, pref.getString(KEY_PASSWORD, null));
        user.put(KEY_TOKEN, pref.getString(KEY_TOKEN, null));
        user.put(KEY_CREATEDAT, pref.getString(KEY_CREATEDAT, null));

        return user;
    }

    /**
     * Clear session details
     */
    public void backtoNews() {
        editor2.clear();
        editor2.commit();
    }

    public void logoutUser() {
        editor1.clear();
        editor1.commit();
        Intent i = new Intent(_context, ServiceLogin.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        _context.startActivity(i);
    }

    public boolean isLoggedIn() {
        return pref.getBoolean(IS_LOGIN, false);
    }
}
