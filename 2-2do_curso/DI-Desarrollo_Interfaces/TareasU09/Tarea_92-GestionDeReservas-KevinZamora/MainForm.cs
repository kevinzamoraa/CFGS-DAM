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
        private PictureBox previewImageBox;


        public MainForm()
        {
            this.Text = "Gestión de Reservas - Salón Caribe";
            this.Size = new Size(600, 450);
            this.StartPosition = FormStartPosition.CenterScreen;

            openDialogButton = new Button
            {
                Text = "Crear nueva reserva",
                Location = new Point(20, 20),
                BackColor = Color.DarkViolet,
                ForeColor = Color.White,
                Font = new Font("Segoe UI", 11, FontStyle.Bold),
                AutoSize = true
            };
            openDialogButton.Click += OpenDialogButton_Click;
            
            reservationListBox = new ListBox
            {
                Location = new Point(20, 70),
                Size = new Size(545, 320),
                Font = new Font("Segoe UI", 10)
            };
            reservationListBox.DoubleClick += ReservationListBox_DoubleClick;

            Label titleLabel = new Label
            {
                Text = "📋 Lista de Reservas",
                Font = new Font("Segoe UI", 14, FontStyle.Bold),
                Location = new Point(200, 50),
                AutoSize = true
            };
            Controls.Add(titleLabel);

            // y baja la listbox para que no se solape
            reservationListBox.Location = new Point(20, 80);
            
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
                    RefreshReservationList();
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
