import React, { Fragment } from "react";
import FlexPaperTemplate from "../components/main/FlexPaperTemplate";
import { Button } from "@material-ui/core";
import { Link } from 'react-router-dom';

const PageNotFound = props => {
  const clear = () => {
    sessionStorage.clear();
  }

  return (
    <Fragment>
      <FlexPaperTemplate>
        <h1>페이지를 찾을 수 없습니다.</h1>
        <Link to="/">
          <Button
            variant="contained"
            size="large"
            color="primary"
            onClick={clear}
          >
            돌아가기
          </Button>
        </Link>
      </FlexPaperTemplate>
      {/* <UserFooter /> */}
    </Fragment>
  )
}

export default PageNotFound
