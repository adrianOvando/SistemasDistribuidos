const express = require('express');
const router = express.Router();
const controller = require('../controllers/facturaController');

router.get('/:ci', controller.buscarPorCI);
router.put('/:id', controller.pagarFactura);

module.exports = router;
