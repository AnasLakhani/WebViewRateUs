package rate.web.view;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

import rate.web.view.databinding.ActivityMainBinding;
import rate.web.view.ui.activities.Activity1;
import rate.web.view.ui.activities.Activity2;
import rate.web.view.ui.activities.Activity3;
import rate.web.view.utils.Utilities;

public class WebViewActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Utilities.showDialog(this);


        // Enable the display of the home button as an up button
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        DrawerLayout drawer = findViewById(R.id.drawerLayout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, binding.toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        WebSettings settings = binding.webview.getSettings();

        settings.setJavaScriptEnabled(true);
        settings.getDomStorageEnabled();
        binding.webview.loadUrl("https://lottovip.gb.net/22316/");
        binding.webview.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
//                view.loadUrl(url);
                openInExternalBrowser(url);
                return true;
            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);

                Log.d("TAG", "onPageStarted: " + url);

            }


        });


//        binding.link.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                openInExternalBrowser("https://www.google.com");
//
//            }
//        });


        NavigationView navigationView = findViewById(R.id.navigationView);


        // Set item click listener
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                // Handle navigation item clicks here

                if (item.getItemId() == R.id.menu_item_1) {
                    startActivity(new Intent(WebViewActivity.this, Activity1.class));
                }

                if (item.getItemId() == R.id.menu_item_2) {
                    startActivity(new Intent(WebViewActivity.this, Activity2.class));
                }

                if (item.getItemId() == R.id.menu_item_3) {
                    startActivity(new Intent(WebViewActivity.this, Activity3.class));
                }


                // Close the drawer after item selection
                drawer.closeDrawer(GravityCompat.START);


                // Return true to indicate that the item selection is handled
                return true;
            }
        });
    }

    private void openInExternalBrowser(String url) {
        // Create an intent with ACTION_VIEW and the URL
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));

        // Check if there's any app that can handle the intent
//        if (intent.resolveActivity(getPackageManager()) != null) {
        // Open the URL in the default browser
        startActivity(intent);
//        } else {
//            // Handle case where no app can handle the intent
//            // For example, display an error message to the user
//        }
    }
}
