import React, { useState, useEffect } from "react";
import {
  PieChart,
  Pie,
  Cell,
  ResponsiveContainer,
  Tooltip,
  Legend
} from "recharts";
import LinearProgress from "@material-ui/core/LinearProgress";
import axios from "axios";

const COLORS = ["#00C49F", "#FF8042"];

const RADIAN = Math.PI / 180;
const renderCustomizedLabel = ({
  cx,
  cy,
  midAngle,
  innerRadius,
  outerRadius,
  percent,
  index
}) => {
  const radius = innerRadius + (outerRadius - innerRadius) * 0.5;
  const x = cx + radius * Math.cos(-midAngle * RADIAN);
  const y = cy + radius * Math.sin(-midAngle * RADIAN);

  return (
    <text
      x={x}
      y={y}
      fill="white"
      textAnchor={x > cx ? "start" : "end"}
      dominantBaseline="central"
    >
      {`${(percent * 100).toFixed(0)}%`}
    </text>
  );
};

const Circle = props => {
  const [loading, setLoading] = useState(false);
  const [data, setData] = useState([]);
  const [refresh, setRefresh] = useState(false);

  useEffect(() => {
    const [voteCode] = props.selected;
    const fetchData = async () => {
      setLoading(true);

      if (voteCode != null) {
        try {
          const res = await axios.get(
            "http://54.180.134.217:8080/api/voter/voteProgressData/" + voteCode
          );
          console.log(res.data.result);
          if (res.data.resmsg === "success") {
            const tmp = [
              { name: "투표", value: res.data.result.completeCnt },
              { name: "미투표", value: res.data.result.incompleteCnt }
            ];
            setData(tmp);
            console.log(tmp);
          }
        } catch (e) {
          console.log(e);
        }
      } else {
        setData([]);
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
      <h1>투표진행률(%)</h1>
      {loading ? (
        <LinearProgress />
      ) : (
        <ResponsiveContainer width="100%" height={300}>
          <PieChart>
            <Legend verticalAlign="top" />
            <Pie
              data={data}
              labelLine={false}
              label={renderCustomizedLabel}
              fill="#8884d8"
              dataKey="value"
            >
              {data.map((entry, index) => (
                <Cell
                  key={`cell-${index}`}
                  fill={COLORS[index % COLORS.length]}
                />
              ))}
            </Pie>
            <Tooltip />
          </PieChart>
        </ResponsiveContainer>
      )}
    </>
  );
};

export default Circle;
