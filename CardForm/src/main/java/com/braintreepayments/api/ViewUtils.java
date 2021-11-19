package com.braintreepayments.api;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;

import com.braintreepayments.api.cardform.R;

class ViewUtils {

    static int dp2px(Context context, float dp) {
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp,
                context.getResources().getDisplayMetrics()));
    }

    static boolean isDarkBackground(Activity activity) {
        int color = activity.getResources().getColor(R.color.bt_white);
        try {
            Drawable background = activity.getWindow().getDecorView().getRootView().getBackground();
            if (background instanceof ColorDrawable) {
                color = ((ColorDrawable) background).getColor();
            }
        } catch (Exception ignored) {}

        double luminance = (0.2126 * Color.red(color)) + (0.7152 * Color.green(color)) +
                (0.0722 * Color.blue(color));

        return luminance < 128;
    }
}
