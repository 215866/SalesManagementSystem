package com.zpi.salesmanagementsystem.services;

import com.zpi.salesmanagementsystem.models.Category;
import com.zpi.salesmanagementsystem.repositories.CategoryRepository;
import org.apache.commons.collections4.IterableUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CategoryService {

    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getAllCategory(){
        return IterableUtils.toList(this.categoryRepository.findAll());
    }

    public void addCategory(Category category){
        this.categoryRepository.save(category);
    }
}
