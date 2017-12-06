package com.sharenews.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.Collections;
import java.util.List;


public abstract class AbsFragmentAdapter<T> extends FragmentStatePagerAdapter {
    List<T> items = Collections.emptyList();

    public AbsFragmentAdapter(FragmentManager fm) {
        super(fm);
        items = getItems();
    }

    public abstract List<T> getItems();


    @Override
    public final int getCount() {
        return items.size();
    }

    @Override
    public final Fragment getItem(int position) {
        return getItem(position, items.get(position));
    }

    public abstract Fragment getItem(int position, T item);

}
