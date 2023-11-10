import React, { Component } from "react";
import "./App.css";
import Child from "./props_state/Child";
import Child1 from "./props_state/Child1";
import Subject from "./props_state/Subject";
import TOC from "./props_state/TOC";
import Content from "./props_state/Content";
class App extends Component {
  constructor(props) {
    super(props);
    this.state = {
      child: { a: "1", b: "2" },
      Subject: { title: "WEB", sub: "World Wide Web" },
      contents: [
        { id: 1, title: "HTML", desc: "HTML is for information." },
        { id: 2, title: "CSS", desc: "CSS is for design." },
        { id: 3, title: "Javascript", desc: "JavaScript is for interactive." },
      ],
    };
  }

  render() {
    return (
      <div className="App">
        <Child a="1" b="2"></Child>
        <Child1 a={this.state.child.a} b={this.state.child.b}></Child1>
        <Subject
          title={this.state.Subject.title}
          sub={this.state.Subject.sub}
        ></Subject>
        <TOC contents={this.state.contents}></TOC>
        <Content
          title={this.state.contents[0].title}
          desc={this.state.contents[0].desc}
        ></Content>
        <Content
          title={this.state.contents[1].title}
          desc={this.state.contents[1].desc}
        ></Content>
        <Content
          title={this.state.contents[2].title}
          desc={this.state.contents[2].desc}
        ></Content>
      </div>
    );
  }
}

export default App;
