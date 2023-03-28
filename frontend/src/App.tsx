import React from 'react';
import RecipeList from "./compontens/RandomRecipe";
import Header from "./compontens/Header";
import {Route, Routes} from "react-router-dom";
import AddRecipe from "./compontens/AddRecipe";


export default function App() {
    return (
        <div className="App">
            <Header/>
            <Routes>
                <Route path="/" element={<RecipeList/>}></Route>
                <Route path="/add" element={<AddRecipe/>}></Route>
            </Routes>


        </div>
    );
}
