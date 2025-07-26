// src/components/MainModulesNav/MainModulesNav.jsx
import React from "react";
import { NavLink } from "react-router-dom";
import { FaHome } from "react-icons/fa";

const MODULES = [
  { to: "/home", label: <FaHome size={16} /> },
  { to: "/administration", label: "Administration" },
  { to: "/gruppe", label: "Fahrschülerverwaltung" },
  { to: "/benutzerg", label: "Kursplanung & Kalender" },
  { to: "/students", label: "Reservierungssystem" },
  { to: "/kursplanung", label: "Prüfungsüberwachung" },
  { to: "/reservierungen", label: "Zahlungssystem" },
  { to: "/pruefung", label: "Benachrichtigungen & Nachrichten" },
  { to: "/zahlung", label: "Fahrzeug-und Geräteverwaltung" },
  { to: "/berichte", label: "Berichte & Statistik" },
  { to: "/mehrsprachig", label: "Mehrsprachig Unterstützung" },
];

export default function MainModulesNav() {
  return (
    <div style={wrapper}>
      <div style={inner}>
        {MODULES.map((m) => (
          <NavLink
            key={m.to}
            to={m.to}
            style={({ isActive }) => ({
              ...chip,
              ...(isActive ? chipActive : {}),
            })}
          >
            {m.label}
          </NavLink>
        ))}
      </div>
    </div>
  );
}

const wrapper = {
  background: "#f6f8fb",
  borderBottom: "1px solid #e5e7eb",
  padding: "0.45rem 0.6rem",
};

const inner = {
  display: "flex",
  flexWrap: "wrap",          // <<< WRAP AÇIK
  gap: "0.35rem 0.45rem",    // row-gap column-gap
};

const chip = {
  display: "inline-flex",
  alignItems: "center",
  justifyContent: "center",
  padding: "0.35rem 0.6rem",
  borderRadius: 6,
  border: "1px solid #e0e0e0",
  background: "#fff",
  color: "#0f4aa1",
  fontWeight: 600,
  fontSize: "0.85rem",
  lineHeight: 1,
  textDecoration: "none",
  transition: "all .15s ease",
  whiteSpace: "nowrap",
};

const chipActive = {
  background: "#174bd1",
  color: "#fff",
  borderColor: "#174bd1",
};
