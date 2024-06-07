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
  componentWillMount() {
      this.setState({status:"Loading Status"});
  }
  componentDidMount() {
    setTimeout(()=>{
      this.setState({status:"Work In Progress"});
    },2000);
  }
componentWillUnmount() {
  setTimeout(()=>{
    this.setState({status:"Done"})
  },5000);
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

        <GetNote input={this.state.note} handleInput={this.handleInput}/>
        <RenderNote note={this.state.note}/>

      </div>
    );
  }
}

class GetNote extends React.Component {
  constructor(props){
    super(props);
  }

  render() {
     return (
     <div>
     <h2>Write the Note</h2> 
     <input onChange={this.props.handleInput}></input>
     </div>);
  }
}

let styles = {color:"yellow",fontSize:24,border:"2px solid white",padding:"20px"};

class RenderNote extends React.Component {
  constructor(props) {
    super(props);
  }

  shouldComponentUpdate(nextProps,nextState) {
    if(nextProps.note === "")
      {
        return false;
      }
      else {
        return true;
      }
  }

  componentDidUpdate() {
  }

  render() {
    if(this.props.note.length >15) {
      styles = {
        color:"red",
        fontSize:24,
        border:"2px solid white",
        padding:"20px"
      };
    } else {
      styles = {
        color:"yellow",
        fontSize:24,
        border:"2px solid white",
        padding:"20px"
      };
    }
    
        return (  
          <div>
            <h2>Note:</h2>
         {this.props.note===""?<h2>There is no note yet!!</h2> : <p style={styles}>{this.props.note}</p>} 
          </div>
       );
  }
}

class FormComponent extends React.Component {
  constructor(props) {
    super(props);
  }
  render() {
    return (  
      <div>
        <h2>Form Input</h2>
        <form onSubmit={this.handleSubmit}>
          <input/>
       <button type="Submit">Submit</button>
       </form>
      </div>
   );
  }
}

export default App;
