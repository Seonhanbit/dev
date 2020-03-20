import React from "react";
import Keyboard from "react-simple-keyboard";
import "react-simple-keyboard/build/css/index.css";

const BirthKeyboard = props => {
  return (
    <Keyboard
      onChange={props.keyChangeBirth}
      onKeyPress={props.keyPressBirth}
      maxLength={6}
      layout={{
        default: [
          "1 2 3 4 5 6 7 8 9 0 {bksp}",
        ],
      }}
    />
  )
}

export default BirthKeyboard;