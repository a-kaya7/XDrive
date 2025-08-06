import React, { useState, useEffect } from "react";
import axios from "axios";
import { useNavigate } from "react-router-dom";

const PRIMARY_COLOR = "#174bd1ff";

const MandantenNeuanlage = () => {
  const [idname, setIdname] = useState("");
  const [bezeichnung, setBezeichnung] = useState("");
  const [institut, setInstitut] = useState("");
  const [locale, setLocale] = useState("");

  const [name1, setName1] = useState("");
  const [name2, setName2] = useState("");
  const [straße, setStraße] = useState("");
  const [plz, setPlz] = useState("");
  const [ort, setOrt] = useState("");
  const [land, setLand] = useState("");
  const [telefon, setTelefon] = useState("");
  const [email, setEmail] = useState("");

  const [error, setError] = useState("");
  const [message, setMessage] = useState({ text: "", type: "" });
  const [loading, setLoading] = useState(false);
  const [instituteListe, setInstituteListe] = useState([]);

  const navigate = useNavigate();

  useEffect(() => {
  const fetchInstitutes = async () => {
    try {
      const response = await axios.get("/api/institutanzeigen");
      console.log("Institutes from API:", response.data);
      setInstituteListe(response.data);
    } catch (err) {
      console.error("Fehler beim Laden der Institute:", err);
    }
  };
  fetchInstitutes();
}, []);


  const handleSubmit = async (e) => {
    e.preventDefault();
    setMessage({ text: "", type: "" });

    if (!idname.trim()) return setError("ID ist erforderlich!");
    if (!bezeichnung.trim()) return setError("Bezeichnung ist erforderlich!");
    if (!institut.trim()) return setError("Institut ist erforderlich!");
    if (!name1) return setError("Name ist erforderlich!");

    setError("");
    setLoading(true);

    try {
      await axios.post("/api/mandantenneuanlage", {
        idname,
        bezeichnung,
        institut: {id: Number(institut)},
        locale,
        name1,
        name2,
        straße,
        plz,
        ort,
        land,
        telefon,
        email,
      });

      setMessage({ text: "Mandant erfolgreich gespeichert!", type: "success" });
      setTimeout(() => navigate("/mandanten"), 1000);
    } catch (err) {
      setMessage({
        text:
    typeof err.response?.data === "string"
      ? err.response.data
      : err.response?.data?.message || "Fehler aufgetreten",
  type: "error",
      });
    } finally {
      setLoading(false);
    }
  };

  return (
    <div style={page}>
      <div style={container}>
        <h2 style={title}>Mandanten anlegen</h2>

        <form onSubmit={handleSubmit}>
          <h3 style={sectionTitle}>Allgemeine Angaben</h3>

          <div style={field}>
            <label style={label}>
              ID <span style={{ color: "red" }}>*</span>
            </label>
            <input
              type="text"
              value={idname}
              onChange={(e) => setIdname(e.target.value)}
              style={input}
            />
          </div>

          <div style={field}>
            <label style={label}>Bezeichnung</label>
            <input
              type="text"
              value={bezeichnung}
              onChange={(e) => setBezeichnung(e.target.value)}
              style={input}
            />
          </div>
           
           <label htmlFor="institut-select" style={label}>
                Institut auswählen <span style={{ color: "red" }}>*</span>
            </label>
           <select
            value={institut}
            onChange={(e) => setInstitut(e.target.value)}
            style={{ ...input, border: "none", borderBottom: "2px solid #ccc" }}
           >
           <option value="">- Bitte wählen -</option>
            {instituteListe.map((inst) => (
             <option key={inst.id} value={inst.id}>
            {inst.idname}
            </option>
                 ))}
            </select>



          <div style={field}>
            <label style={label}>Locale</label>
            <input
              type="text"
              value={locale}
              onChange={(e) => setLocale(e.target.value)}
              style={input}
            />
          </div>

          <h3 style={sectionTitle}>Adresse</h3>

          <div style={field}>
            <label style={label}>
              Name 1 <span style={{ color: "red" }}>*</span>
            </label>
            <input
              type="text"
              value={name1}
              onChange={(e) => setName1(e.target.value)}
              style={input}
            />
          </div>

          <div style={field}>
            <label style={label}>Name 2</label>
            <input
              type="text"
              value={name2}
              onChange={(e) => setName2(e.target.value)}
              style={input}
            />
          </div>

          <div style={field}>
            <label style={label}>Straße</label>
            <input
              type="text"
              value={straße}
              onChange={(e) => setStraße(e.target.value)}
              style={input}
            />
          </div>

          <div style={field}>
            <label style={label}>PLZ</label>
            <input
              type="text"
              value={plz}
              onChange={(e) => setPlz(e.target.value)}
              style={input}
            />
          </div>

          <div style={field}>
            <label style={label}>Ort</label>
            <input
              type="text"
              value={ort}
              onChange={(e) => setOrt(e.target.value)}
              style={input}
            />
          </div>

          <div style={field}>
            <label style={label}>Land</label>
            <input
              type="text"
              value={land}
              onChange={(e) => setLand(e.target.value)}
              style={input}
            />
          </div>

          <div style={field}>
            <label style={label}>Telefon</label>
            <input
              type="text"
              value={telefon}
              onChange={(e) => setTelefon(e.target.value)}
              style={input}
            />
          </div>

          <div style={field}>
            <label style={label}>Email</label>
            <input
              type="text"
              value={email}
              onChange={(e) => setEmail(e.target.value)}
              style={input}
            />
          </div>

          {error && <div style={errorStyle}>{error}</div>}

          {message.text && (
            <div
              style={{
                color: message.type === "error" ? "red" : "green",
                marginBottom: "1rem",
              }}
            >
              {message.text}
            </div>
          )}

          <div style={buttonsRow}>
            <button type="submit" style={buttonPrimary} disabled={loading}>
              {loading ? "Speichere..." : "Speichern"}
            </button>
            <button
              type="button"
              style={buttonSecondary}
              onClick={() => navigate(-1)}
            >
              Zurück
            </button>
          </div>
        </form>
      </div>
    </div>
  );
};

// Styles
const page = { fontFamily: "Arial, sans-serif", padding: "2rem" };
const container = {
  maxWidth: 600,
  margin: "0 auto",
  padding: "2rem",
  background: "transparent",
};
const title = { textAlign: "center", color: PRIMARY_COLOR, marginBottom: "1.5rem" };
const sectionTitle = {
  color: PRIMARY_COLOR,
  margin: "1.5rem 0 0.8rem 0",
  fontSize: "1.05rem",
};
const field = { marginBottom: "1.5rem" };
const label = { display: "block", marginBottom: "0.3rem" };
const input = {
  width: "100%",
  padding: "0.5rem 0",
  border: "none",
  borderBottom: "2px solid #ccc",
  fontSize: "1rem",
  outline: "none",
};
const errorStyle = {
  color: "red",
  fontSize: "0.9rem",
  marginBottom: "0.8rem",
};
const buttonsRow = { display: "flex", gap: "1rem", justifyContent: "flex-start" };
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
const buttonSecondary = { ...buttonBase };

export default MandantenNeuanlage;
