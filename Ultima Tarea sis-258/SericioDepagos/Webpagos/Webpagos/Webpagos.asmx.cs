using System;
using System.Collections.Generic;
using System.Linq;
using System.Net.Http;
using System.Text;
using System.Threading.Tasks;
using System.Web.Services;
using Newtonsoft.Json;
using System.Diagnostics;

namespace Webpagos
{
    /// <summary>
    /// Servicio Web Webpagos: orquesta ConsultarDeudas y Pagar sobre Cessa, Elapas y Entel.
    /// </summary>
    [WebService(Namespace = "http://tempuri.org/")]
    [WebServiceBinding(ConformsTo = WsiProfiles.BasicProfile1_1)]
    [System.ComponentModel.ToolboxItem(false)]
    public class Webpagos : System.Web.Services.WebService
    {
     
        private readonly string urlCessa = "http://localhost:8000/api/facturas";   // Laravel
        private readonly string urlElapas = "http://localhost:3000/facturas";  // NodeJS 
        private readonly string urlEntel = "http://localhost:3002/graphql";       // NodeJS GraphQL


        [WebMethod]
        public Factura[] ConsultarDeudas(string ci)
        {
            if (string.IsNullOrWhiteSpace(ci))
            {
                Debug.WriteLine("CI está vacío");
                return new Factura[0];
            }

            var todasLasFacturas = new List<Factura>();

            try
            {
                var taskCessa = Task.Run(async () => await ConsultarFacturasCessa(ci));
                var taskElapas = Task.Run(async () => await ConsultarFacturasElapas(ci));
                var taskEntel = Task.Run(async () => await ConsultarFacturasEntel(ci));

                Task.WaitAll(taskCessa, taskElapas, taskEntel);

                todasLasFacturas.AddRange(taskCessa.Result);
                todasLasFacturas.AddRange(taskElapas.Result);
                todasLasFacturas.AddRange(taskEntel.Result);
            }
            catch (Exception ex)
            {
                Debug.WriteLine($"Error en ConsultarDeudas: {ex.Message}");
                Debug.WriteLine($"StackTrace: {ex.StackTrace}");
            }

            return todasLasFacturas.ToArray();
        }

        [WebMethod]
        public bool Pagar(Factura[] facturas)
        {
            if (facturas == null || facturas.Length == 0)
            {
                Debug.WriteLine("No hay facturas para pagar");
                return false;
            }

            bool todosPagadosCorrectamente = true;

            try
            {
                foreach (var factura in facturas)
                {
                    if (factura == null || string.IsNullOrWhiteSpace(factura.Empresa))
                    {
                        Debug.WriteLine("Factura nula o sin empresa");
                        todosPagadosCorrectamente = false;
                        continue;
                    }

                    bool pagado = false;
                    switch (factura.Empresa.ToUpperInvariant())
                    {
                        case "CESSA":
                            pagado = Task.Run(async () => await PagarFacturaCessa(factura.Id)).Result;
                            break;
                        case "ELAPAS":
                            pagado = Task.Run(async () => await PagarFacturaElapas(factura.Id)).Result;
                            break;
                        case "ENTEL":
                            pagado = Task.Run(async () => await PagarFacturaEntel(factura.Id)).Result;
                            break;
                        default:
                            Debug.WriteLine($"Empresa desconocida: {factura.Empresa}");
                            pagado = false;
                            break;
                    }

                    if (pagado)
                    {
                        factura.Estado = "Pagado";
                        Debug.WriteLine($"Factura {factura.Id} de {factura.Empresa} pagada correctamente");
                    }
                    else
                    {
                        todosPagadosCorrectamente = false;
                        Debug.WriteLine($"Error al pagar factura {factura.Id} de {factura.Empresa}");
                    }
                }
            }
            catch (Exception ex)
            {
                Debug.WriteLine($"Error en Pagar: {ex.Message}");
                Debug.WriteLine($"StackTrace: {ex.StackTrace}");
                return false;
            }

            return todosPagadosCorrectamente;
        }

        private async Task<List<Factura>> ConsultarFacturasCessa(string ci)
        {
            var lista = new List<Factura>();
            HttpClient client = null;

            try
            {
                client = new HttpClient();
                client.Timeout = TimeSpan.FromSeconds(30);

                var response = await client.GetAsync($"{urlCessa}/{ci}");
                Debug.WriteLine($"Respuesta Cessa: {response.StatusCode}");

                if (response.IsSuccessStatusCode)
                {
                    var json = await response.Content.ReadAsStringAsync();
                    Debug.WriteLine($"JSON Cessa: {json}");

                    if (!string.IsNullOrWhiteSpace(json))
                    {
                        var facturasResponse = JsonConvert.DeserializeObject<List<FacturaResponse>>(json);
                        if (facturasResponse != null)
                        {
                            foreach (var f in facturasResponse)
                            {
                                lista.Add(new Factura
                                {
                                    Id = f.id,
                                    Empresa = "CESSA",
                                    NroFactura = f.nro_factura ?? "",
                                    CI = f.ci ?? "",
                                    NombreCompleto = f.nombre_completo ?? "",
                                    Periodo = f.periodo ?? "",
                                    Monto = f.monto,
                                    Estado = f.estado ?? "Pendiente"
                                });
                            }
                        }
                    }
                }
            }
            catch (Exception ex)
            {
                Debug.WriteLine($"Error ConsultarFacturasCessa: {ex.Message}");
            }
            finally
            {
                client?.Dispose();
            }

            return lista;
        }

        private async Task<List<Factura>> ConsultarFacturasElapas(string ci)
        {
            var lista = new List<Factura>();
            HttpClient client = null;

            try
            {
                client = new HttpClient();
                client.Timeout = TimeSpan.FromSeconds(30);

                var response = await client.GetAsync($"{urlElapas}/{ci}");
                Debug.WriteLine($"Respuesta Elapas: {response.StatusCode}");

                if (response.IsSuccessStatusCode)
                {
                    var json = await response.Content.ReadAsStringAsync();
                    Debug.WriteLine($"JSON Elapas: {json}");

                    if (!string.IsNullOrWhiteSpace(json))
                    {
                        var facturasResponse = JsonConvert.DeserializeObject<List<FacturaResponse>>(json);
                        if (facturasResponse != null)
                        {
                            foreach (var f in facturasResponse)
                            {
                                lista.Add(new Factura
                                {
                                    Id = f.id,
                                    Empresa = "ELAPAS",
                                    NroFactura = f.nro_factura ?? "",
                                    CI = f.ci ?? "",
                                    NombreCompleto = f.nombre_completo ?? "",
                                    Periodo = f.periodo ?? "",
                                    Monto = f.monto,
                                    Estado = f.estado ?? "Pendiente"
                                });
                            }
                        }
                    }
                }
            }
            catch (Exception ex)
            {
                Debug.WriteLine($"Error ConsultarFacturasElapas: {ex.Message}");
            }
            finally
            {
                client?.Dispose();
            }

            return lista;
        }

        private async Task<List<Factura>> ConsultarFacturasEntel(string ci)
        {
            var lista = new List<Factura>();
            HttpClient client = null;

            try
            {
                client = new HttpClient();
                client.Timeout = TimeSpan.FromSeconds(30);

                // Consulta GraphQL para obtener facturas
                var graphqlQuery = new
                {
                    query = $@"
                    {{
                      facturas(ci: ""{ci}"") {{
                        id
                        empresa
                        nro_factura
                        ci
                        nombre_completo
                        periodo
                        monto
                        estado
                      }}
                    }}"
                };

                var jsonQuery = JsonConvert.SerializeObject(graphqlQuery);
                var content = new StringContent(jsonQuery, Encoding.UTF8, "application/json");
                var response = await client.PostAsync(urlEntel, content);

                Debug.WriteLine($"Respuesta Entel: {response.StatusCode}");

                if (response.IsSuccessStatusCode)
                {
                    var jsonResponse = await response.Content.ReadAsStringAsync();
                    Debug.WriteLine($"JSON Entel: {jsonResponse}");

                    if (!string.IsNullOrWhiteSpace(jsonResponse))
                    {
                        var graphqlResponse = JsonConvert.DeserializeObject<GraphQLResponse>(jsonResponse);
                        if (graphqlResponse?.data?.facturas != null)
                        {
                            foreach (var f in graphqlResponse.data.facturas)
                            {
                                lista.Add(new Factura
                                {
                                    Id = f.id,
                                    Empresa = "ENTEL",
                                    NroFactura = f.nro_factura ?? "",
                                    CI = f.ci ?? "",
                                    NombreCompleto = f.nombre_completo ?? "",
                                    Periodo = f.periodo ?? "",
                                    Monto = f.monto,
                                    Estado = f.estado ?? "Pendiente"
                                });
                            }
                        }
                    }
                }
            }
            catch (Exception ex)
            {
                Debug.WriteLine($"Error ConsultarFacturasEntel: {ex.Message}");
            }
            finally
            {
                client?.Dispose();
            }

            return lista;
        }

       

        private async Task<bool> PagarFacturaCessa(int idFactura)
        {
            HttpClient client = null;
            try
            {
                client = new HttpClient();
                client.Timeout = TimeSpan.FromSeconds(30);

                // Laravel espera PUT /api/facturas/{id}
                var content = new StringContent("{}", Encoding.UTF8, "application/json");
                var response = await client.PutAsync($"{urlCessa}/{idFactura}", content);
                Debug.WriteLine($"Pago Cessa {idFactura}: {response.StatusCode}");
                return response.IsSuccessStatusCode;
            }
            catch (Exception ex)
            {
                Debug.WriteLine($"Error PagarFacturaCessa: {ex.Message}");
                return false;
            }
            finally
            {
                client?.Dispose();
            }
        }

        private async Task<bool> PagarFacturaElapas(int idFactura)
        {
            HttpClient client = null;
            try
            {
                client = new HttpClient();
                client.Timeout = TimeSpan.FromSeconds(30);

                // Node REST espera PUT /api/facturas/{id}
                var content = new StringContent("{}", Encoding.UTF8, "application/json");
                var response = await client.PutAsync($"{urlElapas}/{idFactura}", content);
                Debug.WriteLine($"Pago Elapas {idFactura}: {response.StatusCode}");
                return response.IsSuccessStatusCode;
            }
            catch (Exception ex)
            {
                Debug.WriteLine($"Error PagarFacturaElapas: {ex.Message}");
                return false;
            }
            finally
            {
                client?.Dispose();
            }
        }

        private async Task<bool> PagarFacturaEntel(int idFactura)
        {
            HttpClient client = null;
            try
            {
                client = new HttpClient();
                client.Timeout = TimeSpan.FromSeconds(30);

                // Mutación GraphQL: pagarFactura(id: ...)
                var graphqlMutation = new
                {
                    query = $@"
                    mutation {{
                      pagarFactura(id: {idFactura}) {{
                        id
                        estado
                      }}
                    }}"
                };

                var jsonQuery = JsonConvert.SerializeObject(graphqlMutation);
                var content = new StringContent(jsonQuery, Encoding.UTF8, "application/json");
                var response = await client.PostAsync(urlEntel, content);
                Debug.WriteLine($"Pago Entel {idFactura}: {response.StatusCode}");
                return response.IsSuccessStatusCode;
            }
            catch (Exception ex)
            {
                Debug.WriteLine($"Error PagarFacturaEntel: {ex.Message}");
                return false;
            }
            finally
            {
                client?.Dispose();
            }
        }
    }

    [Serializable]
    public class Factura
    {
        public int Id { get; set; }
        public string Empresa { get; set; }
        public string NroFactura { get; set; }
        public string CI { get; set; }
        public string NombreCompleto { get; set; }
        public string Periodo { get; set; }
        public decimal Monto { get; set; }
        public string Estado { get; set; }
    }

    // Clase para deserializar respuestas REST de Cessa y Elapas
    public class FacturaResponse
    {
        public int id { get; set; }
        public string nro_factura { get; set; }
        public string ci { get; set; }
        public string nombre_completo { get; set; }
        public string periodo { get; set; }
        public decimal monto { get; set; }
        public string estado { get; set; }
    }

    // Clases para deserializar respuesta GraphQL de Entel
    public class GraphQLResponse
    {
        public GraphQLData data { get; set; }
    }

    public class GraphQLData
    {
        public List<FacturaResponse> facturas { get; set; }
    }
}