const mongoose = require('mongoose');

const facturaSchema = new mongoose.Schema({
  empresa: String,
  nro_factura: { type: String, unique: true },
  ci: String,
  nombre_completo: String,
  periodo: String,
  monto: Number,
  estado: { type: String, enum: ['Pendiente', 'Pagado'], default: 'Pendiente' },
});

module.exports = mongoose.model('Factura', facturaSchema);
