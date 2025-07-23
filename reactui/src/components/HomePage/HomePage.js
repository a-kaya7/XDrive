import React, { useState } from "react";

const modules = [
{ id: 1, title: "Fahrschülerverwaltung", description: "Verwaltung der Fahrschülerdaten und -profile", link: "/schueler-management" },
{ id: 2, title: "Benutzerverwaltung", description: "Fahrschüler-, Fahrlehrer- und Administratorverwaltung", link: "/user-management" },
{ id: 3, title: "Stundenplanung und Kalender", description: "Theorie- & Praxisunterricht, Kalenderverwaltung", link: "/schedule" },
{ id: 4, title: "Reservierungssystem", description: "Unterrichtsreservierung, Fahrlehrer- & Fahrzeugausswahl", link: "/reservation" },
{ id: 5, title: "Prüfungsverfolgung", description: "Prüfungstermine, Ergebnisse und Simulationstests", link: "/exam-tracking" },
{ id: 6, title: "Zahlungssystem", description: "Kursgebühren, Online-Zahlungen und Verlauf", link: "/payments" },
{ id: 7, title: "Benachrichtigungen und Nachrichten", description: "Unterrichtserinnerungen und Fahrlehrernachrichten", link: "/notifications" },
{ id: 8, title: "Fahrzeug- und Ausrüstungsverwaltung", description: "Fahrzeugverfolgung und Wartungsstatus", link: "/vehicle-management" },
{ id: 9, title: "Berichte und Statistiken", description: "Fortschrittsberichte und Leistungskontrolle", link: "/reports" },
{ id: 10, title: "Mehrsprachige Unterstützung", description: "Sprachoptionen: Deutsch, Türkisch und Englisch", link: "/language" },

];

function HomePage() {
  const [language, setLanguage] = useState("de");

  const handleLanguageChange = (e) => {
    setLanguage(e.target.value);
  };

  return (
    <div style={{ fontFamily: "Arial, sans-serif" }}>
      {/* Navigation Bar */}
      <nav style={{
        backgroundColor: "#174bd1ff",
        color: "white",
        padding: "1rem 2rem",
        display: "flex",
        justifyContent: "space-between",
        alignItems: "center"
      }}>
        <div style={{ fontWeight: "bold", fontSize: "1.5rem" }}>
          Fahrschule Portal
        </div>
        <div>
          <a href="/logout" style={navLinkStyle}>Abmelden</a>

          {/* Dil seçici */}
          <select
            value={language}
            onChange={handleLanguageChange}
            style={{
              marginLeft: "1rem",
              padding: "0.3rem",
              borderRadius: "4px",
              border: "none",
              cursor: "pointer",
              fontSize: "1rem",
            }}
          >
            <option value="de">Deutsch</option>
            <option value="en">English</option>
          </select>
        </div>
      </nav>

      {/* Ana içerik */}
      <main style={{ padding: "2rem" }}>
        <h1 style={{ textAlign: "center" }}>
        </h1>

        <div
          style={{
            marginTop: "2rem",
            display: "grid",
            gridTemplateColumns: "repeat(auto-fit,minmax(250px,1fr))",
            gap: "1.5rem",
          }}
        >
          {modules.map((mod) => (
            <ModuleCard key={mod.id} module={mod} language={language} />
          ))}
        </div>
      </main>
    </div>
  );
}

const navLinkStyle = {
  color: "white",
  marginLeft: "1.5rem",
  textDecoration: "none",
  fontWeight: "500",
  fontSize: "1rem",
  cursor: "pointer",
};

function ModuleCard({ module, language }) {
  const translations = {
    "Fahrschülerverwaltung": {
      de: "Fahrschülerverwaltung",
      en: "Student Management"
    },
    "Benutzerverwaltung": {
      de: "Benutzerverwaltung",
      en: "User Management",
    },
    "Stundenplanung und Kalender": {
      de: "Kursplanung und Kalender",
      en: "Course Scheduling and Calendar",
    },
    "Reservierungssystem": {
      de: "Reservierungssystem",
      en: "Reservation System",
    },
    "Prüfungsverfolgung": {
      de: "Prüfungsüberwachung",
      en: "Exam Tracking",
    },
    "Zahlungssystem": {
      de: "Zahlungssystem",
      en: "Payment System",
    },
    "Benachrichtigungen und Nachrichten": {
      de: "Benachrichtigungen und Nachrichten",
      en: "Notifications and Messaging",
    },
    "Fahrzeug- und Ausrüstungsverwaltung": {
      de: "Fahrzeug- und Geräteverwaltung",
      en: "Vehicle and Equipment Management",
    },
    "Berichte und Statistiken": {
      de: "Berichterstattung und Statistik",
      en: "Reporting and Statistics",
    },
    "Mehrsprachige Unterstützung": {
     de: "Mehrsprachige Unterstützung",
    en: "Multilingual Support"
    }
  };

  const title = translations[module.title][language] || module.title;
  const descriptions = {
    de: {
      1: "Verwaltung der Fahrschülerdaten und -profile", 
      2: "Fahrerprofil, Lehrer und Admin-Management",
      3: "Theoretische & praktische Kurse, Kalenderverwaltung",
      4: "Kursbuchung, Lehrer- & Fahrzeugauswahl",
      5: "Prüfungstermine, Ergebnisse & Simulation",
      6: "Kursgebühren, Online-Zahlung & Historie",
      7: "Erinnerungen & Lehrer-Nachrichten",
      8: "Fahrzeugverwaltung und Wartung",
      9: "Fortschrittsberichte & Leistungsüberwachung",
      10: "Unterstützung für Deutsch & Englisch",
    },
    en: {
      1: "Management of student driver data and profiles",
      2: "Driver, instructor & admin profile management",
      3: "Theoretical & practical courses, calendar management",
      4: "Course booking, instructor & vehicle selection",
      5: "Exam dates, results & simulation tests",
      6: "Course fees, online payment & history",
      7: "Reminders & instructor messaging",
      8: "Vehicle tracking and maintenance",
      9: "Progress reports & performance tracking",
      10: "Support for German & English",
    },
  };

  const description = descriptions[language][module.id];

  return (
    <a
      href={module.link}
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
      onMouseEnter={e => (e.currentTarget.style.transform = "scale(1.05)")}
      onMouseLeave={e => (e.currentTarget.style.transform = "scale(1)")}
    >
      <h2 style={{ marginBottom: "0.5rem" }}>{title}</h2>
      <p style={{ fontSize: "0.9rem", color: "#555" }}>{description}</p>
    </a>
  );
}

export default HomePage;
