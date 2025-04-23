using System;
using System.Collections.Generic;
using System.Drawing;
using System.IO;
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
        private PictureBox imageBox;
        private Button uploadImageButton;
        private string imagePath = null;

        public ReservationDialog()
        {
            this.Text = "Reserva del Salón Caribe";
            this.FormBorderStyle = FormBorderStyle.FixedDialog;
            this.StartPosition = FormStartPosition.CenterParent;
            this.BackColor = Color.White;
            this.Size = new Size(600, 450);
            this.MaximizeBox = false;
            this.MinimizeBox = false;

            AutoScroll = true;

            // Crear instancia de ToolTip
            ToolTip tooltip = new ToolTip();

            // Imagen
            imageBox = new PictureBox
            {
                Location = new Point(420, 15),
                Size = new Size(80, 80),
                SizeMode = PictureBoxSizeMode.StretchImage,
                BorderStyle = BorderStyle.FixedSingle
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
            ImageHelper.MakeCircularPictureBox(imageBox);  // aplicar máscara circular
            Controls.Add(imageBox);

            // Botón para subir imagen
            uploadImageButton = new Button
            {
                Text = "Subir Imagen",
                Location = new Point(420, 100),
                AutoSize = true
            };
            uploadImageButton.Click += (s, e) =>
            {
                using (OpenFileDialog openFileDialog = new OpenFileDialog())
                {
                    openFileDialog.Filter = "Imágenes (*.jpg;*.jpeg;*.png)|*.jpg;*.jpeg;*.png";
                    if (openFileDialog.ShowDialog() == DialogResult.OK)
                    {
                        imagePath = openFileDialog.FileName;
                        imageBox.Image = Image.FromFile(imagePath);
                    }
                }
            };
            Controls.Add(uploadImageButton);

            Label nameLabel = new Label { Text = "Nombre:", Location = new Point(60, 20) };
            nameTextBox = new TextBox { Location = new Point(200, 20), Width = 200 };
            tooltip.SetToolTip(nameTextBox, "Introduce el nombre de contacto");

            Label phoneLabel = new Label { Text = "Teléfono:", Location = new Point(60, 60) };
            phoneTextBox = new TextBox { Location = new Point(200, 60), Width = 200 };
            tooltip.SetToolTip(phoneTextBox, "Introduce el número de contacto");

            Label dateLabel = new Label { Text = "Fecha del evento:", Location = new Point(60, 100) };
            eventDatePicker = new DateTimePicker { Location = new Point(200, 100) };
            tooltip.SetToolTip(eventDatePicker, "Selecciona la fecha del evento");

            Label typeLabel = new Label { Text = "Tipo de evento:", Location = new Point(60, 140) };
            typeComboBox = new ComboBox { Location = new Point(200, 140), DropDownStyle = ComboBoxStyle.DropDownList };
            typeComboBox.Items.AddRange(new[] { "Banquete", "Jornada", "Congreso" });
            typeComboBox.SelectedIndexChanged += TypeComboBox_SelectedIndexChanged;
            tooltip.SetToolTip(typeComboBox, "Selecciona el tipo de evento");

            Label peopleLabel = new Label { Text = "Núm. personas:", Location = new Point(60, 180) };
            peopleNumeric = new NumericUpDown { Location = new Point(200, 180), Minimum = 1, Maximum = 1000 };
            tooltip.SetToolTip(peopleNumeric, "Introduce la cantidad estimada de personas");

            Label foodLabel = new Label { Text = "Tipo de cocina:", Location = new Point(60, 220) };
            foodComboBox = new ComboBox { Location = new Point(200, 220), DropDownStyle = ComboBoxStyle.DropDownList };
            foodComboBox.Items.AddRange(new[] { "Bufé", "Carta", "Cita con el chef", "No precisa" });
            tooltip.SetToolTip(foodComboBox, "Selecciona el tipo de comida");

            Label daysLabel = new Label { Text = "Núm. de días:", Location = new Point(60, 260) };
            daysNumeric = new NumericUpDown { Location = new Point(200, 260), Minimum = 1, Maximum = 30, Enabled = false };
            tooltip.SetToolTip(daysNumeric, "Número de días/jornadas (solo para congresos)");

            roomCheckBox = new CheckBox
            {
                Text = "¿Requiere habitaciones?",
                Location = new Point(200, 300),
                AutoSize = true,
                MaximumSize = new Size(250, 0),
                Enabled = false
            };
            tooltip.SetToolTip(roomCheckBox, "Marca si se requieren habitaciones (solo congresos)");

            saveButton = new Button
            {
                Text = "Guardar reserva",
                Location = new Point(160, 340),
                BackColor = Color.DarkViolet,
                ForeColor = Color.White,
                Font = new Font("Segoe UI", 11, FontStyle.Bold),
                AutoSize = true
            };
            saveButton.Click += SaveButton_Click;

            showReservationsButton = new Button
            {
                Text = "Ver reservas",
                Location = new Point(320, 340),
                BackColor = Color.LightGray,
                Font = new Font("Segoe UI", 11, FontStyle.Bold),
                AutoSize = true
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

            // Ruta de la imagen por defecto (ajusta si está en otra carpeta)
            string defaultImagePath = Path.Combine(AppDomain.CurrentDomain.BaseDirectory, "Resources", "profile.png");

            // Si no se ha seleccionado ninguna imagen, usar la predeterminada
            if (string.IsNullOrEmpty(imagePath) || !System.IO.File.Exists(imagePath))
            {
                imagePath = defaultImagePath;
                imageBox.Image = Image.FromFile(imagePath);
            }

            ReservationData = new Reservation
            {
                ContactName = nameTextBox.Text,
                Phone = phoneTextBox.Text,
                EventDate = eventDatePicker.Value,
                EventType = typeComboBox.SelectedItem.ToString(),
                NumberOfPeople = (int)peopleNumeric.Value,
                FoodType = foodComboBox.SelectedItem.ToString(),
                Days = (int)daysNumeric.Value,
                RequiresRooms = roomCheckBox.Checked,
                ProfileImagePath = imagePath
            };
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

            if (!string.IsNullOrEmpty(reservation.ProfileImagePath) && System.IO.File.Exists(reservation.ProfileImagePath))
            {
                imageBox.Image = Image.FromFile(reservation.ProfileImagePath);
                imagePath = reservation.ProfileImagePath;
            }
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
