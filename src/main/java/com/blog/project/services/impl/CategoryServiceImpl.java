package com.blog.project.services.impl;

import com.blog.project.entities.Category;
import com.blog.project.exceptions.ResourceNotFoundException;
import com.blog.project.payloads.CategoryDto;
import com.blog.project.repositories.CategoryRepo;
import com.blog.project.services.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepo categoryRepo;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {
        Category category=this.modelMapper.map(categoryDto,Category.class);
        Category saved=categoryRepo.save(category);
        return this.modelMapper.map(saved,CategoryDto.class);
//        Category category=this.toCategory(categoryDto);
//        Category savedCategory=categoryRepo.save(category);
//        CategoryDto saved=toDto(savedCategory);
//        return saved;
    }

    @Override
    public CategoryDto updateCategory(CategoryDto categoryDto,Integer categoryId) {
        Category cate=this.categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category","categoryId",categoryId));
        cate.setCategoryDescription(categoryDto.getCategoryDescription());
        cate.setCategoryTitle(categoryDto.getCategoryTitle());
        Category updatedCat=categoryRepo.save(cate);

        return modelMapper.map(updatedCat,CategoryDto.class);
    }

    @Override
    public List<CategoryDto> getAllCategory() {
        List<Category> allCategory=categoryRepo.findAll();
       List<CategoryDto> allCat= allCategory.stream().map(data->this.modelMapper.map(data,CategoryDto.class)).collect(Collectors.toList());
        return allCat;
    }

    @Override
    public CategoryDto getById(Integer categoryId) {
        Category cat=categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category","categoryId",categoryId));
        CategoryDto byId=this.modelMapper.map(cat,CategoryDto.class);
        return byId;
    }

    @Override
    public void deleteById(Integer categoryId) {
        Category category=this.categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category","categoryId",categoryId));
        this.categoryRepo.delete(category);

    }
//    public CategoryDto toDto(Category category){
//        return this.modelMapper.map(category,CategoryDto.class);
//    }
//    public Category toCategory(CategoryDto categoryDto){
//        return this.modelMapper.map(categoryDto,Category.class);
//    }
}
