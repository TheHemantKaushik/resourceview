package resourceview.bindings;

import android.databinding.BindingAdapter;

import resourceview.ResourceView;

/**
 * Created by hemant on 2/1/18.
 * All rights reserved @2017.
 */
public class ResourceViewBindings {

    @BindingAdapter("bindResource")
    public static void bindResource(ResourceView resourceView, Resource<?> resource) {

        switch (resource.status) {

            case ResourceStatus.LOADING:
                if (resource.data != null) {
                    resourceView.showContents();
                } else {
                    resourceView.showLoadingLayout(resource.message);
                }
                break;

            case ResourceStatus.SUCCESS:
                resourceView.showContents();
                break;

            case ResourceStatus.ERROR:
                if (resource.data != null) {
                    resourceView.showContents();
                } else {
                    resourceView.showErrorLayout(resource.message);
                }
                break;
        }
    }

}
