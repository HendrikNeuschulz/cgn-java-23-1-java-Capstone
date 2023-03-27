import React from 'react';
import RecipeList from "./compontens/RandomRecipe";
import Header from "./compontens/Header";


export default function App() {
    return (
        <div className="App">
            <Header/>
            <RecipeList/>

        </div>
    );
}
