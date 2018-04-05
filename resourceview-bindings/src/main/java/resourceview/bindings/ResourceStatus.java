package resourceview.bindings;

import android.support.annotation.IntDef;

/**
 * Created by hemant on 2/1/18.
 * All rights reserved @2017.
 */

@IntDef(value = {ResourceStatus.LOADING, ResourceStatus.SUCCESS, ResourceStatus.ERROR})
public @interface ResourceStatus {

    int LOADING = 0;

    int SUCCESS = 1;

    int ERROR = 2;
}
