import React, {useEffect, useState} from 'react';
import axios from 'axios';
import {Recipe} from '../model/Recipe';
import RecipeItem from './RecipeItem';


export default function RandomRecipe() {
    const [recipe, setRecipe] = useState<Recipe | null>(null);

    const fetchRandomRecipe = async () => {
        try {
            const response = await axios.get('/api/wtf/recipes/random');
            setRecipe(response.data);
        } catch (error) {
            console.error(error);
        }
    };

    useEffect(() => {
        fetchRandomRecipe();
    }, []);

    const handleClick = () => {
        fetchRandomRecipe();
    };

    if (!recipe) {
        return <p>Loading...</p>;
    }

    return (
        <div>
            <RecipeItem {...recipe} />
            <button onClick={handleClick}>Next Random Recipe</button>
        </div>
    );
}