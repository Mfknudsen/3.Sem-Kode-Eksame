import React, { useState } from "react";
import BackendAPI from "../API/BackendAPI";

export default function AdminPage(props) {
    return(
        <div>
            <AddAuction/>
            <Update/>
            <RemoveAuction/>
        </div>
    )
}

function AddAuction() {
    const [name, setName] = useState('');
    const [location, setLocation] = useState('');
    const [time, setTime] = useState('');
    const [date, setDate] = useState('');

    const handleName = event => {
        setName(event.target.value);
    }
    const handleLocation = event => {
        setLocation(event.target.value);
    }
    const handleTime = event => {
        setTime(event.target.value);
    }
    const handleDate = event => {
        setDate(event.target.value);
    }
    
    const handleSubmit = event => {
        event.preventDefault();
        BackendAPI.AddAuction(name, location, time, date);
    }

    return(
        <div>
            <h1>Add Auction</h1>
            <form onSubmit={handleSubmit}>
                <label for="name">Name:</label>
                <input type="text" id="name" name="name" onChange={handleName}/>
                <label for="location">Location:</label>
                <input type="text" id="location" name="location" onChange={handleLocation}/>
                <label for="time">Time:</label>
                <input type="text" id="time" name="time" onChange={handleTime}/>
                <label for="date">Date:</label>
                <input type="text" id="date" name="date" onChange={handleDate}/>
                <input type="submit" value="Submit"/>
            </form>
        </div>
    )
}

function Update(){
return(
    <div>
        <h1>Update</h1>
        <UpdateAuction/>
        <UpdateOwner/>
        <UpdateBoat/>
    </div>
)
}

function UpdateAuction(){
    const [id, setID] = useState('');
    const [name, setName] = useState('');
    const [location, setLocation] = useState('');
    const [time, setTime] = useState('');
    const [date, setDate] = useState('');

    const handleID = event => {
        setID(event.target.value);
    }
    const handleName = event => {
        setName(event.target.value);
    }
    const handleLocation = event => {
        setLocation(event.target.value);
    }
    const handleTime = event => {
        setTime(event.target.value);
    }
    const handleDate = event => {
        setDate(event.target.value);
    }
    
    const handleSubmit = event => {
        event.preventDefault();
        BackendAPI.AddAuction(id, name, location, time, date);
    }

    return(
        <div>
            <h2>Update Auction</h2>
            <form onSubmit={handleSubmit}>
                <label for="name">ID:</label>
                <input type="number" id="name" name="name" onChange={handleID}/>
                <label for="name">Name:</label>
                <input type="text" id="name" name="name" onChange={handleName}/>
                <label for="location">Location:</label>
                <input type="text" id="location" name="location" onChange={handleLocation}/>
                <label for="time">Time:</label>
                <input type="text" id="time" name="time" onChange={handleTime}/>
                <label for="date">Date:</label>
                <input type="text" id="date" name="date" onChange={handleDate}/>
                <input type="submit" value="Submit"/>
            </form>
        </div>
    )
}

function UpdateOwner(){
    const [id, setID] = useState('');
    const [name, setName] = useState('');

    const handleID = event => {
        setID(event.target.value);
    }
    const handleName = event => {
        setName(event.target.value);
    }

    const handleSubmit = event => {
        event.preventDefault();
        BackendAPI.UpdateOwner(id, name);
    }

    return(
        <div>
            <h2>Update Owner</h2>
            <form onSubmit={handleSubmit}>
                <label for="name">Boat ID:</label>
                <input type="number" id="name" name="name" onChange={handleID}/>
                <label for="name">Owner ID:</label>
                <input type="number" id="name" name="name" onChange={handleName}/>
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
            <h2>Update Boat Info</h2>
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

function RemoveAuction() {
    const [id, setID] = useState("");
    const handleID = event => {
        setID(event.target.value);
    }

    const handleSubmit = event => {
        event.preventDefault();
        BackendAPI.RemoveAuction(id);
    }

    return(
        <div>
            <h1>Remove Auction</h1>
            <form onSubmit={handleSubmit}>
                <label for="id">ID:</label>
                <input type ="number" defaultValue="1" increment="1" onChange={handleID}/>
                <input type="submit" value="Submit"/>
            </form>
        </div>
    )
}