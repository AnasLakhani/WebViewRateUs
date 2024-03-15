package rate.web.view.ui.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import rate.web.view.R;
import rate.web.view.databinding.Activity1Binding;

public class Activity1 extends AppCompatActivity {

    Activity1Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = Activity1Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.toolbar.setTitle("All Popular Trip Packages 1");
    }
}