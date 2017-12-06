package com.sharenews.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Pair;

import com.sharenews.ui.fragment.NewsFragment;

import java.util.Collections;
import java.util.List;


public class NewsFragmentAdapter extends FragmentStatePagerAdapter {
    private static List<Pair<String, String>> list = Collections.emptyList();

    static {
        list.add(new Pair<String, String>("top", "头条"));
        list.add(new Pair<String, String>("shehui", "社会"));
        list.add(new Pair<String, String>("guonei", "国内"));
        list.add(new Pair<String, String>("guoji", "国际"));
        list.add(new Pair<String, String>("yule", "娱乐"));
        list.add(new Pair<String, String>("tiyu", "体育"));
        list.add(new Pair<String, String>("junshi", "军事"));
        list.add(new Pair<String, String>("keji", "科技"));
        list.add(new Pair<String, String>("caijing", "财经"));
        list.add(new Pair<String, String>("shishang", "时尚"));

    }

    public NewsFragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        return NewsFragment.newInstance(list.get(position).second, list.get(position).first);
    }

    @Override
    public int getCount() {
        return list.size();
    }
}
