import axios from "axios";


export default function useAuthRedirect() {
    if (window.location.pathname !== "/sign-in") {
        console.log(window.location.href)
        axios.interceptors.response.use(function (response) {
            return response;
        }, function (error) {
            if (error.response.status === 401) {
                window.location.href = "/sign-up";
            }

            return Promise.reject(error);
        });
    }
}
