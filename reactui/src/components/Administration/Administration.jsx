// src/components/Administration/Administration.jsx
import React from "react";
import { Link } from "react-router-dom";

const modules = [
  { id: 1, title: "Allgemein", description: "Institut, Mandanten/Gruppe, Mandant, Benutzer/Rollen, Organisationseinheiten, Systemfunktion, Protokolierung, Scorecard, System ", link: "/administrationallgemein" },
  { id: 2, title: "Recht", description: "Benutzergruppe verwalten", link: "/benutzergruppe" },
  { id: 3, title: "Import/Export", description: "Admin-Bereich", link: "/schueler-management" },
  { id: 4, title: "Drucken", description: "Admin-Bereich", link: "/schueler-management" },
  { id: 5, title: "Wartungsmodus", description: "Admin-Bereich", link: "/schueler-management" },
];

function Administration() {
  return (
    <div style={{ fontFamily: "Arial, sans-serif" }}>
      {/* İçerik */}
      <main style={{ padding: "2rem" }}>

        <div
          style={{
            marginTop: "2rem",
            display: "grid",
            gridTemplateColumns: "repeat(auto-fit,minmax(250px,1fr))",
            gap: "1.5rem",
          }}
        >
          {modules.map((mod) => (
            <ModuleCard key={mod.id} module={mod} />
          ))}
        </div>
      </main>
    </div>
  );
}

function ModuleCard({ module }) {
  return (
    <Link
      to={module.link}
      style={{
        display: "block",
        padding: "1.5rem",
        borderRadius: "10px",
        border: "1px solid #ccc",
        textDecoration: "none",
        color: "#004080",
        boxShadow: "0 2px 5px rgba(0,0,0,0.1)",
        transition: "transform 0.2s",
      }}
      onMouseEnter={(e) => (e.currentTarget.style.transform = "scale(1.05)")}
      onMouseLeave={(e) => (e.currentTarget.style.transform = "scale(1)")}
    >
      <h2 style={{ marginBottom: "0.5rem" }}>{module.title}</h2>
      <p style={{ fontSize: "0.9rem", color: "#555" }}>{module.description}</p>
    </Link>
  );
}

export default Administration;
