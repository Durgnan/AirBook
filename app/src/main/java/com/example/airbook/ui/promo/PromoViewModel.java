package com.example.airbook.ui.promo;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PromoViewModel extends ViewModel {
    // TODO: Implement the ViewModel
    private MutableLiveData<String> mText;

    public PromoViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Promotions fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
