package com.mypostgre.mycode28.service.impl;


import com.mypostgre.mycode28.entity.Comment;
import com.mypostgre.mycode28.entity.Post;
import com.mypostgre.mycode28.exception.ResourceNotFoundException;
import com.mypostgre.mycode28.payload.CommentDto;
import com.mypostgre.mycode28.repository.CommentRepository;
import com.mypostgre.mycode28.repository.PostRepository;
import com.mypostgre.mycode28.service.CommentService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceimpl implements CommentService {

    private PostRepository postRepository;
    private CommentRepository commentRepository;
    private ModelMapper modelMapper;

    public CommentServiceimpl(PostRepository postRepository, CommentRepository commentRepository,ModelMapper modelMapper) {
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;
        this.modelMapper=modelMapper;
    }

    @Override
    public CommentDto createComment(CommentDto commentDto,long postId){
        Post post = postRepository.findById(postId).orElseThrow(
                () -> new ResourceNotFoundException("Post not found id :" + postId)



        );
        Comment comment=new Comment();
        comment.setId(commentDto.getId());
        comment.setEmail(commentDto.getEmail());
        comment.setText(commentDto.getText());

        comment.setPost(post);

        Comment savedComment = commentRepository.save(comment);

       CommentDto dto=new CommentDto();
       dto.setId(savedComment.getId());
       dto.setEmail(savedComment.getEmail());
       dto.setText(savedComment.getText());

        return dto;
    }

    @Override
    public void deleteComment(long id) {
        commentRepository.deleteById(id);
    }

    @Override
    public CommentDto updateComment(Long id, CommentDto commentDto, long postId) {
        Post post = postRepository.findById(postId).orElseThrow(
                () -> new ResourceNotFoundException("Post not found for id:" + id)
        );
        Comment comment = commentRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Comment not found for id:" + id)
        );
        Comment c = mapToEntity(commentDto);
        c.setId(comment.getId());
        c.setPost(post);
        Comment  savedComment = commentRepository.save(c);

        return mapToDto(savedComment);
    }



   CommentDto mapToDto(Comment comment){
       CommentDto dto = modelMapper.map(comment, CommentDto.class);
       return dto;
   }

    Comment mapToEntity(CommentDto commentDto){
        Comment comment = modelMapper.map(commentDto, Comment.class);
        return comment;
    }
}
