package com.xdm.pureb;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.tabs.TabLayout;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);

        TabLayout tabLayout = findViewById(R.id.tab_layout);

        TabLayout.Tab homeTab = tabLayout.newTab();
        homeTab.setText("Home");
        tabLayout.addTab(homeTab);

        TabLayout.Tab categoriesTab = tabLayout.newTab();
        categoriesTab.setText("Categories");
        tabLayout.addTab(categoriesTab);

        TabLayout.Tab cartTab = tabLayout.newTab();
        cartTab.setText("Cart");
        tabLayout.addTab(cartTab);

        TabLayout.Tab profileTab = tabLayout.newTab();
        profileTab.setText("Profile");
        tabLayout.addTab(profileTab);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.home), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
