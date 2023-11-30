package com.blog.project.services;

import com.blog.project.payloads.CategoryDto;

import java.util.List;
public interface CategoryService {
    //create
    public CategoryDto createCategory(CategoryDto categoryDto);

    //update
    public CategoryDto updateCategory(CategoryDto categoryDto,Integer categoryId);

    //getall
    public List<CategoryDto> getAllCategory();

    //getbyid
    public CategoryDto getById(Integer categoryId);

    //delete
    public void deleteById(Integer categoryId);
}
