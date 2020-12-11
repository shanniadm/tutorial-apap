import React from "react";
import classes from "./styles.module.css";
import Button from "../Button";
import Kamar from "../Kamar";
import EmptyState from "../Kamar/EmptyState";

const Hotel = (props) => {
    const { id, namaHotel, alamat, nomorTelepon, listKamar, handleEdit, handleDelete } = props;
    return (
        <div className={classes.hotel}>
            <h3>{`ID Hotel ${id}`}</h3>
            <p>{`Nama Hotel: ${namaHotel}`}</p>
            <p>{`Alamat: ${alamat}`}</p>
            <p>{`Nomor telepon: ${nomorTelepon}`}</p>
            <div>
            {listKamar.length > 0 ? listKamar.map((kamar) => (
                <Kamar
                    key={kamar.noKamar}
                    noKamar = {kamar.noKamar}
                    namaKamar = {kamar.namaKamar}
                    kapasitasKamar = {kamar.kapasitasKamar}
                /> 
            )) : <EmptyState/>}
            </div>
            <br/>
            <Button onClick={handleEdit} variant="success">
            Edit
            </Button>
            <Button onClick={handleDelete} variant="danger">
            Delete
            </Button>
        </div>
    );
};

export default Hotel;