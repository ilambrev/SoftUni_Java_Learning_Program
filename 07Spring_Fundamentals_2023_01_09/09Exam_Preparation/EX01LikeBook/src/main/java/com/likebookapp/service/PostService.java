package com.likebookapp.service;

import com.likebookapp.model.dto.PostCreateDTO;
import com.likebookapp.model.dto.PostDTO;

import java.util.List;

public interface PostService {

    void addPost(PostCreateDTO postCreateDTO);

    List<PostDTO> getUserPosts(Long id);

    List<PostDTO> getOtherUsersPosts(Long id);

    void likePost(Long id);

    void deletePost(Long id);

}