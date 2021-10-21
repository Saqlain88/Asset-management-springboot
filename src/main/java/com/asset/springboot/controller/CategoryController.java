package com.asset.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.asset.springboot.model.Category;
import com.asset.springboot.service.CategoryService;

@RestController
//@RequestMapping("/api/")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@GetMapping("/category")
	public ResponseEntity<List<Category>> getAllCategory() {
		return ResponseEntity.ok().body(categoryService.getAllCategory());
	}
	
	@PostMapping("/category/create")
	public ResponseEntity<Category> createCategory(@RequestBody Category category){
		return ResponseEntity.ok().body(this.categoryService.createCategory(category));
	}
	
	@PutMapping("/category/update/{id}")
	public ResponseEntity<Category> updateCategory(@PathVariable long id,@RequestBody Category category){
		category.setId(id);
		return ResponseEntity.ok().body(this.categoryService.updateCategory(category));
	}
	
	@GetMapping("/category/view/{id}")
	public ResponseEntity<Category> getCategoryById(@PathVariable long id){
		return ResponseEntity.ok().body(this.categoryService.getCategoryById(id));
	}
	
	@DeleteMapping("/category/delete/{id}")
	public HttpStatus deleteCategory(@PathVariable long id) {
		this.categoryService.deleteCategory(id);
		return HttpStatus.OK;
	}

}
