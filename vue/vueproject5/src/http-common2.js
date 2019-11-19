import axios from "axios";

export default axios.create({
  //baseURL: "http://192.168.28.129:8397/api/auth",
  baseURL: "http://localhost:8397/api/auth",
  headers: {
    "Content-type": "application/json"
  }
});