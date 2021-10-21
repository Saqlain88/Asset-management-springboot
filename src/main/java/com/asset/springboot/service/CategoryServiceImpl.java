package com.asset.springboot.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asset.springboot.exception.ResourceNotFoundException;
import com.asset.springboot.model.Category;
import com.asset.springboot.repository.CategoryRepository;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public Category createCategory(Category category) {
		// TODO Auto-generated method stub
		return categoryRepository.save(category);
	}

	@Override
	public Category updateCategory(Category category) {
		// TODO Auto-generated method stub
		Optional<Category> categoryDb = this.categoryRepository.findById(category.getId());

		if (categoryDb.isPresent()) {
			Category categoryUpdate = categoryDb.get();
			categoryUpdate.setId(category.getId());
			categoryUpdate.setName(category.getName());
			categoryUpdate.setDescription(category.getDescription());
			categoryRepository.save(categoryUpdate);
			return categoryUpdate;
		} else {
			throw new ResourceNotFoundException("Record not found with id: " + category.getId());
		}

	}

	@Override
	public List<Category> getAllCategory() {
		// TODO Auto-generated method stub
		return categoryRepository.findAll();
	}

	@Override
	public Category getCategoryById(long categoryId) {
		// TODO Auto-generated method stub

		Optional<Category> categoryDb = this.categoryRepository.findById(categoryId);
		if (categoryDb.isPresent()) {
			return categoryDb.get();
		} else {
			throw new ResourceNotFoundException("Record not found with id: " + categoryId);
		}

	}

	@Override
	public void deleteCategory(long categoryId) {
		// TODO Auto-generated method stub
		Optional<Category> categoryDb = this.categoryRepository.findById(categoryId);
		if (categoryDb.isPresent()) {
			this.categoryRepository.delete(categoryDb.get());
		} else {
			throw new ResourceNotFoundException("Record not found with id: " + categoryId);
		}
	}

}
