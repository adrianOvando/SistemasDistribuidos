using sPersona;

namespace crudPersona
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            //wsPersona.wsPersonaSoapClient client = new wsPersona.wsPersonaSoapClient(wsPersona.wsPersonaSoapClient.EndpointConfiguration.wsPersonaSoap12);

        }

        private void label2_Click(object sender, EventArgs e)
        {

        }

        private void label4_Click(object sender, EventArgs e)
        {

        }

        private void button2_Click(object sender, EventArgs e)
        {
            sPersona.wsPersonaSoapClient client = new sPersona.wsPersonaSoapClient(sPersona.wsPersonaSoapClient.EndpointConfiguration.wsPersonaSoap12);
            int ci = int.Parse(ci1.Text);
            string nombre = nombre1.Text;
            string papellido = papellido1.Text;
            string sapellido = sapellido1.Text;
            sPersona.Persona p = client.persona(ci, nombre, papellido, sapellido);


        }

        private void button1_Click_1(object sender, EventArgs e)
        {
            sPersona.wsPersonaSoapClient client = new sPersona.wsPersonaSoapClient(sPersona.wsPersonaSoapClient.EndpointConfiguration.wsPersonaSoap12);

            var listaPersonas = client.ListaPersona();

            panel1.Controls.Clear();

            DataGridView dgv = new DataGridView
            {
                Dock = DockStyle.Fill,
                AutoSizeColumnsMode = DataGridViewAutoSizeColumnsMode.Fill,
                ReadOnly = true,
                AllowUserToAddRows = false
            };

            dgv.Columns.Add("CI", "Cédula");
            dgv.Columns.Add("Nombre", "Nombre");
            dgv.Columns.Add("PrimerApellido", "Primer Apellido");
            dgv.Columns.Add("SegundoApellido", "Segundo Apellido");

            foreach (var persona in listaPersonas)
            {
                dgv.Rows.Add(persona.ci, persona.nombre, persona.pApellido, persona.sApellido);
            }
            panel1.Controls.Add(dgv);
        }

        private void button4_Click(object sender, EventArgs e)
        {
            sPersona.wsPersonaSoapClient client = new sPersona.wsPersonaSoapClient(sPersona.wsPersonaSoapClient.EndpointConfiguration.wsPersonaSoap12);

            int ci = int.Parse(ci1.Text);
            string nombre = nombre1.Text;
            string papellido = papellido1.Text;
            string sapellido = sapellido1.Text;

            bool resultado = client.EditarPersona(ci, nombre, papellido, sapellido);
            panel1.Controls.Clear();
            if (resultado)
            {
                MessageBox.Show("Persona actualizada correctamente", "Éxito", MessageBoxButtons.OK, MessageBoxIcon.Information);
            }
            else
            {
                MessageBox.Show("No se pudo actualizar la persona", "Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }
        }

        private void button3_Click(object sender, EventArgs e)
        {
            sPersona.wsPersonaSoapClient client = new sPersona.wsPersonaSoapClient(sPersona.wsPersonaSoapClient.EndpointConfiguration.wsPersonaSoap12);

            int ci = int.Parse(ci1.Text);

            bool resultado = client.EliminarPersona(ci);
            panel1.Controls.Clear();
            if (resultado)
            {
                MessageBox.Show("Persona eliminada", "Éxito", MessageBoxButtons.OK, MessageBoxIcon.Information);
            }
            else
            {
                MessageBox.Show("No se pudo actualizar la persona", "Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }

        }
    }
}
