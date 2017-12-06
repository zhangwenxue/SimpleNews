package com.sharenews;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.sharenews.internal.bean.JuheNews;
import com.sharenews.internal.http.ApiConstants;
import com.sharenews.internal.http.ApiManager;
import com.sharenews.internal.http.HttpResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    ApiManager.getInstance().getNewsAsync(ApiConstants.paramValue.NEWS_BUSINESS, "6d1649705c3f0b127f034b64d0ce6bb8", new Callback<HttpResponse<JuheNews>>() {
                        @Override
                        public void onResponse(Call<HttpResponse<JuheNews>> call, Response<HttpResponse<JuheNews>> response) {
                            JuheNews news = response.body().getData();
                            String ret = null;
                        }

                        @Override
                        public void onFailure(Call<HttpResponse<JuheNews>> call, Throwable t) {

                        }
                    });

                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
