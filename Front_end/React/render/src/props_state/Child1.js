import React, { Component } from "react";
class Child1 extends Component {
  render() {
    return (
      <div>
        <p>{this.props.a}</p>
        <p>{this.props.b}</p>
      </div>
    );
  }
}
export default Child1;
