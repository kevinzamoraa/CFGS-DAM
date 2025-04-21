using System;
using System.Drawing;
using System.Windows.Forms;

namespace MostrarImagenWinForms
{
    public class Form1 : Form
    {
        private PictureBox pictureBox;
        private Button loadButton;

        public Form1()
        {
            this.Text = "Visor de Imágenes";
            this.Size = new Size(800, 600);

            pictureBox = new PictureBox
            {
                Dock = DockStyle.Fill,
                SizeMode = PictureBoxSizeMode.Zoom
            };

            loadButton = new Button
            {
                Text = "Cargar Imagen",
                Dock = DockStyle.Top,
                Height = 40
            };
            loadButton.Click += LoadButton_Click;

            this.Controls.Add(pictureBox);
            this.Controls.Add(loadButton);
        }

        private void LoadButton_Click(object sender, EventArgs e)
        {
            OpenFileDialog openFileDialog = new OpenFileDialog();
            openFileDialog.Title = "Selecciona una imagen";
            openFileDialog.Filter = "Archivos de imagen|*.jpg;*.jpeg;*.png;*.bmp;*.gif";

            if (openFileDialog.ShowDialog() == DialogResult.OK)
            {
                pictureBox.Image = Image.FromFile(openFileDialog.FileName);
            }
        }
    }
}