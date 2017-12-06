package com.sharenews.ui.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.sharenews.R;
import com.sharenews.internal.bean.JuheNews;
import com.sharenews.internal.http.ApiManager;
import com.sharenews.internal.http.HttpResponse;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsListFragment extends Fragment {
    @BindView(R.id.recycler_view)
    RecyclerView mRV;
    private String mTitle;
    private String mType;
    private Call<HttpResponse<JuheNews>> mCall;
    private List<JuheNews.Data> mList = new ArrayList<>();
    private SimpleAdapter mAdapter;

    public NewsListFragment() {
    }

    public static NewsListFragment newInstance(String title, String type) {
        Bundle bundle = new Bundle();
        bundle.putString("title", title);
        bundle.putString("type", type);
        NewsListFragment fragment = new NewsListFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mTitle = getArguments().getString("title");
            mType = getArguments().getString("type");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_news_list, container, false);
        ButterKnife.bind(this, root);

        mRV.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        mAdapter = new SimpleAdapter(mList);
        mRV.setAdapter(mAdapter);
        return root;
    }

    @Override
    public void onStart() {
        super.onStart();
        mCall = ApiManager.getInstance().getNewsAsync(mType, new Callback<HttpResponse<JuheNews>>() {
            @Override
            public void onResponse(Call<HttpResponse<JuheNews>> call, Response<HttpResponse<JuheNews>> response) {
                JuheNews news = response.body().getData();
                mList.addAll(news.getData());
                mAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<HttpResponse<JuheNews>> call, Throwable t) {
            }
        });
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mCall != null && !mCall.isCanceled()) {
            mCall.cancel();
        }
    }

    public class SimpleAdapter extends BaseQuickAdapter<JuheNews.Data, BaseViewHolder> {

        public SimpleAdapter(@Nullable List<JuheNews.Data> data) {
            super(R.layout.list_item_news, data);
        }

        @Override
        protected void convert(BaseViewHolder helper, JuheNews.Data item) {
            helper.setText(R.id.title, item.getTitle()).setText(R.id.date, item.getDate());
            String url = null;
            if (!TextUtils.isEmpty(item.getThumbnailPicS())) {
                url = item.getThumbnailPicS();
            } else if (!TextUtils.isEmpty(item.getThumbnailPicS02())) {
                url = item.getThumbnailPicS02();
            } else if (!TextUtils.isEmpty(item.getThumbnailPicS03())) {
                url = item.getThumbnailPicS03();
            }
            if (!TextUtils.isEmpty(url)) {
                Glide.with(getActivity()).load(url).into((ImageView) helper.getView(R.id.news_img));
            }
        }
    }
}
