package com.daquexian.flexiblerichtextview;

import android.graphics.Color;

import org.scilab.forge.jlatexmath.core.AjLatexMath;

public class RichTextViewSetting {


    /**
     * 富文本文字颜色
     *
     * */
    private static int textColor = 0;

    /*
     * 富文本公式颜色
     *
     * */
    //private static int lateXColor = 0;

    /**
     * 富文本文字大小
     *
     * */
    private static int textSize = -1;

    /**
     * 富文本公式大小（codeView文字大小也是用的这个）
     *
     * */
    private static float lateXSize = -1;


    /**
     * codeView 文字颜色
     * */
    private static int codeTextColor = Color.parseColor("#4a5b6c");

    /**
     * codeView 背景颜色
     * */
    private static int codeBgColor = Color.parseColor("#e9edf4");


    /**
     * 设置富文本的公式和文字的颜色
     *
     * */
    public static void setColor(int color){

        AjLatexMath.setColor(color);
        setTextColor(color);
    }

    /**
     * 设置富文本公式和文字的大小(只设置公式大小就可以设置公式和文本的大小，所以在没有单独设置文本大小的情况下等效于setLateXSize)
     * （codeView文字大小也是用的这个）
     * */
    public static void setSize(float size){

        setLateXSize(size);
    }


    /**
     * 得到富文本文字颜色（默认0透明）
     *
     * */
    public static int getTextColor() {
        return textColor;
    }

    /**
     * 设置富文本文字颜色
     *
     * */
    public static void setTextColor(int textColor) {
        RichTextViewSetting.textColor = textColor;
    }

    /*public static int getLateXColor() {
        return lateXColor;
    }*/

    /**
     * 设置富文本公式大小
     * */
    public static void setLateXColor(int lateXColor) {
        //RichTextViewSetting.lateXColor = lateXColor;
        AjLatexMath.setColor(lateXColor);
    }

    public static int getTextSize() {
        return textSize;
    }

    /**
     * 设置富文本文字大小（单位px）
     *
     * */
    public static void setTextSize(int textSize) {
        RichTextViewSetting.textSize = textSize;
    }

    public static float getLateXSize() {
        return lateXSize;
    }

    /**
     * 设置富文本公式大小（单位sp）
     *
     * */
    public static void setLateXSize(float lateXSize) {
        RichTextViewSetting.lateXSize = lateXSize;
    }

    public static int getCodeTextColor() {
        return codeTextColor;
    }

    /**
     * 设置codeView文字颜色
     *
     * */
    public static void setCodeTextColor(int codeTextColor) {
        RichTextViewSetting.codeTextColor = codeTextColor;
    }

    public static int getCodeBgColor() {
        return codeBgColor;
    }

    /**
     * 设置codeView背景颜色
     *
     * */
    public static void setCodeBgColor(int codeBgColor) {
        RichTextViewSetting.codeBgColor = codeBgColor;
    }
}
