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

    const GetBoats = (id) =>{
        const [json, setJson] = useState([]);

        const options = makeOptions("PUT", true, {id: id});
        const getData = async () => {
            const response = await fetch(urlAPI+"Boat", options)
            const json = await response.json();
            setJson(json)
        }

        useEffect(() => {
            getData();
        });

        return json;
    }

    const AddAuction = (name, location, time, date) => {
        const options = makeOptions("POST", true, { name: name, location: location, time: time, date: date});
        fetch(urlAPI+"Auction/Add", options)
        .then(handleHttpErrors)
    }

    const RemoveAuction = (id) =>{
        const options = makeOptions("POST", true, { id: id});
        fetch(urlAPI+"Auction/Remove", options)
        .then(handleHttpErrors)
    }

    const AddBoat = (name, brand, make, year, url) => {
        const options = makeOptions("POST", true, { name: name, brand:brand, make:make, year:year, url: url});
        fetch(urlAPI+"Boat/Add", options)
        .then(handleHttpErrors)
    }

    const UpdateBoat = (id, name, brand, make, year, url) => {
        const options = makeOptions("PUT", true, {id:id, name: name, brand:brand, make:make, year:year, url: url});
        fetch(urlAPI+"Boat/Update", options)
        .then(handleHttpErrors)
    }

    const UpdateOwner = (boat, owner) => {
        const options = makeOptions("PUT", true, {boat: boat, owner: owner});
        fetch(urlAPI+"Boat/UpdateOwner", options)
        .then(handleHttpErrors)
    }
    
    const login = (user, password) => {
        const options = makeOptions("POST", true, { username: user, password: password });
        return fetch(urlAPI + "login", options)
            .then(handleHttpErrors)
            .then(response => { setToken(response.token);
            return {
                username: response["username"],
                role: response["role"], 
                id: response["id"]
            }})
    };
    const register = (user, password) => {
        const options = makeOptions("POST", true, { username: user, password: password });
        return fetch(urlAPI + "login/New", options)
            .then(handleHttpErrors)
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
        AddAuction,
        RemoveAuction,
        AddBoat,
        GetBoats,
        UpdateBoat,
        UpdateOwner,
        makeOptions,
        setToken,
        getToken,
        loggedIn,
        login,
        register,
        logout
    }
}
const facade = BackendAPI();
export default facade;