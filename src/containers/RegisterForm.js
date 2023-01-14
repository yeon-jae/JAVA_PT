import React,{useEffect} from 'react';
import { useDispatch, useSelector } from 'react-redux';
import { changeField, initializeForm ,register} from '../modules/auth';
import AuthForm from '../components/auth/AuthForm';
import {check} from '../modules/user';
import { useNavigate } from 'react-router-dom';

const RegisterForm=()=>{

    const dispatch=useDispatch();
    const {form,auth,authError,user}=useSelector(({auth,user})=>({
        form:auth.register,
        auth:auth.auth,
        authError:auth.authError,
        user: user.user
    }));

    const onChange=e=>{
        const{value,name}=e.target;
        dispatch(
            changeField({
                form:'register',
                key:name,
                value
            })
        );
    };

    //폼 등록 이벤트 핸들러
    const onSubmit=e=>{
        e.preventDefault();
        const {username,password,passwordConfirm}=form;
        if(password!==passwordConfirm){
            return;
        }
        dispatch(register({username,password}));
    };
    //컴포넌트가 처음 렌더링될때 form을 초기화함
    useEffect(()=>{
        dispatch(initializeForm('register'));
    },[dispatch]);
    //회원가입 성공/실패 처리
    useEffect(()=>{
        if(authError){
            console.log('오류발생');
            console.log(authError);
            return;
        }
        if(auth){
            console.log('회원가입 성공');
            console.log(auth);
        }
    },[auth,authError]);

    const navigate=useNavigate();
    useEffect(()=>{
        if(user){
            navigate('/');
        }
    },[navigate,user]);

    return(<AuthForm
        type="register"
        form={form}
        onChange={onChange}
        onSubmit={onSubmit}
    />
    );

};
export default RegisterForm;