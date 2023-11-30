package com.blog.project.controller;

import com.blog.project.payloads.ApiResponse;
import com.blog.project.payloads.CategoryDto;
import com.blog.project.services.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    //Create.
    @PostMapping("/create")
    public ResponseEntity<CategoryDto> create(@Valid @RequestBody CategoryDto categoryDto){
        CategoryDto created=this.categoryService.createCategory(categoryDto);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }
    //Find by id
    @GetMapping("/byid/{categoryId}")
    public ResponseEntity<CategoryDto> findById(@PathVariable Integer categoryId){
        CategoryDto byId=this.categoryService.getById(categoryId);
        return new ResponseEntity<CategoryDto>(byId,HttpStatus.OK);
    }
    //Update.
    @PutMapping("/update/{categoryId}")
    public ResponseEntity<CategoryDto> update(@Valid @RequestBody CategoryDto categoryDto,@PathVariable Integer categoryId){
        CategoryDto updateById=this.categoryService.updateCategory(categoryDto,categoryId);
        return new ResponseEntity<>(updateById, HttpStatus.CREATED);
    }
    //get all
    @GetMapping("/getall")
    public ResponseEntity<List<CategoryDto>> getAll(){
        List<CategoryDto> all=this.categoryService.getAllCategory();
        return new ResponseEntity<>(all,HttpStatus.OK);
    }
    //delete
    @DeleteMapping("/delete/{categoryId}")
    public ResponseEntity<ApiResponse> deleteCategory(@PathVariable Integer categoryId){
        this.categoryService.deleteById(categoryId);
        return new ResponseEntity<ApiResponse>(new ApiResponse("Category is deleted successfuly",true),HttpStatus.OK);
    }
}
