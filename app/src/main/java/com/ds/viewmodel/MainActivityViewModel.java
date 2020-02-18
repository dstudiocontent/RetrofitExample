package com.ds.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;

import com.ds.model.Post;
import com.ds.model.Resource;
import com.ds.model.User;
import com.ds.repository.PostRepository;
import com.ds.repository.UserRepository;

public class MainActivityViewModel extends ViewModel {

    private PostRepository postRepository;
    private UserRepository userRepository;
    private SavedStateHandle savedStateHandle;

    public MainActivityViewModel(SavedStateHandle savedStateHandle) {
        this.savedStateHandle = savedStateHandle;
        postRepository = new PostRepository();
        userRepository = new UserRepository();
    }

    public LiveData<Resource<Post>> getAllPosts() {
        return postRepository.getAllPosts();
    }

    public LiveData<Resource<User>> getAllUsers() {
        return userRepository.getAllUsers();
    }

}
