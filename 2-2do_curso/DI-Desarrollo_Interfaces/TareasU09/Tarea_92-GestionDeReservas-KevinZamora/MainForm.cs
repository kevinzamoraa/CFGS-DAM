using System;
using System.Windows.Forms;

namespace GestionReservas
{
    public partial class MainForm : Form
    {
        public MainForm()
        {
            InitializeComponent();

            this.Text = "Gestión de Reservas - Salón Caribe";

            Button openDialogButton = new Button
            {
                Text = "Nueva Reserva",
                AutoSize = true,
                BackColor = System.Drawing.Color.MediumPurple,
                ForeColor = System.Drawing.Color.White
            };
            openDialogButton.Click += (s, e) =>
            {
                using (var dialog = new ReservationDialog())
                {
                    dialog.ShowDialog();
                }
            };

            MenuStrip menu = new MenuStrip();
            ToolStripMenuItem reservasMenu = new ToolStripMenuItem("Reservas");
            ToolStripMenuItem nuevaReservaItem = new ToolStripMenuItem("Nueva reserva", null, (s, e) => openDialogButton.PerformClick());
            reservasMenu.DropDownItems.Add(nuevaReservaItem);
            menu.Items.Add(reservasMenu);

            Controls.Add(menu);
            Controls.Add(openDialogButton);

            MainMenuStrip = menu;
        }
    }
}
