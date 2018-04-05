package resourceview;

import android.content.Context;
import android.support.annotation.DrawableRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

/**
 * Created by hemant on 1/22/18.
 * All rights reserved @2017.
 */

@SuppressWarnings("unused")
public class ResourceView extends FrameLayout {

    @Nullable
    private View errorLayout;
    @Nullable
    private View loaderLayout;


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

    private void init(Context context) {
        // to set vector drawables programmatically in pre-lollipop devices.
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }

    /**
     * Show custom loading view from resource
     */
    public void showLoadingView(@LayoutRes int layout) {
        Utils.ensureLayoutRes(getContext(), layout);
        View view = Utils.inflate(layout, this, false);
        showLoadingView(view);
    }

    /**
     * Show custom loading view
     */
    public void showLoadingView(@NonNull View view) {
        hideErrorView();
        hideLoadingView();

        loaderLayout = view;
        addView(loaderLayout);
    }

    /**
     * Show loading without any message
     */
    public void showLoadingLayout() {
        showLoadingView(R.layout.loader_layout);
    }

    /**
     * Show loading with a message
     *
     * @param messageRes pass message string resource
     */
    public void showLoadingLayout(@StringRes int messageRes) {
        Utils.ensureStringRes(getContext(), messageRes);
        showLoadingLayout(getContext().getString(messageRes));
    }

    /**
     * Show loading with a message
     *
     * @param loaderMessage pass message
     */
    public void showLoadingLayout(@Nullable String loaderMessage) {
        View view = Utils.inflate(R.layout.loader_layout, this, false);
        if (loaderMessage != null) {
            TextView messageTextView = view.findViewById(R.id.loaderMessageTextView);
            messageTextView.setText(loaderMessage);
            messageTextView.setVisibility(VISIBLE);
        }
        showLoadingView(view);
    }

    /**
     * Show custom loading view from resource
     */
    public void showErrorView(@LayoutRes int layout) {
        Utils.ensureLayoutRes(getContext(), layout);
        View view = Utils.inflate(layout, this, false);
        showErrorView(view);
    }

    /**
     * Show custom loading view
     */
    public void showErrorView(@NonNull View view) {
        hideErrorView();
        hideLoadingView();

        errorLayout = view;
        errorLayout = view;
        errorLayout = view;
        addView(errorLayout);
    }

    /**
     * Show error layout with a message
     *
     * @param message pass error message
     */
    public void showErrorLayout(@Nullable String message) {
        View errorLayout = Utils.inflate(R.layout.error_layout, this, false);

        if (message != null) {
            TextView messageTextView = errorLayout.findViewById(R.id.errorMessageTextView);
            messageTextView.setText(message);
            messageTextView.setVisibility(VISIBLE);
        }
        showErrorView(errorLayout);
    }

    /**
     * Show error layout with an image and message
     *
     * @param imageRes drawable resource to show image
     * @param message  pass error message
     */
    public void showErrorLayout(@DrawableRes int imageRes, @Nullable String message) {

        View view = Utils.inflate(R.layout.error_layout, this, false);

        AppCompatImageView errorImageView = view.findViewById(R.id.errorImageView);
        errorImageView.setImageDrawable(ResourcesCompat.getDrawable(getContext().getResources(), imageRes, null));
        errorImageView.setVisibility(VISIBLE);

        if (message != null) {
            TextView messageTextView = view.findViewById(R.id.errorMessageTextView);
            messageTextView.setText(message);
            messageTextView.setVisibility(VISIBLE);
        }

        showErrorView(view);
    }

    /**
     * Show error layout with a message and button
     *
     * @param message              pass error message
     * @param actionButtonText     pass button name string resource
     * @param actionButtonCallback pass a listener to listen button click
     */
    public void showErrorLayout(@Nullable String message,
                                @Nullable String actionButtonText,
                                @Nullable Runnable actionButtonCallback) {

        View errorLayout = Utils.inflate(R.layout.error_layout, this, false);

        if (message != null) {
            TextView messageTextView = errorLayout.findViewById(R.id.errorMessageTextView);
            messageTextView.setText(message);
            messageTextView.setVisibility(VISIBLE);
        }

        if (actionButtonText != null && actionButtonCallback != null) {
            AppCompatButton errorButton = errorLayout.findViewById(R.id.retryButton);
            errorButton.setText(actionButtonText);
            errorButton.setVisibility(VISIBLE);
            errorButton.setOnClickListener(v -> actionButtonCallback.run());
        }

        showErrorView(errorLayout);
    }

    /**
     * Show error layout with a message and button
     *
     * @param imageRes             drawable resource to show image
     * @param message              pass error message string
     * @param actionButtonText     pass button name string resource
     * @param actionButtonCallback pass a listener to listen button click
     */
    public void showErrorLayout(@DrawableRes int imageRes,
                                @Nullable String message,
                                @Nullable String actionButtonText,
                                @Nullable Runnable actionButtonCallback) {

        View errorLayout = Utils.inflate(R.layout.error_layout, this, false);

        AppCompatImageView errorImageView = errorLayout.findViewById(R.id.errorImageView);
        errorImageView.setImageDrawable(ResourcesCompat.getDrawable(getContext().getResources(), imageRes, null));
        errorImageView.setVisibility(VISIBLE);

        if (message != null) {
            TextView messageTextView = errorLayout.findViewById(R.id.errorMessageTextView);
            messageTextView.setText(message);
            messageTextView.setVisibility(VISIBLE);
        }

        if (actionButtonText != null && actionButtonCallback != null) {
            AppCompatButton errorButton = errorLayout.findViewById(R.id.retryButton);
            errorButton.setText(actionButtonText);
            errorButton.setVisibility(VISIBLE);
            errorButton.setOnClickListener(v -> actionButtonCallback.run());
        }

        showErrorView(errorLayout);
    }

    /**
     * Show actual contents
     */
    public void showContents() {
        hideLoadingView();
        hideErrorView();
    }

    /**
     * Hide loading
     */
    private void hideLoadingView() {
        if (loaderLayout != null) {
            loaderLayout.setVisibility(GONE);
            removeView(loaderLayout);
            loaderLayout = null;
        }
    }

    /**
     * Hide error view
     */
    private void hideErrorView() {
        if (errorLayout != null) {
            errorLayout.setVisibility(GONE);
            removeView(errorLayout);
            errorLayout = null;
        }
    }

}
