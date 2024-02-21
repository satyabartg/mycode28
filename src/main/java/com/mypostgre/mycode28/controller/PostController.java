package com.mypostgre.mycode28.controller;

import com.mypostgre.mycode28.payload.PostDto;
import com.mypostgre.mycode28.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/post")
public class PostController {
   private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping
    public ResponseEntity<?> createPost(@RequestBody PostDto postDto){
        PostDto dto = postService.createPost(postDto);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    @GetMapping("/particular")
    public ResponseEntity<?>getPostById(@RequestParam Long id){
        PostDto dto = postService.getPostById(id);
        return new ResponseEntity<>(dto,HttpStatus.OK);
    }


    @GetMapping
    public List<PostDto>getAllPost(
            @RequestParam(name = "pageNo",required = false,defaultValue = "0") int pageNo,
            @RequestParam(name = "pageSize",required = false,defaultValue = "5") int pageSize,
            @RequestParam(name = "sortBy",required = false,defaultValue = "id") String sortBy,
            @RequestParam(name = "sortDir",required = false,defaultValue = "id") String sortDir

    ){
        List<PostDto> postDtos= postService.getAllPost(pageNo,pageSize,sortBy,sortDir);
        return postDtos;

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String>deleteComment(@PathVariable long id){
         postService.getPostById(id);
        return new ResponseEntity<>("Post is Deleted !!...",HttpStatus.OK);
    }
}
