import React from "react";
import BackendAPI from "../API/BackendAPI.jsx";

export default function AuctionList(){
    const auctionList = BackendAPI.GetAllAuctions();

    return(
        <div key="auctionList">
            List of Auctions
            <ul>
                {
                    auctionList.map((element, index) => (
                        <li key={index}>
                            <p>{element["name"]}</p>
                            <p>{element["time"]}</p>
                            <p>{element["date"]}</p>
                            <p>{element["location"]}</p>
                        </li>
                    ))
                }
            </ul> 
        </div>
    )
}