package com.daquexian.flexiblerichtextview;

import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by daquexian on 17-2-13.
 */

public class TextWithFormula extends SpannableStringBuilder {
    private List<Formula> formulas = new ArrayList<>();

    public TextWithFormula(CharSequence text) {
        super(text);
        //设置富文本文字颜色
        if(RichTextViewSetting.getTextColor() != 0){
            setSpan(new ForegroundColorSpan(RichTextViewSetting.getTextColor()), 0, text.length(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        }
        //设置富文本文字大小（单位pix）
        if(RichTextViewSetting.getTextSize() != -1){
            setSpan(new AbsoluteSizeSpan(RichTextViewSetting.getTextSize()), 0, text.length(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        }

    }

    public void addFormula(int start, int end, String content, int contentStart,
                           int contentEnd) {
        formulas.add(new Formula(start, end, content, contentStart, contentEnd));
    }

    public List<Formula> getFormulas() {
        return formulas;
    }

    public static class Formula {
        public int start, end, contentStart, contentEnd;
        public String content;

        public Formula(int start, int end, String content, int contentStart, int contentEnd) {
            this.start = start;
            this.end = end;
            this.content = content;
            this.contentStart = contentStart;
            this.contentEnd = contentEnd;
        }
    }
}
