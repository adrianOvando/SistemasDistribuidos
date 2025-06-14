const Factura = require('../models/Factura');

exports.buscarPorCI = async (req, res) => {
  const facturas = await Factura.find({ ci: req.params.ci });
  res.json(facturas);
};

exports.pagarFactura = async (req, res) => {
  const factura = await Factura.findByIdAndUpdate(
    req.params.id,
    { estado: 'Pagado' },
    { new: true }
  );
  res.json({ mensaje: 'Factura pagada', factura });
};
