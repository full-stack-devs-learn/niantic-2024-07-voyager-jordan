import { createSlice, PayloadAction, createAsyncThunk } from "@reduxjs/toolkit";
import { Category } from "../../models/category";
import { categoriesService } from "../../services/categories-service";

/* Defines the shape an states that this slice can return*/
// <----- CREATE INTERFACE ----->
interface CategoriesState
{
    categories: Category[]
    loading: boolean
    error: string | null
}
// <----- SET INITIAL STATE OF VALUES ----->
const initialState: CategoriesState = {
    categories: [],
    loading: false,
    error: null
}

// <----- METHODS THIS SLICE HAS ACCESS TO *CRUD* ----->
/* 
   createAsyncThunk Params
    - PARAM 1 : Type Prefix
    - PARAM 2 : Async Function that does the API Call
*/

export const getCategory = createAsyncThunk("products/getCategory", async () => {
    let categories = await categoriesService.getAllCategories();
    return categories
})

export const addCategory = createAsyncThunk("products/addCategory", async (category: Category) => {
    const newCategory = await categoriesService.addCategory(category);
    return newCategory;
})

export const updateCategory = createAsyncThunk("products/updateCategory", async (category: Category) => {
    await categoriesService.updateCategory(category);
    return category;
})

export const deleteCategory = createAsyncThunk("products/deleteCategory", async (categoryId: number) => {
    await categoriesService.deleteCategory(categoryId);
    return categoryId;
})

const categoriesSlice = createSlice({
    name: 'categories', 
    initialState, 
    reducers: {}, 
    extraReducers: (builder) => { 

      builder.addCase(getCategory.pending, (state) => {
        state.loading = true;
        state.error = null;
      });
      builder.addCase(getCategory.fulfilled, (state, action: PayloadAction<Category[]>) => {
        state.loading = false;
        state.categories = action.payload;
      });
      builder.addCase(getCategory.rejected, (state, action) => {
        state.loading = false;
        state.error = action.error.message || 'Failed to fetch products';
      });
    }
})
const categoriesReducer = categoriesSlice.reducer
export default categoriesReducer;