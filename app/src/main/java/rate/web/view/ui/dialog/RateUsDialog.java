package rate.web.view.ui.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;

import rate.web.view.databinding.RateUsDialogBinding;
import rate.web.view.utils.SharedPreference;


public class RateUsDialog extends Dialog {

    RateUsDialogBinding binding;

    Context context;

    SharedPreference sharedPreferences;


    public RateUsDialog(@NonNull Context context) {
        super(context);
        this.context = context;
        sharedPreferences = new SharedPreference(context);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = RateUsDialogBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dismiss();


            }
        });

        binding.btnRateUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sharedPreferences.setDialogShowed(true);

                dismiss();

                Uri uri = Uri.parse("https://play.google.com/store/apps/details?id=" + context.getPackageName());
                v.getContext().startActivity(new Intent(Intent.ACTION_VIEW, uri));
            }
        });

    }
}
