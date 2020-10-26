import React, { useState } from "react";
import {
  GridList,
  Grid,
  useMediaQuery,
  makeStyles,
  MenuItem,
  FormControl,
  Select
} from "@material-ui/core";
import VoteGridItem from "./VoteGridItem";

import { useNowCols } from "../common/MediaQueryHooks";
import TuneIcon from "@material-ui/icons/Tune";

const useStyles = makeStyles(theme => ({
  root: {
    display: "flex",
    flexWrap: "wrap",
    justifyContent: "space-around",
    overflow: "hidden",
    backgroundColor: theme.palette.background.paper
  },

  gridList: {
    width: "100%"
  },
  VoteGridListGridItem: {
    padding: "5px 5px 0 10px",
    color: "#5D5D5D"
  }
}));

const ImageGridFilter = props => {
  const { filterItem, onChangeFilterItem } = props;
  const classes = useStyles();

  const items = [
    { key: "default", value: "Filter", disabled: true },
    { key: "recently", value: "Recently", disabled: false },
    { key: "comments", value: "Most comments", disabled: false },
    { key: "votes", value: "Most Votes", disabled: false }
  ];

  return (
    <FormControl className={classes.formControl}>
      <Select
        labelId="demo-simple-select-label"
        id="demo-simple-select"
        value={filterItem}
        onChange={onChangeFilterItem}
        className={classes.ImageGridFilterSelect}
        disableUnderline
      >
        {items.map(item => (
          <MenuItem key={item.key} value={item.key} disabled={item.disabled}>
            {item.value}
          </MenuItem>
        ))}
      </Select>
    </FormControl>
  );
};

const VoteGridList = () => {
  const classes = useStyles();
  const nowCols = useNowCols();

  const [filterItem, setFilterItem] = useState("default");

  const onChangeFilterItem = event => {
    setFilterItem(event.target.value);
  };

  return (
    <div className={classes.root}>
      <Grid
        container
        justify="left"
        alignItems="center"
        className={classes.VoteGridListGrid}
      >
        <Grid item className={classes.VoteGridListGridItem}>
          <TuneIcon />
        </Grid>
        <Grid item>
          <ImageGridFilter
            filterItem={filterItem}
            onChangeFilterItem={onChangeFilterItem}
          />
        </Grid>
      </Grid>
      <GridList className={classes.gridList} cols={nowCols} cellHeight={"auto"}>
        >
        {new Array(50).fill("").map((x, index) => (
          <Grid item key={index}>
            <VoteGridItem itemData={x} index={index} />
          </Grid>
        ))}
      </GridList>
    </div>
  );
};
export default VoteGridList;
