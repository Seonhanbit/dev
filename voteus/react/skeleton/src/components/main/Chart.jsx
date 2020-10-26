import React, { useState, useEffect } from "react";
import {
  BarChart,
  Bar,
  Brush,
  ReferenceLine,
  XAxis,
  YAxis,
  CartesianGrid,
  Tooltip,
  Legend,
  ResponsiveContainer
} from "recharts";
import LinearProgress from "@material-ui/core/LinearProgress";
import axios from "axios";
import { date_to_str_onlyDate } from "../../common.js";

const Chart = props => {
  const [loading, setLoading] = useState(false);
  const [data, setData] = useState([]);
  const [candidate, setCandidate] = useState([]);
  const [refresh, setRefresh] = useState(false);

  useEffect(() => {
    const [voteCode] = props.selected;
    const fetchData = async () => {
      setLoading(true);
      const nowDate = date_to_str_onlyDate(new Date());
      let tmp = [];
      for (let i = 6; i <= 18; i++) {
        tmp.push({ name: (i < 10 ? "0" + i : i) + ":00", time: i });
      }

      if (voteCode != null) {
        try {
          const candiResponse = await axios.get(
            "http://54.180.134.217:8080/api/candi/getCandiVotecode/" + voteCode
          );

          if (candiResponse.data !== "failure") {
            setCandidate(candiResponse.data);
            for (const item of tmp) {
              for (const candi of candiResponse.data) {
                item[candi.name] = 0;
              }
            }
          }

          for (const item of tmp) {
            const response = await axios.get(
              "http://54.180.134.217:8080/api/statistics/getCandiPick/" +
                voteCode +
                "/" +
                nowDate +
                "/" +
                item.time
            );

            if (response.data.length > 0) {
              for (const score of response.data) {
                item[score.name] += score.pick;
              }
            }
          }
          setData(tmp);
        } catch (e) {
          console.log(e);
        }
      } else {
        setCandidate([]);
      }
      setLoading(false);
    };
    fetchData();
  }, [props.selected, refresh]);

  const timer = setTimeout(() => {
    setRefresh(refresh ? false : true);
    console.log("타이머작동");
  }, 20000);

  return (
    <>
      <h1>선거 모니터링 (시간대별 득표수)</h1>
      {loading ? (
        <LinearProgress />
      ) : data.length === 0 ? (
        <p>모니터링할 투표를 선택해주세요.</p>
      ) : (
        <ResponsiveContainer width="100%" height={300}>
          <BarChart
            data={data}
            margin={{
              top: 5,
              right: 30,
              left: 20,
              bottom: 5
            }}
          >
            <CartesianGrid strokeDasharray="3 3" />
            <XAxis dataKey="name" />
            <Tooltip />
            <Legend verticalAlign="top" />
            <ReferenceLine y={0} stroke="#000" />
            <YAxis type="number" domain={[0, "auto"]} allowDecimals={false} />
            {candidate.map(candi => (
              <Bar
                key={candi.code}
                dataKey={candi.name}
                fill={`#${Math.round(Math.random() * 0xffffff).toString(16)}`}
              />
            ))}
            <Brush dataKey="name" height={50} stroke="#8884d8" />
          </BarChart>
        </ResponsiveContainer>
      )}
    </>
  );
};

export default Chart;
