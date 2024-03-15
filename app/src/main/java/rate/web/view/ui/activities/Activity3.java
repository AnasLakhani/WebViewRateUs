package rate.web.view.ui.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import rate.web.view.R;
import rate.web.view.databinding.Activity1Binding;
import rate.web.view.databinding.Activity2Binding;
import rate.web.view.databinding.Activity3Binding;

public class Activity3 extends AppCompatActivity {

    Activity3Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = Activity3Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.toolbar.setTitle("All Popular Trip Packages 3");
    }
}