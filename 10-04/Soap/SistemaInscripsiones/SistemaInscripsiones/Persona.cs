using System.Security.Authentication;

namespace SistemaInscripsiones
{
    public class Persona
    {


        public int ci { get; set; }
        public string nombre { get; set; }
        public string primerApellido { get; set; }
        public string segundoApellido { get; set; }


        public Persona(int ci, string nombre, string primerApellido, string segumndoApellido) { 
            this.ci = ci;
            this.nombre = nombre;
            this.primerApellido = primerApellido;
            this.segundoApellido = segumndoApellido;
        
        }
        public Persona()
        {

        }

    }
}