package com.mypostgre.mycode28.controller;

import com.mypostgre.mycode28.payload.CommentDto;
import com.mypostgre.mycode28.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/comments")
public class CommentController {

    private CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping
    public ResponseEntity<CommentDto> createComment(@RequestBody CommentDto commentDto,
                                                    @RequestParam long postId){
        CommentDto dto = commentService.createComment(commentDto, postId);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String>deleteComment(@PathVariable long id){
        commentService.deleteComment(id);
        return new ResponseEntity<>("Comment is Deleted !!...",HttpStatus.OK);
    }

    @PutMapping("/{id}/post/{postId}")
    public ResponseEntity<CommentDto>updateComment(@PathVariable Long id, @RequestBody CommentDto commentDto, @PathVariable long postId){
        CommentDto dto = commentService.updateComment(id, commentDto,postId);
        return new ResponseEntity<>(dto,HttpStatus.OK);
    }
}
