package com.niantic.controllers;

import com.niantic.models.Category;
import com.niantic.services.CategoryDao;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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

        return "categories/index";
    }
}
