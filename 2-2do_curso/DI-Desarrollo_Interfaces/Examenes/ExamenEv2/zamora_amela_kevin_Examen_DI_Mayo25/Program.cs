using System;
using System.Windows.Forms;
using zamora_amela_kevin_Examen_DI_Mayo25;

namespace zamora_amela_kevin_Examen_DI_Mayo25
{
    static class Program
    {
        [STAThread]
        static void Main()
        {
            Application.EnableVisualStyles();
            Application.SetCompatibleTextRenderingDefault(false);
            Application.Run(new LoteriaPrimitiva());
        }
    }
}