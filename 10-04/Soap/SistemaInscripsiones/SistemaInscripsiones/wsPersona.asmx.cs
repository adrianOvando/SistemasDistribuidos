using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Services;

namespace SistemaInscripsiones
{
    /// <summary>
    /// Descripción breve de wsPersona
    /// </summary>
    [WebService(Namespace = "http://tempuri.org/")]
    [WebServiceBinding(ConformsTo = WsiProfiles.BasicProfile1_1)]
    [System.ComponentModel.ToolboxItem(false)]
    // Para permitir que se llame a este servicio web desde un script, usando ASP.NET AJAX, quite la marca de comentario de la línea siguiente. 
    // [System.Web.Script.Services.ScriptService]
    public class wsPersona : System.Web.Services.WebService
    {

        [WebMethod]
        public Persona crearPersona(int ci, string nombre, string prApellido, string seApellido)
        {
            Persona persona = new Persona(ci, nombre, prApellido, seApellido);
            return persona;
        }

        [WebMethod]
        public Persona[] listaPersonas() {
            return null;
        }
    }
}
