// src/components/PortalLayout.jsx
import React from "react";
import { Outlet, useNavigate } from "react-router-dom";
import MainModulesNav from "../MainModulesNav/MainModulesNav";

export default function PortalLayout() {
  const lang = "de";
  const navigate = useNavigate();

  const handleLogout = () => {
    // Çıkış işlemleri (token temizleme vs.)
    navigate("/login");
  };

  return (
    <div>
      {/* NAVBAR */}
      <nav style={topNav}>
        <div style={left}>
          <span style={brand}>Fahrschule Portal</span>
        </div>
        <div style={right}>
          <button onClick={handleLogout} style={logoutBtn}>
            Abmelden
          </button>
        </div>
      </nav>

      {/* Üst modül barı */}
      <MainModulesNav lang={lang} />

      {/* İçerik */}
      <div style={{ padding: "1.5rem 2rem" }}>
        <Outlet context={{ lang }} />
      </div>
    </div>
  );
}

const topNav = {
  background: "#174bd1ff",
  color: "white",
  padding: "0.8rem 1.2rem",
  display: "flex",
  alignItems: "center",
  justifyContent: "space-between",
};

const left = {
  display: "flex",
  alignItems: "center",
  gap: ".6rem",
};

const brand = {
  fontWeight: "bold",
  fontSize: "1.4rem",
};

const right = {
  display: "flex",
  alignItems: "center",
  gap: ".6rem",
};

const logoutBtn = {
  background: "transparent",
  border: "1px solid rgba(255,255,255,.6)",
  color: "#fff",
  padding: "0.25rem .6rem",
  borderRadius: 4,
  cursor: "pointer",
  fontSize: ".9rem",
};
