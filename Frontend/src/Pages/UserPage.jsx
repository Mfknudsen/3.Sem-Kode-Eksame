import React from "react";
import { useState } from "react";
import BackendAPI from "../API/BackendAPI";

export default function UserPage(){
    return(
        <div>
            <AddBoat/>
            <UpdateBoat/>
            <OwnedBoats/>
        </div>
    )
}

function AddBoat(){
    const [name, setName] = useState('');
    const [brand, setBrand] = useState('');
    const [make, setMake] = useState('');
    const [year, setYear] = useState('');
    const [url, setUrl] = useState('');

    const handleName = event => {
        setName(event.target.value);
    }
    const handleBrand = event => {
        setBrand(event.target.value);
    }
    const handleMake = event => {
        setMake(event.target.value);
    }
    const handleYear = event => {
        setYear(event.target.value);
    }
    const handleUrl = event => {
        setUrl(event.target.value);
    }

    const handleSubmit = event => {
        event.preventDefault();
        BackendAPI.AddBoat(name, brand, make, year, url);
    }

    return(
        <div>
            <h1>Add Boat</h1>
            <form onSubmit={handleSubmit}>
                <label for="name">Name:</label>
                <input type="text" id="name" name="name" onChange={handleName}/>
                <label for="location">Brand:</label>
                <input type="text" id="location" name="location" onChange={handleBrand}/>
                <label for="time">Make:</label>
                <input type="text" id="time" name="time" onChange={handleMake}/>
                <label for="date">Year:</label>
                <input type="text" id="date" name="date" onChange={handleYear}/>
                <label for="date">Url:</label>
                <input type="text" id="date" name="date" onChange={handleUrl}/>
                <input type="submit" value="Submit"/>
            </form>
        </div>
    )
}

function UpdateBoat(){
    const [id, setID] = useState('');
    const [name, setName] = useState('');
    const [brand, setBrand] = useState('');
    const [make, setMake] = useState('');
    const [year, setYear] = useState('');
    const [url, setUrl] = useState('');

    const handleID= event => {
        setID(event.target.value);
    }
    const handleName = event => {
        setName(event.target.value);
    }
    const handleBrand = event => {
        setBrand(event.target.value);
    }
    const handleMake = event => {
        setMake(event.target.value);
    }
    const handleYear = event => {
        setYear(event.target.value);
    }
    const handleUrl = event => {
        setUrl(event.target.value);
    }

    const handleSubmit = event => {
        event.preventDefault();
        BackendAPI.UpdateBoat(id,name, brand, make, year, url);
    }
    return(
        <div>
            <h1>Update Boat</h1>
            <form onSubmit={handleSubmit}>
                <label for="name">ID:</label>
                <input type="number" increment="1" id="name" name="name" onChange={handleID}/>
                <label for="name">Name:</label>
                <input type="text" id="name" name="name" onChange={handleName}/>
                <label for="location">Brand:</label>
                <input type="text" id="location" name="location" onChange={handleBrand}/>
                <label for="time">Make:</label>
                <input type="text" id="time" name="time" onChange={handleMake}/>
                <label for="date">Year:</label>
                <input type="text" id="date" name="date" onChange={handleYear}/>
                <label for="date">Url:</label>
                <input type="text" id="date" name="date" onChange={handleUrl}/>
                <input type="submit" value="Submit"/>
            </form>
        </div>
    )
}

function OwnedBoats(){
    return(
        <div>
            <h1>Owned Boats</h1>
        </div>
    )
}