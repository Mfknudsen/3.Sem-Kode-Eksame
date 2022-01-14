import React from "react";
import BackendAPI from "../API/BackendAPI.jsx";

export default function AuctionList(){
    const auctionList = BackendAPI.GetAllAuctions();

    return(
        <div>
            <h1>List of All Auctions</h1>
            <ul>
                {
                    auctionList.map((element, index) => (
                        <li key={index}>
                            <h4>ID: {element["id"]}</h4>
                            <p>Name: {element["name"]}</p>
                            <p>Time: {element["time"]}</p>
                            <p>Date: {element["date"]}</p>
                            <p>Location: {element["location"]}</p>
                        </li>
                    ))
                }
            </ul> 
        </div>
    )
}