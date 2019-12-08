package com.example.airbook.ui.bookings;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.airbook.R;
import com.example.airbook.ui.dashboard.DashboardViewModel;

public class Bookings extends Fragment {

    private BookingsViewModel mViewModel;

    public static Bookings newInstance() {
        return new Bookings();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mViewModel = ViewModelProviders.of(this).get(BookingsViewModel.class);
        View root = inflater.inflate(R.layout.bookings_fragment,container,false);
        final TextView textView = root.findViewById(R.id.text_bookings);
        mViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                textView.setText(s);
            }
        });
        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(BookingsViewModel.class);
        // TODO: Use the ViewModel
    }


}
