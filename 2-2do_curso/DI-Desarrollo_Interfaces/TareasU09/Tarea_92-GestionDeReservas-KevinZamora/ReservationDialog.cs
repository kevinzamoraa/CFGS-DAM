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

        public ReservationDialog()
        {
            InitializeComponent();
            this.Text = "Reserva del Salón Caribe";
            this.FormBorderStyle = FormBorderStyle.FixedDialog;
            this.StartPosition = FormStartPosition.CenterParent;
            this.BackColor = Color.White;

            Label nameLabel = new Label { Text = "Nombre:", Location = new Point(10, 20) };
            nameTextBox = new TextBox { Location = new Point(150, 20), Width = 200, ToolTipText = "Introduce el nombre de contacto" };

            Label phoneLabel = new Label { Text = "Teléfono:", Location = new Point(10, 60) };
            phoneTextBox = new TextBox { Location = new Point(150, 60), Width = 200 };

            Label dateLabel = new Label { Text = "Fecha del evento:", Location = new Point(10, 100) };
            eventDatePicker = new DateTimePicker { Location = new Point(150, 100) };

            Label typeLabel = new Label { Text = "Tipo de evento:", Location = new Point(10, 140) };
            typeComboBox = new ComboBox { Location = new Point(150, 140), DropDownStyle = ComboBoxStyle.DropDownList };
            typeComboBox.Items.AddRange(new[] { "Banquete", "Jornada", "Congreso" });
            typeComboBox.SelectedIndexChanged += TypeComboBox_SelectedIndexChanged;

            Label peopleLabel = new Label { Text = "Número de personas:", Location = new Point(10, 180) };
            peopleNumeric = new NumericUpDown { Location = new Point(150, 180), Minimum = 1, Maximum = 1000 };

            Label foodLabel = new Label { Text = "Tipo de cocina:", Location = new Point(10, 220) };
            foodComboBox = new ComboBox { Location = new Point(150, 220), DropDownStyle = ComboBoxStyle.DropDownList };
            foodComboBox.Items.AddRange(new[] { "Bufé", "Carta", "Cita con el chef", "No precisa" });

            Label daysLabel = new Label { Text = "Número de jornadas:", Location = new Point(10, 260) };
            daysNumeric = new NumericUpDown { Location = new Point(150, 260), Minimum = 1, Maximum = 30, Enabled = false };

            roomCheckBox = new CheckBox { Text = "¿Requiere habitaciones?", Location = new Point(150, 300), Enabled = false };

            saveButton = new Button
            {
                Text = "Guardar reserva",
                Location = new Point(150, 340),
                BackColor = Color.MediumPurple,
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
                MessageBox.Show(string.Join(Environment.NewLine, reservations), "Reservas actuales");
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
            bool isCongress = typeComboBox.SelectedItem.ToString() == "Congreso";
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
                EventType = typeComboBox.SelectedItem.ToString(),
                NumberOfPeople = (int)peopleNumeric.Value,
                FoodType = foodComboBox.SelectedItem.ToString(),
                Days = daysNumeric.Enabled ? (int)daysNumeric.Value : 0,
                RequiresRooms = roomCheckBox.Enabled && roomCheckBox.Checked
            };

            reservations.Add(reservation);
            MessageBox.Show("¡Reserva guardada con éxito!", "Confirmación");
            this.Close();
        }
    }
}
