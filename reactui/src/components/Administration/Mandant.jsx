import React from "react";
import { useNavigate } from "react-router-dom";

const PRIMARY_COLOR = "#174bd1ff";

const ActionButtons = () => {
  const navigate = useNavigate();

  return (
    <div style={buttonContainer}>
      <button style={buttonPrimary} onClick={() => navigate(-1)}>
        Zurück
      </button>
      <button style={buttonPrimary} onClick={() => navigate("/mandantenneuanlage")}>
        Neuanlage
      </button>
      <button style={buttonPrimary} onClick={() => navigate("/mandanten")}>
        Alle Mandanten
      </button>
    </div>
  );
};

// Stil tanımları
const buttonContainer = {
  marginTop: "1rem",
  display: "flex",
  justifyContent: "flex-end",
  gap: "1rem",
};

const buttonPrimary = {
  backgroundColor: PRIMARY_COLOR,
  color: "#fff",
  padding: "0.5rem 1.5rem",
  border: "none",
  borderRadius: "4px",
  cursor: "pointer",
  fontSize: "1rem",
};

export default ActionButtons;
