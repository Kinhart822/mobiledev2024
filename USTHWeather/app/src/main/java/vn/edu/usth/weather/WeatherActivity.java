package vn.edu.usth.weather;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import vn.edu.usth.weather.databinding.ActivityWeatherBinding;

public class WeatherActivity extends AppCompatActivity {

    private ActivityWeatherBinding binding;
    private static final String TAG = "WeatherActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set locale to Vietnamese
        LocaleHelper.setLocale(this, "vi");

        // Initialize ViewBinding
        binding = ActivityWeatherBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Set up Toolbar
        Toolbar toolbar = binding.toolbar;
        setSupportActionBar(toolbar);

        // Set up ViewPager and TabLayout
        ViewPager viewPager = binding.viewPager;
        TabLayout tabLayout = binding.tabLayout;

        // Create the adapter and set it to the ViewPager
        WeatherAndForecastPagerAdapter adapter = new WeatherAndForecastPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);

        // Link the TabLayout with the ViewPager
        tabLayout.setupWithViewPager(viewPager);

        // Extract the MP3 file to external storage
        extractMP3ToExternalStorage();

        // Play the MP3 after extraction
        playMP3FromExternalStorage();
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

    private void extractMP3ToExternalStorage() {
        try {
            InputStream inputStream = getResources().openRawResource(R.raw.relaxing_audio);
            File outFile = new File(getExternalFilesDir(null), "relaxing_audio.mp3");

            FileOutputStream outputStream = new FileOutputStream(outFile);

            byte[] buffer = new byte[1024];
            int length;
            while ((length = inputStream.read(buffer)) > 0) {
                outputStream.write(buffer, 0, length);
            }

            outputStream.close();
            inputStream.close();
            Log.i(TAG, "MP3 extracted to: " + outFile.getAbsolutePath());
        } catch (IOException e) {
            Log.e(TAG, "Error extracting MP3", e);
        }
    }

    private void playMP3FromExternalStorage() {
        try {
            File mp3File = new File(getExternalFilesDir(null), "relaxing_audio.mp3");

            MediaPlayer mediaPlayer = new MediaPlayer();
            mediaPlayer.setDataSource(mp3File.getAbsolutePath());
            mediaPlayer.prepare();
            mediaPlayer.start();
            Log.i(TAG, "Playing MP3");
        } catch (IOException e) {
            Log.e(TAG, "Error playing MP3", e);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu options from the res/menu/menu_weather.xml
        getMenuInflater().inflate(R.menu.menu_weather, menu);
        return true;
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_refresh:
                    // Show a toast when the refresh action is clicked
    //         Toast.makeText(this, "Refreshing...", Toast.LENGTH_SHORT).show();

                    // Simulate a network request using a thread and handler
    //            simulateNetworkRequest();

                    // Execute the AsyncTask
                new SimulateNetworkTask().execute();
                return true;
            case R.id.action_settings:
                    // Start PrefActivity when the settings action is clicked
                Intent intent = new Intent(this, PrefActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

//    private void simulateNetworkRequest() {
//        // Handler to post results to the UI thread
//        final Handler handler = new Handler(Looper.getMainLooper()) {
//            @Override
//            public void handleMessage(Message msg) {
//                // This method is executed in the main thread
//                String content = msg.getData().getString("server_response");
//                Toast.makeText(WeatherActivity.this, content, Toast.LENGTH_SHORT).show();
//            }
//        };
//
//        // Worker thread to simulate network request
//        Thread t = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    // Wait for 5 seconds to simulate a long network access
//                    Thread.sleep(5000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//
//                // Simulate server response
//                Bundle bundle = new Bundle();
//                bundle.putString("server_response", "Data refreshed successfully!");
//
//                // Notify the main thread
//                Message msg = new Message();
//                msg.setData(bundle);
//                handler.sendMessage(msg);
//            }
//        });
//
//        // Start the thread
//        t.start();
//    }

    // Define the AsyncTask for network simulation
    private class SimulateNetworkTask extends AsyncTask<Void, Void, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Toast.makeText(WeatherActivity.this, "Starting refresh...", Toast.LENGTH_SHORT).show();
        }

        @Override
        protected String doInBackground(Void... voids) {
            try {
                // Simulate network delay
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Data refreshed successfully!";
        }

        @Override
        protected void onPostExecute(String result) {
            Toast.makeText(WeatherActivity.this, result, Toast.LENGTH_SHORT).show();
        }
    }

}
