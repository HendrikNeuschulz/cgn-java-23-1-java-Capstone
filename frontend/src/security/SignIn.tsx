import React from "react";
import {useNavigate} from "react-router-dom";
import axios from "axios";

export default function SignIn() {
    const [username, setUsername] = React.useState<string>("");
    const [password, setPassword] = React.useState<string>("");
    const navigate = useNavigate();

    return (
        <div style={{padding: "5rem 0"}}>
            <h1>Sign In</h1>

            <form onSubmit={e => {
                e.preventDefault();
                axios.post("/api/users/login", {}, {
                    headers: {
                        Authorization: `Basic ${window.btoa(`${username}:${password}`)}`
                    }
                }).then(() => {
                    const redirect = window.sessionStorage.getItem("signInRedirect") || "/";
                    window.sessionStorage.removeItem("signInRedirect");
                    navigate(redirect);
                }).catch(err => {
                    alert(err.response.data.error);
                });
            }}>
                <div>
                    <label>
                        Username
                        <input
                            type="text"
                            value={username}
                            onChange={e => setUsername(e.currentTarget.value)}
                        />
                    </label>
                </div>

                <div>
                    <label>
                        Password
                        <input
                            type="password"
                            value={password}
                            onChange={e => setPassword(e.currentTarget.value)}
                        />
                    </label>
                </div>

                <button type="submit">Sign In</button>
            </form>
        </div>
    );
}