namespace crudPersona
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
            label2 = new Label();
            label3 = new Label();
            label4 = new Label();
            ci1 = new TextBox();
            nombre1 = new TextBox();
            papellido1 = new TextBox();
            sapellido1 = new TextBox();
            button2 = new Button();
            button3 = new Button();
            panel1 = new Panel();
            button4 = new Button();
            button1 = new Button();
            SuspendLayout();
            // 
            // label1
            // 
            label1.AutoSize = true;
            label1.Location = new Point(63, 75);
            label1.Name = "label1";
            label1.Size = new Size(29, 20);
            label1.TabIndex = 0;
            label1.Text = "Ci: ";
            // 
            // label2
            // 
            label2.AutoSize = true;
            label2.Location = new Point(63, 127);
            label2.Name = "label2";
            label2.Size = new Size(67, 20);
            label2.TabIndex = 1;
            label2.Text = "Nombre:";
            label2.Click += label2_Click;
            // 
            // label3
            // 
            label3.AutoSize = true;
            label3.Location = new Point(49, 177);
            label3.Name = "label3";
            label3.Size = new Size(116, 20);
            label3.TabIndex = 2;
            label3.Text = "Primer Apellido:";
            // 
            // label4
            // 
            label4.AutoSize = true;
            label4.Location = new Point(33, 231);
            label4.Name = "label4";
            label4.Size = new Size(132, 20);
            label4.TabIndex = 3;
            label4.Text = "Segundo Apellido:";
            label4.Click += label4_Click;
            // 
            // ci1
            // 
            ci1.Location = new Point(171, 75);
            ci1.Name = "ci1";
            ci1.Size = new Size(125, 27);
            ci1.TabIndex = 4;
            // 
            // nombre1
            // 
            nombre1.Location = new Point(171, 127);
            nombre1.Name = "nombre1";
            nombre1.Size = new Size(125, 27);
            nombre1.TabIndex = 5;
            // 
            // papellido1
            // 
            papellido1.Location = new Point(171, 177);
            papellido1.Name = "papellido1";
            papellido1.Size = new Size(125, 27);
            papellido1.TabIndex = 6;
            // 
            // sapellido1
            // 
            sapellido1.Location = new Point(171, 231);
            sapellido1.Name = "sapellido1";
            sapellido1.Size = new Size(125, 27);
            sapellido1.TabIndex = 7;
            // 
            // button2
            // 
            button2.Location = new Point(350, 318);
            button2.Name = "button2";
            button2.Size = new Size(94, 29);
            button2.TabIndex = 9;
            button2.Text = "Crear";
            button2.UseVisualStyleBackColor = true;
            button2.Click += button2_Click;
            // 
            // button3
            // 
            button3.Location = new Point(650, 318);
            button3.Name = "button3";
            button3.Size = new Size(94, 29);
            button3.TabIndex = 10;
            button3.Text = "Eliminar";
            button3.UseVisualStyleBackColor = true;
            button3.Click += button3_Click;
            // 
            // panel1
            // 
            panel1.Location = new Point(391, 75);
            panel1.Name = "panel1";
            panel1.Size = new Size(305, 189);
            panel1.TabIndex = 11;
            // 
            // button4
            // 
            button4.Location = new Point(550, 318);
            button4.Name = "button4";
            button4.Size = new Size(94, 29);
            button4.TabIndex = 13;
            button4.Text = "Editar";
            button4.UseVisualStyleBackColor = true;
            button4.Click += button4_Click;
            // 
            // button1
            // 
            button1.Location = new Point(450, 318);
            button1.Name = "button1";
            button1.Size = new Size(94, 29);
            button1.TabIndex = 14;
            button1.Text = "Mostrar";
            button1.UseVisualStyleBackColor = true;
            button1.Click += button1_Click_1;
            // 
            // Form1
            // 
            AutoScaleDimensions = new SizeF(8F, 20F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(800, 450);
            Controls.Add(button1);
            Controls.Add(button4);
            Controls.Add(panel1);
            Controls.Add(button3);
            Controls.Add(button2);
            Controls.Add(sapellido1);
            Controls.Add(papellido1);
            Controls.Add(nombre1);
            Controls.Add(ci1);
            Controls.Add(label4);
            Controls.Add(label3);
            Controls.Add(label2);
            Controls.Add(label1);
            Name = "Form1";
            Text = "Form1";
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private Label label1;
        private Label label2;
        private Label label3;
        private Label label4;
        private TextBox ci1;
        private TextBox nombre1;
        private TextBox papellido1;
        private TextBox sapellido1;
        private Button button2;
        private Button button3;
        private Panel panel1;
        private Button button4;
        private Button button1;
    }
}
