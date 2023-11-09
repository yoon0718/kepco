import "./App.css";
import React, { Component } from "react";
import Subject from "./Subject";
import TOC from "./TOC";
import Content from "./Content";

class App extends Component {
  //함수 그려줘
  render() {
    return (
      <div className="App">
        <Subject title="WEB" sub="World Wide Web!"></Subject>
        <TOC></TOC>
        <Content
          title="HTML"
          desc="HTML is HyperText Markup Language."
        ></Content>
        <MyComponent data="Data!" number="2324"></MyComponent>
      </div>
    );
  }
}

class MyComponent extends Component {
  render() {
    return (
      <div>
        <h1>{this.props.data}</h1>
        <h1>{this.props.number}</h1>
      </div>
    );
  }
}

export default App;
