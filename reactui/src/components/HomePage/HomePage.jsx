// src/components/HomePage/HomePage.jsx
import React from "react";
import { Link } from "react-router-dom";

const modules = [
  { id: 1, title: "Administration", description: "Allgemein, Recht, Import/Export, Drucken, Wartungsmodus", link: "/administration" },
  { id: 2, title: "Fahrschülerverwaltung", description: "Verwaltung der Fahrschülerdaten und -profile", link: "/schueler-management" },
  { id: 3, title: "Stundenplanung und Kalender", description: "Theorie- & Praxisunterricht, Kalenderverwaltung", link: "/schedule" },
  { id: 4, title: "Reservierungssystem", description: "Unterrichtsreservierung, Fahrlehrer- & Fahrzeugausswahl", link: "/reservation" },
  { id: 5, title: "Prüfungsverfolgung", description: "Prüfungstermine, Ergebnisse und Simulationstests", link: "/exam-tracking" },
  { id: 6, title: "Zahlungssystem", description: "Kursgebühren, Online-Zahlungen und Verlauf", link: "/payments" },
  { id: 7, title: "Benachrichtigungen und Nachrichten", description: "Unterrichtserinnerungen und Fahrlehrernachrichten", link: "/notifications" },
  { id: 8, title: "Fahrzeug-& Geräteverwaltung", description: "Fahrzeugverfolgung und Wartungsstatus", link: "/vehicle-management" },
  { id: 9, title: "Berichte & Statistiken", description: "Fortschrittsberichte und Leistungskontrolle", link: "/reports" },
  { id: 9, title: "Aufgabenübersicht", description: "Die Aufgaben", link: "/aufgabenübersicht" },
  { id: 10, title: "Mehrsprachige Unterstützung", description: "Sprachoptionen: Deutsch, und Englisch", link: "/language" },
];

function HomePage() {
  return (
    <div style={{ fontFamily: "Arial, sans-serif" }}>
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
  const lines = module.description.split(",");
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
      <div style={{ fontSize: "0.9rem", color: "#555" }}>
        {lines.map((line, index) => (
          <div key={index}>{line.trim()}</div> // her satır alt alta
        ))}
      </div>
    </Link>
  );
}

export default HomePage;
