package com.mardoqueu.bookstore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mardoqueu.bookstore.domain.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>{
	
}
