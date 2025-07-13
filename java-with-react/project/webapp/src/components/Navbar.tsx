import { FaBars } from "react-icons/fa";
import Logo from "./Logo";
import { NavLink } from "react-router-dom";

const Navbar = () => {
  return (
    <nav className="navbar navbar-expand-lg navbar-light">
      <div className="container-fluid">
       <Logo/>
        <div className="collapse navbar-collapse" id="navbarNav">
          <div className="navbar-nav">
            <NavLink className="nav-link" to="/">
              Dashboard
            </NavLink>
            <NavLink className="nav-link" to="/new">
              New Expense
            </NavLink>
            <NavLink className="nav-link" to="/reports">
              Reports
            </NavLink>
          </div>
        </div>
      </div>
      <div className="d-flex">
        <NavLink to="/login" className="btn btn-sm btn-outline-light">Login</NavLink>
        <NavLink to="/register" className="btn btn-sm btn-outline-light mx-1">Register</NavLink>
         <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <FaBars color="white"/>
    </button>
      </div>
    </nav>
  );
};

export default Navbar;
