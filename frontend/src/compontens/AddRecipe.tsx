import AddSingleRecipe from "../Hooks/useAddSingleRecipe";
import React, {ChangeEvent, FormEvent, useEffect, useState} from "react";
import {Recipe} from "../model/Recipe";
import styled from "styled-components";
import Navbar from "./Navbar";
import checkbutton from "../Items/foursquare-check-in.png"
import axios from "axios";

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
    const [file, setFile] = React.useState<File | null>(null);
    const [url, setUrl] = React.useState<string>("");

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
        const payload = new FormData();
        if (!file) {
            return;
        }
        payload.set('file', file);
        axios.post("/api/wtf/recipes/upload", payload)
            .then(res => {
                setUrl(res.data)
                console.log(res);
            })
            .catch(err => {
                console.error(err);
            })
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

    const handleFileChange = (event: React.ChangeEvent<HTMLInputElement>) => {
        if (event.target.files && event.target.files.length > 0) {
            setFile(event.target.files[0]);
        }
    }


    return (
        <>
            <FormContainer onSubmit={handleSubmit}>
                <FormHeadline>Add your tasty Recipe</FormHeadline>
                <NameInput type="text" value={inputFields.name} onChange={handleChange} name="name" placeholder="Name"/>
                <input type={'file'} onChange={handleFileChange} accept={"image/jpeg, image/png"}/>
                <IngredientsInput type="text" value={inputFields.ingredients} onChange={handleChange} name="ingredients"
                                  placeholder="Ingredients"/>
                <InstructionsInput type="text" value={inputFields.instructions} onChange={handleChange}
                                   name="instructions"
                                   placeholder="Instructions"/>
                <CheckButton type="submit"><img src={checkbutton} alt="checkbutton" width="50"
                                                height="50"/></CheckButton>
            </FormContainer>
            {
                url ? <a href={url}>{url}</a> : ''
            }
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