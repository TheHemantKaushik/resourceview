package com.thehemantkaushik;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;

/**
 * Created by hemant on 1/22/18.
 * All rights reserved @2017.
 */

public class ResourceView extends FrameLayout {

    private View errorLayout;
    private AppCompatImageView errorImageView;
    private AppCompatTextView errorTextView;
    private AppCompatButton errorButton;

    private View loaderLayout;
    private ProgressBar loaderProgressBar;
    private AppCompatTextView loaderMessageTextView;
    private boolean contentsHidden = false;
    private int[] childrenVisibility;

    public ResourceView(@NonNull Context context) {
        super(context);
        init(context);
    }

    public ResourceView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public ResourceView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public ResourceView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);

        loaderLayout = layoutInflater.inflate(R.layout.loader_layout, this, false);
        loaderProgressBar = loaderLayout.findViewById(R.id.loader);
        loaderMessageTextView = loaderLayout.findViewById(R.id.loaderMessageTextView);

        errorLayout = layoutInflater.inflate(R.layout.error_layout, this, false);
        errorImageView = errorLayout.findViewById(R.id.errorImageView);
        errorTextView = errorLayout.findViewById(R.id.errorMessageTextView);
        errorButton = errorLayout.findViewById(R.id.retryButton);

        loaderLayout.setVisibility(GONE);
        errorLayout.setVisibility(GONE);
    }

    public void showErrorLayout(@StringRes int errorMessageRes) {
        showErrorLayout(0, errorMessageRes, 0, null);
    }

    public void showErrorLayout(@NonNull String errorMessage) {
        showErrorLayout(0, errorMessage, null, null);
    }

    public void showErrorLayout(@DrawableRes int errorImageRes,
                                @StringRes int errorMessageRes) {
        showErrorLayout(errorImageRes, errorMessageRes, 0, null);
    }

    public void showErrorLayout(@DrawableRes int errorImageRes,
                                @Nullable String errorMessage) {
        showErrorLayout(errorImageRes, errorMessage, null, null);
    }

    public void showErrorLayout(@StringRes int errorMessageRes,
                                @StringRes int errorButtonTextRes,
                                @Nullable View.OnClickListener errorButtonClickListener) {

        String errorMessage = isValidStringRes(errorMessageRes) ? getContext().getString(errorMessageRes) : null;
        String errorButtonText = isValidStringRes(errorButtonTextRes) ? getContext().getString(errorButtonTextRes) : null;

        showErrorLayout(0, errorMessage, errorButtonText, errorButtonClickListener);
    }

    public void showErrorLayout(@Nullable String errorMessage,
                                @Nullable String errorButtonText,
                                @Nullable View.OnClickListener errorButtonClickListener) {

        showErrorLayout(0, errorMessage, errorButtonText, errorButtonClickListener);
    }

    public void showErrorLayout(@DrawableRes int errorImageRes,
                                @StringRes int errorMessageRes,
                                @StringRes int errorButtonTextRes,
                                @Nullable View.OnClickListener errorButtonClickListener) {

        String errorMessage = isValidStringRes(errorMessageRes) ? getContext().getString(errorMessageRes) : null;
        String errorButtonText = isValidStringRes(errorButtonTextRes) ? getContext().getString(errorButtonTextRes) : null;

        showErrorLayout(errorImageRes, errorMessage, errorButtonText, errorButtonClickListener);
    }

    private boolean isValidDrawableRes(@DrawableRes int errorButtonTextRes) {
        return getResources().getIdentifier(String.valueOf(errorButtonTextRes), "drawable", getContext().getPackageName()) != 0;
    }

    private boolean isValidStringRes(@StringRes int errorButtonTextRes) {
        return getResources().getIdentifier(String.valueOf(errorButtonTextRes), "string", getContext().getPackageName()) != 0;
    }

    public void showErrorLayout(@DrawableRes int errorImageRes,
                                @Nullable String errorMessage,
                                @Nullable String errorButtonText,
                                @Nullable View.OnClickListener errorButtonClickListener) {

        hideContents();
        removeView(loaderLayout);
        removeView(errorLayout);

        addView(errorLayout);
        errorLayout.setVisibility(VISIBLE);

        if (isValidDrawableRes(errorImageRes)) {
            errorImageView.setImageDrawable(ResourcesCompat.getDrawable(getContext().getResources(), errorImageRes, null));
        } else {
            errorImageView.setVisibility(GONE);
        }

        if (errorMessage != null) {
            errorTextView.setText(errorMessage);
        } else {
            errorTextView.setVisibility(GONE);
        }

        if (errorButtonText != null && errorButtonClickListener != null) {
            errorButton.setText(errorButtonText);
        } else {
            errorButton.setVisibility(GONE);
        }

        errorButton.setOnClickListener(errorButtonClickListener);
    }

    public void showLoadingLayout() {
        showLoadingLayout(null);
    }

    public void showLoadingLayout(@StringRes int loaderMessage) {
        if (isValidStringRes(loaderMessage)) {
            showLoadingLayout(getContext().getString(loaderMessage));
        } else {
            showLoadingLayout(null);
        }
    }

    public void showLoadingLayout(@Nullable String loaderMessage) {

        hideContents();
        removeView(loaderLayout);
        removeView(errorLayout);

        addView(loaderLayout);
        loaderLayout.setVisibility(VISIBLE);

        if (loaderMessage != null) {
            loaderMessageTextView.setText(loaderMessage);
        } else {
            loaderMessageTextView.setVisibility(GONE);
        }
    }

    private void hideContents() {
        if (contentsHidden) {
            return;
        }
        contentsHidden = true;

        childrenVisibility = new int[getChildCount()];

        for (int i = 0; i < getChildCount(); i++) {
            childrenVisibility[i] = getChildAt(i).getVisibility();
            getChildAt(i).setVisibility(GONE);
        }
    }

    public void showContents() {
        if (!contentsHidden) {
            return;
        }
        contentsHidden = false;

        removeView(loaderLayout);
        removeView(errorLayout);

        for (int i = 0; i < childrenVisibility.length; i++) {
            getChildAt(i).setVisibility(childrenVisibility[i]);
        }
    }
}
