package com.mypostgre.mycode28.service;

import com.mypostgre.mycode28.payload.CommentDto;

public interface CommentService {
    CommentDto createComment(CommentDto commentDto,long postId);

    void deleteComment(long id);

     CommentDto updateComment(Long id, CommentDto commentDto, long postId);

}
