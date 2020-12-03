import React from "react";
import Item from "../Item";

export default function List({ title, items, onItemClick }) {
    return (
        <>
            <h3 style={styles.heading}>{title}</h3>
            {items.length > 0 ? 
                <div className="list-group">
                    {items.map((item) => (
                        <Item key={item.id} item={item} onChange={onItemClick}/>
                    ))}
                </div>
                : <div className="text-center">
                    <h2>Belum ada item yang dipilih</h2>
                    <h6>Klik salah satu item di List Movies</h6>
                </div>}
            
        </>
    );
}

const styles = {
    heading: {
        fontFamily: "courier new",
    },
};