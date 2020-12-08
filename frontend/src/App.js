import React from "react";
import List from "./components/List";
import listMovies from "../src/movies.json";
import './App.css';
import Toggle from 'react-toggle';
import EmptyState from './components/EmptyState';

export default class App extends React.Component {
  state = {
    favItems: [],
    itemListAvai : false,
    show : false,
    darkMode : false,
  };

  handleItemClick = (item) => {
    const newItems = [ ... this.state.favItems ];
    const newItem = { ... item };

    const targetInd = newItems.findIndex((it) => it.id === newItem.id);
    if(targetInd < 0) newItems.push(newItem);

    this.setState({ favItems: newItems});
  };

  handleFavItemClick = (item) => {
    const newItems = [ ... this.state.favItems ];
    const newItem = { ... item };

    const targetInd = newItems.findIndex((it) => it.id === newItem.id);
    if(targetInd < 0) newItems.push(newItem);
    else newItems.splice(targetInd, 1);

    this.setState({ favItems: newItems});
  };

  deleteList = () => {
    this.setState({favItems:[]});
  };

  handleToggle = () => {
    this.setState({show : !this.state.show})
  }

  handleTheme = () => {
    this.setState({darkMode : !this.state.darkMode})
  }

  render() {
    const {favItems} = this.state;

    return (
      <div className= {this.state.darkMode ? "dark-mode" : "light-mode"}>
        <div className="container-fluid">
          {this.showFavorites}
          <h1 className="text-center mt-3 mb-3">Favorites Movie App</h1>
          <p className="text-center text-secondary text-sm font-italic">
            (This is a <strong>class-based</strong> application)
          </p>
          <div className="align-content-center">
            <Toggle id='showStatus'
              onChange={this.handleToggle}/>
            <label htmlFor='showStatus'>Show Favorites</label>
          </div>
          <div className="align-content-center">
            <Toggle id='setTheme'
              onChange={this.handleTheme}/>
            <label htmlFor='setTheme'>Set Dark Mode Theme</label>
          </div>
          <div className="container pt-3">
            <div className="row">
              <div className="col-sm">
                <List
                    title="List Movies"
                    items={listMovies}
                    onItemClick={this.handleItemClick}
                />
              </div>
              { this.state.show ? 
                <div className="col-sm">
                  <input type={this.state.favItems.length>0 ? "button" : "hidden"}
                  onClick={this.deleteList} value="Delete All Favorites"/>
                  { this.state.favItems.length > 0 ? 
                  <List
                  title="My Favorites"
                  items={favItems}
                  onItemClick={this.handleFavItemClick}
                  /> : <EmptyState/>
                  }
                </div>
              : null}
            </div>
          </div>
        </div>
      </div>
    )
  }
}
