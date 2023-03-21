import React from "react";
import { useRecipeList } from "../Hooks/useGetRecipes";
import DisplayRecipes from "./DisplayRecipes";
import {Recipe} from "../model/Recipe";
import styled from "styled-components";

type RecipeListProps = {
    recipeList: Recipe[];
}

export default function RecipeList(props: RecipeListProps) {
    const {recipes} = useRecipeList();

    return (
        <div>
            <RecipeListHeadline>Recipes:</RecipeListHeadline>
            <DisplayRecipes recipes={recipes}/>
        </div>
    );
}

const RecipeListHeadline = styled.h1`
    text-align: center;
  text-decoration: underline;
`