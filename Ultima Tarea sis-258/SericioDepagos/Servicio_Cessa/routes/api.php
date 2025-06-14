<?php

use Illuminate\Http\Request;
use Illuminate\Support\Facades\Route;
use App\Http\Controllers\Api\FacturaController;

Route::get('/user', function (Request $request) {
    return $request->user();
})->middleware('auth:sanctum');

Route::get('/facturas/{ci}', [FacturaController::class, 'showByCI']);
Route::put('/facturas/{id}', [FacturaController::class, 'pagarFactura']);