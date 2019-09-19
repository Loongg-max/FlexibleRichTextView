package com.daquexian.flexiblerichtextview;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.AppCompatTextView;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.TypefaceSpan;
import android.util.AttributeSet;
import android.util.TypedValue;

/**
 * Created by panj on 2017/3/21.
 */

public class CodeView extends AppCompatTextView {
    public CodeView(Context context) {
        super(context);
        init();
    }

    public CodeView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CodeView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    /*@TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public CodeView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }*/

    private void init() {
        setTextColor(RichTextViewSetting.getCodeTextColor());
        setBackgroundColor(RichTextViewSetting.getCodeBgColor());
        if(RichTextViewSetting.getLateXSize() != -1){
            setTextSize(RichTextViewSetting.getLateXSize());
        }

        int padding = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 8, getResources().getDisplayMetrics());
        setPadding(padding, padding, padding, padding);
    }

    public void setCode(String text) {
        super.setText(text);
        Spannable span = new SpannableString(text);
        span.setSpan(new TypefaceSpan("monospace"), 0, text.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        setText(span);
    }
}
