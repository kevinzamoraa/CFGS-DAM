using System;
using System.Drawing;
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
            this.Size = new Size(420, 450);
            this.StartPosition = FormStartPosition.CenterParent;
            this.BackColor = Color.White;

            var panel = new TableLayoutPanel
            {
                Dock = DockStyle.Fill,
                AutoScroll = true,
                ColumnCount = 1,
                RowCount = 0,
                Padding = new Padding(20),
            };

            void AddLabel(string text)
            {
                panel.Controls.Add(new Label
                {
                    Text = text,
                    AutoSize = true,
                    Font = new Font("Segoe UI", 10),
                    Margin = new Padding(5)
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
                AutoSize = true,
                Margin = new Padding(10, 0, 10, 0)
            };
            editButton.Click += EditButton_Click;

            var deleteButton = new Button
            {
                Text = "🗑️ Eliminar",
                BackColor = Color.DarkRed,
                ForeColor = Color.White,
                AutoSize = true,
                Margin = new Padding(10, 0, 10, 0)
            };
            deleteButton.Click += DeleteButton_Click;

            buttonPanel.Controls.Add(editButton);
            buttonPanel.Controls.Add(deleteButton);
            panel.Controls.Add(buttonPanel);

            Controls.Add(panel);
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
