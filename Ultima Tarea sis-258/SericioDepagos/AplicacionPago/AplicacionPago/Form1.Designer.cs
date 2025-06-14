namespace AplicacionPago
{
    partial class Form1
    {
        /// <summary>
        ///  Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        ///  Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        ///  Required method for Designer support - do not modify
        ///  the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            txtCI = new TextBox();
            btnConsultar = new Button();
            dvgFacturas = new DataGridView();
            btnPagar = new Button();
            label1 = new Label();
            ((System.ComponentModel.ISupportInitialize)dvgFacturas).BeginInit();
            SuspendLayout();
            // 
            // txtCI
            // 
            txtCI.Location = new Point(116, 166);
            txtCI.Name = "txtCI";
            txtCI.Size = new Size(125, 27);
            txtCI.TabIndex = 0;
            // 
            // btnConsultar
            // 
            btnConsultar.Location = new Point(588, 335);
            btnConsultar.Name = "btnConsultar";
            btnConsultar.Size = new Size(94, 29);
            btnConsultar.TabIndex = 1;
            btnConsultar.Text = "Consultar";
            btnConsultar.UseVisualStyleBackColor = true;
            btnConsultar.Click += btnConsultar_Click;
            // 
            // dvgFacturas
            // 
            dvgFacturas.ColumnHeadersHeightSizeMode = DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            dvgFacturas.Location = new Point(382, 107);
            dvgFacturas.Name = "dvgFacturas";
            dvgFacturas.RowHeadersWidth = 51;
            dvgFacturas.Size = new Size(300, 188);
            dvgFacturas.TabIndex = 2;
            // 
            // btnPagar
            // 
            btnPagar.Location = new Point(401, 335);
            btnPagar.Name = "btnPagar";
            btnPagar.Size = new Size(94, 29);
            btnPagar.TabIndex = 3;
            btnPagar.Text = "Pagar";
            btnPagar.UseVisualStyleBackColor = true;
            btnPagar.Click += btnPagar_Click;
            // 
            // label1
            // 
            label1.AutoSize = true;
            label1.Location = new Point(87, 173);
            label1.Name = "label1";
            label1.Size = new Size(23, 20);
            label1.TabIndex = 4;
            label1.Text = "ci:";
            // 
            // Form1
            // 
            AutoScaleDimensions = new SizeF(8F, 20F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(800, 450);
            Controls.Add(label1);
            Controls.Add(btnPagar);
            Controls.Add(dvgFacturas);
            Controls.Add(btnConsultar);
            Controls.Add(txtCI);
            Name = "Form1";
            Text = "Form1";
            ((System.ComponentModel.ISupportInitialize)dvgFacturas).EndInit();
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private TextBox txtCI;
        private Button btnConsultar;
        private DataGridView dvgFacturas;
        private Button btnPagar;
        private Label label1;
    }
}
