<?php

namespace App\Http\Controllers\Api;

use App\Http\Controllers\Controller;
use Illuminate\Http\Request;
use App\Models\Factura;

class FacturaController extends Controller
{
    /**
     * Display a listing of the resource.
     */
    public function index()
    {
        //
    }

    /**
     * Store a newly created resource in storage.
     */
    public function store(Request $request)
    {
        //
    }

    /**
     * Display the specified resource.
     */
    public function show(string $id)
    {
        //
    }

    /**
     * Update the specified resource in storage.
     */
    public function update(Request $request, string $id)
    {
        //
    }

    /**
     * Remove the specified resource from storage.
     */
    public function destroy(string $id)
    {
        //
    }
    // GET /api/facturas/{ci}
    public function showByCI($ci)
    {
        $facturas = Factura::where('ci', $ci)->get();
        return response()->json($facturas);
    }

    // PUT /api/facturas/{id}
    public function pagarFactura($id)
    {
        $factura = Factura::findOrFail($id);
        $factura->estado = 'Pagado';
        $factura->save();

        return response()->json([
            'mensaje' => 'Factura pagada correctamente',
            'factura' => $factura
        ]);
    }
}
