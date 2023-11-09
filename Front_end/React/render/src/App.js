import React, { Component } from "react";
import "./App.css";

class App extends Component {
  constructor(props) {
    super(props);
    this.state = {
      contents: {
        mode: "welcome",
        welcome: { title: "welcome", desc: "Hello, React" },
      },
    };
  }
  render() {
    let title, desc;
    if (this.state.contents.mode == "welcome") {
      title = this.state.welcome.title;
      desc = this.state.welcome.desc;
    }
    return <div className="App"></div>;
  }
}

export default App;
