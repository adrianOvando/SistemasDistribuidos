namespace TareaCrud
{
    public class Persona
    {
         public int ci { get; set; }
        public string nombre { get; set; }
        public string pApellido { get; set; }
        public string sApellido { get; set; }

        public Persona (int ci, string nombre, string pApellido, string sApellido)
        {
            this.ci = ci;
            this.nombre = nombre;
            this.pApellido = pApellido;
            this.sApellido = sApellido;
        }

        public Persona()
        {

        }
    }
}