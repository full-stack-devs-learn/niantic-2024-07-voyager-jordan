package com.niantic.controllers.apis;

import com.niantic.models.Category;
import com.niantic.services.CategoryDao;
import com.niantic.services.MySqlCategoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoriesController
{
    @Autowired
    private CategoryDao categoryDao;

    @GetMapping
    public List<Category> getAllCategories()
    {
        return categoryDao.getCategories();
    }

    @GetMapping(path = "{id}")
    public Category getCategory(@PathVariable int id)
    {
        return categoryDao.getCategory(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Category addCategory(@RequestBody Category category)
    {
        return categoryDao.addCategory(category);
    }

    @PutMapping(path = "{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCategory(@PathVariable int id, @RequestBody Category category)
    {
        categoryDao.updateCategory(id, category);
    }

    @DeleteMapping(path = "{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCategory(@PathVariable int id)
    {
        categoryDao.deleteCategory(id);
    }

}
