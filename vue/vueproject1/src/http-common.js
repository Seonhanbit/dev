import axios from "axios";

export default axios.create({
  baseURL: "http://localhost:8197/ssafyvue/api",
  headers: {
    "Content-type": "application/json",
  }
});