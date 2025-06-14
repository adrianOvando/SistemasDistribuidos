<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Model;

class Factura extends Model
{
    protected $fillable = [
        'empresa',
        'nro_factura',
        'ci',
        'nombre_completo',
        'periodo',
        'monto',
        'estado',
    ];
}
