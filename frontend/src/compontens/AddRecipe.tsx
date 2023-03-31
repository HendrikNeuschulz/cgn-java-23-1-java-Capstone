import AddSingleRecipe from "../Hooks/useAddSingleRecipe";
import React, {ChangeEvent, FormEvent, useEffect, useState} from "react";
import {Recipe} from "../model/Recipe";
import styled from "styled-components";
import Navbar from "./Navbar";
import checkbutton from "../Items/foursquare-check-in.png"

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
        <>
            <FormContainer onSubmit={handleSubmit}>
                <FormHeadline>Add your tasty Recipe</FormHeadline>
                <NameInput type="text" value={inputFields.name} onChange={handleChange} name="name" placeholder="Name"/>
                <IngredientsInput type="text" value={inputFields.ingredients} onChange={handleChange} name="ingredients"
                                  placeholder="Ingredients"/>
                <InstructionsInput type="text" value={inputFields.instructions} onChange={handleChange}
                                   name="instructions"
                                   placeholder="Instructions"/>
                <CheckButton type="submit"><img src={checkbutton} alt="checkbutton" width="50"
                                                height="50"/></CheckButton>
            </FormContainer>
            <Navbar/>
        </>


    );
}

const FormContainer = styled.form`
  display: flex;
  flex-direction: column;
  padding: 5px;
  margin: 10px;
  gap: 10px;

`

const FormHeadline = styled.h1`
  text-align: center;
`

const NameInput = styled.input`
  padding: 5px;
  height: 20px;
  font-size: 20px;
`

const IngredientsInput = styled.input`
  padding: 5px;
  height: 100px;
  font-size: 20px;

`
const InstructionsInput = styled.input`
  padding: 5px;
  height: 150px;
  font-size: 20px;
`

const CheckButton = styled.button`
  width: 20%;
  align-self: center;
  border: none;
  background-color: white;
  padding-top: 25px;

  &:active {
    transform: scale(0.7);
  }
`