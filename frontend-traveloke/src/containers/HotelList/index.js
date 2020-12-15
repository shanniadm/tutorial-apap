import React, { Component } from "react";
import Hotel from "../../components/Hotel";
import classes from "./styles.module.css";
import APIConfig from "../../api/APIConfig";
import Button from "../../components/Button";
import Modal from "../../components/Modal";

class HotelList extends Component {
    constructor(props) {
        super(props);
        this.state = {
            hotels: [],
            isLoading: false,
            isCreate: false,
            isEdit: false,
            namaHotel : "",
            alamat : "",
            nomorTelepon : "",
            search : "",
        };
        this.handleAddHotel = this.handleAddHotel.bind(this);
        this.handleCancel = this.handleCancel.bind(this);
        this.handleChangeField = this.handleChangeField.bind(this);
        this.handleSubmitAddHotel = this.handleSubmitAddHotel.bind(this);
        this.loadData = this.loadData.bind(this);
        this.handleEditHotel = this.handleEditHotel.bind(this);
        this.handleDeleteHotel = this.handleDeleteHotel.bind(this);
        this.handleSubmitEditHotel = this.handleSubmitEditHotel.bind(this);
        this.handleSearch = this.handleSearch.bind(this);
    }

    componentDidMount() {
        this.setState({isLoading : true});
        this.loadData();
        setTimeout(() => {
            this.setState({isLoading : false});
        }, 2000);
    }

    async loadData() {
        try {
            const { data } = await APIConfig.get("/hotels");
            this.setState({ hotels: data });
        } catch (error) {
            alert("Oops terjadi masalah pada server");
            console.log(error);
        }
    }

    handleEditHotel(hotel) {
        this.setState({
        isEdit: true,
        id: hotel.id,
        namaHotel: hotel.namaHotel,
        alamat: hotel.alamat,
        nomorTelepon: hotel.nomorTelepon,
        });
    }

    async handleSubmitEditHotel(event) {
        event.preventDefault();
        try {
            const data = {
            namaHotel: this.state.namaHotel,
            alamat: this.state.alamat,
            nomorTelepon: this.state.nomorTelepon,
            };
            await APIConfig.put(`/hotel/${this.state.id}`, data);
            this.setState({namaHotel : "", alamat : "", nomorTelepon : ""});
            this.loadData();
        } catch (error) {
            alert("Oops terjadi masalah pada server");
            console.log(error);
        }
        this.handleCancel(event);
    }

    async handleDeleteHotel(id) {
        try {
            await APIConfig.delete(`/hotel/${id}`);
            this.loadData();
        } catch (error) {
            alert("Oops terjadi masalah pada server");
            console.log(error);
        }
    }
        
    handleAddHotel(){
        this.setState({isCreate : true});
    }

    async handleSubmitAddHotel(event) {
        event.preventDefault();
        try {
            const data = {
            namaHotel: this.state.namaHotel,
            alamat: this.state.alamat,
            nomorTelepon: this.state.nomorTelepon,
            };
            await APIConfig.post("/hotel", data);
            this.setState({namaHotel : "", alamat : "", nomorTelepon : ""});
            this.loadData();
        } catch (error) {
            alert("Oops terjadi masalah pada server");
            console.log(error);
        }
        this.handleCancel(event);
    }

    handleSearch (event) {
        this.setState({search : event.target.value});
    }

    handleCancel (event) {
        event.preventDefault();
        this.setState({isCreate : false, isEdit : false});
    }

    handleChangeField(event) {
        const { name, value } = event.target;
        this.setState({ [name]: value });
    }
        
    shouldComponentUpdate(nextProps, nextState) {
        console.log("shouldComponentUpdate()");
        return true;
    }

    handleClickLoading() {
        const currentLoading = this.state.isLoading;
        this.setState({ isLoading: !currentLoading });
        console.log(this.state.isLoading);
    }   
    
    filterHotel = (hotel) => {
        return hotel.namaHotel.toLowerCase().indexOf(this.state.search.toLowerCase()) > -1
    }

    render() {
        return (
            <div className={classes.hotelList}>
                <h1 className={classes.title}>All Hotels</h1>
                <Button onClick={this.handleAddHotel} variant="primary">
                Add Hotel
                </Button>
            <div>
            <div>
                <input className= {classes.textField}
                type="text"
                placeholder="Search"
                value={this.state.search}
                onChange={this.handleSearch}/>
            </div>
            { this.state.isLoading && <p>Fetch data from server...</p>}
            {this.state.hotels && this.state.hotels.filter(this.filterHotel).map((hotel) => (
            <Hotel
                key={hotel.id}
                id={hotel.id}
                namaHotel={hotel.namaHotel}
                alamat={hotel.alamat}
                nomorTelepon={hotel.nomorTelepon}
                listKamar={hotel.listKamar}
                handleEdit={() => this.handleEditHotel(hotel)}
                handleDelete={() => this.handleDeleteHotel(hotel.id)}
            />
            ))}
            </div>
                <Modal show={this.state.isCreate || this.state.isEdit} handleCloseModal={this.handleCancel}>
                    <form>
                        <h3 className={classes.modalTitle}>{this.state.isCreate ? "Add Hotel" : `Edit Hotel Nomor ${this.state.id}`}</h3>
                        <input
                        className={classes.textField}
                        type="text"
                        placeholder="Nama Hotel"
                        name="namaHotel"
                        value={this.state.namaHotel}
                        onChange={this.handleChangeField}
                        />

                        <input
                        className={classes.textField}
                        type="text"
                        placeholder="Alamat"
                        name="alamat"
                        value={this.state.alamat}
                        onChange={this.handleChangeField}
                        />

                        <textarea
                        className={classes.textField}
                        placeholder="Nomor Telepon"
                        name="nomorTelepon"
                        rows="4"
                        value={this.state.nomorTelepon}
                        onChange={this.handleChangeField}
                        />
                        <Button onClick={this.state.isCreate? this.handleSubmitAddHotel : this.handleSubmitEditHotel} variant="primary">{this.state.isCreate? "Create" : "Edit"}</Button>
                        <Button onClick={this.handleCancel} variant="danger">Cancel</Button>
                    </form>
                </Modal>
            </div>
        );
    }

}

export default HotelList;

