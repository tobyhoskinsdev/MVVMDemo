package examples.aaronhoskins.com.mvvmdemo.viewmodel;

import android.arch.lifecycle.ViewModel;
import android.databinding.Bindable;
import android.databinding.Observable;
import android.databinding.PropertyChangeRegistry;
import android.text.Editable;
import android.util.Log;

import examples.aaronhoskins.com.mvvmdemo.BR;


public class LoginViewModel extends ViewModel implements Observable {
    PropertyChangeRegistry propertyChangeRegistry = new PropertyChangeRegistry();
    @Bindable
    public String passwordStatus = "Password not entered yet";
    @Bindable
    public String emailStatus = "Email not entered yet";

    public void OnPasswordTextChanged(Editable editable) {
        passwordStatus = editable.toString();
        notifySingleFieldOfChange(BR.passwordStatus);
    }

    public void OnEmailTextChanged(Editable editable) {
        emailStatus = editable.toString();
        notifySingleFieldOfChange(BR.emailStatus);
    }

    @Override
    public void addOnPropertyChangedCallback(OnPropertyChangedCallback callback) {
        propertyChangeRegistry.add(callback);
    }

    @Override
    public void removeOnPropertyChangedCallback(OnPropertyChangedCallback callback) {
        propertyChangeRegistry.remove(callback);
    }

    public void notifyAllFieldsOfChange() {
        propertyChangeRegistry.notifyCallbacks(this, 0, null);
    }

    public void notifySingleFieldOfChange(int fieldId) {
        propertyChangeRegistry.notifyCallbacks(this, fieldId, null);
    }
}
