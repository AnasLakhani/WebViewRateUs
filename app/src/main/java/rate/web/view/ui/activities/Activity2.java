package rate.web.view.ui.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import rate.web.view.databinding.Activity2Binding;

public class Activity2 extends AppCompatActivity {

    Activity2Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = Activity2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.toolbar.setTitle("All Popular Trip Packages 2");
    }
}