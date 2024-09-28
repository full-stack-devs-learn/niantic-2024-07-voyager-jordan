import { Link } from "react-router-dom";

export default function Header() {
  return (
    <header>
        <div id="navigation">
            <h1>TypeDex</h1>
            <Link to="/" className="link" >Home</Link>
            <Link to="/pokemon" className="link" >Pokemon</Link>
        </div>
    </header>
  );
}
