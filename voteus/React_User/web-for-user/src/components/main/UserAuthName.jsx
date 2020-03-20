import React, { useState, Fragment, useMemo, useCallback } from "react";
import axios from "axios";
import Grid from "@material-ui/core/Grid";
import TextField from "@material-ui/core/TextField";
import Button from "@material-ui/core/Button";
import { Alert, AlertTitle } from "@material-ui/lab";

// keyboard
import Keyboard from "react-simple-keyboard";
import "react-simple-keyboard/build/css/index.css";
import BirthKeyboard from "../keyboard/BirthKeyboard";
import AreaKeyboard from "../keyboard/AreaKeyboard";

import * as Hangul from 'hangul-js';

const UserAuthName = props => {

  const [commit, setCommit] = useState(false);
  const [loginState, setLoginState] = useState(true);
  const [name, setName] = useState("");
  const [birth_registration_number, setBirthRegistrationNumber] = useState("");
  const [area_registration_number, setAreaRegistrationNumber] = useState("");
  const [layoutname, setLayoutName] = useState("default");
  const [showkeyboardname, setShowKeyboardName] = useState(false);
  const [showkeyboardbirth, setShowKeyboardBirth] = useState(false);
  const [showkeyboardarea, setShowKeyboardArea] = useState(false);
  const [clickwhere, setClickWhere] = useState(null);

  const inputRef = React.useRef();
  const keyboard = React.useRef();

  const nameError = useMemo(() => (name.length < 2 ? true : false), [name]);
  const namePopup = useMemo(() => {
    if (commit) {
      return name.length >= 2 ? false : true;
    } else {
      return name.length === 0 || name.length >= 2 ? false : true;
    }
  }, [name, commit]);

  const birthRegError = useMemo(
    () => (birth_registration_number.length === 6 ? false : true),
    [birth_registration_number]
  );

  const birthRegPopup = useMemo(() => {
    if (commit) {
      return birth_registration_number.length === 6 ? false : true;
    } else {
      return birth_registration_number.length === 0 ||
        birth_registration_number.length === 6
        ? false
        : true;
    }
  }, [birth_registration_number, commit]);

  const areaRegError = useMemo(
    () => (area_registration_number.length === 7 ? false : true),
    [area_registration_number]
  );
  const areaRegPopup = useMemo(() => {
    if (commit) {
      return area_registration_number.length === 7 ? false : true;
    } else {
      return area_registration_number.length === 0 ||
        area_registration_number.length === 7
        ? false
        : true;
    }
  }, [area_registration_number, commit]);

  const handleChangeName = useCallback(e => {
    // console.log(e.target.value)
    setName(e.target.value);
    keyboard.current.setInput("김")
  }, []);

  const handleChangeBirthRegistrationNumber = useCallback(e => {
    setBirthRegistrationNumber(e.target.value);
  }, []);

  const handleChangeAreaRegistrationNumber = useCallback(e => {
    setAreaRegistrationNumber(e.target.value);
  }, []);

  const handleSubmit = e => {
    e.preventDefault();
    setCommit(true);

    const registration_number =
      birth_registration_number + area_registration_number;

    if (!nameError && !birthRegError && !areaRegError) {
      // axios
      axios
        .get(
          "http://54.180.134.217:8080/api/voter/getOnlyVotercode/" +
            name +
            "/" +
            registration_number
        )
        .then(res => {
          if (res.data !== "failure") {
            props.setUserInfo({ code: res.data, name: name });
            props.setNumber(number => number + 1);
            setLoginState(true);
          } else {
            setLoginState(false);
          }
        })
        .catch(res => console.log(res));
    }
  };

  const keyChangeName = input => {
    keyboard.current.setInput(Hangul.assemble(input))
    let tempname = Hangul.assemble(input)
    setName(tempname)
  }

  const keyPressName = (button) => {
    if (layoutname === "shift") {
      handleShift()
    } else if ( button === "{shift}" || button === "{lock}") {
      handleShift()
    }
  }

  const handleShift = () => {
    if (layoutname === "default") {
      setLayoutName("shift")
    } else {
      setLayoutName("default")
    }
  }

  const keyChangeBirth = input => {
    setBirthRegistrationNumber(input)
  }

  const keyPressBirth = (button) => {
  }

  const keyChangeArea = input => {
    setAreaRegistrationNumber(input)
  }

  const keyPressArea = (button) => {
  }

  const keyboardClickName = () => {
    if (clickwhere === "name") {
      setClickWhere("name")
    } else {
      setName("")
    }
    setClickWhere("name")
    setShowKeyboardBirth(false)
    setShowKeyboardArea(false)
    setShowKeyboardName(true)
  }

  const keyboardClickBirth = () => {
    if (clickwhere === "birth") {
      setClickWhere("birth")
    } else {
      setBirthRegistrationNumber("")
    }
    setClickWhere("birth")
    setShowKeyboardName(false)
    setShowKeyboardArea(false)
    setShowKeyboardBirth(true)
  }

  const keyboardClickArea = () => {
    if (clickwhere === "area") {
      setClickWhere("area")
    } else {
      setAreaRegistrationNumber("")
    }
    setClickWhere("area")
    setShowKeyboardName(false)
    setShowKeyboardBirth(false)
    setShowKeyboardArea(true)
  }

  const outClick = () => {
    setShowKeyboardName(false)
    setShowKeyboardBirth(false)
    setShowKeyboardArea(false)
    setClickWhere(null)
  }

  return (
    <Fragment>
      <h1 onClick={outClick}>투표 시작 전 인증을 시작합니다.</h1>
      <form onSubmit={handleSubmit}>
        <Grid container spacing={3}>
          <Grid item xs={12}>
            <TextField
              id="standard-full-width"
              label="이름"
              placeholder="이름을 입력해주세요."
              helperText={namePopup ? "2글자이상 입력해주세요." : " "}
              fullWidth
              margin="normal"
              InputLabelProps={{
                shrink: true
              }}
              type="text"
              value={name}
              onChange={handleChangeName}
              autoComplete="off"
              error={namePopup}
              onClick={keyboardClickName}
              inputRef={inputRef}
            />
            {showkeyboardname === true ? (
              <Keyboard
                layoutName={layoutname}
                onChange={keyChangeName}
                onKeyPress={keyPressName}
                keyboardRef={r => (keyboard.current = r)}
                // 뒤에서부터 지워지도록 설정
                // disableCaretPositioning={true}
                layout={{
                  default: [
                    "` 1 2 3 4 5 6 7 8 9 0 - = {bksp}",
                    "{tab} ㅂ ㅈ ㄷ ㄱ ㅅ ㅛ ㅕ ㅑ ㅐ ㅔ [ ] \\",
                    "{lock} ㅁ ㄴ ㅇ ㄹ ㅎ ㅗ ㅓ ㅏ ㅣ ; ' {enter}",
                    "{shift} ㅋ ㅌ ㅊ ㅍ ㅠ ㅜ ㅡ , . / {shift}",
                  ],
                  shift: [
                    "~ ! @ # $ % ^ & * ( ) _ + {bksp}",
                    "{tab} ㅃ ㅉ ㄸ ㄲ ㅆ ㅛ ㅕ ㅑ ㅒ ㅖ { } |",
                    '{lock} ㅁ ㄴ ㅇ ㄹ ㅎ ㅗ ㅓ ㅏ ㅣ : " {enter}',
                    "{shift} ㅋ ㅌ ㅊ ㅍ ㅠ ㅜ ㅡ < > ? {shift}",
                  ]
                }}
              />
            ):(
              null
            )}
          </Grid>
          <Grid item xs={12}>
            <Grid container>
              <Grid item xs={6}>
                <TextField
                  id="standard-full-width"
                  label="주민등록번호"
                  placeholder="앞번호 6자리"
                  helperText={
                    birthRegPopup ? "주민등록번호 앞 6자리를 입력해주세요." : " "
                  }
                  fullWidth
                  margin="normal"
                  InputLabelProps={{
                    shrink: true
                  }}
                  type="text"
                  value={birth_registration_number}
                  onChange={handleChangeBirthRegistrationNumber}
                  autoComplete="off"
                  error={birthRegPopup}
                  inputProps={{
                    maxLength: 6
                  }}
                  onClick={keyboardClickBirth}
                />
              </Grid>
              <Grid item xs={6}>
                <TextField
                  id="standard-full-width"
                  label=" "
                  placeholder="뒷번호 7자리"
                  helperText={
                    areaRegPopup ? "주민등록번호 뒷 7자리를 입력해주세요." : " "
                  }
                  fullWidth
                  margin="normal"
                  InputLabelProps={{
                    shrink: true
                  }}
                  type="password"
                  value={area_registration_number}
                  onChange={handleChangeAreaRegistrationNumber}
                  autoComplete="off"
                  error={areaRegPopup}
                  inputProps={{
                    maxLength: 7
                  }}
                  onClick={keyboardClickArea}
                />
              </Grid>
            </Grid>

            <Grid item xs={12}>
              {showkeyboardbirth === true ? (
                <BirthKeyboard
                  keyChangeBirth={keyChangeBirth}
                  keyPressBirth={keyPressBirth}
                />
              ):(
                null
              )}
              {showkeyboardarea === true ? (
                <AreaKeyboard
                  keyChangeArea={keyChangeArea}
                  keyPressArea={keyPressArea}
                />
              ):(
                null
              )}
            </Grid>
          </Grid>
          
          {!loginState && (
            <Grid item xs={12}>
              <Alert severity="error">
                <AlertTitle style={{ textAlign: "left", fontWeight: "bold" }}>
                  인증 실패
                </AlertTitle>
                등록된 정보가 없습니다. 이름과 주민등록번호를 확인해주세요.
              </Alert>
            </Grid>
          )}
          <Grid item xs={12}>
            <Button
              variant="contained"
              size="large"
              color="primary"
              fullWidth={true}
              type="submit"
              onClick={outClick}
            >
              인증
            </Button>
          </Grid>
        </Grid>
      </form>
    </Fragment>
  );
};

export default UserAuthName;
