import {useState, useEffect, useCallback} from 'react';
import axios from 'axios';
import { Recipe } from '../model/Recipe';

export const useRecipeList = () => {
    const [recipes, setRecipes] = useState<Recipe[]>([]);

    useEffect(() => {
        getRecipes()
    }, []);
    const getRecipes = useCallback(() => {
        axios.get('/wtf/recipes').then(response => {
            setRecipes(response.data);
        });
    }, []);

    return {recipes, getRecipes};
};
