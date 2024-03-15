package rate.web.view.utils;

import android.content.Context;
import android.content.SharedPreferences;

import rate.web.view.R;


public class SharedPreference {

    SharedPreferences sharedPreferences;

    private final SharedPreferences.Editor editor;


    //string with name of SharedPreferences of isFirstRun
    public static final String IS_FIRST_RUN = "isFirstRun";

    //string with name of SharedPreferences of isDialogShowed
    public static final String IS_DIALOG_SHOWED = "isDialogShowed";

    //string with name of SharedPreferences of locationName
    public static final String TEXTFROMWEB = "textFromWeb";

    private Context context;


    public SharedPreference(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences(context.getString(R.string.app_name), Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    //add key with name 'isFirstRun' and value 'true' to SharedPreferences
    public void setFirstRun(boolean isFirstRun) {
        editor.putBoolean(IS_FIRST_RUN, isFirstRun);
        editor.commit();
//        editor.apply();

    }

    //add key with name 'isDialogShowed' and value 'true' to SharedPreferences
    public void setDialogShowed(boolean isDialogShowed) {
        editor.putBoolean(IS_DIALOG_SHOWED, isDialogShowed);
        editor.apply();
    }

    //add key with name 'locationName' and value 'locationName' to SharedPreferences
    public void setText(String locationName) {
        editor.putString(TEXTFROMWEB, locationName);
        editor.apply();
    }

    //get value of key with name 'isFirstRun' from SharedPreferences
    public boolean getFirstRun() {
        return sharedPreferences.getBoolean(IS_FIRST_RUN, true);
    }

    //get value of key with name 'isDialogShowed' from SharedPreferences
    public boolean getDialogShowed() {
        return sharedPreferences.getBoolean(IS_DIALOG_SHOWED, false);
    }

    //get value of key with name 'locationName' from SharedPreferences
    public String getText() {
        return sharedPreferences.getString(TEXTFROMWEB, "");
    }


}
