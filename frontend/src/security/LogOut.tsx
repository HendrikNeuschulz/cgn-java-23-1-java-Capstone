import axios from "axios";
import {useLocation} from "react-router-dom";

export default function LogOut() {
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