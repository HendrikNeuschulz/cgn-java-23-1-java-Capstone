import AddSingleRecipe from "../Hooks/useAddSingleRecipe";
import React, {ChangeEvent, FormEvent, useEffect, useState} from "react";
import {Recipe} from "../model/Recipe";

export default function AddRecipe() {
    const {postSingleRecipe} = AddSingleRecipe();
    const [addRecipe, setAddRecipe] = useState<Recipe | undefined>();
    const [inputFields, setInputFields] = React.useState({
        name: '',
        image: '',
        measure: '',
        ingredients: '',
        instructions: '',
        youtube: '',
    });

    const handleSubmit = (event: FormEvent<HTMLFormElement>) => {
        event.preventDefault();
        const newRecipe: Recipe = {
            id: '',
            category: '',
            likedby: [],
            comments: [],
            name: inputFields.name,
            image: inputFields.image,
            youtube: inputFields.youtube,
            ingredients: inputFields.ingredients.split(','),
            measure: inputFields.measure.split(','),
            instructions: inputFields.instructions,
        };
        setAddRecipe(newRecipe);
    };

    function handleChange(evt: ChangeEvent<HTMLInputElement>) {
        setInputFields({...inputFields, [evt.target.name]: evt.target.value});
    }

    useEffect(() => {
        if (addRecipe) {
            postSingleRecipe(addRecipe);
        }
    }, [addRecipe, postSingleRecipe]);

    return (
        <form onSubmit={handleSubmit}>
            <h1>Add your tasty Recipe</h1>
            <label>Name:</label>
            <input type="text" value={inputFields.name} onChange={handleChange} name="name"/>
            <label>measure:</label>
            <input type="text" value={inputFields.measure} onChange={handleChange} name="measure"/>
            <label>Ingredients:</label>
            <input type="text" value={inputFields.ingredients} onChange={handleChange} name="ingredients"/>
            <label>Instructions:</label>
            <input type="text" value={inputFields.instructions} onChange={handleChange} name="instructions"/>
            <label>Video:</label>
            <input type="text" value={inputFields.youtube} onChange={handleChange} name="youtube"/>
            <button type="submit">Add Recipe</button>
        </form>
    );
}