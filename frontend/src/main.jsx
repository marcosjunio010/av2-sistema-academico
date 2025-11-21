import React from "react";
import { createRoot } from "react-dom/client";

function App() {
  return (
    <div style={{
      fontFamily: "Arial, sans-serif",
      padding: "40px",
      maxWidth: "900px",
      margin: "0 auto"
    }}>
      
      <h1 style={{ textAlign: "center" }}>Sistema Acadêmico</h1>
      <p style={{ textAlign: "center" }}>
        Backend: Spring Boot 3 • Frontend: React + Vite
      </p>

      <section style={{
        background: "#f5f5f5",
        padding: "20px",
        borderRadius: "8px",
        marginTop: "30px"
      }}>
        <h2>📚 Cursos cadastrados automaticamente</h2>
        <ul>
          <li>Análise e Desenvolvimento de Sistemas (1600 horas)</li>
          <li>Redes de Computadores (1200 horas)</li>
        </ul>
      </section>

      <section style={{
        background: "#eef6ff",
        padding: "20px",
        borderRadius: "8px",
        marginTop: "20px"
      }}>
        <h2>👨‍🎓 Exemplo de aluno matriculado</h2>
        <p>
          <strong>Nome:</strong> Ronaldinho Gaúcho <br />
          <strong>Matrícula:</strong> 2025002 <br />
          <strong>Curso:</strong> Análise e Desenvolvimento de Sistemas
        </p>
      </section>

      <footer style={{
        marginTop: "40px",
        padding: "20px",
        textAlign: "center",
        fontSize: "14px",
        color: "#666"
      }}>
        Trabalho prático — Sistema Acadêmico
      </footer>
    </div>
  );
}

createRoot(document.getElementById("root")).render(<App />);