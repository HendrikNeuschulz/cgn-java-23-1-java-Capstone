import {useState, useEffect, useCallback} from 'react';
import axios from 'axios';
import { Recipe } from '../model/Recipe';

export const useRecipeList = () => {
    const [recipes, setRecipes] = useState<Recipe[]>([]);


    const getRecipes = useCallback(() => {
        axios.get('/wtf/recipes')
            .then(response => {
                setRecipes(response.data);
            })
            .catch(error => {
                console.error(error);
            });
    }, []);

    useEffect(() => {
        getRecipes()
    }, [getRecipes]);

    return {recipes, getRecipes};
};
