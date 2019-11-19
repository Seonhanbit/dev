import axios from "axios";

export default axios.create({
  //baseURL: "http://192.168.28.129:8197/ssafyvue/api",
  baseURL: "http://localhost:8197/ssafyvue/api",
  headers: {
    "Content-type": "application/json"
  }
});