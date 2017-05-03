package com.peakhe.www.assimplebook.imp;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.youth.banner.loader.ImageLoader;

/**
 * Created by Administrator on 2017/5/3 0003.
 */

public class GlideImageLoader extends ImageLoader
{
    @Override
    public void displayImage(Context context, Object path, ImageView imageView) {
        Glide.with(context).load(path).into(imageView);

    }
}
