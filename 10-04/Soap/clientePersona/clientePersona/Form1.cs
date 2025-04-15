namespace clientePersona
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void label3_Click(object sender, EventArgs e)
        {

        }

        private void Form1_Load(object sender, EventArgs e)
        {

        }

        private void textBox1_TextChanged(object sender, EventArgs e)
        {

        }

        private void button1_Click(object sender, EventArgs e)
        {
            wsPersona.wsPersonaSoapClient client = new wsPersona.wsPersonaSoapClient(wsPersona.wsPersonaSoapClient.EndpointConfiguration.wsPersonaSoap12);
            int ci = int.Parse(textBox1.Text);
            string nombre = textBox2.Text;
            string pApellido = textBox3.Text;
            string sApellido = textBox4.Text;

            wsPersona.Persona p = client.crearPersona(ci, nombre, pApellido, sApellido);
            
        }
    }
}
