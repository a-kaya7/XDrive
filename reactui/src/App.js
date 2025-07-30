import React from "react";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import Login from "./components/Login/Login";
import HomePage from "./components/HomePage/HomePage";
import Administration from "./components/Administration/Administration";
import AdministrationAllgemein from "./components/Administration/AdministrationAllgemein";
import Benutzergruppe from "./components/Administration/Benutzergruppe";
import Benutzergruppeneuanlage from "./components/Administration/Benutzergruppeneuanlage";
import Benutzerbearbeiten from "./components/Administration/Benutzerbearbeiten";
import Benutzerneuanlage from "./components/Administration/Benutzerneuanlage";
import Institut from "./components/Administration/Institut";
import Institutneuanlage from "./components/Administration/Institutneuanlage";
import Institutbearbeiten from "./components/Administration/Institutbearbeiten";
import PortalLayout from "./components/PortalLayout/PortalLayout";

function App() {
  return (
    <Router>
      <Routes>
        {/* Login Layout'u ayrı tutuyoruz */}
        <Route path="/login" element={<Login />} />

        {/* Tüm diğer sayfalar PortalLayout içinde */}
        <Route element={<PortalLayout />}>
          <Route path="/home" element={<HomePage />} />
          <Route path="/administration" element={<Administration />} />
          <Route path="/administrationallgemein" element={<AdministrationAllgemein />} />
          <Route path="/benutzergruppe" element={<Benutzergruppe />} />
          <Route path="/benutzergruppeneuanlage" element={<Benutzergruppeneuanlage />} />
          <Route path="/benutzerbearbeiten/:id" element={<Benutzerbearbeiten />} />
          <Route path="/benutzerneuanlage" element={<Benutzerneuanlage />} />
          <Route path="/institute" element={<Institut />} />
          <Route path="/institutbearbeiten/:idname" element={<Institutbearbeiten />} />
          <Route path="/institutneuanlage" element={<Institutneuanlage />} />
        </Route>
      </Routes>
    </Router>
  );
}

export default App;
