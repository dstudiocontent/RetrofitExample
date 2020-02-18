package com.ds.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;

import com.ds.model.Post;
import com.ds.model.Resource;
import com.ds.repository.PostRepository;

public class MainActivityViewModel extends ViewModel {

    private PostRepository postRepository;
    private SavedStateHandle savedStateHandle;

    public MainActivityViewModel(SavedStateHandle savedStateHandle) {
        this.savedStateHandle = savedStateHandle;
        postRepository = new PostRepository();
    }

    public LiveData<Resource<Post>> getAllPosts() {
        return postRepository.getAllPosts();
    }

}
