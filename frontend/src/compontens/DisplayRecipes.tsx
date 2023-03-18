import React from "react";
import {Recipe} from "../model/Recipe";
import {useRecipeList} from "../Hooks/useGetRecipes";
import RecipeItem from "./RecipeItem";

type RecipeListProps = {
    recipes: Recipe[]
}
export default function DisplayRecipes(props: RecipeListProps) {
    const {recipes} = useRecipeList();

    const displayRecipes = Array.isArray(recipes) ?
       recipes.map((value) => {
            return RecipeItem(value);
}):null;

    return (
        <div>
            {displayRecipes}
        </div>

    )


}