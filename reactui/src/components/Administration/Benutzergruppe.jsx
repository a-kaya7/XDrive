import React, { useEffect, useState } from "react";
import axios from "axios";
import { useNavigate } from "react-router-dom";
import { FiEdit, FiTrash2 } from "react-icons/fi";
import { FaUserEdit } from "react-icons/fa";

const PRIMARY_COLOR = "#174bd1ff";

const BenutzergruppenListe = () => {
  const [benutzergruppen, setBenutzergruppen] = useState([]);
  const navigate = useNavigate();

  useEffect(() => {
    fetchBenutzergruppen();
  }, []);

  const fetchBenutzergruppen = async () => {
    try {
      const response = await axios.get("/api/benutzergruppen");
      setBenutzergruppen(response.data);
    } catch (err) {
      console.error("Fehler beim Laden der Benutzergruppen:", err);
    }
  };

  const handleDelete = async (id) => {
    if (!window.confirm("Soll diese Benutzergruppe gelöscht werden?")) return;
    try {
      await axios.delete(`/api/benutzergruppen/${id}`);
      setBenutzergruppen((prev) => prev.filter((g) => g.id !== id));
    } catch (e) {
      alert("Löschen fehlgeschlagen!");
    }
  };

  return (
    <div style={page}>
      <table style={tableStyle}>
        <thead>
          <tr>
            <th style={thStyle}>Benutzergruppe</th>
            <th style={thStyle}>Beschreibung</th>
            <th style={thStyle}>Freigaberecht</th>
            <th style={thStyle}>Action</th>
          </tr>
        </thead>
        <tbody>
          {benutzergruppen.map((item) => (
            <tr key={item.id}>
              <td style={tdStyle}>{item.benutzergruppe}</td>
              <td style={tdStyle}>{item.beschreibung}</td>
              <td style={tdStyle}>{item.freigabe ? "Ja" : "Nein"}</td>
              <td style={tdStyle}>
                {/* Gruppe bearbeiten */}
                <button
                  type="button"
                  style={iconButton}
                  onClick={() => navigate(`/benutzergruppeneuanlage/${item.id}`)}
                  aria-label="Benutzergruppe bearbeiten"
                  title="Benutzergruppe bearbeiten"
                >
                  <FiEdit size={20} />
                </button>

                {/* Löschen */}
                <button
                  type="button"
                  style={{ ...iconButton, marginLeft: "0.5rem" }}
                  onClick={() => handleDelete(item.id)}
                  aria-label="Löschen"
                  title="Löschen"
                >
                  <FiTrash2 size={20} />
                </button>

                {/* Benutzer bearbeiten */}
                <button
                  type="button"
                  style={{ ...iconButton, marginLeft: "0.5rem" }}
                  onClick={() =>
                    navigate(`/benutzerbearbeiten/${item.id}`, {
                      state: { gruppeName: item.benutzergruppe },
                    })
                  }
                  aria-label="Benutzer bearbeiten"
                  title="Benutzer bearbeiten"
                >
                  <FaUserEdit size={20} />
                </button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>

      {/* Alt sağ köşe butonları */}
      <div style={buttonContainer}>
        <button
    style={buttonPrimary}
    onClick={() => navigate(-1)}  // Zurück butonu için navigate(-1)
       >
         Zurück
       </button>
        <button
          style={buttonPrimary}
          onClick={() => navigate("/benutzergruppeneuanlage")}
        >
          Neuanlage
        </button>
        <button
          style={buttonPrimary}
          onClick={() => navigate("/benutzer")}
        >
          Alle Benutzer
        </button>
      </div>
    </div>
  );
};

const page = {
  fontFamily: "Arial, sans-serif",
  padding: "2rem",
  minHeight: "100vh",
  position: "relative",
};

const buttonContainer = {
  position: "fixed",
  bottom: "1.5rem",
  right: "1.5rem",
  display: "flex",
  gap: "1rem",
};

const buttonBase = {
  backgroundColor: PRIMARY_COLOR,
  color: "#fff",
  padding: "0.5rem 1.5rem",
  border: "none",
  borderRadius: "4px",
  cursor: "pointer",
  fontSize: "1rem",
};

const buttonPrimary = { ...buttonBase };

const tableStyle = {
  width: "100%",
  borderCollapse: "collapse",
};

const thStyle = {
  borderBottom: "2px solid #ccc",
  padding: "0.5rem",
  textAlign: "left",
  backgroundColor: "#f5f5f5",
  color: PRIMARY_COLOR,
};

const tdStyle = {
  borderBottom: "1px solid #ddd",
  padding: "0.5rem",
};

const iconButton = {
  background: "none",
  border: "none",
  color: PRIMARY_COLOR,
  cursor: "pointer",
  fontSize: "1.2rem",
  padding: 0,
};

export default BenutzergruppenListe;
