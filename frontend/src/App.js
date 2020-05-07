/*import React, {Component, useState, useEffect} from 'react';
import logo from './logo.svg';
import './App.css';

function App () {
    const [message, setMessage] = useState("");

    useEffect(() => {
        fetch('/api/hello')
            .then(response => response.text())
            .then(message => {
                setMessage(message);
            });
    },[])
    return (
        <div className="App">
        <header className="App-header">
        <img src={logo} className="App-logo" alt="logo"/>
        <h1 className="App-title">{message}</h1>
        </header>
        <p className="App-intro">
        To get started, edit <code>src/App.js</code> and save to reload.
    </p>
    </div>
)
}*/
import React, {Component, useState, useEffect} from 'react';
import logo from './logo.svg';
import './App.css';
import Knapsack from './dp/knapsack';
import QuickSort from './sort/QuickSort'
import { Link, Redirect } from 'react-router-dom';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
class App extends Component {
    constructor() {
        super();
    }

    render = () => {
    return (
    <div className="App">
        <header className="App-header">
            <img src={logo} className="App-logo" alt="logo"/>
            <p>A few well known problems, click to solve</p>
        </header>
        <Router>
            <div>
              <a href="/knapsack">Knapsack</a>
              <br/><br/>
              <a href="/quicksort">QuickSort</a>
              <Switch>
                <Route path="/knapsack" component={Knapsack} />
                <Route path="/quicksort" component={QuickSort} />
              </Switch>
            </div>
        </Router>
    </div>
    );
    }
}

export default App;

