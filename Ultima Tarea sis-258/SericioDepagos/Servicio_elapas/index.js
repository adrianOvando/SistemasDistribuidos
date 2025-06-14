const express = require('express');
const mysql = require('mysql2');
const app = express();
app.use(express.json());

// Conexión a la BD
const db = mysql.createConnection({
  host: 'localhost',
  user: 'root',
  password: '', // tu contraseña si tiene
  database: 'bd_sistema_pagos'
});
    
// Buscar facturas por CI
app.get('/facturas/:ci', (req, res) => {
  const ci = req.params.ci;
  db.query('SELECT * FROM facturas WHERE ci = ?', [ci], (err, results) => {
    if (err) return res.status(500).json({ error: err });
    res.json(results);
  });
});

// Pagar factura por ID
app.put('/facturas/:id', (req, res) => {
  const id = req.params.id;
  db.query(
    'UPDATE facturas SET estado = "Pagado" WHERE id = ?',
    [id],
    (err, result) => {
      if (err) return res.status(500).json({ error: err });
      res.json({ mensaje: 'Factura pagada correctamente' });
    }
  );
});

// Iniciar servidor
app.listen(3000, () => {
  console.log('Servicio Elapas corriendo en puerto 3000');
});
