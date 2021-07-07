import React from "react"; 
import Button from "../Button";
import classes from "./styles.module.css";

const Kamar = (props) => {
    const { noKamar, namaKamar, kapasitasKamar} = props;
    return (
        <button className={classes.button}>{`${namaKamar} (${kapasitasKamar})`}</button>
    )
}

export default Kamar;