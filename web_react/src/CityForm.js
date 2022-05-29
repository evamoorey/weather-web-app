import './App.css'
import {Component} from "react"
import React from "react"
import {getWeather} from "./requests";

class CityForm extends Component {
    constructor(props) {
        super(props)
        this.state = {city: ''}
        this.weather = ''

        this.handleChange = this.handleChange.bind(this)
        this.handleSubmit = this.handleSubmit.bind(this)
    }

    handleChange(event) {
        this.setState({city: event.target.value})
    }

    async handleSubmit(event) {
        event.preventDefault()
        console.log('form is submitted')
        this.weather = await getWeather(this.state.city).then(res => this.weather = JSON.parse(JSON.stringify(res)));
        console.log(this.weather)
        document.getElementById('weather').innerHTML = JSON.stringify(this.weather);
        // document.getElementById('temp').innerHTML = this.weather;
    }

    render() {
        return (
            <form onSubmit={this.handleSubmit}>
                <div>
                    <label className="input-label">City</label>
                    <input className="input" type="text" value={this.state.city} onChange={this.handleChange}/>
                    <input className="submit" type="submit" value="Submit"/>
                </div>
                <div id="weather"></div>
                {/*<div id="temp">Temperature </div>*/}
            </form>
        )
    }
}


export default CityForm

