package examples.aaronhoskins.com.mvvmdemo.view.activities;

import android.arch.lifecycle.Observer;
import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import examples.aaronhoskins.com.mvvmdemo.R;
import examples.aaronhoskins.com.mvvmdemo.databinding.ActivityMainBinding;
import examples.aaronhoskins.com.mvvmdemo.viewmodel.LoginViewModel;

public class MainActivity extends AppCompatActivity {
    LoginViewModel loginViewModel;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main); //not used in MVVM
        ActivityMainBinding activityMainBinding
                = DataBindingUtil.setContentView(this, R.layout.activity_main);
        loginViewModel = new LoginViewModel();
        activityMainBinding.setLoginViewModel(loginViewModel);
        activityMainBinding.setLifecycleOwner(this);
        activityMainBinding.executePendingBindings();
        textView = findViewById(R.id.tvEmailValidationStatus);

        loginViewModel.emailStatus.observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
    }

    @BindingAdapter({"android:text"})
    public static void setTextViewText(TextView tv, String message) {
        tv.setText(message);
    }

    @BindingAdapter({"bind:imageUrl"})
    public static void setImageViewsUrl(ImageView imgImage, String url) {
        Glide.with(imgImage.getContext()).load(url).into(imgImage);
    }
}
