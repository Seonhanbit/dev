import React, { useState, Fragment } from "react";

// component
import UserAuthName from "../components/main/UserAuthName";
import UserAuthFace from "../components/main/UserAuthFace";
import UserAuthFinger from "../components/main/UserAuthFinger";

// context
import UserNameContext from "../context/UserNameContext";

const UserAuthBody = props => {
  const [number, setNumber] = useState(0);
  const [userinfo, setUserInfo] = useState("");

  if (number === 0) {
    return (
      <Fragment>
        <UserAuthName
          number={number}
          setNumber={setNumber}
          userinfo={userinfo}
          setUserInfo={setUserInfo}
        />
      </Fragment>
    );
  } else if (number === 1) {
    return (
      <UserNameContext.Provider value={userinfo.name}>
        <UserAuthFace
          number={number}
          setNumber={setNumber}
          userinfocode={userinfo.code}
        />
      </UserNameContext.Provider>
    );
  } else {
    return (
      <UserNameContext.Provider value={userinfo.name}>
        <UserAuthFinger
          number={number}
          setNumber={setNumber}
          userinfocode={userinfo.code}
        />
      </UserNameContext.Provider>
    );
  }
};

export default UserAuthBody;
