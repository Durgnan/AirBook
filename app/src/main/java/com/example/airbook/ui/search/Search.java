package com.example.airbook.ui.search;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.airbook.R;
import com.example.airbook.SearchFlightsActivity;
import com.example.airbook.ui.bookings.BookingsViewModel;

public class Search extends Fragment {

    private SearchViewModel mViewModel;
     EditText source,destination;
     Button search;

    public static Search newInstance() {
        return new Search();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mViewModel = ViewModelProviders.of(this).get(SearchViewModel.class);
        View root = inflater.inflate(R.layout.search_fragment,container,false);
        final TextView textView = root.findViewById(R.id.text_search);
        source = root.findViewById(R.id.text_source);
        destination  = root.findViewById(R.id.text_destination);
        search = root.findViewById(R.id.button_search);

        mViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                textView.setText(s);
            }
        });
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sourc = source.getText().toString().trim();
                String dest = destination.getText().toString().trim();
                if(sourc == null || dest== null || sourc == "" || dest == "" )
                {
                    Toast.makeText(getContext(),"Please enter all the required fields",Toast.LENGTH_LONG).show();
                }
                else
                startActivity(new Intent(getContext(), SearchFlightsActivity.class).putExtra("source",sourc).putExtra("destination",dest));

            }
        });
        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(SearchViewModel.class);
        // TODO: Use the ViewModel

    }

}
