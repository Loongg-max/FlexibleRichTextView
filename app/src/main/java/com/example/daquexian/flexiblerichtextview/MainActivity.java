package com.example.daquexian.flexiblerichtextview;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.daquexian.flexiblerichtextview.Attachment;
import com.daquexian.flexiblerichtextview.FlexibleRichTextView;
import com.daquexian.flexiblerichtextview.RichTextViewSetting;
import com.daquexian.flexiblerichtextview.Tokenizer;

import org.scilab.forge.jlatexmath.core.AjLatexMath;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // train classifier on app start
        //CodeProcessor.init(this);
        AjLatexMath.init(this); // init library: load fonts, create paint, etc.
        RichTextViewSetting.setSize(14);

        RichTextViewSetting.setLateXColor(Color.parseColor("#ff0000"));
        RichTextViewSetting.setCodeTextColor(Color.RED);
        RichTextViewSetting.setCodeBgColor(Color.GREEN);

        List<Attachment> attachments = new ArrayList<>();
        attachments.add(new ExampleAttachment("Android Image", "53ce1", true, "https://gss0.baidu.com/-fo3dSag_xI4khGko9WTAnF6hhy/lvpics/pic/item/6a600c338744ebf8f40404fbd1f9d72a6159a7f9.jpg"));
        attachments.add(new ExampleAttachment("Here is a link", "bc41a", false, "https://google.com"));

        FlexibleRichTextView flexibleRichTextView = (FlexibleRichTextView) findViewById(R.id.frtv);
        Tokenizer.setCenterStartLabels("<center>");
        Tokenizer.setCenterEndLabels("</center>");
        Tokenizer.setTitleStartLabels("<h>");
        Tokenizer.setTitleEndLabels("</h>");

        flexibleRichTextView.setText("<h><center>hi!</center></h>" +
                        "[quote]This is quote\n" +
                        "second line\n" +
                        "third line\n" +
                        "fourth line[/quote]" +
                        "Here is an attachment:[attachment:53ce1]" +
                        "[img]https://gss0.baidu.com/-fo3dSag_xI4khGko9WTAnF6hhy/lvpics/pic/item/6a600c338744ebf8f40404fbd1f9d72a6159a7f9.jpg[/img]" +
                        "[code]print(\"Hello FlexibleRichTextView!\")[/code]" +
                        "Hello FlexibleRichTextView!\n" +
                        "This is LaTeX:\n" +
                        "我爱你安防$e^{\\pi i呵呵} + 1 = 0wo我爱你$我爱你\n" +
                        "This is table:\n" +
                        "| First Header  | Second Header |\n" +
                        "| --- | --- |\n" +
                        "| Content Cell  | Content Cell  |\n" +
                        "| Content Cell  | Content Cell  |\n" +
                        "An attachment is shown at the bottom: \n",
                attachments);
    }
}