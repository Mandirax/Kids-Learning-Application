package com.example.kids_learning_app;
import android.content.Context;

import android.provider.ContactsContract;
import android.view.View;
import android.view.ViewGroup;

import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
public class ImageAdapter extends BaseAdapter {

    private AnimalFragment mcontext;
    public int[]  imageArray = {
            R.drawable.an1,R.drawable.an2,R.drawable.an3,R.drawable.an4,R.drawable.an5,
            R.drawable.an6,R.drawable.an7,R.drawable.an8,R.drawable.an9,
            R.drawable.an10,R.drawable.an11,R.drawable.an12,R.drawable.an13,
            R.drawable.an14,R.drawable.an15,R.drawable.an16,R.drawable.an17,
            R.drawable.an18,R.drawable.an19,R.drawable.an20,R.drawable.an21,R.drawable.an22
    };

    public ImageAdapter(AnimalFragment mcontext) {
        this.mcontext = mcontext;
    }

    @Override
    public int getCount() {
        return imageArray.length;
    }

    @Override
    public Object getItem(int position) {
        return imageArray[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {



        ImageView imageView = new ImageView(mcontext.getContext());
        imageView.setImageResource(imageArray[position]);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setLayoutParams(new ViewGroup.LayoutParams(500,350));
    return imageView;
    }
}
