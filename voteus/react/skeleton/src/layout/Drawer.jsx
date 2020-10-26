import React from "react";
import { makeStyles } from "@material-ui/core/styles";
import Drawer from "@material-ui/core/Drawer";
import List from "@material-ui/core/List";
import Divider from "@material-ui/core/Divider";
import ListItem from "@material-ui/core/ListItem";
import ListItemIcon from "@material-ui/core/ListItemIcon";
import ListItemText from "@material-ui/core/ListItemText";
import { IconButton } from "@material-ui/core";
import MenuIcon from "@material-ui/icons/Menu";
import { Link } from "react-router-dom";
import HowToVoteIcon from "@material-ui/icons/HowToVote";
import HomeWorkIcon from "@material-ui/icons/HomeWork";
import AccountBalanceIcon from "@material-ui/icons/AccountBalance";
import ClassIcon from "@material-ui/icons/Class";
import PermIdentityIcon from "@material-ui/icons/PermIdentity";

const useStyles = makeStyles({
  list: {
    width: 250
  },
  fullList: {
    width: "auto"
  },
  link: {
    // color: "rgba(0, 0, 0, 0.87)",
    color: "inherit",
    textDecorationLine: "none"
  }
});

export default function TemporaryDrawer() {
  const classes = useStyles();
  const [state, setState] = React.useState({
    top: false,
    left: false,
    bottom: false,
    right: false
  });

  const toggleDrawer = (side, open) => event => {
    if (
      event.type === "keydown" &&
      (event.key === "Tab" || event.key === "Shift")
    ) {
      return;
    }

    setState({ ...state, [side]: open });
  };

  const sideList = side => (
    <div
      className={classes.list}
      role="presentation"
      onClick={toggleDrawer(side, false)}
      onKeyDown={toggleDrawer(side, false)}
    >
      <List>
        {[
          {
            name: "투표 관리",
            url: "/VoteList",
            img: <HowToVoteIcon />
          }
        ].map((obj, index) => (
          <Link key={index} to={obj.url} className={classes.link}>
            <ListItem button key={obj.name}>
              <ListItemIcon>{obj.img}</ListItemIcon>
              <ListItemText primary={obj.name} />
            </ListItem>
          </Link>
        ))}
      </List>
      <Divider />
      <List>
        {[
          {
            name: "정당 관리",
            url: "/PartyList",
            img: <AccountBalanceIcon />
          },
          {
            name: "지역구 관리",
            url: "/AreaList",
            img: <HomeWorkIcon />
          },
          {
            name: "선거 분류 관리",
            url: "/MainPartList",
            img: <ClassIcon />
          },
          {
            name: "투표자 등록",
            url: "/VoterList",
            img: <PermIdentityIcon />
          }
        ].map((obj, index) => (
          <Link key={index} to={obj.url} className={classes.link}>
            <ListItem button key={obj.name}>
              <ListItemIcon>{obj.img}</ListItemIcon>
              <ListItemText primary={obj.name} />
            </ListItem>
          </Link>
        ))}
      </List>
    </div>
  );

  return (
    <div>
      <IconButton
        color="inherit"
        aria-label="open drawer"
        onClick={toggleDrawer("left", true)}
        edge="start"
        className={classes.menuButton}
      >
        <MenuIcon />
      </IconButton>
      {/* <Button onClick={toggleDrawer("left", true)}>Open Left</Button> */}
      <Drawer open={state.left} onClose={toggleDrawer("left", false)}>
        {sideList("left")}
      </Drawer>
    </div>
  );
}
