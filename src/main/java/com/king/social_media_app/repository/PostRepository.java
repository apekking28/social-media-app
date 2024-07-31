package com.king.social_media_app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.king.social_media_app.models.Post;

public interface PostRepository extends JpaRepository<Post, Integer> {
    
    @Query("SELECT p FROM Post p WHERE p.user.id =:userId")
    List<Post> findPostByUserId(Integer userId);
}
