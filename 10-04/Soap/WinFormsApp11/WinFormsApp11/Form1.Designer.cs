namespace WinFormsApp11
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
            textBox1 = new TextBox();
            listBox1 = new ListBox();
            textBox2 = new TextBox();
            button1 = new Button();
            panel1 = new Panel();
            label3 = new Label();
            panel1.SuspendLayout();
            SuspendLayout();
            // 
            // label1
            // 
            label1.AutoSize = true;
            label1.Location = new Point(51, 76);
            label1.Name = "label1";
            label1.Size = new Size(17, 20);
            label1.TabIndex = 0;
            label1.Text = "a";
            // 
            // label2
            // 
            label2.AutoSize = true;
            label2.Location = new Point(308, 77);
            label2.Name = "label2";
            label2.Size = new Size(18, 20);
            label2.TabIndex = 1;
            label2.Text = "b";
            // 
            // textBox1
            // 
            textBox1.Location = new Point(71, 68);
            textBox1.Name = "textBox1";
            textBox1.Size = new Size(74, 27);
            textBox1.TabIndex = 2;
            textBox1.TextChanged += textBox1_TextChanged;
            // 
            // listBox1
            // 
            listBox1.AccessibleName = "Operacion";
            listBox1.FormattingEnabled = true;
            listBox1.Location = new Point(130, 122);
            listBox1.Name = "listBox1";
            listBox1.Size = new Size(146, 24);
            listBox1.TabIndex = 3;
            // 
            // textBox2
            // 
            textBox2.Location = new Point(337, 69);
            textBox2.Name = "textBox2";
            textBox2.Size = new Size(115, 27);
            textBox2.TabIndex = 4;
            // 
            // button1
            // 
            button1.Location = new Point(209, 200);
            button1.Name = "button1";
            button1.Size = new Size(94, 29);
            button1.TabIndex = 5;
            button1.Text = "button1";
            button1.UseVisualStyleBackColor = true;
            // 
            // panel1
            // 
            panel1.Controls.Add(label3);
            panel1.Location = new Point(99, 243);
            panel1.Name = "panel1";
            panel1.Size = new Size(340, 120);
            panel1.TabIndex = 6;
            // 
            // label3
            // 
            label3.AutoSize = true;
            label3.Location = new Point(39, 34);
            label3.Name = "label3";
            label3.Size = new Size(50, 20);
            label3.TabIndex = 0;
            label3.Text = "label3";
            label3.Click += label3_Click;
            // 
            // Form1
            // 
            AutoScaleDimensions = new SizeF(8F, 20F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(800, 450);
            Controls.Add(panel1);
            Controls.Add(button1);
            Controls.Add(textBox2);
            Controls.Add(listBox1);
            Controls.Add(textBox1);
            Controls.Add(label2);
            Controls.Add(label1);
            Name = "Form1";
            Text = "Form1";
            panel1.ResumeLayout(false);
            panel1.PerformLayout();
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private Label label1;
        private Label label2;
        private TextBox textBox1;
        private ListBox listBox1;
        private TextBox textBox2;
        private Button button1;
        private Panel panel1;
        private Label label3;
    }
}
