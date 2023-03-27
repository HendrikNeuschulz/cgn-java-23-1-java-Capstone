import styled from "styled-components";
import React from "react";
import logo from "../logowtf.png";


function Header() {
    return (
        <HeaderContainer>
            <img src={logo} alt={"logowtf"} height={"180"} width={"180"}/>
        </HeaderContainer>
    );
}

export default Header;

const HeaderContainer = styled.div`
  display: flex;
  justify-content: center;

`