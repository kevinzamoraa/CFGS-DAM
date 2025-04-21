using System;
using System.Collections.Generic;
using System.Drawing;
using System.Windows.Forms;
using GestionReservas.Models;

namespace GestionReservas
{
    public partial class MainForm : Form
    {
        private List<Reservation> reservations = new List<Reservation>();
        private ListBox reservationListBox;
        private Button openDialogButton;

        public MainForm()
        {
            this.Text = "Gestión de Reservas - Salón Caribe";
            this.Size = new Size(700, 500);
            this.StartPosition = FormStartPosition.CenterScreen;

            openDialogButton = new Button
            {
                Text = "Crear nueva reserva",
                Location = new Point(20, 20),
                BackColor = Color.DarkViolet,
                ForeColor = Color.White,
                AutoSize = true
            };
            openDialogButton.Click += OpenDialogButton_Click;
            
            reservationListBox = new ListBox
            {
                Location = new Point(20, 70),
                Size = new Size(640, 360),
                Font = new Font("Segoe UI", 10)
            };
            reservationListBox.DoubleClick += ReservationListBox_DoubleClick;
            Controls.Add(openDialogButton);
            Controls.Add(reservationListBox);
        }

        private void OpenDialogButton_Click(object sender, EventArgs e)
        {
            using (var dialog = new ReservationDialog())
            {
                if (dialog.ShowDialog() == DialogResult.OK)
                {
                    Reservation newReservation = dialog.ReservationData;
                    reservations.Add(newReservation);
                    reservationListBox.Items.Add(newReservation.ToString());
                }
            }
        }

        private void ReservationListBox_DoubleClick(object sender, EventArgs e)
        {
            int index = reservationListBox.SelectedIndex;
            if (index >= 0 && index < reservations.Count)
            {
                var selectedReservation = reservations[index];
                var detailsForm = new ReservationDetailsForm(selectedReservation, this, index);
                detailsForm.ShowDialog();
            }
        }

        public void RefreshReservationList()
        {
            reservationListBox.Items.Clear();
            foreach (var r in reservations)
            {
                reservationListBox.Items.Add(r.ToString());
            }
        }

        public void UpdateReservation(Reservation updatedReservation, int index)
        {
            if (index >= 0 && index < reservations.Count)
            {
                reservations[index] = updatedReservation;
                RefreshReservationList();
            }
        }

        public void DeleteReservation(int index)
        {
            if (index >= 0 && index < reservations.Count)
            {
                reservations.RemoveAt(index);
                RefreshReservationList();
            }
        }
    }
}
