import React, { useState, useEffect } from "react";
import MaterialTable from "material-table";
import LinearProgress from "@material-ui/core/LinearProgress";

import axios from "axios";

export default function VoterTable(props) {
  const areaCode = {};
  for (let i in props.areaCode) {
    areaCode[props.areaCode[i].areaCode] = props.areaCode[i].name;
  }

  const [state, setState] = React.useState({
    columns: [
      {
        title: "주민등록번호",
        field: "id_num",
        editable: "onAdd",
        render: rowData => {
          if (rowData.id_num !== null) {
            return (
              rowData.id_num.substr(0, 6) +
              "*".repeat(rowData.id_num.substr(6).length)
            );
          } else {
            return rowData.id_num;
          }
        }
      },
      {
        title: "이름",
        field: "name"
      },
      {
        title: "지역",
        field: "areaCode",
        lookup: areaCode
      }
    ],
    data: []
  });

  const [loading, setLoading] = useState(false);

  useEffect(() => {
    const fetchData = async () => {
      setLoading(true);
      try {
        const response = await axios.get(
          "http://54.180.134.217:8080/api/voter/getVoterAllList"
        );
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
      title="투표자 관리"
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
              axios
                .post(
                  "http://54.180.134.217:8080/api/voter/insertVoter",
                  JSON.stringify(insertData),
                  {
                    headers: { "Content-Type": "application/json" }
                  }
                )
                .then(ret => {
                  if (ret.data === "success") {
                    setState(prevState => {
                      const data = [...prevState.data];
                      data.push(newData);
                      return { ...prevState, data };
                    });
                  }
                })
                .catch(error => console.log(error));
            }, 600);
          }),
        onRowUpdate: (newData, oldData) =>
          new Promise(resolve => {
            setTimeout(() => {
              resolve();

              let updateData = { ...newData };
              axios
                .put(
                  "http://54.180.134.217:8080/api/voter/updateVoter",
                  JSON.stringify(updateData),
                  {
                    headers: { "Content-Type": "application/json" }
                  }
                )
                .then(ret => {
                  console.log(ret);
                  if (ret.data === "success") {
                    if (oldData) {
                      setState(prevState => {
                        const data = [...prevState.data];
                        data[data.indexOf(oldData)] = newData;
                        return { ...prevState, data };
                      });
                    }
                  }
                })
                .catch(error => console.log(error));
            }, 600);
          }),
        onRowDelete: oldData =>
          new Promise(resolve => {
            setTimeout(() => {
              resolve();

              axios
                .delete(
                  "http://54.180.134.217:8080/api/voter/delVoter/" +
                    oldData.code
                )
                .then(ret => {
                  if (ret.data === "success") {
                    setState(prevState => {
                      const data = [...prevState.data];
                      data.splice(data.indexOf(oldData), 1);
                      return { ...prevState, data };
                    });
                  }
                })
                .catch(error => console.log(error));
            }, 600);
          })
      }}
    />
  );
}
