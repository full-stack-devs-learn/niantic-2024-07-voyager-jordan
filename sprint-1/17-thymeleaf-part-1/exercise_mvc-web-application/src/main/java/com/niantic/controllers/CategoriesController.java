package com.niantic.controllers;

import com.niantic.models.Category;
import com.niantic.services.CategoryDao;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class CategoriesController
{
    //Create a private variable = a new categoryDao;
    private CategoryDao categoryDao = new CategoryDao();

    //Establish the path of this route
    @GetMapping("/categories")
    //Create the result of going to this route
    //Importing Model and passing in model for spring boot to process the information
    public String getAllCategories(Model model){
        //Using the categoryDao assign data to an array list that spring boot can use
        ArrayList<Category> categories = categoryDao.getCategories();
        //Add data to the springboot model;
        model.addAttribute("categories", categories);

        //return string of the path
        return "categories/index";
    }

    @GetMapping("/categories/{id}")
    public String getCategory(Model model, @PathVariable("id") int id)
    {
        Category category = categoryDao.getCategoryById(id);
        model.addAttribute("categories", category);

        return "categories/details_category";
    }

    @GetMapping("/categories/{id}/edit")
    public String editCategory(Model model, @PathVariable("id") int id)
    {
        Category category = categoryDao.getCategoryById(id);
        model.addAttribute("categories", category);

        return "categories/edit_category";
    }

    @GetMapping("/categories/add")
    public String addCategory(){
        return "/categories/add_category";
    }

    @PostMapping ("/categories/add")
    public String postCategory(@ModelAttribute Category category){

        if(category.getCategoryName().isEmpty() || category.getDescription().isEmpty() ){
            return "redirect:/categories/error_category";
        }
        categoryDao.addCategory(category);
        return "redirect:/categories";
    }


//UPDATE
    @PostMapping("/categories/{id}/edit")
    public String postEditCategory(@ModelAttribute Category category, @PathVariable("id") int id)
    {
        Category current = categoryDao.getCategoryById(id);

        category.setCategoryId(id);

        category.setCategoryName((category.getCategoryName().isEmpty()
                ? current.getCategoryName()
                : category.getCategoryName()));
        category.setDescription((category.getDescription().isEmpty()
                ? current.getDescription()
                : category.getDescription()));

        categoryDao.updateCategory(category);

        return "redirect:/categories";
    }
//DELETE
    @GetMapping("/categories/{id}/delete")
    public String getDeleteCategory(Model model, @PathVariable("id") int id)
    {
        Category category = categoryDao.getCategoryById(id);
        model.addAttribute("categories", category);
        return "/categories/delete_category";
    }
    @PostMapping("/categories/{id}/delete")
    public String deleteCategory(@PathVariable("id") int id)
    {
        try {
            categoryDao.deleteCategory(id);
        } catch (Exception e){
            return "redirect:/categories/error_category";
        }
        return "redirect:/categories";
    }
//ERRORS
    @GetMapping("/categories/error_category")
    public String errorCategory()
    {
        return "categories/error_category";
    }
}
