package com.ds.ui;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.ds.R;
import com.ds.model.Post;
import com.ds.model.Resource;
import com.ds.model.User;
import com.ds.viewmodel.MainActivityViewModel;

public class MainActivity extends AppCompatActivity {

    MainActivityViewModel activityViewModel;
    TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewResult = findViewById(R.id.text_view);

        activityViewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);

        /*activityViewModel.getAllPosts().observe(this, resource -> {
            if (resource.getStatus() == Resource.ResourceStatus.SUCCESS) {
                if (resource.getData() != null) {
                    for (Post post : resource.getData()) {

                        String content = "";
                        content += "ID: " + post.getId() + "\n";
                        content += "User ID: " + post.getUserId() + "\n";
                        content += "Title: " + post.getTitle() + "\n";
                        content += "Text: " + post.getText() + "\n\n";

                        textViewResult.append(content);
                    }
                }
            }
        });*/

        activityViewModel.getAllUsers().observe(this, resource -> {
            if (resource.getStatus() == Resource.ResourceStatus.SUCCESS) {
                if (resource.getData() != null) {
                    for (User user : resource.getData()) {

                        String content = "";
                        content += "ID: " + user.getId() + "\n";
                        content += "User ID: " + user.getName() + "\n";

                        textViewResult.append(content);
                    }
                }
            }
        });

        //getPosts("posts?userId=5");
    }

    /*void getPostById(int postId) {
        Call<Post> call = retrofitApi.getPostById(postId);

        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {

                if (!response.isSuccessful()) {
                    textViewResult.setText("Code: " + response.code());
                    return;
                }

                Post post = response.body();

                String content = "";
                content += "ID: " + post.getId() + "\n";
                content += "User ID: " + post.getUserId() + "\n";
                content += "Title: " + post.getTitle() + "\n";
                content += "Text: " + post.getText() + "\n\n";

                textViewResult.append(content);
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                textViewResult.setText(t.getMessage());
            }
        });
    }


    void getPostByUserId(int[] userId) {
        Call<List<Post>> call = retrofitApi.getPostByUserId(userId);

        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {

                if (!response.isSuccessful()) {
                    textViewResult.setText("Code: " + response.code());
                    return;
                }

                List<Post> posts = response.body();

                for (Post post : posts) {
                    String content = "";
                    content += "ID: " + post.getId() + "\n";
                    content += "User ID: " + post.getUserId() + "\n";
                    content += "Title: " + post.getTitle() + "\n";
                    content += "Text: " + post.getText() + "\n\n";

                    textViewResult.append(content);
                }
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                textViewResult.setText(t.getMessage());
            }
        });
    }

    void getPostByUserIdsSorted() {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("userId", "2");
        parameters.put("_sort", "id");
        parameters.put("_order", "desc");
        Call<List<Post>> call = retrofitApi.getPostByUserIdsSorted(parameters);

        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {

                if (!response.isSuccessful()) {
                    textViewResult.setText("Code: " + response.code());
                    return;
                }

                List<Post> posts = response.body();

                for (Post post : posts) {
                    String content = "";
                    content += "ID: " + post.getId() + "\n";
                    content += "User ID: " + post.getUserId() + "\n";
                    content += "Title: " + post.getTitle() + "\n";
                    content += "Text: " + post.getText() + "\n\n";

                    textViewResult.append(content);
                }
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                textViewResult.setText(t.getMessage());
            }
        });
    }*/
}
