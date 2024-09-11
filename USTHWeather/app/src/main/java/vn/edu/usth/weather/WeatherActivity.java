package vn.edu.usth.weather;

import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import vn.edu.usth.weather.databinding.ActivityWeatherBinding;

public class WeatherActivity extends AppCompatActivity {

    private ActivityWeatherBinding binding;
    private static final String TAG = "WeatherActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Initialize ViewBinding
        binding = ActivityWeatherBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Set up ViewPager and TabLayout
        ViewPager viewPager = binding.viewPager;
        TabLayout tabLayout = binding.tabLayout;

        // Create the adapter and set it to the ViewPager
        WeatherAndForecastPagerAdapter adapter = new WeatherAndForecastPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);

        // Link the TabLayout with the ViewPager
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart() called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume() called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause() called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop() called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy() called");
    }
}
