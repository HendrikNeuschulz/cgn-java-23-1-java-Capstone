import React from "react";
import {useAuth} from "../Hooks/useSignInSignUp";

export default function SignUp() {
    const {signUp: {username, password, handleUsernameChange, handlePasswordChange, handleSubmit}} = useAuth();

    return (
        <div style={{padding: "5rem 0"}}>
            <h1>Sign Up</h1>

            <form onSubmit={handleSubmit}>
                <div>
                    <label>
                        Username
                        <input
                            type="text"
                            value={username}
                            onChange={handleUsernameChange}
                        />
                    </label>
                </div>

                <div>
                    <label>
                        Password
                        <input
                            type="password"
                            value={password}
                            onChange={handlePasswordChange}
                        />
                    </label>
                </div>

                <button type="submit">Sign Up</button>
            </form>
        </div>
    );
}