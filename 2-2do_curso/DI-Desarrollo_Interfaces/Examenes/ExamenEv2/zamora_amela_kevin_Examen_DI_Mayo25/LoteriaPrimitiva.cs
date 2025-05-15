using System;
using System.Collections;
using System.Collections.Generic;
using System.Globalization;
using System.Linq;
using System.Windows.Forms;

namespace zamora_amela_kevin_Examen_DI_Mayo25
{
    public class LoteriaPrimitiva : Form
    {
        private List<CheckBox> checkBoxes = new List<CheckBox>();
        private FlowLayoutPanel floatCheckboxes;
        private System.Windows.Forms.Button btnManual;
        private System.Windows.Forms.Button btnBorrar;
        private System.Windows.Forms.Label labelResultado;
        //private System.Windows.Forms.TableLayoutPanel tablaResultado;
        private System.Windows.Forms.Label labelSeleccion;
        private System.Windows.Forms.Label labelAciertos;
        HashSet<int> numbers = new HashSet<int>();

        private const int numsQuantity = 6;
        private const int numsMax = 9;

        private void InitializeComponent()
        {
            this.floatCheckboxes = new System.Windows.Forms.FlowLayoutPanel();
            this.btnManual = new System.Windows.Forms.Button();
            this.btnBorrar = new System.Windows.Forms.Button();
            this.labelResultado = new System.Windows.Forms.Label();
            //this.tablaResultado = new System.Windows.Forms.TableLayoutPanel();
            this.SuspendLayout();


            // 
            // floatCheckboxes
            // 
            this.floatCheckboxes.Location = new System.Drawing.Point(20, 210);
            this.floatCheckboxes.Name = "floatCheckboxes";
            this.floatCheckboxes.Size = new System.Drawing.Size(280, 100);
            this.floatCheckboxes.TabIndex = 1;
            this.floatCheckboxes.AutoSize = true;
            this.floatCheckboxes.AutoSizeMode = AutoSizeMode.GrowAndShrink;

            // 
            // btnManual
            // 
            this.btnManual.Location = new System.Drawing.Point(20, 250);
            this.btnManual.Name = "btnManual";
            this.btnManual.Size = new System.Drawing.Size(100, 35);
            this.btnManual.Text = "Manual";
            this.btnManual.UseVisualStyleBackColor = true;
            this.btnManual.Click += new System.EventHandler(this.btnManualOnClick);

            // 
            // btnBorrar
            // 
            this.btnBorrar.Location = new System.Drawing.Point(205, 250);
            this.btnBorrar.Name = "btnBorrar";
            this.btnBorrar.Size = new System.Drawing.Size(100, 35);
            this.btnBorrar.Text = "Borrar";
            this.btnBorrar.UseVisualStyleBackColor = true;
            this.btnBorrar.Click += new System.EventHandler(this.btnBorrarOnClick);

            // 
            // labelResultado
            // 
            this.labelResultado.AutoSize = true;
            this.labelResultado.Font = new System.Drawing.Font("Arial", 16F, System.Drawing.FontStyle.Bold);
            this.labelResultado.Location = new System.Drawing.Point(30, 100);
            this.labelResultado.Name = "labelResultado";
            this.labelResultado.Size = new System.Drawing.Size(0, 13);

            // 
            // labelSeleccion
            // 
            this.labelSeleccion = new System.Windows.Forms.Label();
            this.labelSeleccion.AutoSize = true;
            this.labelSeleccion.Font = new System.Drawing.Font("Arial", 16F, System.Drawing.FontStyle.Bold);
            this.labelSeleccion.Location = new System.Drawing.Point(30, 40);
            this.labelSeleccion.Name = "labelSeleccion";
            this.labelSeleccion.Size = new System.Drawing.Size(0, 13);

            // 
            // labelAciertos
            // 
            this.labelAciertos = new System.Windows.Forms.Label();
            this.labelAciertos.AutoSize = true;
            this.labelAciertos.Font = new System.Drawing.Font("Arial", 16F, System.Drawing.FontStyle.Bold);
            this.labelAciertos.Location = new System.Drawing.Point(30, 160);
            this.labelAciertos.Name = "labelAciertos";
            this.labelAciertos.Size = new System.Drawing.Size(0, 13);

            // 
            // LoteriaPrimitiva
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(325, 310);
            this.Controls.Add(this.floatCheckboxes);
            this.Controls.Add(this.btnManual);
            this.Controls.Add(this.btnBorrar);
            this.Controls.Add(this.labelResultado);
            this.Controls.Add(this.labelSeleccion);
            this.Controls.Add(this.labelAciertos);
            this.Name = "ExamenDI";
            this.Text = "Lotería Primitiva";
            this.StartPosition = FormStartPosition.CenterScreen;
            this.ResumeLayout(false);
            this.PerformLayout();
        }

        public LoteriaPrimitiva()
        {
            InitializeComponent();
            GenerarCheckboxes();
        }

        private void GenerarCheckboxes()
        {
            for (int i = 1; i <= 9; i++)
            {
                CheckBox cb = new CheckBox();
                cb.Text = i.ToString();
                cb.AutoSize = true;
                checkBoxes.Add(cb);
                floatCheckboxes.Controls.Add(cb);
            }
        }

        private List<int> mostrar_resultados_sorteos()
        {
            Random randomNum = new Random();
            while (numbers.Count < 6)
            {
                int num = randomNum.Next(1, numsMax + 1);
                numbers.Add(num);
            }
            return numbers.ToList();
        }

        private List<int> ordenar(List<int> numbers)
        {
            numbers.Sort();
            return numbers;
        }

        private void btnManualOnClick(object obj, EventArgs e)
        {
            var seleccionUsuario = ObtenerSeleccionUsuario();

            if (seleccionUsuario.Count != numsQuantity)
            {
                MessageBox.Show("Selecciona exactamente 6 números antes de continuar.",
                "Selección incompleta", MessageBoxButtons.OK, MessageBoxIcon.Warning);
                return;
            }

            var combinacion = mostrar_resultados_sorteos();
            var ordenada = ordenar(combinacion);

            labelSeleccion.Text = "Tu combinación es: \n" + string.Join(" ", seleccionUsuario);
            labelResultado.Text = "La combinación ganadora es: \n" + string.Join(" ", ordenada);

            int aciertos = seleccionUsuario.Intersect(ordenada).Count();
            labelAciertos.Text = $"El número de aciertos es {aciertos}";
        }

        private void btnBorrarOnClick(object obj, EventArgs e)
        {
            foreach (var cb in checkBoxes)
            {
                cb.Checked = false;
            }

            labelResultado.Text = "";
            labelSeleccion.Text = "";
            labelAciertos.Text = "";
        }
        
        private List<int> ObtenerSeleccionUsuario()
        {
            return checkBoxes
                .Where(cb => cb.Checked)
                .Select(cb => int.Parse(cb.Text))
                .OrderBy(n => n)
                .ToList();
        }
    }
}