using System;
using System.Collections.Generic;
using System.Drawing;
using System.Windows.Forms;
using GestionReservas.Models;

namespace GestionReservas
{
    public partial class ReservationDialog : Form
    {
        private static List<Reservation> reservations = new List<Reservation>();

        private TextBox nameTextBox;
        private TextBox phoneTextBox;
        private DateTimePicker eventDatePicker;
        private ComboBox typeComboBox;
        private NumericUpDown peopleNumeric;
        private ComboBox foodComboBox;
        private NumericUpDown daysNumeric;
        private CheckBox roomCheckBox;
        private Button saveButton;
        private Button showReservationsButton;
        public Reservation ReservationData { get; private set; }

        public ReservationDialog()
        {
            this.Text = "Reserva del Salón Caribe";
            this.FormBorderStyle = FormBorderStyle.FixedDialog;
            this.StartPosition = FormStartPosition.CenterParent;
            this.BackColor = Color.White;
            this.Size = new Size(450, 500);
            this.MaximizeBox = false;
            this.MinimizeBox = false;

            AutoScroll = true;

            // Crear instancia de ToolTip
            ToolTip tooltip = new ToolTip();

            Label nameLabel = new Label { Text = "Nombre:", Location = new Point(10, 20) };
            nameTextBox = new TextBox { Location = new Point(150, 20), Width = 200 };
            tooltip.SetToolTip(nameTextBox, "Introduce el nombre de contacto");

            Label phoneLabel = new Label { Text = "Teléfono:", Location = new Point(10, 60) };
            phoneTextBox = new TextBox { Location = new Point(150, 60), Width = 200 };
            tooltip.SetToolTip(phoneTextBox, "Introduce el número de contacto");

            Label dateLabel = new Label { Text = "Fecha del evento:", Location = new Point(10, 100) };
            eventDatePicker = new DateTimePicker { Location = new Point(150, 100) };
            tooltip.SetToolTip(eventDatePicker, "Selecciona la fecha del evento");

            Label typeLabel = new Label { Text = "Tipo de evento:", Location = new Point(10, 140) };
            typeComboBox = new ComboBox { Location = new Point(150, 140), DropDownStyle = ComboBoxStyle.DropDownList };
            typeComboBox.Items.AddRange(new[] { "Banquete", "Jornada", "Congreso" });
            typeComboBox.SelectedIndexChanged += TypeComboBox_SelectedIndexChanged;
            tooltip.SetToolTip(typeComboBox, "Selecciona el tipo de evento");

            Label peopleLabel = new Label { Text = "Núm. personas:", Location = new Point(10, 180) };
            peopleNumeric = new NumericUpDown { Location = new Point(150, 180), Minimum = 1, Maximum = 1000 };
            tooltip.SetToolTip(peopleNumeric, "Introduce la cantidad estimada de personas");

            Label foodLabel = new Label { Text = "Tipo de cocina:", Location = new Point(10, 220) };
            foodComboBox = new ComboBox { Location = new Point(150, 220), DropDownStyle = ComboBoxStyle.DropDownList };
            foodComboBox.Items.AddRange(new[] { "Bufé", "Carta", "Cita con el chef", "No precisa" });
            tooltip.SetToolTip(foodComboBox, "Selecciona el tipo de comida");

            Label daysLabel = new Label { Text = "Núm. de días:", Location = new Point(10, 260) };
            daysNumeric = new NumericUpDown { Location = new Point(150, 260), Minimum = 1, Maximum = 30, Enabled = false };
            tooltip.SetToolTip(daysNumeric, "Número de días/jornadas (solo para congresos)");

            roomCheckBox = new CheckBox
            {
                Text = "¿Requiere habitaciones?",
                Location = new Point(150, 300),
                AutoSize = true,
                MaximumSize = new Size(250, 0),
                Enabled = false
            };
            tooltip.SetToolTip(roomCheckBox, "Marca si se requieren habitaciones (solo congresos)");

            saveButton = new Button
            {
                Text = "Guardar reserva",
                Location = new Point(150, 340),
                BackColor = Color.DarkViolet,
                ForeColor = Color.White
            };
            saveButton.Click += SaveButton_Click;

            showReservationsButton = new Button
            {
                Text = "Ver reservas",
                Location = new Point(270, 340),
                BackColor = Color.LightGray
            };
            showReservationsButton.Click += (s, e) =>
            {
                if (reservations.Count == 0)
                {
                    MessageBox.Show("No hay ninguna reserva guardada aún.", "Sin reservas", MessageBoxButtons.OK, MessageBoxIcon.Information);
                }
                else
                {
                    string mensaje = "";
                    foreach (var r in reservations)
                    {
                        mensaje += $"- {r.ContactName}, {r.EventDate.ToShortDateString()}, {r.EventType}\n";
                    }

                    MessageBox.Show(mensaje, "Reservas actuales", MessageBoxButtons.OK, MessageBoxIcon.Information);
                }
            };


            Controls.AddRange(new Control[]
            {
                nameLabel, nameTextBox,
                phoneLabel, phoneTextBox,
                dateLabel, eventDatePicker,
                typeLabel, typeComboBox,
                peopleLabel, peopleNumeric,
                foodLabel, foodComboBox,
                daysLabel, daysNumeric,
                roomCheckBox,
                saveButton, showReservationsButton
            });
        }

        private void TypeComboBox_SelectedIndexChanged(object sender, EventArgs e)
        {
            bool isCongress = typeComboBox.SelectedItem?.ToString() == "Congreso";
            daysNumeric.Enabled = isCongress;
            roomCheckBox.Enabled = isCongress;
        }

        private void SaveButton_Click(object sender, EventArgs e)
        {
            var reservation = new Reservation
            {
                ContactName = nameTextBox.Text,
                Phone = phoneTextBox.Text,
                EventDate = eventDatePicker.Value,
                EventType = typeComboBox.SelectedItem?.ToString() ?? "Desconocido",
                NumberOfPeople = (int)peopleNumeric.Value,
                FoodType = foodComboBox.SelectedItem?.ToString() ?? "No precisa",
                Days = daysNumeric.Enabled ? (int)daysNumeric.Value : 0,
                RequiresRooms = roomCheckBox.Enabled && roomCheckBox.Checked
            };

            ReservationData = reservation;
            reservations.Add(reservation);

            MessageBox.Show("¡Reserva guardada con éxito!", "Confirmación");
            this.DialogResult = DialogResult.OK;
            this.Close();
        }

        public void PreloadReservation(Reservation reservation)
        {
            nameTextBox.Text = reservation.ContactName;
            phoneTextBox.Text = reservation.Phone;
            eventDatePicker.Value = reservation.EventDate;
            typeComboBox.SelectedItem = reservation.EventType;
            peopleNumeric.Value = reservation.NumberOfPeople;
            foodComboBox.SelectedItem = reservation.FoodType;
            daysNumeric.Value = reservation.Days;
            roomCheckBox.Checked = reservation.RequiresRooms;
        }

        public void CopyFrom(Reservation other)
        {
            nameTextBox.Text = other.ContactName;
            phoneTextBox.Text = other.Phone;
            eventDatePicker.Value = other.EventDate;
            typeComboBox.SelectedItem = other.EventType;
            peopleNumeric.Value = other.NumberOfPeople;
            foodComboBox.SelectedItem = other.FoodType;
            daysNumeric.Value = other.Days;
            roomCheckBox.Checked = other.RequiresRooms;

            // Asegúrate de habilitar los controles si el evento es congreso
            daysNumeric.Enabled = other.EventType == "Congreso";
            roomCheckBox.Enabled = other.EventType == "Congreso";
        }
    }
}
