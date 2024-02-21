package com.mypostgre.mycode28.service;

import com.mypostgre.mycode28.payload.PostDto;

import java.util.List;

public interface PostService {

    PostDto createPost(PostDto postDto);

    PostDto getPostById(Long id);


    List<PostDto> getAllPost(int pageNo, int pageSize, String sortBy, String sortDir);

    void deleteComment(long id);
}
