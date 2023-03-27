import React from "react";
import {Recipe} from "../model/Recipe";
import styled from "styled-components";

interface RecipeProps extends Recipe {}

export default function RecipeItem(props: RecipeProps) {
        return (
            <RecipeListContainer>
                <RecipeName>{props.name}</RecipeName>
                <RecipeImage src={props.image} alt={props.name} />
            </RecipeListContainer>

        );
}

const RecipeName = styled.p`
  font-size: 1.5rem;
  font-weight: bold;
  border: 1px solid black;
  width: 90%;
  padding: 0.5rem;
  box-shadow: black 0 0 10px;
`;

const RecipeImage = styled.img`
  width: 90%;
  box-shadow: black 0 0 10px;
`;

const RecipeListContainer = styled.div`
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
    margin: 1rem;
`;