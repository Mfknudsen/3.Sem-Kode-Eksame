import React from "react";
import { useState, useEffect } from "react";

const urlAPI = "http://localhost:8080/Backend_war_exploded/api/";
const urlAuctions = urlAPI + "Auction";

const application_json = () => {
    var ops = {
        headers: { 
        'Content-Type': 'application/json',
        'Accept': 'application/json',
        }
    }
    return ops;

}

function handleHttpErrors(response) {
    if (!response.ok) {
        return Promise.reject({ status: response.status, fullError: response.json() })
    }
    return response.json();
}

function BackendAPI(){
    const GetAllAuctions = () =>{
        const [json, setJson] = useState([]);
        const getData = async () => {
            const response = await fetch(urlAuctions, application_json);
            const json = await response.json();
            setJson(json);
        }
        
        useEffect(() => {
            getData()
        }, [])

        return json;
    }
    
    const login = (user, password) => {
        const options = makeOptions("POST", true, { username: user, password: password });
        return fetch(urlAPI + "login", options)
            .then(handleHttpErrors)
            .then(response => { setToken(response.token) })
    };
    const register = (user, password) => {
        console.log(user);
        console.log(password);
        const options = makeOptions("POST", false, { username: user, password: password });
        return fetch(URL + "/api/register", options)
            .then(handleHttpErrors)
    }
    const fetchData = () => {
        const options = makeOptions("GET", true);
        return fetch(URL + "/api/info/user", options).then(handleHttpErrors);
    }
    const makeOptions = (method, addToken, body) => {
        var opts = {
            method: method,
            headers: {
                "Content-type": "application/json",
                'Accept': 'application/json',
            }
        }
        if (addToken && loggedIn()) {
            opts.headers["x-access-token"] = getToken();
        }
        if (body) {
            opts.body = JSON.stringify(body);
        }
        return opts;
    }
    const setToken = (token) => {
        localStorage.setItem('jwtToken', token);
    }
    const getToken = () => {
        return localStorage.getItem('jwtToken');
    }
    const loggedIn = () => {
        const loggedIn = getToken() != null;
        return loggedIn;
    }
    const logout = () => {
        localStorage.removeItem('jwtToken');
    }
    return {
        GetAllAuctions,
        makeOptions,
        setToken,
        getToken,
        loggedIn,
        login,
        register,
        logout,
        fetchData
    }
}
const facade = BackendAPI();
export default facade;