import { configureStore } from "@reduxjs/toolkit";
//prodcutsReducer "Controller"
import productsReducer from "./features/products-slice";

const store = configureStore({
    reducer:{
        products: productsReducer
    }
})

export type RootState = ReturnType<typeof store.getState>
export type AppDispatch = typeof store.dispatch
export default store;