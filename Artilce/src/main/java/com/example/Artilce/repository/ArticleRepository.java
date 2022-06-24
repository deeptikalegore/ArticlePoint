package com.example.Artilce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Artilce.model.Article;
public interface ArticleRepository extends JpaRepository<Article,Integer> {

}
