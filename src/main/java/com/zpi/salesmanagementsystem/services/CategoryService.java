package com.zpi.salesmanagementsystem.services;

import com.zpi.salesmanagementsystem.models.Category;
import com.zpi.salesmanagementsystem.models.Product;
import com.zpi.salesmanagementsystem.repositories.CategoryRepository;
import org.apache.commons.collections4.IterableUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CategoryService {

    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getAllCategories() {
        return IterableUtils.toList(this.categoryRepository.findAll());
    }

    public Category getCategoryById(Long id) {
        return this.categoryRepository.findById(id).orElseThrow();
    }

    public void addCategory(Category category) {
        this.categoryRepository.save(category);
    }

    public void editCategory(Category category) {
        this.categoryRepository.save(category);
    }

    public void deleteCategory(Long id) {
        this.categoryRepository.deleteById(id);
    }

    public void addProductToCategory(Product product) {
        Category category = this.categoryRepository.findById(product.getCategory().getId()).orElseThrow();
        category.getProducts().add(product);
        category.setQuantityOfProducts(category.getProducts().size());
        this.categoryRepository.save(category);
    }

    public void removeProductFromCategory(Product product) {
        Category category = this.categoryRepository.findById(product.getCategory().getId()).orElseThrow();
        category.getProducts().remove(product);
        category.setQuantityOfProducts(category.getProducts().size());
        this.categoryRepository.save(category);
    }

}
