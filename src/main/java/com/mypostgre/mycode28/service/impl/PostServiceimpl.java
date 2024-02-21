package com.mypostgre.mycode28.service.impl;

import com.mypostgre.mycode28.entity.Post;
import com.mypostgre.mycode28.exception.ResourceNotFoundException;
import com.mypostgre.mycode28.payload.PostDto;
import com.mypostgre.mycode28.repository.PostRepository;
import com.mypostgre.mycode28.service.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceimpl implements PostService {

    private  PostRepository postRepository;

    private ModelMapper modelMapper;


    public PostServiceimpl(PostRepository postRepository,ModelMapper modelMapper)

    {
        this.postRepository=postRepository;
        this.modelMapper=modelMapper;
    }
    @Override
    public PostDto createPost(PostDto postDto) {

        Post post = mapToEntity(postDto);
        Post savePost = postRepository.save(post);
        PostDto dto = mapToDto(savePost);

        return dto;

    }


    @Override
    public PostDto getPostById(Long id) {
       Post post= postRepository.findById(id).orElseThrow(
               ()->new ResourceNotFoundException("Post not found with id:"+id)
        );
        PostDto dto=new PostDto();
        dto.setId(post.getId());
        dto.setTitle(post.getTitle());
        dto.setDescription(post.getDescription());
        dto.setContent(post.getContent());
        return dto;
    }

    @Override
    public List<PostDto> getAllPost(int pageNo, int pageSize, String sortBy, String sortDir) {
        Sort sort = (sortDir.equalsIgnoreCase(Sort.Direction.ASC.name())) ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(pageNo,pageSize, Sort.by(sortBy));
        Page<Post> pagePost = postRepository.findAll(pageable);

        List<Post> posts = pagePost.getContent();
        List<PostDto> dtos = posts.stream().map(post -> mapToDto(post)).collect(Collectors.toList());
        return dtos;
    }

    @Override
    public void deleteComment(long id) {
        postRepository.deleteById(id);
    }

    PostDto mapToDto(Post post){
        PostDto dto= modelMapper.map(post,PostDto.class);

        return dto;
    }

    Post mapToEntity(PostDto postDto){
        Post post = modelMapper.map(postDto, Post.class);
        return post;
    }
}
