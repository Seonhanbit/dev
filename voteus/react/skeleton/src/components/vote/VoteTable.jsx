import React, { useState, useEffect } from "react";
import MaterialTable from "material-table";
import date_to_str from "../../common.js";
import { Link } from "react-router-dom";
import LinearProgress from "@material-ui/core/LinearProgress";

import axios from "axios";

export default function VoteTable(props) {
  const middlepart = {};
  for (let i in props.middlepart) {
    middlepart[props.middlepart[i].code] = props.middlepart[i].name;
  }

  const [state, setState] = React.useState({
    columns: [
      {
        title: "선거분류",
        field: "middlepart",
        lookup: middlepart
      },
      {
        title: "투표명",
        field: "name",
        render: rowData => {
          const href = "/CandidateList/" + rowData.code + "/" + rowData.name;
          return (
            <Link
              key={rowData.index}
              to={href}
              style={{ color: "#3f51b5", textDecorationLine: "none" }}
            >
              {rowData.name}
            </Link>
          );
        }
      },
      {
        title: "시작일",
        field: "start",
        type: "datetime"
      },
      {
        title: "종료일",
        field: "end",
        type: "datetime"
      }
    ],
    // data:
    data: []
  });

  const [loading, setLoading] = useState(false);

  useEffect(() => {
    const fetchData = async () => {
      setLoading(true);
      try {
        const token = "Bearer " + sessionStorage.getItem("token");
        const response = await axios({
          method: "GET",
          url: "http://54.180.134.217:8080/api/vote/getVoteAllList",
          headers: { Authorization: token }
        });
        const restate = {
          ...state,
          data: response.data
        };
        setState(restate);
      } catch (e) {
        console.log(e);
      }
      setLoading(false);
    };
    fetchData();
  }, []);

  if (loading) {
    return (
      <>
        <LinearProgress />
      </>
    );
  }

  return (
    <MaterialTable
      title="투표 관리"
      columns={state.columns}
      data={state.data}
      localization={{
        toolbar: {
          searchTooltip: "검색",
          searchPlaceholder: "검색"
        },
        body: {
          emptyDataSourceMessage: "데이터가 존재하지 않습니다.",
          editTooltip: "수정",
          deleteTooltip: "삭제",
          editRow: {
            deleteText: "정말 삭제하시겠습니까?",
            cancelTooltip: "취소",
            saveTooltip: "저장"
          }
        },
        pagination: {
          labelRowsSelect: "줄 표시",
          firstTooltip: "첫 페이지",
          nextTooltip: "다음 페이지",
          lastTooltip: "마지막 페이지",
          previousTooltip: "이전 페이지",
          labelDisplayedRows: "총 {count} : {from}-{to}"
        }
      }}
      editable={{
        onRowAdd: newData =>
          new Promise(resolve => {
            setTimeout(() => {
              resolve();

              let insertData = { ...newData };
              insertData.start = date_to_str(insertData.start);
              insertData.end = date_to_str(insertData.end);
              axios
                .post(
                  "http://54.180.134.217:8080/api/vote/insertVote",
                  JSON.stringify(insertData),
                  {
                    headers: { "Content-Type": "application/json" }
                  }
                )
                .then(ret => console.log(ret))
                .catch(error => console.log(error));

              setState(prevState => {
                const data = [...prevState.data];
                data.push(newData);
                return { ...prevState, data };
              });
            }, 600);
          }),
        onRowUpdate: (newData, oldData) =>
          new Promise(resolve => {
            setTimeout(() => {
              resolve();

              let updateData = { ...newData };
              updateData.start = date_to_str(
                new Date(Date.parse(updateData.start))
              );
              updateData.end = date_to_str(
                new Date(Date.parse(updateData.end))
              );
              axios
                .put(
                  "http://54.180.134.217:8080/api/vote/updateVote",
                  JSON.stringify(updateData),
                  {
                    headers: { "Content-Type": "application/json" }
                  }
                )
                .then(ret => console.log(ret))
                .catch(error => console.log(error));

              if (oldData) {
                setState(prevState => {
                  const data = [...prevState.data];
                  data[data.indexOf(oldData)] = newData;
                  return { ...prevState, data };
                });
              }
            }, 600);
          }),
        onRowDelete: oldData =>
          new Promise(resolve => {
            setTimeout(() => {
              resolve();

              axios
                .delete(
                  "http://54.180.134.217:8080/api/vote/delVote/" + oldData.code
                )
                .then(ret => console.log(ret))
                .catch(error => console.log(error));

              setState(prevState => {
                const data = [...prevState.data];
                data.splice(data.indexOf(oldData), 1);
                return { ...prevState, data };
              });
            }, 600);
          })
      }}
    />
  );
}
