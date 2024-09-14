package vn.edu.usth.weather;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class WeatherAndForecastPagerAdapter extends FragmentPagerAdapter {

    private final String[] titles = new String[] { "Hà Nội", "Hồ Chí Minh", "Nam Định" };

    public WeatherAndForecastPagerAdapter(FragmentManager fm) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        // Return a new instance of WeatherAndForecastFragment
        return WeatherAndForecastFragment.newInstance();
    }

    @Override
    public int getCount() {
        // We want 3 fragments
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int page) {
        // returns a tab title corresponding to the specified page
        return titles[page];
    }
}
