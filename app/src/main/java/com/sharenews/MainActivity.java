package com.sharenews;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.sharenews.internal.bean.JuheNews;
import com.sharenews.internal.http.ApiConstants;
import com.sharenews.internal.http.ApiManager;
import com.sharenews.internal.http.HttpResponse;
import com.sharenews.ui.fragment.NewsFragment;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    replaceFragment(NewsFragment.newInstance());
                    return true;
                case R.id.navigation_dashboard:
                    return true;
                case R.id.navigation_notifications:
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

    private void replaceFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.content, fragment).commit();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
