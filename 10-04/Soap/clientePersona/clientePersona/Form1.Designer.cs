namespace clientePersona
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
            label1 = new Label();
            textBox1 = new TextBox();
            label2 = new Label();
            label3 = new Label();
            label4 = new Label();
            textBox2 = new TextBox();
            textBox3 = new TextBox();
            textBox4 = new TextBox();
            button1 = new Button();
            panel1 = new Panel();
            SuspendLayout();
            // 
            // label1
            // 
            label1.AutoSize = true;
            label1.Location = new Point(140, 88);
            label1.Name = "label1";
            label1.Size = new Size(20, 20);
            label1.TabIndex = 0;
            label1.Text = "ci";
            // 
            // textBox1
            // 
            textBox1.AccessibleName = "textci";
            textBox1.Location = new Point(166, 88);
            textBox1.Name = "textBox1";
            textBox1.Size = new Size(125, 27);
            textBox1.TabIndex = 1;
            textBox1.TextChanged += textBox1_TextChanged;
            // 
            // label2
            // 
            label2.AutoSize = true;
            label2.Location = new Point(99, 127);
            label2.Name = "label2";
            label2.Size = new Size(61, 20);
            label2.TabIndex = 2;
            label2.Text = "nombre";
            // 
            // label3
            // 
            label3.AutoSize = true;
            label3.Location = new Point(47, 175);
            label3.Name = "label3";
            label3.Size = new Size(113, 20);
            label3.TabIndex = 3;
            label3.Text = "Primer Apellido";
            label3.Click += label3_Click;
            // 
            // label4
            // 
            label4.AutoSize = true;
            label4.Location = new Point(31, 216);
            label4.Name = "label4";
            label4.Size = new Size(129, 20);
            label4.TabIndex = 4;
            label4.Text = "Segundo Apellido";
            // 
            // textBox2
            // 
            textBox2.AccessibleName = "nombre";
            textBox2.Location = new Point(166, 127);
            textBox2.Name = "textBox2";
            textBox2.Size = new Size(129, 27);
            textBox2.TabIndex = 5;
            // 
            // textBox3
            // 
            textBox3.AccessibleName = "pApellido";
            textBox3.Location = new Point(167, 174);
            textBox3.Name = "textBox3";
            textBox3.Size = new Size(124, 27);
            textBox3.TabIndex = 6;
            // 
            // textBox4
            // 
            textBox4.AccessibleName = "sApellido";
            textBox4.Location = new Point(169, 210);
            textBox4.Name = "textBox4";
            textBox4.Size = new Size(125, 27);
            textBox4.TabIndex = 7;
            // 
            // button1
            // 
            button1.Location = new Point(489, 76);
            button1.Name = "button1";
            button1.Size = new Size(136, 29);
            button1.TabIndex = 8;
            button1.Text = "mostrar persona";
            button1.UseVisualStyleBackColor = true;
            button1.Click += button1_Click;
            // 
            // panel1
            // 
            panel1.Location = new Point(456, 127);
            panel1.Name = "panel1";
            panel1.Size = new Size(250, 128);
            panel1.TabIndex = 9;
            // 
            // Form1
            // 
            AutoScaleDimensions = new SizeF(8F, 20F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(800, 450);
            Controls.Add(panel1);
            Controls.Add(button1);
            Controls.Add(textBox4);
            Controls.Add(textBox3);
            Controls.Add(textBox2);
            Controls.Add(label4);
            Controls.Add(label3);
            Controls.Add(label2);
            Controls.Add(textBox1);
            Controls.Add(label1);
            Name = "Form1";
            Text = "Form1";
            Load += Form1_Load;
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private Label label1;
        private TextBox textBox1;
        private Label label2;
        private Label label3;
        private Label label4;
        private TextBox textBox2;
        private TextBox textBox3;
        private TextBox textBox4;
        private Button button1;
        private Panel panel1;
    }
}
