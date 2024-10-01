import { createSlice, PayloadAction, createAsyncThunk } from "@reduxjs/toolkit";
import { Product } from "../../models/products";
import { productsService } from "../../services/products-service";

/* Defines the shape an states that this slice can return*/
// <----- CREATE INTERFACE ----->
interface ProductsState
{
    products: Product[]
    loading: boolean
    error: string | null
}
// <----- SET INITIAL STATE OF VALUES ----->
const initialState: ProductsState = {
    products: [],
    loading: false,
    error: null
}

// <----- METHODS THIS SLICE HAS ACCESS TO *CRUD* ----->
/* 
   createAsyncThunk Params
    - PARAM 1 : Type Prefix
    - PARAM 2 : Async Function that does the API Call
*/

export const getProducts = createAsyncThunk("products/getProducts", async () => {
    let products = await productsService.getAllProducts();
    return products
})

export const addProduct = createAsyncThunk("products/addProducts", async (product: Product) => {
    const newProduct = await productsService.addProducts(product);
    return newProduct;
})

export const updateProduct = createAsyncThunk("products/addProducts", async (product: Product) => {
    await productsService.updateProducts(product);
    return product;
})

export const deleteProduct = createAsyncThunk("products/addProducts", async (productId: number) => {
    await productsService.deleteProducts(productId);
    return productId;
})

const productsSlice = createSlice({
    name: 'products', //Action type prefix ---> /products/getProducts
    initialState, //Initial state before anything is dispatched
    reducers: {}, //Synchronous actions
    extraReducers: (builder) => { //asynchronous actions
                // Fetch Actors
      builder.addCase(getProducts.pending, (state) => {
        state.loading = true;
        state.error = null;
      });
      builder.addCase(getProducts.fulfilled, (state, action: PayloadAction<Product[]>) => {
        state.loading = false;
        state.products = action.payload;
      });
      builder.addCase(getProducts.rejected, (state, action) => {
        state.loading = false;
        state.error = action.error.message || 'Failed to fetch products';
      });
    }
})