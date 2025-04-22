using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Services;
using MySql.Data.MySqlClient;
using Mysqlx.Cursor;

namespace sCotizacion
{
    /// <summary>
    /// Descripción breve de swCotizar
    /// </summary>
    [WebService(Namespace = "http://tempuri.org/")]
    [WebServiceBinding(ConformsTo = WsiProfiles.BasicProfile1_1)]
    [System.ComponentModel.ToolboxItem(false)]
    // Para permitir que se llame a este servicio web desde un script, usando ASP.NET AJAX, quite la marca de comentario de la línea siguiente. 
    // [System.Web.Script.Services.ScriptService]
    public class swCotizar : System.Web.Services.WebService
    {

        string conexion = "server=localhost;user=root;password=;database=cotizaciones;";

        [WebMethod]
        public string obtenerCotizacion(string fecha)
        {
            string resultado = "";

            using (MySqlConnection conn = new MySqlConnection(conexion))
            {
                string query = "SELECT cotizacion FROM cotizar WHERE fecha = @fe";

                using (MySqlCommand cmd = new MySqlCommand(query, conn))
                {
                    cmd.Parameters.AddWithValue("@fe", fecha);
                    conn.Open();

                    using (MySqlDataReader reader = cmd.ExecuteReader())
                    {
                        if (reader.Read())
                        {
                            resultado = reader["cotizacion"].ToString();
                        }
                        else
                        {
                            resultado = "No se encontró cotización para esa fecha.";
                        }
                    }
                }
            }

            return resultado;
        }

        [WebMethod]
        public void registrarCotizacion(string fecha, float monto, float co_of)
        {
            string query = "INSERT INTO cotizar (fecha, cotizacion , cotizacion_oficial) VALUES (@fecha, @monto, @co_of)";

            using (MySqlConnection conn = new MySqlConnection(conexion))
            {
                using (MySqlCommand cmd = new MySqlCommand(query, conn))
                {
                    cmd.Parameters.AddWithValue("@fecha", fecha);
                    cmd.Parameters.AddWithValue("@monto", monto);
                    cmd.Parameters.AddWithValue("@co_of", co_of);   

                    conn.Open();
                    cmd.ExecuteNonQuery();
                }
            }

        }
    }
}
