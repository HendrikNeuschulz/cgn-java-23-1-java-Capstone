import React,  {useEffect} from "react";
import RecipeList from "../src/compontens/RecipeList"
import {useRecipeList} from "./Hooks/useGetRecipes";


function App() {

    const {recipes, getRecipes} = useRecipeList();

    useEffect(() => {
        getRecipes()
    }, [getRecipes]);

    return (
        <div className="App">
            <header className="App-header">

            </header>
            <RecipeList recipeList={recipes}/>
        </div>
    );
}

export default App;