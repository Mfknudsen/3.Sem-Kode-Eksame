import React from "react";
import BackendAPI from "../API/BackendAPI.jsx";

export default function AuctionList(){
    const auctionList = BackendAPI.GetAllActions();

    return(
        <div>
            <ul>
                {
                    auctionList.array.forEach(element => {
                      {<li>
                          {element["name"]}
                      </li>}  
                    })
                }
            </ul>
        </div>
    );
}