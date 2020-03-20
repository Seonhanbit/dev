import React, { useContext, Fragment } from "react";

import UserNameContext from '../../context/UserNameContext';

import Button from "@material-ui/core/Button";
// import { Link } from "@material-ui/core";
import { Link } from 'react-router-dom';

//image
import Election_logo from "../../images/Election_logo.png";
import Exclamation_mark from "../../images/Exclamation_mark.png";

const UserAuthComplete = props => {
  const username = useContext(UserNameContext);

  const url = "/user-vote/" + props.userinfocode + "/" + username;

  const click = () => {
    // 로컬 스토리지에 저장 (모든 인증을 완료했을 경우에 저장)
    sessionStorage.setItem("user", props.userinfocode)
  }

  return (
    <Fragment>
      <table align = "center">
      <td><img src={Election_logo} height="20" alt="투표로고이미지"/></td>
      <td> <h1>사용자 인증 완료</h1></td>
      </table>
      <table bgcolor="#E6E6E6" align = "center" style={{padding: 30}}>
      <h2 style={{color: "#819FF7"}}><u>전자 투표 시 준수사항</u></h2>
      <p style={{textAlign:"left"}}>전자 투표로 진행함에 있어 부정 투표를 방지하기 위하여
         투표 진행 시 <span style={{color: "#819FF7"}}>개개인의 투표 정보가 기록</span>됩니다.<br></br>
        만약 아래 사항을 <span style={{color: "#819FF7"}}>위반할 경우 관련법에 따라 조치될 수 있음</span>을 알려드립니다. </p>
      <p style={{textAlign:"left", fontSize:"small"}}> &nbsp;&nbsp; 1. 본인 외 다른 사람의 대리 투표를 하지 않는다.<br></br>
      &nbsp;&nbsp; 2. 본인 인증에 사용된 사진 및 지문 촬영본 기록을 남기는 것에 대해 동의한다.</p>
      </table>
      <table align = "center"  style={{padding: 40}}>
      <p style={{textAlign:"left"}}> <img src={Exclamation_mark} height="20" alt="주의사항이미지"/>
      주의사항</p>
      <p style={{textAlign:"left"}}>1. 투표 도중 정전 등의 사고로 투표가 중단될 경우,
        새로이 투표 사이트에 접속 후 재인증을 하시면 투표가 가능합니다.<br></br>
        2. 카메라, 지문 인증 시 기기 및 통신 사정에 따라 3초-1분 이상 걸릴 수 있습니다. </p>
      </table>
      <p bold style={{color: "#151515"}}>위의 사항에 대해 동의합니다.</p>
      <Link to={url}>
        <Button variant="contained" color="primary" onClick={click}>
          동의 함
        </Button>
      </Link>
    </Fragment>
  );
};

export default UserAuthComplete;
