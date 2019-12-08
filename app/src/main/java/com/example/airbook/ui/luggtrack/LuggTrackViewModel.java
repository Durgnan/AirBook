package com.example.airbook.ui.luggtrack;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class LuggTrackViewModel extends ViewModel {
    // TODO: Implement the ViewModel
    private MutableLiveData<String> mText;

    public LuggTrackViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is LuggTrack fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
