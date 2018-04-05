package resourceview.bindings;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public class Resource<T> {

    @ResourceStatus
    public final int status;

    @Nullable
    public final T data;

    @Nullable
    public final String message;

    private Resource(@ResourceStatus int status, @Nullable T data, @Nullable String message) {
        this.status = status;
        this.data = data;
        this.message = message;
    }

    public static <T> Resource<T> loading(@Nullable T data) {
        return new Resource<>(ResourceStatus.LOADING, data, null);
    }

    public static <T> Resource<T> loading(@Nullable T data, @Nullable String message) {
        return new Resource<>(ResourceStatus.LOADING, data, message);
    }

    public static <T> Resource<T> success(@NonNull T data) {
        return new Resource<>(ResourceStatus.SUCCESS, data, null);
    }

    public static <T> Resource<T> error(@Nullable String msg, @Nullable T data) {
        return new Resource<>(ResourceStatus.ERROR, data, msg);
    }

}