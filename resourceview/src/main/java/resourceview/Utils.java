package resourceview;

import android.content.Context;
import android.support.annotation.DrawableRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.StringRes;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public final class Utils {

    private Utils() {
    }

    public static boolean isValidDrawableRes(Context context, @DrawableRes int drawableRes) {
        return drawableRes != 0 && context.getResources().getIdentifier(String.valueOf(drawableRes), "drawable", context.getPackageName()) != 0;
    }

    public static boolean isValidStringRes(Context context, @StringRes int stringRes) {
        return stringRes != 0 && context.getResources().getIdentifier(String.valueOf(stringRes), "string", context.getPackageName()) != 0;
    }

    public static boolean isValidLayoutRes(Context context, @LayoutRes int layoutRes) {
        return layoutRes != 0 && context.getResources().getIdentifier(String.valueOf(layoutRes), "string", context.getPackageName()) != 0;
    }

    public static void ensureLayoutRes(Context context, @LayoutRes int res) {
        if (!isValidLayoutRes(context, res)) {
            throw new IllegalStateException("Layout resource is not valid: " + res);
        }
    }

    public static void ensureStringRes(Context context, int res) {
        if (!isValidStringRes(context, res)) {
            throw new IllegalStateException("String resource is not valid: " + res);
        }
    }

    public static View inflate(int layout, ViewGroup parent, boolean attachToParent) {
        return LayoutInflater.from(parent.getContext().getApplicationContext()).inflate(layout, parent, attachToParent);
    }
}
