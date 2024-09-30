import { Link, NavLink } from "react-router-dom";

export default function Header() {
  return (
    <header>
        <div id="navigation">
            <h1>TypeDex</h1>
            <NavLink to="/" className="link" >Home</NavLink>
            <NavLink to="/pokemon" className="link" >Pokemon</NavLink>
        </div>
    </header>
  );
}
