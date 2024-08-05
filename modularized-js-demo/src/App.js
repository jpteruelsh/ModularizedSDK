import logo from './logo.svg';
import './App.css';
import { Greeting } from 'ModularizedSDK';
// import { CoreClass} from 'ModularizedSDK/CoreModule'; // tried this, but doesn't work

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
