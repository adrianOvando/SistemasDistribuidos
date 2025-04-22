using System.Globalization;

namespace formCotizar
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {

        }

        private void button1_Click(object sender, EventArgs e)
        {
            //sPersona.wsPersonaSoapClient client = new sPersona.wsPersonaSoapClient(sPersona.wsPersonaSoapClient.EndpointConfiguration.wsPersonaSoap12);
            swCotizar.swCotizarSoapClient client = new swCotizar.swCotizarSoapClient(swCotizar.swCotizarSoapClient.EndpointConfiguration.swCotizarSoap12);
            string fecha = textBox1.Text;
            var verCotizacion = client.obtenerCotizacion(fecha);

            panel1.Controls.Clear();

            string[] datos = verCotizacion.Split(',');

            DataGridView dgv = new DataGridView
            {
                Dock = DockStyle.Fill,
                AutoSizeColumnsMode = DataGridViewAutoSizeColumnsMode.Fill,
                ReadOnly = true,
                AllowUserToAddRows = false
            };

            dgv.Columns.Add("fecha", "Fecha");

            dgv.Rows.Add(verCotizacion);

            panel1.Controls.Add(dgv);
        }

        private void button2_Click(object sender, EventArgs e)
        {
            swCotizar.swCotizarSoapClient client = new swCotizar.swCotizarSoapClient(swCotizar.swCotizarSoapClient.EndpointConfiguration.swCotizarSoap12);
            string fecha = textBox1.Text;
            float monto = float.Parse(textBox2.Text, CultureInfo.InvariantCulture);
            float cof_of = float.Parse(textBox3.Text, CultureInfo.InvariantCulture);

            client.registrarCotizacion(fecha, monto, cof_of);

        }
    }
}
