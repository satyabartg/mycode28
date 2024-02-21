package com.mypostgre.mycode28.repository;

import com.mypostgre.mycode28.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment,Long> {

}
