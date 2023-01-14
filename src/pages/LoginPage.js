import AuthTemplate from "../components/auth/AuthTemplate";
import LoginForm from "../containers/LoginForms";


const LoginPage=()=>{
    return(
        <AuthTemplate>
            <LoginForm/>
        </AuthTemplate>
    );
};
export default LoginPage;