package com.simple.commonlibrary.glide;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.simple.commonlibrary.R;
import com.simple.commonlibrary.base.BaseApplication;

/**
 * Created by hych on 2017/4/13.
 */

public class GlideUtils {

    /**
     * @param imgNumber 图片大小 1最大 2中等 3最小 正方形的
     * @param url
     * @param image
     */
    public static void loadImage(int imgNumber, String url, ImageView image) {
        Glide.with(BaseApplication.getAppContext())
                .load(url)
                .crossFade(1500)
                .error(getDefaultPic(imgNumber))
                .into(image);
    }

    private static int getDefaultPic(int imgNumber) {
        switch (imgNumber) {
            case 1:
                return R.mipmap.common_glide_img_two_bi_one;
            case 2:
                return R.mipmap.common_glide_img_four_bi_three;
            case 3:
                return R.mipmap.common_glide_img_one_bi_one;
            case 4:
                return R.mipmap.common_glide_img_default_movie;
        }
        return R.mipmap.common_glide_img_four_bi_three;
    }

    /**
     * 使用Glide加载圆形ImageView(如头像)时，不要使用占位图
     *
     * @param context
     * @param url
     * @param iv
     */
    public static void load(Context context, String url, ImageView iv) {
        Glide.with(context).load(url).crossFade().diskCacheStrategy(DiskCacheStrategy.SOURCE).into(iv);
    }

}
