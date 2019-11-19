import axios from 'axios'
  const apiCall = ({...args}) => new Promise((resolve, reject) => {
    //console.log(args["data"])
    //data: {usernameOrEmail: "cccccc", password: "cccccc"}
    //axios.post('http://192.168.28.129:8397/api/auth/signin', args["data"]).then(({data}) => {
      axios.post('http://localhost:8397/api/auth/signin', args["data"]).then(({data}) => {
      //console.log(data)
      resolve(data)
    }).catch((error) => {
      //reject(new Error(error))
      reject(error)
    })
  })
  


  export default apiCall