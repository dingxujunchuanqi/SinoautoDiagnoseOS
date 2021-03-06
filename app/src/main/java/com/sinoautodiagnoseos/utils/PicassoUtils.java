package com.sinoautodiagnoseos.utils;

import android.content.Context;
import android.widget.ImageView;

import com.sinoautodiagnoseos.R;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by dingxujun on 2017/5/5.
 */
/*
*  加载圆形图片
* */
public class PicassoUtils {
    public static void loadImageView(Context mContext, String url, CircleImageView mImageView) {
        Picasso.with(mContext).load(url)
                .placeholder(R.drawable.default_image)
                .error(R.drawable.default_image)
                .tag(mContext)
                .into(mImageView);
    }

    /**
     * 加载指定大小加载图片
     *
     * @param mContext   上下文
     * @param path       图片路径
     * @param width      宽
     * @param height     高
     * @param mImageView 控件
     */
    public static void loadImageViewSize(Context mContext, String path, int width, int height, ImageView mImageView) {
        Picasso.with(mContext).load(path).resize(width, height).placeholder(R.drawable.default_image)
                .error(R.drawable.default_image).centerCrop().into(mImageView);
    }

    /**
     * 加载有默认图片
     *
     * @param mContext   上下文
     * @param path       图片路径
     * @param mImageView 控件
     */
    public static void loadImageViewHolder(Context mContext, String path,ImageView mImageView) {
        Picasso.with(mContext).load(path).fit(). placeholder(R.drawable.default_image).into(mImageView);
    }

    /**
     * 加载网络图片
     * @param mContext
     * @param url
     * @param mImageView
     */
    public static void loadLocalImageView(Context mContext, String url, ImageView mImageView) {
        Picasso.with(mContext).load(url)
                .placeholder(R.drawable.default_image)
                .error(R.drawable.default_image)
                .tag(mContext)
                .into(mImageView);
    }
}
