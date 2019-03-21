package examples.aaronhoskins.com.mvvmdemo.view.activities;

import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import examples.aaronhoskins.com.mvvmdemo.R;
import examples.aaronhoskins.com.mvvmdemo.databinding.ActivityMainBinding;
import examples.aaronhoskins.com.mvvmdemo.viewmodel.LoginViewModel;

public class MainActivity extends AppCompatActivity {
    LoginViewModel loginViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main); //not used in MVVM
        ActivityMainBinding activityMainBinding
                = DataBindingUtil.setContentView(this, R.layout.activity_main);
        loginViewModel = new LoginViewModel();
        activityMainBinding.setLoginViewModel(loginViewModel);
        activityMainBinding.executePendingBindings();
    }

    @BindingAdapter({"android:text"})
    public static void setTextViewText(TextView tv, String message) {
        tv.setText(message);
    }
}
