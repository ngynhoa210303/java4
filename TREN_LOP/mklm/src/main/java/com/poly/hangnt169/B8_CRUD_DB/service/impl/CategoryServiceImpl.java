package com.poly.hangnt169.B8_CRUD_DB.service.impl;

import com.poly.hangnt169.B8_CRUD_DB.entity.Category;
import com.poly.hangnt169.B8_CRUD_DB.repository.CategoryRepository;
import com.poly.hangnt169.B8_CRUD_DB.service.CategoryService;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {
    private CategoryRepository cateR = new CategoryRepository();

    @Override
    public List<Category> getAll() {
        return cateR.getAll();
    }
}
