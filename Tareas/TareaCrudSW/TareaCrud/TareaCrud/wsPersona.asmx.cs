using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Services;
using MySql.Data.MySqlClient;

namespace TareaCrud
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

        string conexion = "server=localhost;user=root;password=;database=crudpersonas;";

        [WebMethod]
        public Persona persona(int ci, string nombre, String pApellido, String sapelldo)
        {
            Persona persona = new Persona(ci, nombre, pApellido, sapelldo);
            string query = "INSERT INTO persona (ci, nombre, pApellido, sApellido) VALUES (@ci, @nombre, @pApellido, @sApellido)";

            using (MySqlConnection conn = new MySqlConnection(conexion))
            {
                using (MySqlCommand cmd = new MySqlCommand(query, conn))
                {
                    cmd.Parameters.AddWithValue("@ci", persona.ci);
                    cmd.Parameters.AddWithValue("@nombre", persona.nombre);
                    cmd.Parameters.AddWithValue("@pApellido", persona.pApellido);
                    cmd.Parameters.AddWithValue("@sApellido", persona.sApellido);

                    conn.Open(); 
                    cmd.ExecuteNonQuery();
                }
            }

            return persona;
        }



        [WebMethod]
        public List<Persona> ListaPersona() 
        {
            List<Persona> personas = new List<Persona>();

            using (MySqlConnection conn = new MySqlConnection(conexion))
            {
                string query = "SELECT ci, nombre, pApellido, sApellido FROM persona";
                MySqlCommand cmd = new MySqlCommand(query, conn);

                conn.Open();
                MySqlDataReader reader = cmd.ExecuteReader();

                while (reader.Read())
                {
                    personas.Add(new Persona(
                        Convert.ToInt32(reader["ci"]),
                        reader["nombre"].ToString(),
                        reader["pApellido"].ToString(),
                        reader["sApellido"].ToString()
                    ));
                }
            }

            return personas;
        }

        [WebMethod]
        public bool EditarPersona(int ci, string nombre, string pApellido, string sApellido)
        {
            try
            { 
                using (MySqlConnection conn = new MySqlConnection(conexion))
                {
                    string query = "UPDATE persona SET nombre = @nombre, pApellido = @pApellido, sApellido = @sApellido WHERE ci = @ci";
                    MySqlCommand cmd = new MySqlCommand(query, conn);

                    cmd.Parameters.AddWithValue("@ci", ci);
                    cmd.Parameters.AddWithValue("@nombre", nombre);
                    cmd.Parameters.AddWithValue("@pApellido", pApellido);
                    cmd.Parameters.AddWithValue("@sApellido", sApellido);

                    conn.Open();
                    int filasAfectadas = cmd.ExecuteNonQuery(); 
                    return filasAfectadas > 0; 
                }
            }
            catch (Exception)
            {
                return false;
            }
        }

        [WebMethod]
        public bool EliminarPersona(int ci)
        {
            try
            {
                using (MySqlConnection conn = new MySqlConnection(conexion))
                {
                    string query = "DELETE FROM persona WHERE ci = @ci";

                    MySqlCommand cmd = new MySqlCommand(query, conn);
                    cmd.Parameters.AddWithValue("@ci", ci);

                    conn.Open();
                    int filasAfectadas = cmd.ExecuteNonQuery();

                    return filasAfectadas > 0;
                }
            }
            catch (Exception ex)
            {
                return false;
            }
        }
    }
}
