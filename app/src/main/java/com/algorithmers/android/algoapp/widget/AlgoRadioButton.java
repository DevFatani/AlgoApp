package com.algorithmers.android.algoapp.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.RadioButton;

import com.algorithmers.android.algoapp.util.TypefaceFont;


/**
 * Created by DevFatani on 7/21/2016 AD.
 */
public class AlgoRadioButton extends RadioButton {

    public AlgoRadioButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.init();
    }

    public AlgoRadioButton(Context context) {
        super(context);
        this.init();
    }

    public AlgoRadioButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.init();
    }

    private void init() {
        if (!isInEditMode()) {

            this.setTypeface(TypefaceFont.INSTANCE.set(this.getContext()));

        }
    }
}
