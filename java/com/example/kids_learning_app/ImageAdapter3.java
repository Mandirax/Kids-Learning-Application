package com.example.kids_learning_app;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class ImageAdapter3 extends BaseAdapter {
    private Alphabet_fragment mcontext;
    public int[]  imageArray = {
            R.drawable.aaa,R.drawable.bbb,R.drawable.ccc,R.drawable.ddd,R.drawable.eee,
            R.drawable.fff,R.drawable.ggg,R.drawable.hhh,R.drawable.iii,R.drawable.jjj,R.drawable.kkk,R.drawable.lll,
            R.drawable.mmm,R.drawable.nnn,R.drawable.ooo,R.drawable.ppp,R.drawable.qqq,R.drawable.rrr,R.drawable.sss,R.drawable.ttt,R.drawable.uuu,R.drawable.vvv,
            R.drawable.www,R.drawable.xxx,R.drawable.yyy,R.drawable.zzz
    };

    public ImageAdapter3(Alphabet_fragment mcontext) {
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
