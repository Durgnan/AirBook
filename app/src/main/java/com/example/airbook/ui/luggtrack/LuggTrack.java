package com.example.airbook.ui.luggtrack;

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
import com.example.airbook.ui.bookings.BookingsViewModel;

public class LuggTrack extends Fragment {

    private LuggTrackViewModel mViewModel;

    public static LuggTrack newInstance() {
        return new LuggTrack();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mViewModel = ViewModelProviders.of(this).get(LuggTrackViewModel.class);
        View root = inflater.inflate(R.layout.lugg_track_fragment,container,false);
        final TextView textView = root.findViewById(R.id.text_luggage);
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
        mViewModel = ViewModelProviders.of(this).get(LuggTrackViewModel.class);
        // TODO: Use the ViewModel
    }

}
