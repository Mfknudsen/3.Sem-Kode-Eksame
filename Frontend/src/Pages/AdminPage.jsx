import React, { useState } from "react";
import BackendAPI from "../API/BackendAPI";

export default function AdminPage(props) {
    return(
        <div>
            <AddAuction/>
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