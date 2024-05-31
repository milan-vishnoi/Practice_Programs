import logo from "./logo.svg";
import "./App.css";
import React from "react";
import PropTypes from "prop-types";

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <p>
          <ToDo />
        </p>
        {/* <a
          className="App-link"
          href="https://reactjs.org"
          target="_blank"
          rel="noopener noreferrer"
        >
          Learn React
        </a> */}
      </header>
    </div>
  );
}

class List extends React.Component {
  constructor(props) {
    super(props);
  }

  render() {
    return <p>{this.props.tasks.join(", ")}</p>;
  }
}


List.defaultProps = { tasks: ["Reading, Eating"] };

List.propTypes = {tasks: PropTypes.array.isRequired};

class ToDo extends React.Component {
  constructor(props) {
    super(props);
    this.state = {status:"Work in Progress",
      note:"",
      submit:""
    };
    this.handleClick = this.handleClick.bind(this);
    this.handleInput = this.handleInput.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
  }


  handleClick() {
    this.setState(state => ({status: state.status==="Done"?"Work In Progress":"Done"}));
  }

  handleInput(event) {
    this.setState({note:event.target.value});
  }

  handleSubmit(event) {
    event.preventDefault();
    this.setState(state=>({submit:state.note}));

  }
  render() {
    return (
      <div>
        <h1>To Do Lists</h1>
        <h2>Today</h2>
        <List />
        <h2>Tomorrow</h2>
        <List tasks={["Study", "Sing", "Dance"]} />
        <h2>State</h2>
        <p>Status : {this.state.status}</p>
        <button onClick={this.handleClick}>Change Status</button><br/>
        <h2>Write an update</h2>
        <form onSubmit={this.handleSubmit}>
        <input onChange={this.handleInput}></input><br/>
        <button type="Submit">Submit</button>
        </form>
        
        <h2>Note</h2>
        <p>{this.state.submit}</p>
      </div>
    );
  }
}



export default App;
