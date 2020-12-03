import React, { useState } from "react";

import List from "./components/List";
import listMovies from "../src/movies.json";
import Toggle from 'react-toggle';

function App() {
    const [favItems, setFavItems] = useState(() => []);
    const [show, setShow] = useState(() => false);

    function handleItemClick(item) {
        const newItems = [...favItems];
        const newItem = {...item};
        
        const targetInd = newItems.findIndex(it => it.id === newItem.id);

        if(targetInd < 0) newItems.push(newItem);

        setFavItems(newItems);
    }

    function handleFavItemClick(item){
        const newItems = [...favItems];
        const newItem = {...item};
        
        const targetInd = newItems.findIndex(it => it.id === newItem.id);

        if(targetInd < 0) newItems.push(newItem);
        else newItems.splice(targetInd, 1);

        setFavItems(newItems);
    }

    function deleteAllItem(){
        setFavItems([]);
    }

    function handleToggle(){
        setShow(!show);
    }

    return (
        <div className="container-fluid">
            <h1 className="text-center mt-3 mb-0"> Favorites Movie App</h1>
            <p className="text-center text-secondary text-sm font-italic">
                (This is a <strong>function-based</strong> application)
            </p>
            <div className="align-content-center">
                <Toggle id='showStatus'
                    onChange={handleToggle}/>
                <label htmlFor='showStatus'>Show Favorites</label>
            </div>
            <div className="container pt-3">
                <div className="row">
                    <div className="col-sm">
                        <List
                            title="List Movies"
                            items={listMovies}
                            onItemClick={handleItemClick}
                        />
                    </div>
                    { show ? 
                        <div className="col-sm">
                            <input type={favItems.length>0 ? "button" : "hidden"}
                            onClick={deleteAllItem} value="Delete All Favorites"/>
                            <List
                            title="My Favorites"
                            items={favItems}
                            onItemClick={handleFavItemClick}
                            />
                        </div>
                    : null}
                </div>
            </div>
        </div>
    );
}

export default App;