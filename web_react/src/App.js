import React, { Component } from 'react'

import CityForm from './CityForm'

class App extends Component {
    render() {
        return (
            <div>
                <div className="header"><h1><span>Weather forecast</span></h1></div>
                <CityForm />
            </div>
        );
    }
}

export default App