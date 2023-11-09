import React, { Component } from "react";

class Footer extends Component {
  render() {
    return (
      <footer>
        <h5>{this.props.a[0].desc}</h5>
        <h5>{this.props.a[1].desc}</h5>
        <h5>{this.props.a[2].desc}</h5>
        <h5>{this.props.a[3].desc}</h5>
        <h5>{this.props.a[4].desc}</h5>
      </footer>
    );
  }
}
export default Footer;
