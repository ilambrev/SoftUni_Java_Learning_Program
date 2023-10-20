package com.likebookapp.service.impl;

import com.likebookapp.model.dto.PostCreateDTO;
import com.likebookapp.model.dto.PostDTO;
import com.likebookapp.model.entity.Mood;
import com.likebookapp.model.entity.Post;
import com.likebookapp.model.entity.User;
import com.likebookapp.repository.PostRepository;
import com.likebookapp.service.MoodService;
import com.likebookapp.service.PostService;
import com.likebookapp.service.UserService;
import com.likebookapp.util.CurrentUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    private final MoodService moodService;
    private final UserService userService;
    private final PostRepository postRepository;
    private final CurrentUser currentUser;

    @Autowired
    public PostServiceImpl(MoodService moodService, UserService userService, PostRepository postRepository, CurrentUser currentUser) {
        this.moodService = moodService;
        this.userService = userService;
        this.postRepository = postRepository;
        this.currentUser = currentUser;
    }

    @Override
    public void addPost(PostCreateDTO postCreateDTO) {

        Mood mood = this.moodService.getMoodByName(postCreateDTO.getMood());
        User user = this.userService.getUserById(this.currentUser.getId());

        Post post = new Post().setContent(postCreateDTO.getContent())
                .setMood(mood)
                .setUser(user);

        this.postRepository.save(post);
    }

    @Override
    public List<PostDTO> getUserPosts(Long id) {
        return this.postRepository.findByUserId(id)
                .stream()
                .map(this::mapPostToPostDTO).toList();
    }

    @Override
    public List<PostDTO> getOtherUsersPosts(Long id) {
        return this.postRepository.findByUserIdIsNot(id)
                .stream()
                .map(this::mapPostToPostDTO).toList();
    }

    @Override
    public void likePost(Long id) {

        User user = this.userService.getUserById(this.currentUser.getId());

        Post post = findPostById(id);

        if (post != null) {
            post.getUserLikes().add(user);

            this.postRepository.save(post);
        }
    }

    @Override
    public void deletePost(Long id) {

            this.postRepository.delete(findPostById(id));
    }

    private PostDTO mapPostToPostDTO(Post post) {

        return new PostDTO().setId(post.getId())
                .setContent(post.getContent())
                .setUsername(post.getUser().getUsername())
                .setMood(post.getMood().getName())
                .setLikes(post.getUserLikes().size());
    }

    private Post findPostById(Long id) {
        return this.postRepository.findById(id).orElse(null);
    }

}