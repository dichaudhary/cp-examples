import React from 'react';
import logo from '../logo.svg';
import '../App.css';


export default function Header() {
    return (
        <div>
            <header className="App-header">
                <img src={logo} className="App-logo" alt="logo"/>
                <p>A few well known problems, click to solve</p>
            </header>
        </div>

    );

}