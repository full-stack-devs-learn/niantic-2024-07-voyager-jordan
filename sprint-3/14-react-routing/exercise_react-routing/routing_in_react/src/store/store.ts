import { configureStore } from "@reduxjs/toolkit";
//prodcutsReducer "Controller"
import productsReducer from "./features/products-slice";
import categoriesReducer from "./features/categories-slice";

const store = configureStore({
    reducer:{
        products: productsReducer
        , categories: categoriesReducer
    }
})

export type RootState = ReturnType<typeof store.getState>
export type AppDispatch = typeof store.dispatch
export default store;