using System;
using System.Drawing;
using System.IO;
using System.Windows.Forms;
using GestionReservas.Models;

namespace GestionReservas
{
    public class ReservationDetailsForm : Form
    {
        private Reservation reservation;
        private Action<Reservation, int> onUpdate;
        private Action<int> onDelete;
        private int reservationIndex;

        public ReservationDetailsForm(Reservation reservation, Action<Reservation, int> onUpdate, Action<int> onDelete, int index)
        {
            this.reservation = reservation;
            this.onUpdate = onUpdate;
            this.onDelete = onDelete;
            this.reservationIndex = index;

            InitializeForm();
        }

        public ReservationDetailsForm(Reservation reservation, MainForm mainForm, int index)
            : this(reservation,
                  (updatedReservation, i) => mainForm.UpdateReservation(updatedReservation, i),
                  i => mainForm.DeleteReservation(i),
                  index)
        { }

        private void InitializeForm()
        {
            this.Text = "Detalles de la Reserva";
            this.Size = new Size(600, 450);
            this.StartPosition = FormStartPosition.CenterParent;
            this.BackColor = Color.White;

            var mainLayout = new TableLayoutPanel
            {
                Dock = DockStyle.Fill,
                ColumnCount = 2,
                RowCount = 1,
                AutoSize = true,
                Padding = new Padding(20),
            };
            mainLayout.ColumnStyles.Add(new ColumnStyle(SizeType.Percent, 70));
            mainLayout.ColumnStyles.Add(new ColumnStyle(SizeType.Percent, 30));

            // Panel de detalles (labels y botones)
            var detailPanel = new TableLayoutPanel
            {
                Dock = DockStyle.Top,
                AutoSize = true,
                ColumnCount = 1,
                RowCount = 0,
                Margin = new Padding(10),
            };

            var imageBox = new PictureBox
            {
                Location = new Point(100, 15),
                Size = new Size(160, 160),
                SizeMode = PictureBoxSizeMode.Zoom,
                BorderStyle = BorderStyle.FixedSingle,
                Margin = new Padding(20, 10, 20, 20),
                Anchor = AnchorStyles.Left
            };
            imageBox.Paint += (s, e) =>
            {
                using (var pen = new Pen(Color.LightGray))
                {
                    pen.Alignment = System.Drawing.Drawing2D.PenAlignment.Inset;
                    e.Graphics.SmoothingMode = System.Drawing.Drawing2D.SmoothingMode.AntiAlias;
                    e.Graphics.DrawEllipse(pen, 1, 1, imageBox.Width - 3, imageBox.Height - 3);
                }
            };
            ImageHelper.MakeCircularPictureBox(imageBox);
            try
            {
                if (!string.IsNullOrEmpty(reservation?.ProfileImagePath) && File.Exists(reservation.ProfileImagePath))
                {
                    imageBox.Image = Image.FromFile(reservation.ProfileImagePath);
                }
            }
            catch (Exception ex)
            {
                // Opcional: registrar error o mostrar mensaje amigable
                Console.WriteLine("No se pudo cargar la imagen: " + ex.Message);
            }

            void AddLabel(string text)
            {
                detailPanel.Controls.Add(new Label
                {
                    Text = text,
                    AutoSize = true,
                    Font = new Font("Segoe UI", 10),
                    Margin = new Padding(10, 5, 5, 5),
                });
            }

            // Detalles de la reserva
            AddLabel($"👤 Nombre: {reservation.ContactName}");
            AddLabel($"📞 Teléfono: {reservation.Phone}");
            AddLabel($"📅 Fecha del evento: {reservation.EventDate:dd/MM/yyyy}");
            AddLabel($"🎉 Tipo de evento: {reservation.EventType}");
            AddLabel($"👥 Número de personas: {reservation.NumberOfPeople}");
            AddLabel($"🍽️ Tipo de cocina: {reservation.FoodType}");

            if (reservation.EventType == "Congreso")
            {
                AddLabel($"📆 Jornadas: {reservation.Days}");
                AddLabel($"🛏️ Requiere habitaciones: {(reservation.RequiresRooms ? "Sí" : "No")}");
            }

            // Contenedor para los botones
            var buttonPanel = new FlowLayoutPanel
            {
                FlowDirection = FlowDirection.LeftToRight,
                AutoSize = true,
                Anchor = AnchorStyles.None,
                Padding = new Padding(0, 20, 0, 0),
                Margin = new Padding(0, 20, 0, 0)
            };

            var editButton = new Button
            {
                Text = "✏️ Editar",
                BackColor = Color.Goldenrod,
                ForeColor = Color.White,
                Font = new Font("Segoe UI", 11, FontStyle.Bold),
                AutoSize = true
            };
            editButton.Click += EditButton_Click;

            var deleteButton = new Button
            {
                Text = "🗑️ Eliminar",
                BackColor = Color.DarkRed,
                ForeColor = Color.White,
                Font = new Font("Segoe UI", 11, FontStyle.Bold),
                AutoSize = true
            };
            deleteButton.Click += DeleteButton_Click;
            
            buttonPanel.Controls.Add(editButton);
            buttonPanel.Controls.Add(deleteButton);
            detailPanel.Controls.Add(buttonPanel);

            // Añadir ambos paneles al layout principal
            mainLayout.Controls.Add(detailPanel, 0, 0);
            mainLayout.Controls.Add(imageBox, 1, 0);
            buttonPanel.Dock = DockStyle.Bottom;

            // Agregar al formulario
            Controls.Add(mainLayout);
        }

        private void EditButton_Click(object sender, EventArgs e)
        {
            var dialog = new ReservationDialog();
            dialog.PreloadReservation(reservation);

            if (dialog.ShowDialog() == DialogResult.OK)
            {
                onUpdate(dialog.ReservationData, reservationIndex);
                this.Close();
            }
        }

        private void DeleteButton_Click(object sender, EventArgs e)
        {
            var confirm = MessageBox.Show("¿Estás seguro de eliminar esta reserva?", "Confirmar eliminación", MessageBoxButtons.YesNo, MessageBoxIcon.Warning);
            if (confirm == DialogResult.Yes)
            {
                onDelete(reservationIndex);
                this.Close();
            }
        }
    }
}
