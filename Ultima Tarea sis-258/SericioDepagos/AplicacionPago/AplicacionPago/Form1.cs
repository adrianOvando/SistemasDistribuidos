using System;
using System.Collections.Generic;
using System.Linq;
using System.Windows.Forms;

namespace AplicacionPago
{
    public partial class Form1 : Form
    {
        private Servicepagos.WebpagosSoapClient cliente =
            new Servicepagos.WebpagosSoapClient(Servicepagos.WebpagosSoapClient.EndpointConfiguration.WebpagosSoap12);

        public Form1()
        {
            InitializeComponent();
        }

        private void btnConsultar_Click(object sender, EventArgs e)
        {
            string ci = txtCI.Text.Trim();
            if (string.IsNullOrEmpty(ci))
            {
                MessageBox.Show("Ingresa un CI para consultar.");
                return;
            }

            try
            {
                var facturas = cliente.ConsultarDeudas(ci);
                var lista = facturas.ToList();
                dvgFacturas.DataSource = lista;

                dvgFacturas.AllowUserToAddRows = false;

                if (!dvgFacturas.Columns.Contains("Seleccionar"))
                {
                    var chk = new DataGridViewCheckBoxColumn
                    {
                        Name = "Seleccionar",
                        HeaderText = "Seleccionar",
                        Width = 60
                    };
                    dvgFacturas.Columns.Insert(0, chk);
                }

                // Inicializar checkboxes en false
                foreach (DataGridViewRow row in dvgFacturas.Rows)
                {
                    row.Cells["Seleccionar"].Value = false;
                }
            }
            catch (Exception ex)
            {
                MessageBox.Show("Error al consultar deudas: " + ex.Message);
            }
        }

        private void btnPagar_Click(object sender, EventArgs e)
        {
            try
            {
                var seleccionadas = new List<Servicepagos.Factura>();

                foreach (DataGridViewRow row in dvgFacturas.Rows)
                {
                    if (row.Cells["Seleccionar"].Value != null &&
                        Convert.ToBoolean(row.Cells["Seleccionar"].Value))
                    {
                        var factura = row.DataBoundItem as Servicepagos.Factura;
                        if (factura != null)
                        {
                            seleccionadas.Add(factura);
                        }
                    }
                }

                if (seleccionadas.Count == 0)
                {
                    MessageBox.Show("Selecciona al menos una factura marcando la casilla.");
                    return;
                }

                bool exito = cliente.Pagar(seleccionadas.ToArray());

                if (exito)
                {
                    MessageBox.Show("Factura(s) pagada(s) correctamente.");
                    btnConsultar.PerformClick(); 
                }
                else
                {
                    MessageBox.Show("Error al pagar alguna factura.");
                }
            }
            catch (Exception ex)
            {
                MessageBox.Show("Error al pagar: " + ex.Message);
            }
        }
    }
}
