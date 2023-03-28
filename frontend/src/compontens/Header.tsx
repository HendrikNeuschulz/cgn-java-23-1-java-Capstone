import styled from "styled-components";
import React from "react";
import logo from "../logowtf.png";


function Header() {
    return (
        <HeaderContainer>
            <HeaderLogo src={logo} alt={"logowtf"} height={"170"} width={"170"}/>
        </HeaderContainer>
    );
}

export default Header;

const HeaderContainer = styled.div`
  display: flex;
  justify-content: center;

`

const HeaderLogo = styled.img`
  border-radius: 90px;
  padding: 5px;

`