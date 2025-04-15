namespace WinFormsApp11
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

        private void textBox1_TextChanged(object sender, EventArgs e)
        {
            SRacalculadora.WSCalculadoraSoap client = new SRacalculadora.WSCalculadoraSoap(SRacalculadora.WSCalculadoraSoapClient.EndpointConfiguration.WSCalculadoraSoap12);
            int a=int.Parse(textBox1.Text);
            int b=int.Parse(textBox2.Text);
            int resultado = 0;

            switch (cbOperacion.SelectedIndex)
            {
                case 0:
                    resultado = client(a, b);
                break;
                case 1:
                    resultado = client(a, b);
                break;
                case 2:
                    resultado = client(a, b);
                    break;
                    case 3:
                    resultado = client(a, b);
                break;
            }

            
        }
    }
}
