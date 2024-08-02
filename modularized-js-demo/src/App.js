import logo from './logo.svg';
import './App.css';
import {MainClass, Greeting} from 'ModularizedSDK';
// import {CoreClass} from 'CoreModule';

let core = new Greeting();
let output = core.greet();

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <p>
          Edit <code>src/App.js</code> and save to reload.a {output}
        </p>
        <a
          className="App-link"
          href="https://reactjs.org"
          target="_blank"
          rel="noopener noreferrer"
        >
          Learn React
        </a>
      </header>
    </div>
  );
}

export default App;
