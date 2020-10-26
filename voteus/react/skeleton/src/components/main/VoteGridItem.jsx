import React from "react";
import { makeStyles, Grid, Typography, Avatar } from "@material-ui/core";

import FavoriteSharpIcon from "@material-ui/icons/FavoriteSharp";
import VisibilityIcon from "@material-ui/icons/Visibility";

const useStyles = makeStyles(theme => ({
  large: {
    width: "100%",
    height: "100%",
    // height: "30vh",

    borderRadius: "5px"
  },
  img: {
    width: "100%",
    // height: "30vh",
    // minHeight: "200px",
    height: 480,
    minHeight: "inset",
    [theme.breakpoints.down("xs")]: {
      height: "unset",
      minHeight: "480px"
    },
    borderRadius: "5px",
    transition: "transform 1s ease",
    "&:hover": {
      transform: "scale(1.1)"
    }
  },
  infoOpenHandlerGrid: {
    cursor: "pointer"
  },
  infoOpenHandlerGridItemTypography1: {
    padding: "5px 0 0 10px",
    fontWeight: "bold",
    fontSize: 13,
    fontFamily: "Noto Sans KR",
    color: "#191919"
  },
  infoOpenHandlerGridItemTypography2: {
    fontSize: 11,
    fontWeight: 700,
    padding: "0 10px 0 5px",
    color: "#696969"
  },
  infoOpenHandlerGridItemTypography3: {
    fontSize: 11,
    fontWeight: 700,
    color: "#696969"
  },
  infoOpenHandlerGridItemGrid: {
    marginTop: "5px"
  },
  infoOpenHandlerGridItemFaIcon: {
    fontSize: "17px",
    color: "#696969"
  },
  infoOpenHandlerGridItemViIcon: {
    fontSize: "21px",
    paddingRight: 5,
    color: "#696969"
  }
}));

const GridBottomGroup = props => {
  const classes = useStyles();
  const { index } = props;

  const feedCount = Math.floor(Math.random() * (100 + 1));
  const votingCount = Math.floor(Math.random() * (100 + 1));
  const voteTitle = `vote title ${index}`;

  return (
    <Grid
      item
      container
      direction="row"
      justify="space-between"
      alignItems="center"
    >
      <Grid item>
        <Typography
          className={classes.infoOpenHandlerGridItemTypography1}
          variant="subtitle1"
        >
          {voteTitle}
        </Typography>
      </Grid>
      <Grid item>
        <Grid
          container
          direction="row"
          alignItems="center"
          justify="center"
          className={classes.infoOpenHandlerGridItemGrid}
        >
          <FavoriteSharpIcon
            className={classes.infoOpenHandlerGridItemFaIcon}
          />
          <Typography
            variant="subtitle1"
            component="span"
            className={classes.infoOpenHandlerGridItemTypography2}
          >
            {feedCount}
          </Typography>
          <VisibilityIcon className={classes.infoOpenHandlerGridItemViIcon} />
          <Typography
            variant="subtitle1"
            component="span"
            className={classes.infoOpenHandlerGridItemTypography3}
          >
            {votingCount}
          </Typography>
        </Grid>
      </Grid>
    </Grid>
  );
};

const VoteGridItem = props => {
  const classes = useStyles();
  const { index } = props;
  const srcURL = `https://picsum.photos/id/${10 + index}/1600/900.webp`;

  return (
    <div className={classes.root}>
      <Grid container className={classes.infoOpenHandlerGrid}>
        <Grid item xs={12}>
          <Avatar
            variant="square"
            src={srcURL}
            className={classes.large}
            imgProps={{
              className: classes.img
            }}
          />
        </Grid>
        <Grid item xs={12}>
          <GridBottomGroup index={index} />
        </Grid>
      </Grid>
    </div>
  );
};
export default VoteGridItem;
