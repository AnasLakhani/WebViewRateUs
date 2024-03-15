package rate.web.view.utils;

import android.content.Context;

import rate.web.view.ui.dialog.RateUsDialog;


public class Utilities {

    public static void showDialog(Context context) {

        SharedPreference sharedPreference = new SharedPreference(context);

        boolean isFirstRun = sharedPreference.getFirstRun();

        if (isFirstRun) {
            sharedPreference.setFirstRun(false);
        } else {

            boolean isDialogShowed = sharedPreference.getDialogShowed();

            if (isDialogShowed) {
                return;
            }

            //show dialog with custom

            RateUsDialog customDialog = new RateUsDialog(context);
            customDialog.show();

        }

    }

    public static void setClipboard(Context context, String text) {
        if (android.os.Build.VERSION.SDK_INT < android.os.Build.VERSION_CODES.HONEYCOMB) {
            android.text.ClipboardManager clipboard = (android.text.ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
            clipboard.setText(text);
        } else {
            android.content.ClipboardManager clipboard = (android.content.ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
            android.content.ClipData clip = android.content.ClipData.newPlainText("Copied Text", text);
            clipboard.setPrimaryClip(clip);
        }
    }
}
