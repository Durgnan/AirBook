package com.example.airbook.ui.bookings;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class BookingsViewModel extends ViewModel {
    // TODO: Implement the ViewModel
    private MutableLiveData<String> mText;

    public BookingsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Booking fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
