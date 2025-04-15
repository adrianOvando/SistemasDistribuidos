using System;

namespace Sventas
{
    public class Producto
    {
        public string codigo;
        public string nombre;
        public string descripcion;
        public double precio;
        public Producto() { }

        public Producto (String codigo, string nombre, string descripcion, double precio)
        {
            this.codigo = codigo;
            this.nombre = nombre;
            this.descripcion = descripcion;
            this.precio = precio;
        }




    }
}