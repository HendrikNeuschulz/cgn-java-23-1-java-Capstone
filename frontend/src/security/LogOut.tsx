import axios from "axios";
import useAuth from "../Hooks/useAuth";
import {useLocation} from "react-router-dom";

export default function LogOut() {
    const user = useAuth(false);
    const location = useLocation();

    axios.post("/api/users/logout").then(() => {
        window.sessionStorage.setItem(
            "signInRedirect",
            location.pathname || "/"
        );
        window.location.href = "/log-in";
    });


    return (<div/>)


}