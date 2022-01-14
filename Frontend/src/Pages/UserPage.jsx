import React from "react";
import { useState } from "react";
import BackendAPI from "../API/BackendAPI";

export default function UserPage(props){
    return(
        <div>
            <AddBoat/>
            <UpdateBoat/>
            <OwnedBoats id={props.id}/>
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

function OwnedBoats(props){
    let boatList = BackendAPI.GetBoats(props.id);

    return(
        <div>
            <h1>Owned Boats</h1>
            <ul>
                {
                    boatList.map((element, index) => (
                        <li key={index}>
                            <h4>ID: {element["id"]}</h4>
                            <h4>Auction ID: {element["auction"]}</h4>
                            <p>Name: {element["name"]}</p>
                            <p>Brand: {element["brand"]}</p>
                            <p>Make: {element["make"]}</p>
                            <p>Year: {element["year"]}</p>
                            <p>URL: {element["url"]}</p>
                        </li>
                    ))
                }
            </ul> 
        </div>
    )
}