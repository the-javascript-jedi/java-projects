import { FaBars } from "react-icons/fa";
import Logo from "./Logo";

const Navbar = () => {
  return (
    <nav className="navbar navbar-expand-lg navbar-light">
      <div className="container-fluid">
       <Logo/>
        <div className="collapse navbar-collapse" id="navbarNav">
          <div className="navbar-nav">
            <a className="nav-link active" aria-current="page" href="#">
              Home
            </a>
            <a className="nav-link" href="#">
              Features
            </a>
            <a className="nav-link" href="#">
              Pricing
            </a>
            <a className="nav-link disabled" href="#" aria-disabled="true">
              Disabled
            </a>
          </div>
        </div>
      </div>
      <div className="d-flex">
        <button className="btn btn-sm btn-outline-light">Login</button>
        <button className="btn btn-sm btn-outline-light mx-1">Logout</button>
         <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <FaBars color="white"/>
    </button>
      </div>
    </nav>
  );
};

export default Navbar;
