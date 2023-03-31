import React from "react";
import styled from "styled-components";
import {Link, useLocation} from "react-router-dom";
import homebutton from "../Items/heim.png"
import addbutton from "../Items/plus.png"


function Navbar() {
    const location = useLocation();
    return (
        <footer>
            <SytledNav>
                <Link to="/">
                    <StyledImage className={location.pathname === "/" ? "active" : "unactive"} src={homebutton}
                                 alt="homebutton" width="40" height="40"></StyledImage>
                </Link>
                <Link to="/add">
                    <StyledImage className={location.pathname === "/add" ? "active" : "unactive"} src={addbutton}
                                 alt="addbutton" width="40" height="40"></StyledImage>
                </Link>
            </SytledNav>
        </footer>
    );
}

export default Navbar;

const SytledNav = styled.nav`
  display: flex;
  justify-content: center;
  gap: 30px;
  position: fixed;
  bottom: 0;
  width: 100%;
  padding: 8px 0 8px 0;
  background-color: #ecae4d;
`;

const StyledImage = styled.img`
  &.active {
    border-bottom: 3px solid #752421;
    border-radius: 5px;
  }

  &.unactive {
    border-bottom: none;
  }
`;
