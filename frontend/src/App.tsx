import React from 'react';
import RecipeList from "./compontens/RandomRecipe";
import Header from "./compontens/Header";
import {Route, Routes} from "react-router-dom";
import AddRecipe from "./compontens/AddRecipe";
import Navbar from "./compontens/Navbar";
import useAuthRedirect from "./Hooks/useAuthRedirect";
import LogOut from "./security/LogOut";
import SignIn from "./security/SignIn";
import SignUp from "./security/SignUp";


export default function App() {

    useAuthRedirect()

    return (
        <div className="App">
            <Header/>
            <Routes>
                <Route path="/" element={<RecipeList/>}></Route>
                <Route path="/add" element={<AddRecipe/>}></Route>
                <Route path={"/sign-up"} element={<SignUp/>}/>
                <Route path={"/sign-in"} element={<SignIn/>}/>
                <Route path={"/log-out"} element={<LogOut/>}/>
            </Routes>
            <Navbar/>


        </div>
    );
}
