import {Recipe} from "../model/Recipe";
import axios from "axios";


export default function AddSingleRecipe() {
    function postSingleRecipe(props: Recipe | undefined) {
        if (props) {
            axios.post("/api/wtf/recipes/add", {
                id: props.id,
                name: props.name,
                ingredients: props.ingredients,
                category: props.category,
                image: props.image,
                instructions: props.instructions,
                youtube: props.youtube,
                measure: props.measure,
                likedby: props.likedby,
                comments: props.comments

            }).catch((error) => console.error(error))
        }
    }

    return {postSingleRecipe}
}