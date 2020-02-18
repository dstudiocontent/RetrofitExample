package com.ds.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class Resource<T> {

    @NonNull
    private ResourceStatus status;

    @Nullable
    private List<T> data;

    @Nullable
    private Throwable error;

    public Resource() {
        this.status = ResourceStatus.CREATED;
        this.data = null;
        this.error = null;
    }

    public Resource<T> loading() {
        this.status = ResourceStatus.LOADING;
        this.data = null;
        this.error = null;
        return this;
    }

    public Resource<T> success(@NonNull List<T> data) {
        this.status = ResourceStatus.SUCCESS;
        this.data = data;
        this.error = null;
        return this;
    }

    public Resource<T> error(@NonNull Throwable error) {
        this.status = ResourceStatus.ERROR;
        this.data = null;
        this.error = error;
        return this;
    }

    @NonNull
    public ResourceStatus getStatus() {
        return status;
    }

    @Nullable
    public List<T> getData() {
        return data;
    }

    @Nullable
    public Throwable getError() {
        return error;
    }


    public enum ResourceStatus {
        CREATED,
        SUCCESS,
        ERROR,
        LOADING
    }
}
