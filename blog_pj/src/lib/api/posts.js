import client from './client';

export const writePost= ({title,body,tags})=>
    client.post('/api/posts', { title, body, tags });
    //포스트를 읽게 해주는 readpost
    export const readPost = id => client.get(`/api/posts/${id}`);

    export const listPosts=({page, username, tag})=>{
        return client.get(`/api/posts`,{
            params:{page,username,tag},
        });
    };