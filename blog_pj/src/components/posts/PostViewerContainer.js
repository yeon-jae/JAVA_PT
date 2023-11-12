import React,{useEffect} from 'react';
import { useDispatch, useSelector } from 'react-redux';
import { withRouter } from 'react-router-dom';
import { useParams } from 'react-router-dom';
import {readPost, unloadPost} from '../../modules/post';
import PostViewer from '../../components/post/PostViewer';

const PostViewerContainer=({match})=>{
//처음 마운트 될때  포스트 읽기 api요청
    const {postId}=useParams();
    const dispatch=useDispatch();
    const{post,error,loading}=useSelector(({post,loading})=>({
        post:post.post,
        error:post.error,
        loading:loading['post/READ_POST'],
    }));
    useEffect(()=>{
        dispatch(readPost(postId));
        //언마운트 될때 리덕스에서 포스트 데이터 없애기 
        return() =>{
            dispatch(unloadPost());
        };
    },[dispatch,postId]);
    return <PostViewer post={post} loading={loading} error={error} />;
};
//url 파라미터로 받아온 id값을 조회해야 하기 때문에 withRouterㄹㄹ 적용함
export default PostViewerContainer;