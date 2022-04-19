package com.example.testsmartcityapplication.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.testsmartcityapplication.R;
import com.example.testsmartcityapplication.databinding.FragmentDashboardBinding;

public class DashboardFragment extends Fragment {


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dashboard, container, false);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}