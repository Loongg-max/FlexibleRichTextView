package org.scilab.forge.jlatexmath.core;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;

public class AjLatexMath {

    private static Context mContext;
    private static Paint st;

    /**
     * 初始化画笔以及公式解析类
     *
     * @param context 上下文
     */
    public static void init(Context context) {
        mContext = context;
        st = new Paint();
        st.setStyle(Style.FILL_AND_STROKE);
        st.setColor(Color.BLACK);
        st.setStrokeWidth(0);
        TeXFormula.getPartialTeXFormula("{x^{2}+ x-1= 0 }").setDEBUG(false);
    }

    public static AssetManager getAssetManager() {
        AssetManager mng = mContext.getAssets();
        return mng;
    }

    /**
     * 同步画笔颜色，使生成图片与文字颜色一致
     *
     * @param color 画笔颜色
     */
    public static void setColor(int color) {
        if (st == null) {
            init(mContext);
        }
        st.setColor(color);
    }

    public static Context getContext() {
        return mContext;
    }

    /**
     * 得到画笔
     *
     * */
    public static Paint getPaint() {
        return st;
    }

    /**
     * 根据文字大小得到行距
     *
     * */
    public static float getLeading(float textSize) {
        st.setTextSize(textSize);
        return st.getFontSpacing();
    }

}
