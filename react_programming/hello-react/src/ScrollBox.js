import React, {Component} from 'react';

class ScrollBox extends Component{
    //scroll맨 아래쪽으로 움직이게 하기 
    scrollToBottom=()=>{
        //비구조화 할당 문법 사용
        const{scrollHeight, clientHeight}=this.box;
        this.box.scrollTop=scrollHeight-clientHeight;
    }

    render(){
        const style={
            border:'1px solid black',
            height:'300px',
            width:'300px',
            overflow:'auto',
            position:'relative'
        };
        const innerStyle={
            width:'100%',
            height:'650px',
            background:'linear-gradient(white,black)'
        }
        return(
            <div
                style={style}
                ref={(ref)=>{this.box=ref}}>
                <div style={innerStyle}/>
            </div>
        );
    }
}
export default ScrollBox;