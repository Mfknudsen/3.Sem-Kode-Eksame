import React, { useState, useEffect } from 'react';
import BackendAPI from './API/BackendAPI';

function LogIn({ login }) {
  const init = { username: "", password: "" };
  const [loginCredentials, setLoginCredentials] = useState(init);

  const performLogin = (event) => {
    event.preventDefault();
    login(loginCredentials.username, loginCredentials.password);
  }
  const onChange = (event) => {
    setLoginCredentials({ ...loginCredentials, [event.target.id]: event.target.value })
  }

  return (
    <div>
      <h2>Login</h2>
      <form onChange={onChange}>
        <input type="text" placeholder="User Name" id="username" />
        <input type="text" placeholder="Password" id="password" />
        <button onClick={performLogin}>Login</button>
      </form>
    </div>
  )
}

function RegisterUser({ user }) {
  const init = { username: "", password: "" };
  const [newUserCredentials, setNewUserCredentials] = useState(init);

  const performRegister = (event) => {
    event.preventDefault();
    user(newUserCredentials.username, newUserCredentials.password);
  }
  const onChange = (event) => {
    setNewUserCredentials({ ...newUserCredentials, [event.target.id]: event.target.value })
  }

  return (
    <div>
      <h2>Register new user</h2>
      <form onChange={onChange}>
        <input type="text" placeholder="New user name" id="username" />
        <input type="text" placeholder="New password" id="password" />
        <button onClick={performRegister}>Register</button>
      </form>
    </div>
  )
}

function LoggedIn() {
  const [dataFromServer, setDataFromServer] = useState("Loading...");

  useEffect(() => {
    BackendAPI.fetchData().then(data => setDataFromServer(data.msg));
  }, []);
  
  return (
    <div>
      <h2>Data Received from server</h2>
      <h3>{dataFromServer}</h3>
    </div>
  )
}

function App() {
  const [loggedIn, setLoggedIn] = useState(false);

  const logout = () => {
    BackendAPI.logout()
    setLoggedIn(false)
  }
  const login = (user, pass) => {
    BackendAPI.login(user, pass)
      .then(response => setLoggedIn(true));
  }
  const newUser = (user, pass) => {
    BackendAPI.register(user, pass);
  }

  return (
    <div>
      {!loggedIn ? (<RegisterUser user={newUser} />) : null}
      {!loggedIn ? (<LogIn login={login} />) : 
      (<div>
        <LoggedIn />
        <button onClick={logout}>Logout</button>
      </div>)}
    </div>
  )

}
export default App;