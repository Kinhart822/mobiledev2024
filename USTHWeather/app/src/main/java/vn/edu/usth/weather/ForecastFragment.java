package vn.edu.usth.weather;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ForecastFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ForecastFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ForecastFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ForecastFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ForecastFragment newInstance(String param1, String param2) {
        ForecastFragment fragment = new ForecastFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Practical 3
//        // Inflate the layout for this fragment
//        View view = inflater.inflate(R.layout.fragment_forecast, container, false);
//
//        // Bạn có thể thay đổi màu ở đây
//        view.setBackgroundColor(0x20FF0000); // Red
//
//        return view;

        // Practical 4
//        // Create a new LinearLayout
//        LinearLayout layout = new LinearLayout(getActivity());
//        layout.setOrientation(LinearLayout.VERTICAL);
//
//        // Create a new TextView
//        TextView dayTextView = new TextView(getActivity());
//        dayTextView.setText("Thursday");
//        dayTextView.setTextColor(Color.BLACK);
//        dayTextView.setTextSize(24);
//        dayTextView.setPadding(16, 100, 16, 16);
//
//        // Create a new ImageView
//        ImageView weatherImageView = new ImageView(getActivity());
//        weatherImageView.setImageResource(R.drawable.cloudy);
//        weatherImageView.setPadding(16, 16, 16, 16);
//
//        // Add TextView and ImageView to LinearLayout
//        layout.addView(dayTextView);
//        layout.addView(weatherImageView);
//
//        // Set layout parameters for LinearLayout
//        layout.setLayoutParams(new ViewGroup.LayoutParams(
//                ViewGroup.LayoutParams.MATCH_PARENT,
//                ViewGroup.LayoutParams.WRAP_CONTENT));
//
//        // Return the layout as the view for this fragment
//        return layout;

        // Practical 5
        View view = inflater.inflate(R.layout.fragment_forecast, container, false);

        view.setBackgroundColor(Color.parseColor("#E3D7F7"));

        return view;
    }
}