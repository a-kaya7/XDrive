// src/components/Administration/BenutzerBearbeiten.jsx
import React, { useEffect, useMemo, useState } from "react";
import axios from "axios";
import { useLocation, useNavigate, useParams } from "react-router-dom";
import { FiEdit, FiTrash2 } from "react-icons/fi";

const PRIMARY_COLOR = "#174bd1ff";

const BenutzerBearbeiten = () => {
  const { Id } = useParams();
  const location = useLocation();
  const navigate = useNavigate();

  // Liste sayfasından gönderdiğimiz grup adı (ör. Admin)
  const initialGruppeName = location.state?.gruppeName ?? "";

  const [gruppeName, setGruppeName] = useState(initialGruppeName);
  const [eingabe, setEingabe] = useState("");
  const [users, setUsers] = useState([]);
  const [loading, setLoading] = useState(false);
  const [msg, setMsg] = useState({ text: "", type: "" });

  useEffect(() => {
    const fetchData = async () => {
      setLoading(true);
      try {
        // Kullanıcıları çek
        const { data } = await axios.get(`/api/benutzergruppen/${Id}`);
        setUsers(data);
      } catch (e) {
        setMsg({ text: "", type: "error" });
      } finally {
        setLoading(false);
      }
    };

    fetchData();
  }, [Id]);

  const filteredUsers = useMemo(() => {
    const q = eingabe.trim().toLowerCase();
    if (!q) return users;
    return users.filter(
      (u) =>
        u.benutzerkennung?.toLowerCase().includes(q) ||
        `${u.vorname ?? ""} ${u.nachname ?? ""}`.toLowerCase().includes(q) ||
        (u.mandantName ?? "").toLowerCase().includes(q)
    );
  }, [users, eingabe]);

  const handleSubmit = (e) => {
    e.preventDefault();
    setMsg({ text: "", type: "" });

    if (!eingabe.trim()) {
      setMsg({ text: "Eingabe ist erforderlich!", type: "error" });
      return;
    }

    // Burada istersen eingabe ile bir arama/filter tetiklersin
    // veya backend'e patch/put gönderirsin.
    setMsg({ text: "Neuanlage erfolgreich ausgeführt (Dummy).", type: "success" });
  };

  const handleEditUser = (userId) => {
    // örn. kullanıcı düzenleme sayfasına git
    navigate(`/benutzer/edit/${userId}`);
  };

  const handleDeleteUser = async (userId) => {
    if (!window.confirm("Soll dieser Benutzer gelöscht werden?")) return;
    try {
      await axios.delete(`/api/benutzer/${userId}`);
      setUsers((prev) => prev.filter((u) => u.id !== userId));
    } catch (e) {
      alert("Löschen fehlgeschlagen!");
    }
  };

  return (
    <div style={page}>
      <div style={container}>
        <h2 style={title}>Benutzer bearbeiten</h2>

        {/* Auswahl Benutzer */}
        <section style={section}>
          <h3 style={sectionHeader}>Auswahl Benutzer</h3>
          <div style={{ marginBottom: "1.2rem" }}>
            <strong>Benutzergruppe:</strong>{" "}
            <span style={{ color: PRIMARY_COLOR }}>{gruppeName || "(unbekannt)"}</span>
          </div>
        </section>

        {/* Benutzer bearbeiten (form) */}
        <section style={section}>
          <h3 style={sectionHeader}>Benutzer bearbeiten</h3>

          <form onSubmit={handleSubmit}>
            <div style={field}>
              <label style={label}>
                Benutzer bearbeiten <span style={{ color: "red" }}>*</span>
              </label>
              <input
                type="text"
                value={eingabe}
                onChange={(e) => setEingabe(e.target.value)}
                style={input}
                placeholder="Suchen / Eingabe..."
              />
            </div>

            {msg.text && (
              <div
                style={{
                  color: msg.type === "error" ? "red" : "green",
                  marginBottom: "1.5rem",
                }}
              >
                {msg.text}
              </div>
            )}

            <div style={buttonsRow}>
              <button 
              type="button"
              style={buttonPrimary}
              onClick={() => navigate("/benutzerneuanlage")}>
                Neuanlage
              </button>
              <button
                type="button"
                style={buttonPrimary}
                onClick={() => navigate(-1)}
              >
                Zurück
              </button>
            </div>
          </form>
        </section>

        {/* Benutzer tablosu */}
        <section style={section}>
          <h3 style={sectionHeader}>Benutzer der Gruppe</h3>

          {loading ? (
            <div>Lädt...</div>
          ) : (
            <table style={tableStyle}>
              <thead>
                <tr>
                  <th style={thStyle}>Benutzerkennung</th>
                  <th style={thStyle}>Name</th>
                  <th style={thStyle}>Benutzer bis</th>
                  <th style={thStyle}>Mandant</th>
                  <th style={thStyle}>Aktion</th>
                </tr>
              </thead>
              <tbody>
                {filteredUsers.length === 0 ? (
                  <tr>
                    <td colSpan={5} style={{ textAlign: "center", padding: "1rem" }}>
                      Keine Daten vorhanden.
                    </td>
                  </tr>
                ) : (
                  filteredUsers.map((u) => (
                    <tr key={u.id}>
                      <td style={tdStyle}>{u.benutzerkennung}</td>
                      <td style={tdStyle}>
                        {(u.vorname || "") + " " + (u.nachname || "")}
                      </td>
                      <td style={tdStyle}>{u.benutzerBis || "-"}</td>
                      <td style={tdStyle}>{u.mandantName || "-"}</td>
                      <td style={tdStyle}>
                        <button
                          type="button"
                          style={iconButton}
                          onClick={() => handleEditUser(u.id)}
                          aria-label="Bearbeiten"
                          title="Bearbeiten"
                        >
                          <FiEdit size={18} />
                        </button>
                        <button
                          type="button"
                          style={{ ...iconButton, marginLeft: "0.5rem" }}
                          onClick={() => handleDeleteUser(u.id)}
                          aria-label="Löschen"
                          title="Löschen"
                        >
                          <FiTrash2 size={18} />
                        </button>
                      </td>
                    </tr>
                  ))
                )}
              </tbody>
            </table>
          )}
        </section>
      </div>
    </div>
  );
};

/* ---------------- styles ---------------- */
const page = { fontFamily: "Arial, sans-serif", padding: "2rem" };

const container = {
  maxWidth: 1000,
  margin: "0 auto",
};

const title = { textAlign: "center", color: PRIMARY_COLOR, marginBottom: "2rem" };

const section = { marginBottom: "2rem" };

const sectionHeader = { color: PRIMARY_COLOR, marginBottom: "1.5rem" };

const field = { marginBottom: "2rem" };

const label = { display: "block", marginBottom: "0.6rem" };

const input = {
  width: "100%",
  padding: "0.7rem 0",
  border: "none",
  borderBottom: "2px solid #ccc",
  fontSize: "1rem",
  outline: "none",
};

const buttonsRow = {
  display: "flex",
  gap: "1.5rem",
  justifyContent: "flex-end", // sağa hizalama
};

const buttonBase = {
  backgroundColor: PRIMARY_COLOR,
  color: "#fff",
  padding: "0.7rem 2rem",
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
  padding: "0.75rem",
  textAlign: "left",
  backgroundColor: "#f5f5f5",
  color: PRIMARY_COLOR,
};

const tdStyle = {
  borderBottom: "1px solid #ddd",
  padding: "0.75rem",
};

const iconButton = {
  background: "none",
  border: "none",
  color: PRIMARY_COLOR,
  cursor: "pointer",
  fontSize: "1rem",
  padding: 0,
};

export default BenutzerBearbeiten;
