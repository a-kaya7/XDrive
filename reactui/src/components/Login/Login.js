import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import axios from "axios";
import "./Login.css";

function Login() {
  const navigate = useNavigate();
  const [userName, setUserName] = useState("");
  const [passwort, setPasswort] = useState("");
  const [loading, setLoading] = useState(false);
  const [message, setMessage] = useState({ text: "", type: "" });

  const handleLogin = async (e) => {
    e.preventDefault();
    setLoading(true);
    setMessage({ text: "", type: "" });

     try {
    const response = await axios.post("/api/login", {
      userName: userName,
      passwort: passwort,
    });

    navigate("/home");

    setMessage({
      text: "Login erfolgreich! Token: " + response.data.token,
      type: "success",
    });
  } catch (err) {
    setMessage({
      text: "Login fehlgeschlagen. Bitte überprüfen Sie Ihre Eingaben.",
      type: "error",
    });
  } finally {
    setLoading(false);
  }
};

  return (
    <div className="login-container">
      <form className="login-form" onSubmit={handleLogin}>
        <h2>Anmeldung</h2>

        <label>Benutzername</label>
        <input
          type="text"
          value={userName}
          onChange={(e) => setUserName(e.target.value)}
          required
        />

        <label>Passwort</label>
        <input
          type="password"
          value={passwort}
          onChange={(e) => setPasswort(e.target.value)}
          required
        />

        <button type="submit" disabled={loading}>
          {loading ? "Wird geprüft..." : "Login"}
        </button>

        {message.text && (
          <p className={`message ${message.type}`}>{message.text}</p>
        )}
      </form>
    </div>
  );
}

export default Login;
