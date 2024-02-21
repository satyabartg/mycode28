package com.mypostgre.mycode28.entity;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "comments")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
        @Id
        @GeneratedValue(strategy= GenerationType.IDENTITY)
        private long id;

        private String text ;
        private String email ;


        @ManyToOne
        @JoinColumn(name = "post_id")
        private Post post;

    }


